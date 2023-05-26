package storeMovementManager.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("storeIssueRepo")
public interface StoreRecieveRepo extends CrudRepository<StoreIssueMaster, StoreMovementMasterPK> 
{
	
	    
} 

