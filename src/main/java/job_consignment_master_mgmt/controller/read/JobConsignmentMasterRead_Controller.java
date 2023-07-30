package job_consignment_master_mgmt.controller.read;

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
import job_consignment_master_mgmt.model.dto.JobConsignmentMaster_DTO;
import job_consignment_master_mgmt.services.read.I_JobConsignmentMasterRead_Service;

@RestController
@RequestMapping("/jobConsignmentMasterReadMgmt")
public class JobConsignmentMasterRead_Controller {
	@Autowired
	private I_JobConsignmentMasterRead_Service jobConsignmentMasterReadService;

	@GetMapping(value = "/getSelectJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = jobConsignmentMasterReadService.getSelectJobConsignmentMasters(jobMasterSeqNos);
			jobMasterList = jobMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobMastersFromParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobMastersFromParties(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = jobConsignmentMasterReadService.getSelectJobConsignmentMastersForParties(pids);
			jobMasterList = jobMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobMastersToParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobMastersToParties(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = jobConsignmentMasterReadService.getSelectJobConsignmentMastersToParties(pids);
			jobMasterList = jobMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobConsignmentMastersByRequests", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersByRequests(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = jobConsignmentMasterReadService.getSelectJobConsignmentMastersByRequests(pids);
			jobMasterList = jobMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllConsignmentJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getAllConsignmentJobMasters() {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = jobConsignmentMasterReadService.getAllJobConsignmentMasters();
			jobMasterList = jobMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobConsignmentMastersByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersByParents(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = jobConsignmentMasterReadService.getSelectJobConsignmentMastersByParents(pids);
			jobMasterList = jobMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobMasterList, HttpStatus.OK);
	}

}