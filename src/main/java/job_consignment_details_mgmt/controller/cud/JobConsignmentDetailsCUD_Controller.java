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

import job_consignment_details_mgmt.model.dto.JobConsignmentDetail_DTO;
import job_consignment_details_mgmt.services.cud.I_JobConsignmentDetailsCUD_Service;

@RestController
@RequestMapping("/jobConsignmentDetailsCUDMgmt")
public class JobConsignmentDetailsCUD_Controller {
	@Autowired
	private I_JobConsignmentDetailsCUD_Service jobConsignmentDetailsCUDService;

	@PostMapping("/newJobConsignmentDetail")
	public ResponseEntity<JobConsignmentDetail_DTO> newJobConsignmentDetail(
			@RequestBody JobConsignmentDetail_DTO jobConsignmentDetail_DTO) {
		CompletableFuture<JobConsignmentDetail_DTO> future = null;
		JobConsignmentDetail_DTO jobConsignmentDetail_DTO2 = null;
		try {
			future = jobConsignmentDetailsCUDService.newJobConsignmentDetail(jobConsignmentDetail_DTO);
			jobConsignmentDetail_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobConsignmentDetail_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updJobConsignmentDetail")
	public void updJobConsignmentDetail(@RequestBody JobConsignmentDetail_DTO jobConsignmentDetail_DTO) {
		jobConsignmentDetailsCUDService.updJobConsignmentDetail(jobConsignmentDetail_DTO);
		return;
	}

	@DeleteMapping("/delSelectJobDetailsForResources")
	public void delSelectJobDetailsForResources(@RequestBody CopyOnWriteArrayList<Long> rids) {
		jobConsignmentDetailsCUDService.delSelectJobConsignmentDetailsByResources(rids);
		return;
	}

	@DeleteMapping("/delSelectJobDetailsForAssets")
	public void delSelectJobDetailsForAssets(@RequestBody CopyOnWriteArrayList<Long> aids) {
		jobConsignmentDetailsCUDService.delSelectJobConsignmentDetailsByAssets(aids);
		return;
	}

	@DeleteMapping("/delAllConsignmentJobDetails")
	public void delAllConsignmentJobDetails() {
		jobConsignmentDetailsCUDService.delAllConsignmentDetails();
		return;
	}

}