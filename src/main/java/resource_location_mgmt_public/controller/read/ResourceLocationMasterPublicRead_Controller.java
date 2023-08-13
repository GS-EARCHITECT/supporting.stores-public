package resource_location_mgmt_public.controller.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import common.domain.model.dto.ResourceLocationMaster_DTO;
import resource_location_mgmt_public.service.read.I_ResourceLocationMasterPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceLocationPublicReadManagement")
public class ResourceLocationMasterPublicRead_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ResourceLocationMaster_Controller.class);

	@Autowired
	private I_ResourceLocationMasterPublicRead_Service resourceLocationMasterPublicReadService;
	
	@GetMapping(value = "/getSelectResourcesPartyLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesPartyLocations() 
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = null;
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = null;
		try {
			future = resourceLocationMasterPublicReadService.getAllPartyLocationResources();
			resourceLocationMaster_DTOs = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(resourceLocationMaster_DTOs, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getSelectResourcesByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByLocations(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = null;
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = null;
		try {
			future = resourceLocationMasterPublicReadService.getSelectResourcesByLocations(ids);
			resourceLocationMaster_DTOs = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(resourceLocationMaster_DTOs, HttpStatus.OK);

	}

	@GetMapping(value = "/getSelectResourcesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByParties(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = null;
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = null;
		try {
			future = resourceLocationMasterPublicReadService.getSelectResourcesByParties(ids);
			resourceLocationMaster_DTOs = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(resourceLocationMaster_DTOs, HttpStatus.OK);

	}

	@GetMapping(value = "/getSelectResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResources(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> future = null;
		CopyOnWriteArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = null;
		try {
			future = resourceLocationMasterPublicReadService.getSelectResources(ids);
			resourceLocationMaster_DTOs = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(resourceLocationMaster_DTOs, HttpStatus.OK);

	}

	@GetMapping(value = "/getResourceQoh/{cid}/{pid}/{lid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getResourceQoh(@PathVariable Long cid, @PathVariable Long pid, @PathVariable Long lid) 
	{
		CompletableFuture<Float> future = null;
		Float result = null;
		try {
			future = resourceLocationMasterPublicReadService.getResourceQoh(cid, pid, lid);					
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

}