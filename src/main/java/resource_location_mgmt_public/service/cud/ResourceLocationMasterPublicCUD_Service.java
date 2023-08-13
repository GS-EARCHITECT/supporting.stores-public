package resource_location_mgmt_public.service.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import common.domain.model.master.ResourceLocationMasterPK;
import resource_location_mgmt_public.model.cud.ResourceLocationMasterPublicCUD_Repo;

@Service("resourceLocationMasterPublicCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceLocationMasterPublicCUD_Service implements I_ResourceLocationMasterPublicCUD_Service 
{

	@Autowired
	private ResourceLocationMasterPublicCUD_Repo resourceLocationMasterPublicCUDRepo;

	@Autowired
	private Executor asyncExecutor;
	
     public	CompletableFuture<Void> addPartyLocationResourceQoh(Long id, Float qty, Long loc, Long py)
     {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
 		{
    	ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(loc);
 		resourceLocationMasterPK.setResourceSeqNo(id);
 		resourceLocationMasterPK.setPartySeqNo(py);
 		
 		if(resourceLocationMasterPublicCUDRepo.existsById(resourceLocationMasterPK))
 		{
 		resourceLocationMasterPublicCUDRepo.addResourceQoh(id, qty, loc, py);	
 		}
 		return;
		}, asyncExecutor);
 		return future;
     }
    
     public	CompletableFuture<Void> subPartyLocationResourceQoh(Long id, Float qty, Long loc, Long py)
     {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
 		{
    	ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(loc);
 		resourceLocationMasterPK.setResourceSeqNo(id);
 		resourceLocationMasterPK.setPartySeqNo(py);
 		
 		if(resourceLocationMasterPublicCUDRepo.existsById(resourceLocationMasterPK))
 		{
 		resourceLocationMasterPublicCUDRepo.subResourceQoh(id, qty, loc, py);	
 		}
 		return;
		}, asyncExecutor);
 		return future;
     }
     
     public	CompletableFuture<Void> setPartyLocationResourceQoh(Long id, Float qty, Long loc, Long py)
     {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
 		{
    	ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(loc);
 		resourceLocationMasterPK.setResourceSeqNo(id);
 		resourceLocationMasterPK.setPartySeqNo(py);
 		
 		if(resourceLocationMasterPublicCUDRepo.existsById(resourceLocationMasterPK))
 		{
 		resourceLocationMasterPublicCUDRepo.setResourceQoh(id, qty, loc, py);	
 		}
 		return;
		}, asyncExecutor);
 		return future;
     }

}