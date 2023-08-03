package storeMovementManager.issue.services.read;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import storeMovementManager.issue.model.repo.read.StoreIssueRead_Repo;

@Service("storeIssueReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StoreIssueRead_Service implements I_StoreIssueRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreIssueService.class);

	@Autowired
	private StoreIssueRead_Repo storeIssueReadRepo;
	
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
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getAllStoreIssues()  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.findAll();
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}
	*/

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssues(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssues(jcmSeqNos);
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesByRequests(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesByRequests(pids);
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesByParents(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesByParents(pids);
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesForParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesForParties(pids);
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesToParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesToParties(pids);
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesComingIn() 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesComingIn();
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesGoingOut() 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesGoingOut();
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesPending();
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesDelivered() 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesDelivered();
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesCanBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesCanBeProcessed();
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> getSelectStoreIssuesCannotBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssue_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreIssue> jobList = (CopyOnWriteArrayList<StoreIssue>) storeIssueReadRepo.getSelectStoreIssuesCannotBeProcessed();
		CopyOnWriteArrayList<StoreIssue_DTO> jcmDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();
		jcmDTOs = jobList != null ? this.getStoreIssue_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	
	private synchronized CopyOnWriteArrayList<StoreIssue_DTO> getStoreIssue_DTOs(CopyOnWriteArrayList<StoreIssue> jobMasters) {
		StoreIssue_DTO jobDTO = null;
		CopyOnWriteArrayList<StoreIssue_DTO> jobDTOs = new CopyOnWriteArrayList<StoreIssue_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getStoreIssue_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized StoreIssue_DTO getStoreIssue_DTO(StoreIssue jobMaster2) 
	{
		StoreIssue_DTO jobMasterDTO = new StoreIssue_DTO();
		jobMasterDTO = new StoreIssue_DTO();
		jobMasterDTO.setConsignmentSeqNo(jobMaster2.getConsignmentSeqNo());
		jobMasterDTO.setFromLocationSeqNo(jobMaster2.getFromLocationSeqNo());
		jobMasterDTO.setFromPartySeqNo(jobMaster2.getFromPartySeqNo());		
		jobMasterDTO.setParConsignmentSeqNo(jobMaster2.getParConsignmentSeqNo());
		jobMasterDTO.setStoreRequestSeqNo(jobMaster2.getStoreRequestSeqNo());
		jobMasterDTO.setToLocationSeqNo(jobMaster2.getToLocationSeqNo());
		jobMasterDTO.setToPartySeqNo(jobMaster2.getToPartySeqNo());		
		jobMasterDTO.setRemark(jobMaster2.getRemark());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		return jobMasterDTO;
	}

}