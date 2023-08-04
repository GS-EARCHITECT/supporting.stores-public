package store_stock_movement_mgmt.issue.services.read;

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

import store_stock_movement_mgmt.issue.model.dto.StoreIssueMaster_DTO;
import store_stock_movement_mgmt.issue.model.master.StoreIssueMaster;
import store_stock_movement_mgmt.issue.model.repo.read.StoreIssueMasterRead_Repo;

@Service("storeIssueMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StoreIssueMasterRead_Service implements I_StoreIssueMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreIssueMasterService.class);

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
	public CompletableFuture<Float> getTotalRequestItemQtyForStoreRequest(Long sid,  Long rid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getTotalRequestItemQtyForStoreRequest(sid,  rid);
		return qty;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> getRequestQtyForLineItem(Long mid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeIssueMasterReadRepo.getRequestQtyForLineItem(mid);
		return qty;
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
	
	private synchronized CopyOnWriteArrayList<StoreIssueMaster_DTO> getStoreIssueMaster_DTOs(CopyOnWriteArrayList<StoreIssueMaster> jobMasters) {
		StoreIssueMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobDTOs = new CopyOnWriteArrayList<StoreIssueMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getStoreIssueMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
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

}