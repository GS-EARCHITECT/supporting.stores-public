package resource_location_mgmt_public.controller.cud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource_location_mgmt_public.service.cud.I_ResourceLocationMasterPublicCUD_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceLocationPublicCUDManagement")
public class ResourceLocationMasterPublicCUD_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ResourceLocationMaster_Controller.class);

	@Autowired
	private I_ResourceLocationMasterPublicCUD_Service resourceLocationMasterPublicCUDServ;
	
	
	@PostMapping("/addPartyLocationResourceQoh/{id}/{qty}/{loc}/{py}")
	public void addPartyLocationResourceQoh(@PathVariable Long id, @PathVariable Float qty, @PathVariable Long loc, @PathVariable Long py) 
	{
		resourceLocationMasterPublicCUDServ.addPartyLocationResourceQoh(id, qty, loc, py);
		return; 
	}
	
	@PostMapping("/subPartyLocationResourceQoh/{id}/{qty}/{loc}/{py}")
	public void subPartyLocationResourceQoh(@PathVariable Long id, @PathVariable Float qty, @PathVariable Long loc, @PathVariable Long py) 
	{
		resourceLocationMasterPublicCUDServ.subPartyLocationResourceQoh(id, qty, loc, py);
		return; 
	}
	
	@PostMapping("/setPartyLocationResourceQoh/{id}/{qty}/{loc}/{py}")
	public void setPartyLocationResourceQoh(@PathVariable Long id, @PathVariable Float qty, @PathVariable Long loc, @PathVariable Long py) 
	{
		resourceLocationMasterPublicCUDServ.setPartyLocationResourceQoh(id, qty, loc, py);
		return; 
	}
	}