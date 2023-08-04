package store_stock_movement_mgmt.issue.services.cud;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;
import consignment_master_mgmt.model.master.ConsignmentMaster;
import consignment_master_mgmt.model.repo.cud.ConsignmentMasterCUD_Repo;
import store_order_outwards_mgmt.model.repo.read.StoreOrderOutwardsRead_Repo;
import store_stock_movement_mgmt.issue.model.dto.StoreIssueMaster_DTO;
import store_stock_movement_mgmt.issue.model.master.StoreIssueMaster;
import store_stock_movement_mgmt.issue.model.repo.cud.StoreIssueMasterCUD_Repo;
import store_stock_movement_mgmt.issue.model.repo.read.StoreIssueMasterRead_Repo;

@Service("storeIssueMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StoreIssueMasterCUD_Service implements I_StoreIssueMasterCUD_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreIssueMasterService.class);

	@Autowired
	private StoreIssueMasterCUD_Repo storeIssueMasterCUDRepo;
	
	@Autowired
	private ConsignmentMasterCUD_Repo consignmentMasterCUDRepo;

	@Autowired
	private StoreOrderOutwardsRead_Repo storeOrderOutwardsReadRepo;
	
	@Autowired
	private StoreIssueMasterRead_Repo storeIssueMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	/*
	// DO Process Init
	@Scheduled(fixedRate=3000)
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
    public CompletableFuture<Void> check_Processed() 
    {	    	
		Optional<ArrayList<Integer>> storeRegMode0SeqNos = storeRegisterRepo.getAllSeqNosForMode(0);
		Optional<ArrayList<Character>> storeTxnFlags;		
    	Integer store_seq_no_curr = 0;
    	float reg_ProcQty = (float)0;
    	float reg_Qty = (float)0;
    	boolean notVerified = true;    	
    	    	    	
    	if(storeRegMode0SeqNos.isPresent())
    	{
    	for (int i = 0; i < storeRegMode0SeqNos.get().size(); i++) 
    	{    		
    		store_seq_no_curr = storeRegMode0SeqNos.get().get(i);
    		reg_ProcQty = storeIssueRepo.getTotalProcessedQtyForStoreItem(store_seq_no_curr);
    		reg_Qty = storeRegisterRepo.getRegisterRequestQty(store_seq_no_curr);
    		notVerified = false;
    		
    		if(reg_ProcQty==reg_Qty)
    		{
    		storeTxnFlags = storeIssueRepo.getStoreVerifiedStatus(store_seq_no_curr);    		    		
    		if(storeTxnFlags.isPresent())
    		{
    		notVerified=checkTxnStoreStatus(storeTxnFlags);    		
    		if(notVerified)
    		{
    		storeIssueRepo.updateStoreVerifiedStatus(store_seq_no_curr);	
    		}    			
    		}    			
    		}
    	}    		
    	}    	
        return;
    }

private boolean checkTxnStoreStatus(Optional<ArrayList<Character>> storeTxnFlags) 
{
	Character flag = ' ';
	boolean ret_status = false;
			
	for (int j = 0; j < storeTxnFlags.get().size(); j++) 
	{
		if(storeTxnFlags.get().get(j)!=null)
		{
		flag = Character.toUpperCase(storeTxnFlags.get().get(j));    			
		if(!flag.equals('Y'))
    	{
			ret_status=true;
			break;
    	}
		}
		else {
			{
				ret_status=true;
				break;
			}
		}
	}
	return ret_status;
}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getAllStoreIssueMasters()  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.findAll();
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}
	*/

	@Override
	public CompletableFuture<StoreIssueMaster_DTO> newIssueMaster(StoreIssueMaster_DTO storeIssueMaster_DTO)
			{
		CompletableFuture<StoreIssueMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			StoreIssueMaster_DTO jcmDTO = null;
			if (!storeIssueMasterCUDRepo.existsById(storeIssueMaster_DTO.getStoreMovementSeqNo())) 
			{
				jcmDTO = this.getStoreIssueMaster_DTO(storeIssueMasterCUDRepo.save(this.setStoreIssueMaster_DTO(storeIssueMaster_DTO)));
			}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updIssueMaster(StoreIssueMaster_DTO storeIssueMaster_DTO)
			{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			StoreIssueMaster_DTO jcmDTO = null;
			if (storeIssueMasterCUDRepo.existsById(storeIssueMaster_DTO.getStoreMovementSeqNo())) 
			{
				StoreIssueMaster storeIssueMaster = this.setStoreIssueMaster_DTO(storeIssueMaster_DTO);
				storeIssueMaster.setStoreMovementSeqNo(storeIssueMaster_DTO.getStoreMovementSeqNo());
				jcmDTO = this.getStoreIssueMaster_DTO(storeIssueMasterCUDRepo.save(storeIssueMaster));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updOkStatusForLineItem( Long id,  Character st)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeIssueMasterCUDRepo.updOkStatusForLineItem( id,  st);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> updOkFlagForLineItem( Long id)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeIssueMasterCUDRepo.updOkFlagForLineItem( id);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> updDoneStatusForLineItem( Long id,  Character st)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeIssueMasterCUDRepo.updDoneStatusForLineItem(id,  st);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> updDoneFlagForLineItem( Long id)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeIssueMasterCUDRepo.updDoneFlagForLineItem( id);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> addRequestQtyForLineItem( Long sid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float orderQty = storeOrderOutwardsReadRepo.getOrderOutwardsAllocatedQty(sid);
		Float curQty = storeIssueMasterReadRepo.getRequestQtyForLineItem(sid);
		Float result = curQty+qty;
		
		if((orderQty>=result) && (qty > 0))
		{
		storeIssueMasterCUDRepo.addRequestQtyForLineItem(sid, qty);
		result = curQty+qty;
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> subRequestQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float reqQty = storeIssueMasterReadRepo.getRequestQtyForLineItem(mid);
		Float qlyQty = storeIssueMasterReadRepo.getQCQtyForLineItem(mid);
		Float result = reqQty - qty;
		
		if((result >= qlyQty) && (qty > 0))
		{
		storeIssueMasterCUDRepo.subRequestQtyForLineItem(mid, qty);		
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}


	@Override
	public CompletableFuture<Float> addQualityQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float reqQty = storeIssueMasterReadRepo.getRequestQtyForLineItem(mid);
		Float curQty = storeIssueMasterReadRepo.getQCQtyForLineItem(mid);
		Float prcQty = storeIssueMasterReadRepo.getProcessedQtyForLineItem(mid);
		Float conQty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty + qty;
		
		if((result <= reqQty) && ((result >= prcQty) || (result >= conQty)) && (qty > 0))
		{
		storeIssueMasterCUDRepo.addQualityQtyForLineItem(mid, qty);		
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> subQualityQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float reqQty = storeIssueMasterReadRepo.getRequestQtyForLineItem(mid);
		Float curQty = storeIssueMasterReadRepo.getQCQtyForLineItem(mid);
		Float prcQty = storeIssueMasterReadRepo.getProcessedQtyForLineItem(mid);
		Float conQty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty - qty;
		
		if((result >= prcQty) || (result >= conQty) && (qty > 0))
		{
		storeIssueMasterCUDRepo.addQualityQtyForLineItem(mid, qty);		
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> addProcessQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{		
		Float qlyQty = storeIssueMasterReadRepo.getQCQtyForLineItem(mid);
		Float curQty = storeIssueMasterReadRepo.getProcessedQtyForLineItem(mid);
		Float conQty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty + qty;
		
		if((result <= qlyQty) && (conQty == null || conQty ==0) && (qty > 0)) 
		{
		storeIssueMasterCUDRepo.addProcessQtyForLineItem(mid, qty);		
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> subProcessQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{		
		Float curQty = storeIssueMasterReadRepo.getProcessedQtyForLineItem(mid);
		Float conQty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty - qty;
		
		if((qty > 0) && (conQty == null || conQty ==0))
		{
		storeIssueMasterCUDRepo.subProcessQtyForLineItem(mid, qty);		
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<Float> addConsignQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{		
		Float qlyQty = storeIssueMasterReadRepo.getQCQtyForLineItem(mid);
		Float prcQty = storeIssueMasterReadRepo.getProcessedQtyForLineItem(mid);
		Float curQty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty + qty;
		
		if((result <= qlyQty) && (prcQty == null || prcQty ==0) && (qty > 0)) 
		{
		storeIssueMasterCUDRepo.addProcessQtyForLineItem(mid, qty);
		
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> subConsignQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{		
		Float curQty = storeIssueMasterReadRepo.getProcessedQtyForLineItem(mid);
		Float curQty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty - qty;
		
		if((qty > 0) && (conQty == null || conQty ==0))
		{
		storeIssueMasterCUDRepo.subProcessQtyForLineItem(mid, qty);		
		}
		else
		{
		result= (float) -1;	
		}
		return result;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<Float> getTotalQCItemQtyForStoreRequest(Long sid,  Long rid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getTotalQCItemQtyForStoreRequest(sid,  rid);
		return qty;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> getQCQtyForLineItem(Long mid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getQCQtyForLineItem(mid);
		return qty;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<Float> getTotalProcessedItemQtyForStoreRequest(Long sid,  Long rid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getTotalProcessedItemQtyForStoreRequest(sid,  rid);
		return qty;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> getProcessedQtyForLineItem(Long mid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getProcessedQtyForLineItem(mid);
		return qty;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> getTotalConsignItemQtyForStoreRequest(Long sid,  Long rid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getTotalConsignItemQtyForStoreRequest(sid,  rid);
		return qty;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<Float> getConsignQtyForLineItem(Long mid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		return qty;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.getSelectStoreIssueMasters(jcmSeqNos);
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByRequests(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.getSelectStoreIssueMastersByRequests(pids);
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByLocations( CopyOnWriteArrayList<Long> lids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.getSelectStoreIssueMastersByLocations(lids);
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.getSelectStoreIssueMastersLineItemsForRequestsNotDone(ids);
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsDone(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.getSelectStoreIssueMastersLineItemsForRequestsDone(ids);
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.getSelectStoreIssueMastersLineItemsForNotOkStatus(ids);
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.getSelectStoreIssueMastersLineItemsForForOkStatus(ids);
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getAllStoreIssueMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssueMaster> jobList = (CopyOnWriteArrayList<StoreIssueMaster>) storeIssueMasterReadRepo.findAll();
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssueMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	private synchronized StoreIssueMaster_DTO getStoreIssueMaster_DTO(StoreIssueMaster storeIssueMaster) 
	{
		StoreIssueMaster_DTO storeIssueMaster_DTO = new StoreIssueMaster_DTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		storeIssueMaster_DTO.setAppliedOn(formatter.format(storeIssueMaster.getAppliedOn().toLocalDateTime()));
		storeIssueMaster_DTO.setAssetSeqNo(storeIssueMaster.getAssetSeqNo());
		storeIssueMaster_DTO.setConsignQty(storeIssueMaster.getConsignQty());
		storeIssueMaster_DTO.setDoneflag(storeIssueMaster.getDoneflag());
		storeIssueMaster_DTO.setLocationSeqNo(storeIssueMaster.getLocationSeqNo());
		storeIssueMaster_DTO.setOkflag(storeIssueMaster.getOkflag());
		storeIssueMaster_DTO.setProcessedOn(formatter.format(storeIssueMaster.getProcessedOn().toLocalDateTime()));
		storeIssueMaster_DTO.setProcessedQty(storeIssueMaster.getProcessedQty());
		storeIssueMaster_DTO.setQtyUnitSeqNo(storeIssueMaster.getQtyUnitSeqNo());
		storeIssueMaster_DTO.setQualityQty(storeIssueMaster.getQualityQty());
		storeIssueMaster_DTO.setRequestOn(formatter.format(storeIssueMaster.getRequestOn().toLocalDateTime()));
		storeIssueMaster_DTO.setRequestQty(storeIssueMaster.getRequestQty());
		storeIssueMaster_DTO.setResourceSeqNo(storeIssueMaster.getResourceSeqNo());
		storeIssueMaster_DTO.setStoreMovementSeqNo(storeIssueMaster.getStoreMovementSeqNo());
		storeIssueMaster_DTO.setStoreRequestSeqNo(storeIssueMaster.getStoreRequestSeqNo());
		return storeIssueMaster_DTO;
	}
	
	private synchronized StoreIssueMaster setStoreIssueMaster_DTO(StoreIssueMaster_DTO sIssueMaster_DTO) 
	{
		StoreIssueMaster storeIssueMaster = new StoreIssueMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime rd = LocalDateTime.parse(sIssueMaster_DTO.getRequestOn(), formatter);
		LocalDateTime pd = LocalDateTime.parse(sIssueMaster_DTO.getProcessedOn(), formatter);
		LocalDateTime ad = LocalDateTime.parse(sIssueMaster_DTO.getAppliedOn(), formatter);		
		Timestamp rs = Timestamp.valueOf(rd);		
		Timestamp ps = Timestamp.valueOf(pd);
		Timestamp as = Timestamp.valueOf(ad);		
		storeIssueMaster.setAssetSeqNo(sIssueMaster_DTO.getAssetSeqNo());
		storeIssueMaster.setConsignQty(sIssueMaster_DTO.getConsignQty());
		storeIssueMaster.setDoneflag(sIssueMaster_DTO.getDoneflag());
		storeIssueMaster.setLocationSeqNo(sIssueMaster_DTO.getLocationSeqNo());
		storeIssueMaster.setOkflag(sIssueMaster_DTO.getOkflag());
		storeIssueMaster.setProcessedQty(sIssueMaster_DTO.getProcessedQty());
		storeIssueMaster.setQtyUnitSeqNo(sIssueMaster_DTO.getQtyUnitSeqNo());
		storeIssueMaster.setQualityQty(sIssueMaster_DTO.getQualityQty());
		storeIssueMaster.setRequestQty(sIssueMaster_DTO.getRequestQty());
		storeIssueMaster.setResourceSeqNo(sIssueMaster_DTO.getResourceSeqNo());		
		storeIssueMaster.setStoreRequestSeqNo(sIssueMaster_DTO.getStoreRequestSeqNo());
		return storeIssueMaster;
	}


}