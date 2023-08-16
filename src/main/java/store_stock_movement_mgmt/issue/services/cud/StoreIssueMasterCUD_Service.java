package store_stock_movement_mgmt.issue.services.cud;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import consignment_details_mgmt.model.master.ConsignmentDetail;
import consignment_details_mgmt.model.master.ConsignmentDetailPK;
import consignment_details_mgmt.model.repo.cud.ConsignmentDetailsCUD_Repo;
import consignment_details_mgmt.model.repo.read.ConsignmentDetailsRead_Repo;
import consignment_master_mgmt.model.master.ConsignmentMaster;
import consignment_master_mgmt.model.repo.cud.ConsignmentMasterCUD_Repo;
import store_order_asset_outwards_mgmt.model.repo.read.StoreOrderAssetOutwardsReadPublic_Repo;
import store_order_resource_outwards_mgmt.model.repo.read.StoreOrderResourceOutwardsReadPublic_Repo;
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
	private ConsignmentDetailsCUD_Repo consignmentDetailsCUDRepo;	

	@Autowired
	private ConsignmentDetailsRead_Repo consignmentDetailsReadRepo;
	
	@Autowired
	private StoreOrderResourceOutwardsReadPublic_Repo storeOrderResourceOutwardsReadPublicRepo;
	
	@Autowired
	private StoreOrderAssetOutwardsReadPublic_Repo storeOrderAssetOutwardsReadPublicRepo;
	
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
				Float orderQtyRs = (float) 0;
				Character oFlag = null; 
				if(storeIssueMaster_DTO.getAssetSeqNo()!=null &&  storeIssueMaster_DTO.getAssetSeqNo()>0)
				{				
				oFlag = Character.toUpperCase(storeOrderAssetOutwardsReadPublicRepo.getOrderAllocatedFlag(storeIssueMaster_DTO.getStoreRequestSeqNo()));    			
				if(!oFlag.equals('Y'))
				{
				orderQtyRs = (float) 1 ;	
				}
				}
				else
				{
				orderQtyRs = storeOrderResourceOutwardsReadPublicRepo.getOrderAllocatedQty(storeIssueMaster_DTO.getStoreRequestSeqNo());	
				}
				
				Float curQty = storeIssueMaster_DTO.getRequestQty() + storeIssueMasterReadRepo.getTotalRequestItemQtyForStoreRequest(storeIssueMaster_DTO.getStoreRequestSeqNo());
				
				if(curQty <= orderQtyRs)
				{
				jcmDTO = this.getStoreIssueMaster_DTO(storeIssueMasterCUDRepo.save(this.setStoreIssueMaster_DTO(storeIssueMaster_DTO)));
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
		Optional<StoreIssueMaster> storeIssueMasterOpt = storeIssueMasterReadRepo.findById(sid);
		
		Float result = (float) 0;
		if(storeIssueMasterOpt!=null)
		{
		StoreIssueMaster storeIssueMaster = storeIssueMasterOpt.get();
		Float allocQty = (float) 0;		
		Float curQty  = storeIssueMaster.getRequestQty();
		Long resAssetFlag =  storeIssueMaster.getAssetSeqNo();
		
		if(resAssetFlag !=0 && resAssetFlag>0)
		{		
		Character allocFlag = storeOrderAssetOutwardsReadPublicRepo.getOrderAllocatedFlag(storeIssueMaster.getStoreRequestSeqNo());
		if(allocFlag.equals('Y'))
		{
		allocQty = (float) 1 ;	
		}		
		}
		else
		{
		allocQty = storeOrderResourceOutwardsReadPublicRepo.getOrderAllocatedQty(storeIssueMaster.getStoreRequestSeqNo());	
		}
		
		Float totQty = qty + storeIssueMasterReadRepo.getTotalRequestItemQtyForStoreRequest(sid);
		
		if((totQty<=allocQty) && (qty > 0))
		{
		storeIssueMasterCUDRepo.addRequestQtyForLineItem(sid, qty);
		result = curQty+qty;
		}
		else
		{
		result= (float) -1;	
		}
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
		Float result = curQty + qty;
		
		if((result <= reqQty) && (qty > 0))
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
		Float result = curQty + qty;
		
		if((result <= qlyQty) && (qty > 0)) 
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
		ConsignmentMaster consignmentMaster = new ConsignmentMaster();
		ConsignmentDetail consignmentDetail = new ConsignmentDetail();
		ConsignmentDetailPK consignmentDetailPK = new ConsignmentDetailPK(); 
		Optional<StoreIssueMaster> storeIssueMasterOpt = storeIssueMasterReadRepo.findById(mid);
		StoreIssueMaster storeIssueMaster = storeIssueMasterOpt.get();
		consignmentMaster.setDoneflag('N');
		consignmentMaster.setInflag('N');
		consignmentMaster.setOkflag('Y');		
		consignmentDetail.setDoneFlag('N');				
		ConsignmentMaster cm =  consignmentMasterCUDRepo.save(consignmentMaster);		
		consignmentDetailPK.setConsignmentSeqNo(cm.getConsignmentSeqNo());
		consignmentDetailPK.setStoreMovementSeqNo(storeIssueMaster.getStoreMovementSeqNo());
		consignmentDetail.setId(consignmentDetailPK);
		if(storeIssueMaster.getAssetSeqNo()==null || storeIssueMaster.getAssetSeqNo()<=0)
		{
		consignmentDetail.setResourceSeqNo(storeIssueMaster.getResourceSeqNo());
		consignmentDetail.setQty(qty);
		}
		else
		{
		consignmentDetail.setAssetSeqNo(storeIssueMaster.getAssetSeqNo());
		consignmentDetail.setQty((float) 1);
		}					
		consignmentDetailsCUDRepo.save(consignmentDetail);
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
		Float curQty = storeIssueMasterReadRepo.getConsignQtyForLineItem(mid);
		Float result = curQty - qty;
		Optional<StoreIssueMaster> storeIssueMasterOpt = storeIssueMasterReadRepo.findById(mid);
		StoreIssueMaster storeIssueMaster = storeIssueMasterOpt.get();
		Long rid = storeIssueMaster.getResourceSeqNo();
		Long aid = storeIssueMaster.getAssetSeqNo();
		CopyOnWriteArrayList<ConsignmentDetail> consignmentDetails = null;
						
		if(rid != null)
		{
		consignmentDetails = consignmentDetailsReadRepo.getSelectConsignmentResourceDetailsPendingForMovement(mid, rid);
		}
		else
		{
		consignmentDetails = consignmentDetailsReadRepo.getSelectConsignmentAssetDetailsPendingForMovement(mid, aid);	
		}
		
		Float pendingQty = (float) 0;
		
		if(consignmentDetails !=null && aid!=null)
		{
		for (int i = 0; i < consignmentDetails.size(); i++) 
		{			
		pendingQty = pendingQty + consignmentDetailsReadRepo.getTotalSelectConsignmentAssetDetailsPendingForConsignment(consignmentDetails.get(i).getId().getConsignmentSeqNo(),aid);
		}
		}
		else
		{
		for (int i = 0; i < consignmentDetails.size(); i++) 
		{			
		pendingQty = pendingQty + consignmentDetailsReadRepo.getTotalSelectConsignmentResourceDetailsPendingForConsignment(consignmentDetails.get(i).getId().getConsignmentSeqNo(),rid);
		}	
		}
		
		if((result > 0) && (pendingQty >= result))
		{
		storeIssueMasterCUDRepo.subConsignQtyForLineItem(mid, qty);		
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
	public CompletableFuture<Void> delSelectStoreIssueMasters(CopyOnWriteArrayList<Long> ids)  
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.delSelectStoreIssueMasters(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreIssueMastersByRequests( CopyOnWriteArrayList<Long> rids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.delSelectStoreIssueMastersByRequests(rids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreIssueMastersByLocation( CopyOnWriteArrayList<Long> lids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.delSelectStoreIssueMastersByLocation(lids);
		return ;
		},asyncExecutor);

	return future;
	}

	
	@Override
	public CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.delSelectStoreIssueMastersLineItemsForRequestsNotDone(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForRequestsDone( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.delSelectStoreIssueMastersLineItemsForRequestsDone(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.delSelectStoreIssueMastersLineItemsForNotOkStatus(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.delSelectStoreIssueMastersLineItemsForForOkStatus(ids);
		return ;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Void> delAllStoreIssueMasters()
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
		storeIssueMasterCUDRepo.deleteAll();
		return ;
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
		storeIssueMaster.setAppliedOn(as);
		storeIssueMaster.setProcessedOn(ps);
		storeIssueMaster.setRequestOn(rs);
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