package consignment_master_mgmt.controller.read;

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
import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;
import consignment_master_mgmt.services.read.I_ConsignmentMasterRead_Service;

@RestController
@RequestMapping("/consignmentMasterReadMgmt")
public class ConsignmentMasterRead_Controller {
	@Autowired
	private I_ConsignmentMasterRead_Service consignmentMasterReadService;

	@GetMapping(value = "/getSelectJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectJobMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMasters(jobMasterSeqNos);
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
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectJobMastersFromParties(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersForParties(pids);
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
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectJobMastersToParties(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersToParties(pids);
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
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getAllConsignmentJobMasters() {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getAllConsignmentMasters();
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

	@GetMapping(value = "/getSelectConsignmentMastersByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersByParents(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersByParents(pids);
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

	@GetMapping(value = "/getSelectConsignmentMastersComingIn", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersComingIn() {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersComingIn();
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
		
	@GetMapping(value = "/getSelectConsignmentMastersGoingOut", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersGoingOut() {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersGoingOut();
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
	
	@GetMapping(value = "/getSelectConsignmentMastersPending", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersPending();
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
	
	@GetMapping(value = "/getSelectConsignmentMastersCanBeProcessed", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCanBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersCanBeProcessed();
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

	@GetMapping(value = "/getSelectConsignmentMastersCannotBeProcessed", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCannotBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersCannotBeProcessed();
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

	@GetMapping(value = "/getSelectConsignmentInMastersPending", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentInMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentInMastersPending();
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

	@GetMapping(value = "/getSelectConsignmentOutMastersPending", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentOutMastersPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentOutMastersPending();
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

	@GetMapping(value = "/getSelectConsignmentMastersAppliedOutwards", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersAppliedOutwards() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersAppliedOutwards();
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

	@GetMapping(value = "/getSelectConsignmentMastersAppliedInwards", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersAppliedInwards() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = consignmentMasterReadService.getSelectConsignmentMastersAppliedInwards();
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