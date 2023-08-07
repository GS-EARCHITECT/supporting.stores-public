package consignment_details_mgmt.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import consignment_details_mgmt.model.dto.ConsignmentDetail_DTO;
import consignment_details_mgmt.services.read.I_ConsignmentDetailsRead_Service;

@RestController
@RequestMapping("/consignmentDetailsReadMgmt")
public class ConsignmentDetailsRead_Controller {
	@Autowired
	private I_ConsignmentDetailsRead_Service consignmentDetailsReadService;

	@GetMapping(value = "/getSelectJobConsignmentDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectJobConsignmentDetails(
			@RequestBody CopyOnWriteArrayList<Long> jobDetailSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = consignmentDetailsReadService.getSelectConsignmentDetails(jobDetailSeqNos);
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

	@GetMapping(value = "/getSelectConsignmentDetailsByResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsByResources(
			@RequestBody CopyOnWriteArrayList<Long> rids) {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = consignmentDetailsReadService.getSelectConsignmentDetailsByResources(rids);
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

	@GetMapping(value = "/getSelectConsignmentDetailsByAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsByAssets(
			@RequestBody CopyOnWriteArrayList<Long> rids) {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = consignmentDetailsReadService.getSelectConsignmentDetailsByAssets(rids);
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

	@GetMapping(value = "/getAllConsignmentJobConsignmentDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getAllConsignmentJobConsignmentDetails() {
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetail_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailList = null;
		try {
			jobDetail_DTOs = consignmentDetailsReadService.getAllConsignmentDetails();
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

	@GetMapping(value = "/getSelectConsignmentDetailsPending", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsPending() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetails_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailsList = null;
		try {
			jobDetails_DTOs = consignmentDetailsReadService.getSelectConsignmentDetailsPending();
			jobDetailsList = jobDetails_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectConsignmentDetailsDelivered", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsDelivered() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetails_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailsList = null;
		try {
			jobDetails_DTOs = consignmentDetailsReadService.getSelectConsignmentDetailsDelivered();
			jobDetailsList = jobDetails_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectConsignmentDetailsCanBeProcessed", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsCanBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetails_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailsList = null;
		try {
			jobDetails_DTOs = consignmentDetailsReadService.getSelectConsignmentDetailsCanBeProcessed();
			jobDetailsList = jobDetails_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectConsignmentDetailsCannotBeProcessed", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsCannotBeProcessed() 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetails_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailsList = null;
		try {
			jobDetails_DTOs = consignmentDetailsReadService.getSelectConsignmentDetailsCannotBeProcessed();
			jobDetailsList = jobDetails_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectConsignmentAssetDetailsPending/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentAssetDetailsPending(@PathVariable Long cid) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetails_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailsList = null;
		try {
			jobDetails_DTOs = consignmentDetailsReadService.getSelectConsignmentAssetDetailsPending(cid);
			jobDetailsList = jobDetails_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectConsignmentResourceDetailsPending/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentResourceDetailsPending(@PathVariable Long cid) 
	{
		CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> jobDetails_DTOs = null;
		CopyOnWriteArrayList<ConsignmentDetail_DTO> jobDetailsList = null;
		try {
			jobDetails_DTOs = consignmentDetailsReadService.getSelectConsignmentResourceDetailsPending(cid);
			jobDetailsList = jobDetails_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
	}

}