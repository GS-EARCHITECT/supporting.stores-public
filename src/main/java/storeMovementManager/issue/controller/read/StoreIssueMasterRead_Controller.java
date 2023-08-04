package storeMovementManager.issue.controller.read;

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
import storeMovementManager.issue.model.dto.StoreIssueMaster_DTO;
import storeMovementManager.issue.services.read.I_StoreIssueMasterRead_Service;

@RestController
@RequestMapping("/storeIssueMasterReadMgmt")
public class StoreIssueMasterRead_Controller 
{
	@Autowired
	private I_StoreIssueMasterRead_Service storeIssueMasterReadService;

	@GetMapping(value = "/getTotalRequestItemQtyForStoreRequest/{sid}/{rid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getTotalRequestItemQtyForStoreRequest(@PathVariable Long sid,  @PathVariable Long rid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getTotalRequestItemQtyForStoreRequest(sid,  rid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getRequestQtyForLineItem/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getRequestQtyForLineItem(@PathVariable Long mid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getRequestQtyForLineItem(mid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getTotalQCItemQtyForStoreRequest/{sid}/{rid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getTotalQCItemQtyForStoreRequest(@PathVariable Long sid,  @PathVariable Long rid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getTotalQCItemQtyForStoreRequest(sid,  rid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/getQCQtyForLineItem/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getQCQtyForLineItem(@PathVariable Long mid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getRequestQtyForLineItem(mid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/getTotalProcessedItemQtyForStoreRequest/{sid}/{rid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getTotalProcessedItemQtyForStoreRequest(@PathVariable Long sid,  @PathVariable Long rid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getTotalProcessedItemQtyForStoreRequest(sid,  rid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/getProcessedItemQtyForStoreRequest/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getProcessedItemQtyForStoreRequest(@PathVariable Long mid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getProcessedQtyForLineItem(mid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getTotalConsignItemQtyForStoreRequest/{sid}/{rid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getTotalConsignItemQtyForStoreRequest(@PathVariable Long sid,  @PathVariable Long rid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getTotalConsignItemQtyForStoreRequest(sid,  rid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/getConsignItemQtyForStoreRequest/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getConsignItemQtyForStoreRequest(@PathVariable Long mid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeIssueMasterReadService.getConsignQtyForLineItem(mid);
			result = qty.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getSelectStoreIssueMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getSelectStoreIssueMasters(jobMasterSeqNos);
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

	@GetMapping(value = "/getSelectStoreIssueMastersByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByLocations(
			@RequestBody CopyOnWriteArrayList<Long> lids) {
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getSelectStoreIssueMastersByLocations(lids);
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

	@GetMapping(value = "/getSelectStoreIssueMastersLineItemsForRequestsNotDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsNotDone(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getSelectStoreIssueMastersLineItemsForRequestsNotDone(ids);
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

	@GetMapping(value = "/getSelectStoreIssueMastersByRequests", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByRequests(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getSelectStoreIssueMastersByRequests(pids);
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

	@GetMapping(value = "/getAllStoreIssueStoreIssueMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getAllStoreIssueStoreIssueMasters() {
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getAllStoreIssueMasters();
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

	@GetMapping(value = "/getSelectStoreIssueMastersLineItemsForRequestsDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsDone(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getSelectStoreIssueMastersLineItemsForRequestsDone(ids);
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

	@GetMapping(value = "/getSelectStoreIssueMastersLineItemsForNotOkStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForNotOkStatus(@PathVariable CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getSelectStoreIssueMastersLineItemsForNotOkStatus(ids);
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
		
	@GetMapping(value = "/getSelectStoreIssueMastersLineItemsForOkStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForOkStatus(@PathVariable CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreIssueMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeIssueMasterReadService.getSelectStoreIssueMastersLineItemsForForOkStatus(ids);
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

