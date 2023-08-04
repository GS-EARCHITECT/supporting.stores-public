package store_stock_movement_mgmt.recieve.controller.read;

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

import store_stock_movement_mgmt.recieve.model.dto.StoreRecieveMaster_DTO;
import store_stock_movement_mgmt.recieve.services.read.I_StoreRecieveMasterRead_Service;

@RestController
@RequestMapping("/storeRecieveMasterReadMgmt")
public class StoreRecieveMasterRead_Controller 
{
	@Autowired
	private I_StoreRecieveMasterRead_Service storeRecieveMasterReadService;

	@GetMapping(value = "/getTotalRequestItemQtyForStoreRequest/{sid}/{rid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getTotalRequestItemQtyForStoreRequest(@PathVariable Long sid,  @PathVariable Long rid)
	{
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeRecieveMasterReadService.getTotalRecieveItemQtyForStoreRequest(sid, rid);
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
			qty = storeRecieveMasterReadService.getRecieveQtyForLineItem(mid);
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
			qty = storeRecieveMasterReadService.getTotalQCItemQtyForStoreRequest(sid,  rid);
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
			qty = storeRecieveMasterReadService.getQCQtyForLineItem(mid);
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
			qty = storeRecieveMasterReadService.getTotalConsignItemQtyForStoreRequest(sid,  rid);
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
			qty = storeRecieveMasterReadService.getConsignQtyForLineItem(mid);
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

	
	@GetMapping(value = "/getSelectStoreRecieveMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getSelectStoreRecieveMasters(jobMasterSeqNos);
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

	@GetMapping(value = "/getSelectStoreRecieveMastersByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersByLocations(
			@RequestBody CopyOnWriteArrayList<Long> lids) {
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getSelectStoreRecieveMastersByLocations(lids);
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

	@GetMapping(value = "/getSelectStoreRecieveMastersLineItemsForRequestsNotDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForRequestsNotDone(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getSelectStoreRecieveMastersLineItemsForRequestsNotDone(ids);
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

	@GetMapping(value = "/getSelectStoreRecieveMastersByRequests", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersByRequests(
			@RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getSelectStoreRecieveMastersByRequests(pids);
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

	@GetMapping(value = "/getAllStoreRecieveStoreRecieveMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getAllStoreRecieveStoreRecieveMasters() {
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getAllStoreRecieveMasters();
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

	@GetMapping(value = "/getSelectStoreRecieveMastersLineItemsForRequestsDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForRequestsDone(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getSelectStoreRecieveMastersLineItemsForRequestsDone(ids);
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

	@GetMapping(value = "/getSelectStoreRecieveMastersLineItemsForNotOkStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForNotOkStatus(@PathVariable CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getSelectStoreRecieveMastersLineItemsForNotOkStatus(ids);
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
		
	@GetMapping(value = "/getSelectStoreRecieveMastersLineItemsForOkStatus", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForOkStatus(@PathVariable CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> jobMaster_DTOs = null;
		CopyOnWriteArrayList<StoreRecieveMaster_DTO> jobMasterList = null;
		try {
			jobMaster_DTOs = storeRecieveMasterReadService.getSelectStoreRecieveMastersLineItemsForForOkStatus(ids);
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
