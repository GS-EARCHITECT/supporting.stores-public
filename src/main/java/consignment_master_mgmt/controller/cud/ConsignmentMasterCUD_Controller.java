package consignment_master_mgmt.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;
import consignment_master_mgmt.services.cud.I_ConsignmentMasterCUD_Service;

@RestController
@RequestMapping("/consignmentMasterCUDMgmt")
public class ConsignmentMasterCUD_Controller {
	@Autowired
	private I_ConsignmentMasterCUD_Service consignmentMasterCUDService;

	@PostMapping("/newConsignmentMaster")
	public ResponseEntity<ConsignmentMaster_DTO> newConsignmentMaster(
			@RequestBody ConsignmentMaster_DTO consignmentMaster_DTO) {
		CompletableFuture<ConsignmentMaster_DTO> future = null;
		ConsignmentMaster_DTO consignmentMaster_DTO2 = null;
		try {
			future = consignmentMasterCUDService.newConsignmentMaster(consignmentMaster_DTO);
			consignmentMaster_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(consignmentMaster_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updConsignmentMaster")
	public void updConsignmentMaster(@RequestBody ConsignmentMaster_DTO consignmentMaster_DTO) {
		consignmentMasterCUDService.updConsignmentMaster(consignmentMaster_DTO);
		return;
	}

	@PutMapping("/updConsignmentMasterOk/{scid}")
	public void updConsignmentMasterOk(@PathVariable Long scid)
	{
		consignmentMasterCUDService.updConsignmentMasterOk(scid);
		return;
	}

	@PutMapping("/updConsignmentMasterOkStatus/{scid}/{st}")
	public void updConsignmentMasterOkStatus(@PathVariable Long scid, @PathVariable Character st)
	{
		consignmentMasterCUDService.updConsignmentMasterOkStatus(scid, st);
		return;
	}

	@PutMapping("/updConsignmentMasterDone/{scid}")
	public void updConsignmentMasterDone(@PathVariable Long scid)
	{
		consignmentMasterCUDService.updConsignmentMasterDone(scid);
		return;
	}

	@PutMapping("/updConsignmentMasterDoneStatus/{scid}/{st}")
	public void updConsignmentMasterDone(@PathVariable Long scid, @PathVariable Character st)
	{
		consignmentMasterCUDService.updConsignmentMasterDoneStatus(scid, st);
		return;
	}

	
	@DeleteMapping("/delSelectJobMastersFromParties")
	public void delSelectJobMastersFromParties(@RequestBody CopyOnWriteArrayList<Long> pids) {
		consignmentMasterCUDService.delSelectConsignmentMastersForParties(pids);
		return;
	}

	@DeleteMapping("/delSelectJobMastersToParties")
	public void delSelectJobMastersToParties(@RequestBody CopyOnWriteArrayList<Long> pids) {
		consignmentMasterCUDService.delSelectConsignmentMastersToParties(pids);
		return;
	}

	@DeleteMapping("/delSelectConsignmentMastersByRequests")
	public void delSelectConsignmentMastersByRequests(@RequestBody CopyOnWriteArrayList<Long> pids) {
		consignmentMasterCUDService.delSelectConsignmentMastersByRequests(pids);
		return;
	}

	@DeleteMapping("/delAllConsignmentJobMasters")
	public void delAllConsignmentJobMasters() {
		consignmentMasterCUDService.delAllConsignmentMasters();
		return;
	}

	@DeleteMapping("/delSelectConsignmentMastersByParents")
	public void delSelectConsignmentMastersByParents(@RequestBody CopyOnWriteArrayList<Long> pids) {
		consignmentMasterCUDService.delSelectConsignmentMastersByParents(pids);
		return;
	}

}