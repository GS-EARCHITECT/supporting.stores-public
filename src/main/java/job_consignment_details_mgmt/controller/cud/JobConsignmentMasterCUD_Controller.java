package job_consignment_details_mgmt.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import job_consignment_master_mgmt.model.dto.JobConsignmentMaster_DTO;
import job_consignment_master_mgmt.services.cud.I_JobConsignmentMasterCUD_Service;

@RestController
@RequestMapping("/jobConsignmentMasterCUDMgmt")
public class JobConsignmentMasterCUD_Controller {
	@Autowired
	private I_JobConsignmentMasterCUD_Service jobConsignmentMasterCUDService;

	@PostMapping("/newJobConsignmentMaster")
	public ResponseEntity<JobConsignmentMaster_DTO> newJobConsignmentMaster(
			@RequestBody JobConsignmentMaster_DTO jobConsignmentMaster_DTO) {
		CompletableFuture<JobConsignmentMaster_DTO> future = null;
		JobConsignmentMaster_DTO jobConsignmentMaster_DTO2 = null;
		try {
			future = jobConsignmentMasterCUDService.newJobConsignmentMaster(jobConsignmentMaster_DTO);
			jobConsignmentMaster_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobConsignmentMaster_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updJobConsignmentMaster")
	public void updJobConsignmentMaster(@RequestBody JobConsignmentMaster_DTO jobConsignmentMaster_DTO) {
		jobConsignmentMasterCUDService.updJobConsignmentMaster(jobConsignmentMaster_DTO);
		return;
	}

	@DeleteMapping("/delSelectJobMastersFromParties")
	public void delSelectJobMastersFromParties(@RequestBody CopyOnWriteArrayList<Long> pids) {
		jobConsignmentMasterCUDService.delSelectJobConsignmentMastersForParties(pids);
		return;
	}

	@DeleteMapping("/delSelectJobMastersToParties")
	public void delSelectJobMastersToParties(@RequestBody CopyOnWriteArrayList<Long> pids) {
		jobConsignmentMasterCUDService.delSelectJobConsignmentMastersToParties(pids);
		return;
	}

	@DeleteMapping("/delSelectJobConsignmentMastersByRequests")
	public void delSelectJobConsignmentMastersByRequests(@RequestBody CopyOnWriteArrayList<Long> pids) {
		jobConsignmentMasterCUDService.delSelectJobConsignmentMastersByRequests(pids);
		return;
	}

	@DeleteMapping("/delAllConsignmentJobMasters")
	public void delAllConsignmentJobMasters() {
		jobConsignmentMasterCUDService.delAllConsignmentMasters();
		return;
	}

	@DeleteMapping("/delSelectJobConsignmentMastersByParents")
	public void delSelectJobConsignmentMastersByParents(@RequestBody CopyOnWriteArrayList<Long> pids) {
		jobConsignmentMasterCUDService.delSelectJobConsignmentMastersByParents(pids);
		return;
	}

}