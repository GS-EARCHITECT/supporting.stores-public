package job_consignment_details_mgmt.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job_consignment_details_mgmt.model.dto.JobConsignmentDetail_DTO;
import job_consignment_details_mgmt.services.read.I_JobConsignmentDetailsRead_Service;

@RestController
@RequestMapping("/jobConsignmentDetailsReadMgmt")
public class JobConsignmentDetailsRead_Controller {
	@Autowired
	private I_JobConsignmentDetailsRead_Service jobConsignmentDetailsReadService;

	@GetMapping(value = "/getSelectJobDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobDetails(
			@RequestBody CopyOnWriteArrayList<Long> jobDetailSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = jobConsignmentDetailsReadService.getSelectJobConsignmentDetails(jobDetailSeqNos);
			jobDetailList = jobDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobConsignmentDetailsByResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetailsByResources(
			@RequestBody CopyOnWriteArrayList<Long> rids) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = jobConsignmentDetailsReadService.getSelectJobConsignmentDetailsByResources(rids);
			jobDetailList = jobDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobConsignmentDetailsByAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetailsByAssets(
			@RequestBody CopyOnWriteArrayList<Long> rids) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = jobConsignmentDetailsReadService.getSelectJobConsignmentDetailsByAssets(rids);
			jobDetailList = jobDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllConsignmentJobDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getAllConsignmentJobDetails() {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = jobConsignmentDetailsReadService.getAllJobConsignmentDetails();
			jobDetailList = jobDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailList, HttpStatus.OK);
	}

}