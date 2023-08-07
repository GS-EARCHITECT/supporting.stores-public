package resource_location_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource_location_mgmt.model.dto.ResourceLocationMaster_DTO;
import resource_location_mgmt.service.I_ResourceLocationMaster_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceLocationManagement")
public class ResourceLocation_Master_Controller {

//	private static final Logger logger = LoggerFactory.getLogger(ResourceLocationMaster_Controller.class);

	@Autowired
	private I_ResourceLocationMaster_Service resourceLocationMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<ResourceLocationMaster_DTO> newresource(@RequestBody ResourceLocationMaster_DTO resourceDTO) {
		ResourceLocationMaster_DTO resourceDTO2 = resourceLocationMasterServ.newCompanyLocationResource(resourceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllCompanyLocationResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceLocationMaster_DTO>> getAllCompanyLocationResources() {
		ArrayList<ResourceLocationMaster_DTO> resourceDTOs = resourceLocationMasterServ.getAllCompanyLocationResources();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyResourcesLocations", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceLocationMaster_DTO>> getSelectCompanyResourcesLocations(@RequestBody ArrayList<Long> coSeqNos, @RequestBody ArrayList<Long> locSeqNos) 
	{
		ArrayList<ResourceLocationMaster_DTO> resourceDTOs = resourceLocationMasterServ.getSelectCompanyResourcesLocations(coSeqNos, locSeqNos);		
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updCompanyResourceLocation")
	public void updCompanyResourceLocation(@RequestBody ResourceLocationMaster_DTO resourceLocationMaster_DTO) 
	{
	resourceLocationMasterServ.updCompanyResourceLocation(resourceLocationMaster_DTO);	
	return;
	}
	
	@PutMapping("/setCompanyLocationResourceQoh/{id}/{qty}/{loc}/{co}")
	public void updateResLocQoh(@PathVariable Long id, @PathVariable Float qty,@PathVariable Long loc, @PathVariable Long co) 
	{
		resourceLocationMasterServ.setCompanyLocationResourceQoh(id, qty, loc, co);	
		return;
	}
	
	@DeleteMapping("/delSelectCompanyResourcesLocations")
	public void deleteresource(@RequestBody ArrayList<Long> cos, @RequestBody ArrayList<Long> locs) 
	{
		resourceLocationMasterServ.delSelectCompanyResourcesLocations(cos, locs);
	}

	@DeleteMapping("/delAllresource")
	public void deleteAllresources() 
	{
		resourceLocationMasterServ.delAllCompanyLocationResources();
		return;
	}
	}