package store_stock_movement_mgmt.recieve.services.read;

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

import store_stock_movement_mgmt.recieve.model.dto.StoreRecieveMaster_DTO;
import store_stock_movement_mgmt.recieve.model.master.StoreRecieveMaster;
import store_stock_movement_mgmt.recieve.model.repo.read.StoreRecieveMasterRead_Repo;

@Service("storeRecieveMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StoreRecieveMasterRead_Service implements I_StoreRecieveMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreRecieveMasterService.class);

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
	public CompletableFuture<Float> getTotalRecieveItemQtyForStoreRequest(Long sid,  Long rid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeRecieveMasterReadRepo.getTotalRecieveItemQtyForStoreRequest(sid,  rid);
		return qty;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> getRecieveQtyForLineItem(Long mid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeRecieveMasterReadRepo.getRecieveQtyForLineItem(mid);
		return qty;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> getTotalQCItemQtyForStoreRequest(Long sid,  Long rid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeRecieveMasterReadRepo.getTotalQCItemQtyForStoreRequest(sid,  rid);
		return qty;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<Float> getQCQtyForLineItem(Long mid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeRecieveMasterReadRepo.getQCQtyForLineItem(mid);
		return qty;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<Float> getTotalConsignItemQtyForStoreRequest(Long sid,  Long rid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeRecieveMasterReadRepo.getTotalConsignItemQtyForStoreRequest(sid,  rid);
		return qty;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<Float> getConsignQtyForLineItem(Long mid)  
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float qty = storeRecieveMasterReadRepo.getConsignQtyForLineItem(mid);
		return qty;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.getSelectStoreRecieveMasters(jcmSeqNos);
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersByRequests(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.getSelectStoreRecieveMastersByRequests(pids);
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersByLocations( CopyOnWriteArrayList<Long> lids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.getSelectStoreRecieveMastersByLocations(lids);
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.getSelectStoreRecieveMastersLineItemsForRequestsNotDone(ids);
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForRequestsDone(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.getSelectStoreRecieveMastersLineItemsForRequestsDone(ids);
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.getSelectStoreRecieveMastersLineItemsForNotOkStatus(ids);
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreRecieveMaster> jobList = (CopyOnWriteArrayList<StoreRecieveMaster>) storeRecieveMasterReadRepo.getSelectStoreRecieveMastersLineItemsForForOkStatus(ids);
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();
		jcmDTOs = jobList != null ? this.getStoreRecieveMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
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
	
	private synchronized CopyOnWriteArrayList<StoreRecieveMaster_DTO> getStoreRecieveMaster_DTOs(CopyOnWriteArrayList<StoreRecieveMaster> jobMasters) {
		StoreRecieveMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobDTOs = new CopyOnWriteArrayList<StoreRecieveMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getStoreRecieveMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
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
		storeRecieveMaster_DTO.setProcessedOn(formatter.format(storeRecieveMaster.getProcessedOn().toLocalDateTime()));
		storeRecieveMaster_DTO.setQtyUnitSeqNo(storeRecieveMaster.getQtyUnitSeqNo());
		storeRecieveMaster_DTO.setQualityQty(storeRecieveMaster.getQualityQty());
		storeRecieveMaster_DTO.setRecievedOn(formatter.format(storeRecieveMaster.getRecievedOn().toLocalDateTime()));
		storeRecieveMaster_DTO.setRecievedQty(storeRecieveMaster.getRecievedQty());
		storeRecieveMaster_DTO.setResourceSeqNo(storeRecieveMaster.getResourceSeqNo());
		storeRecieveMaster_DTO.setStoreMovementSeqNo(storeRecieveMaster.getStoreMovementSeqNo());
		storeRecieveMaster_DTO.setStoreRequestSeqNo(storeRecieveMaster.getStoreRequestSeqNo());
		return storeRecieveMaster_DTO;
	}

}