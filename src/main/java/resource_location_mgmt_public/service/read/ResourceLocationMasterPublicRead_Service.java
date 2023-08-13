package resource_location_mgmt_public.service.read;

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
import common.domain.model.dto.ResourceLocationMaster_DTO;
import common.domain.model.master.*;
import resource_location_mgmt_public.model.read.ResourceLocationMasterPublicRead_Repo;

@Service("resourceLocationMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceLocationMasterPublicRead_Service implements I_ResourceLocationMasterPublicRead_Service 
{

	@Autowired
	private ResourceLocationMasterPublicRead_Repo resourceLocationMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getAllPartyLocationResources() 
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
 		{
		CopyOnWriteArrayList<ResourceLocationMaster> resourceList = (CopyOnWriteArrayList<ResourceLocationMaster>) resourceLocationMasterPublicReadRepo.findAll();
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> lMasters = new CopyOnWriteArrayList<ResourceLocationMaster_DTO>();
		lMasters = resourceList != null ? this.getResourceLocationMaster_DTOs(resourceList) : null;
		return lMasters;
		}, asyncExecutor);
 		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesPartyLocations(CopyOnWriteArrayList<ResourceLocationMasterPK> resourceLocationMasterPKs)
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
 		{
		CopyOnWriteArrayList<ResourceLocationMaster> lMasters = (CopyOnWriteArrayList<ResourceLocationMaster>) resourceLocationMasterPublicReadRepo.findAllById(resourceLocationMasterPKs);
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new CopyOnWriteArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
		}, asyncExecutor);
 		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByLocations( CopyOnWriteArrayList<Long> lidss)
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
 		{
		CopyOnWriteArrayList<ResourceLocationMaster> lMasters = (CopyOnWriteArrayList<ResourceLocationMaster>) resourceLocationMasterPublicReadRepo.getSelectResourcesByLocations(lidss);
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new CopyOnWriteArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
		}, asyncExecutor);
 		return future;
	}
   
	public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByParties(CopyOnWriteArrayList<Long> pids)
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
 		{
		CopyOnWriteArrayList<ResourceLocationMaster> lMasters = (CopyOnWriteArrayList<ResourceLocationMaster>) resourceLocationMasterPublicReadRepo.getSelectResourcesByParties(pids);
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new CopyOnWriteArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
		}, asyncExecutor);
 		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResources(CopyOnWriteArrayList<Long> ridss)
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
 		{
		CopyOnWriteArrayList<ResourceLocationMaster> lMasters = (CopyOnWriteArrayList<ResourceLocationMaster>) resourceLocationMasterPublicReadRepo.getSelectResources(ridss);
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new CopyOnWriteArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
		}, asyncExecutor);
 		return future;
	}
	
	public CompletableFuture<Float> getResourceQoh(Long rid, Long pid, Long lid)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
 		{
 		Float result = 	resourceLocationMasterPublicReadRepo.getResourceQoh(rid, pid, lid);
		return result;
		}, asyncExecutor);
 		return future;
	}
     
	
	private synchronized CopyOnWriteArrayList<ResourceLocationMaster_DTO> getResourceLocationMaster_DTOs(CopyOnWriteArrayList<ResourceLocationMaster> lMaster) {
		ResourceLocationMaster_DTO lDTO = null;
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<ResourceLocationMaster_DTO>();		
		for (int i = 0; i < lMaster.size(); i++) {
			lDTO = getResourceLocationMaster_DTO(lMaster.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized ResourceLocationMaster_DTO getResourceLocationMaster_DTO(ResourceLocationMaster lMaster) 
	{		
		ResourceLocationMaster_DTO lDTO = new ResourceLocationMaster_DTO();
		lDTO.setLocationSeqNo(lMaster.getId().getLocationSeqNo());		
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		lDTO.setPartySeqNo(lMaster.getId().getPartySeqNo());
		lDTO.setQtySeqNo(lMaster.getQtySeqNo());
		lDTO.setQty(lMaster.getQty());
		return lDTO;
	}
	
}