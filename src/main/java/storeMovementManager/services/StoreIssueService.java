package storeMovementManager.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import common.domain.model.StoreRegisterRepo;
import storeMovementManager.model.StoreIssueRepo;
import storeRegisterManagement.services.StoreRegisterService;

@Service("storeIssueServ")
public class StoreIssueService implements I_StoreIssueService 
{
	private static final Logger logger = LoggerFactory.getLogger(StoreRegisterService.class);
	
	@Autowired
    private StoreRegisterRepo storeRegisterRepo;
	
	@Autowired
    private StoreIssueRepo storeIssueRepo;
		
	/* DO Process Init   
	 * 
	 */	
	@Scheduled(fixedRate=3000)
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
    public void check_Processed() 
    {	    	
		logger.info("Store Issue Process Job Start");
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

	
}