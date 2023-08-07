package store_stock_movement_mgmt.recieve.services.cud;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.UpperCamelCaseStrategy;

import consignment_details_mgmt.model.master.ConsignmentDetail;
import consignment_details_mgmt.model.master.ConsignmentDetailPK;
import consignment_details_mgmt.model.repo.cud.ConsignmentDetailsCUD_Repo;
import consignment_details_mgmt.model.repo.read.ConsignmentDetailsRead_Repo;
import consignment_master_mgmt.model.master.ConsignmentMaster;
import consignment_master_mgmt.model.repo.cud.ConsignmentMasterCUD_Repo;
import consignment_master_mgmt.model.repo.read.ConsignmentMasterRead_Repo;
import oracle.net.aso.s;
import store_order_outwards_mgmt.model.repo.read.StoreOrderOutwardsRead_Repo;
import store_stock_movement_mgmt.recieve.model.dto.StoreRecieveMaster_DTO;
import store_stock_movement_mgmt.recieve.model.master.StoreRecieveMaster;
import store_stock_movement_mgmt.recieve.model.repo.cud.StoreRecieveMasterCUD_Repo;
import store_stock_movement_mgmt.recieve.model.repo.read.StoreRecieveMasterRead_Repo;

@Service("storeRecieveMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StoreRecieveMasterCUD_Service implements I_StoreRecieveMasterCUD_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreRecieveMasterService.class);

	@Autowired
	private StoreRecieveMasterCUD_Repo storeRecieveMasterCUDRepo;
	
	@Autowired
	private ConsignmentMasterCUD_Repo consignmentMasterCUDRepo;
	
	@Autowired
	private ConsignmentMasterRead_Repo consignmentMasterReadRepo;
	
	@Autowired
	private ConsignmentDetailsCUD_Repo consignmentDetailsCUDRepo;	

	@Autowired
	private ConsignmentDetailsRead_Repo consignmentDetailsReadRepo;
	
	@Autowired
	private StoreOrderOutwardsRead_Repo storeOrderOutwardsReadRepo;
	
	@Autowired
	private StoreRecieveMasterRead_Repo storeRecieveMasterReadRepo;
	
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
    		reg_ProcQty = storeRecieveRepo.getTotalProcessedQtyForStoreItem(store_seq_no_curr);
    		reg_Qty = storeRegisterRepo.getRegisterRequestQty(store_seq_no_curr);
    		notVerified = false;
    		
    		if(reg_ProcQty==reg_Qty)
    		{
    		storeTxnFlags = storeRecieveRepo.getStoreVerifiedStatus(store_seq_no_curr);    		    		
    		if(storeTxnFlags.isPresent())
    		{
    		notVerified=checkTxnStoreStatus(storeTxnFlags);    		
    		if(notVerified)
    		{
    		storeRecieveRepo.updateStoreVerifiedStatus(store_seq_no_curr);	
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
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getAllStoreRecieveMasters()  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.findAll();
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}
	*/


	
	@Override
	public CompletableFuture<StoreRecieveMaster_DTO> newRecieveMaster(StoreRecieveMaster_DTO storeRecieveMaster_DTO)
			{
		CompletableFuture<StoreRecieveMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			StoreRecieveMaster_DTO jcmDTO = null;
			if (!storeRecieveMasterCUDRepo.existsById(storeRecieveMaster_DTO.getStoreMovementSeqNo())) 
			{
				Float orderQty = storeOrderOutwardsReadRepo.getOrderOutwardsAllocatedQty(storeRecieveMaster_DTO.getStoreRequestSeqNo());
				Float curQty = storeRecieveMaster_DTO.getRecievedQty();
				
				if(curQty <= orderQty)
				{
				jcmDTO = this.getStoreRecieveMaster_DTO(storeRecieveMasterCUDRepo.save(this.setStoreRecieveMaster_DTO(storeRecieveMaster_DTO)));
				}
			}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updOkStatusForLineItem( Long id,  Character st)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeRecieveMasterCUDRepo.updOkStatusForLineItem( id,  st);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> updOkFlagForLineItem( Long id)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeRecieveMasterCUDRepo.updOkFlagForLineItem( id);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> updDoneStatusForLineItem( Long id,  Character st)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeRecieveMasterCUDRepo.updDoneStatusForLineItem(id,  st);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> updDoneFlagForLineItem( Long id)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			storeRecieveMasterCUDRepo.updDoneFlagForLineItem( id);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> addRecieveQtyForLineItem( Long sid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qltyQty = storeRecieveMasterReadRepo.getQCQtyForLineItem(sid);
		Float curQty = storeRecieveMasterReadRepo.getRecieveQtyForLineItem(sid);		
		Float result = curQty+qty;
		
		if((result >= qltyQty) && (qty > 0)) 
		{
		storeRecieveMasterCUDRepo.addRecievedQtyForLineItem(sid, qty);
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
	public CompletableFuture<Float> subRecieveQtyForLineItem( Long mid,  Float qty)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qltyQty = storeRecieveMasterReadRepo.getQCQtyForLineItem(mid);
		Float curQty = storeRecieveMasterReadRepo.getRecieveQtyForLineItem(mid);		
		Float result = curQty - qty;
		
		if((result >= qltyQty) && (qty > 0))
		{
		storeRecieveMasterCUDRepo.subRecievedQtyForLineItem(mid, qty);		
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
		Float curQty = storeRecieveMasterReadRepo.getQCQtyForLineItem(mid);		
		Float conQty = storeRecieveMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty + qty;
		
		if((result >= conQty) && (qty > 0))
		{
		storeRecieveMasterCUDRepo.addQualityQtyForLineItem(mid, qty);		
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
		Float curQty = storeRecieveMasterReadRepo.getQCQtyForLineItem(mid);		
		Float conQty = storeRecieveMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty - qty;
		
		if((result >= conQty) && (qty > 0))
		{
		storeRecieveMasterCUDRepo.addQualityQtyForLineItem(mid, qty);		
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
	public CompletableFuture<Void> delSelectStoreRecieveMasters(CopyOnWriteArrayList<Long> ids)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.delSelectStoreRecieveMasters(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreRecieveMastersByRequests( CopyOnWriteArrayList<Long> rids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.delSelectStoreRecieveMastersByRequests(rids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreRecieveMastersByLocation( CopyOnWriteArrayList<Long> lids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.delSelectStoreRecieveMastersByLocation(lids);
		return ;
		},asyncExecutor);

	return future;
	}

	
	@Override
	public CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.delSelectStoreRecieveMastersLineItemsForRequestsNotDone(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForRequestsDone( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.delSelectStoreRecieveMastersLineItemsForRequestsDone(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.delSelectStoreRecieveMastersLineItemsForNotOkStatus(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.delSelectStoreRecieveMastersLineItemsForForOkStatus(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delAllStoreRecieveMasters()
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeRecieveMasterCUDRepo.deleteAll();
		return ;
		},asyncExecutor);

	return future;
	}

	
	private synchronized StoreRecieveMaster_DTO getStoreRecieveMaster_DTO(StoreRecieveMaster storeRecieveMaster) 
	{
		StoreRecieveMaster_DTO storeRecieveMaster_DTO = new StoreRecieveMaster_DTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		storeRecieveMaster_DTO.setAppliedOn(formatter.format(storeRecieveMaster.getAppliedOn().toLocalDateTime()));
		storeRecieveMaster_DTO.setAssetSeqNo(storeRecieveMaster.getAssetSeqNo());
		storeRecieveMaster_DTO.setConsignQty(storeRecieveMaster.getConsignQty());
		storeRecieveMaster_DTO.setDoneflag(storeRecieveMaster.getDoneflag());
		storeRecieveMaster_DTO.setLocationSeqNo(storeRecieveMaster.getLocationSeqNo());
		storeRecieveMaster_DTO.setOkflag(storeRecieveMaster.getOkflag());
		storeRecieveMaster_DTO.setQtyUnitSeqNo(storeRecieveMaster.getQtyUnitSeqNo());
		storeRecieveMaster_DTO.setQualityQty(storeRecieveMaster.getQualityQty());
		storeRecieveMaster_DTO.setRecievedOn(formatter.format(storeRecieveMaster.getRecievedOn().toLocalDateTime()));
		storeRecieveMaster_DTO.setRecievedQty(storeRecieveMaster.getRecievedQty());
		storeRecieveMaster_DTO.setResourceSeqNo(storeRecieveMaster.getResourceSeqNo());
		storeRecieveMaster_DTO.setStoreMovementSeqNo(storeRecieveMaster.getStoreMovementSeqNo());
		storeRecieveMaster_DTO.setStoreRequestSeqNo(storeRecieveMaster.getStoreRequestSeqNo());
		return storeRecieveMaster_DTO;
	}
	
	private synchronized StoreRecieveMaster setStoreRecieveMaster_DTO(StoreRecieveMaster_DTO sRecieveMaster_DTO) 
	{
		StoreRecieveMaster storeRecieveMaster = new StoreRecieveMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime rd = LocalDateTime.parse(sRecieveMaster_DTO.getRecievedOn(), formatter);
		LocalDateTime ad = LocalDateTime.parse(sRecieveMaster_DTO.getAppliedOn(), formatter);		
		Timestamp rs = Timestamp.valueOf(rd);
		Timestamp as = Timestamp.valueOf(ad);
		storeRecieveMaster.setAppliedOn(as);
		storeRecieveMaster.setRecievedOn(rs);
		storeRecieveMaster.setAssetSeqNo(sRecieveMaster_DTO.getAssetSeqNo());
		storeRecieveMaster.setConsignQty(sRecieveMaster_DTO.getConsignQty());
		storeRecieveMaster.setDoneflag(sRecieveMaster_DTO.getDoneflag());
		storeRecieveMaster.setLocationSeqNo(sRecieveMaster_DTO.getLocationSeqNo());
		storeRecieveMaster.setOkflag(sRecieveMaster_DTO.getOkflag());		
		storeRecieveMaster.setQtyUnitSeqNo(sRecieveMaster_DTO.getQtyUnitSeqNo());
		storeRecieveMaster.setQualityQty(sRecieveMaster_DTO.getQualityQty());
		storeRecieveMaster.setRecievedQty(sRecieveMaster_DTO.getRecievedQty());
		storeRecieveMaster.setResourceSeqNo(sRecieveMaster_DTO.getResourceSeqNo());		
		storeRecieveMaster.setStoreRequestSeqNo(sRecieveMaster_DTO.getStoreRequestSeqNo());
		return storeRecieveMaster;
	}

}