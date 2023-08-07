package store_stock_movement_mgmt.issue.controller.cud;

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
import store_stock_movement_mgmt.issue.model.dto.StoreIssueMaster_DTO;
import store_stock_movement_mgmt.issue.services.cud.I_StoreIssueMasterCUD_Service;

@RestController
@RequestMapping("/storeIssueMasterCUDMgmt")
public class StoreIssueMasterCUD_Controller 
{
	@Autowired
	private I_StoreIssueMasterCUD_Service storeIssueMasterCUDService;

	@PostMapping("/newStoreIssueMaster")
	public ResponseEntity<StoreIssueMaster_DTO> newStoreIssueMaster(
			@RequestBody StoreIssueMaster_DTO storeIssueMaster_DTO) {
		CompletableFuture<StoreIssueMaster_DTO> future = null;
		StoreIssueMaster_DTO storeIssueMaster_DTO2 = null;
		try {
			future = storeIssueMasterCUDService.newIssueMaster(storeIssueMaster_DTO);
			storeIssueMaster_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(storeIssueMaster_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updOkStatusForLineItem/{id}/{st}")
	public void updStoreIssueMasterOk(@PathVariable Long id, @PathVariable Character st)
	{
		storeIssueMasterCUDService.updOkStatusForLineItem(id, st);
		return;
	}

	@PutMapping("/updOkFlagForLineItem/{id}")
	public void updOkFlagForLineItem(@PathVariable Long id)
	{
		storeIssueMasterCUDService.updOkFlagForLineItem(id);
		return;
	}

	@PutMapping("/updDoneStatusForLineItem/{id}/{sst}")
	public void updDoneStatusForLineItem(@PathVariable Long id, @PathVariable Character st)
	{
		storeIssueMasterCUDService.updDoneStatusForLineItem(id, st);
		return;
	}

	@PutMapping("/updDoneFlagForLineItem/{id}")
	public void updDoneFlagForLineItem(@PathVariable Long id)
	{
		storeIssueMasterCUDService.updDoneFlagForLineItem(id);
		return;
	}

	@PutMapping("/addRequestQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> addRequestQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.addRequestQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/subRequestQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> subRequestQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.subRequestQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PutMapping("/addQualityQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> addQualityQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.addQualityQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/subQualityQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> subQualityQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.subQualityQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/addProcessedQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> addProcessedQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.addProcessQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/subProcessedQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> subProcessedQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.subProcessQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	@PutMapping("/addConsignedQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> addConsignedQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.addConsignQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/subConsignedQtyForLineItem/{sid}/{qty}")
	public ResponseEntity<Float> subConsignedQtyForLineItem(@PathVariable Long sid,  Float qty)
	{
		CompletableFuture<Float> future = storeIssueMasterCUDService.subConsignQtyForLineItem(sid, qty);
		Float result= (float) -1;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/delSelectStoreIssueMasters")
	public void delSelectStoreIssueMasters(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		storeIssueMasterCUDService.delSelectStoreIssueMasters(ids);
		return;
	}

	@DeleteMapping("/delSelectStoreIssueMastersByRequests")
	public void delSelectStoreIssueMastersByRequests(@RequestBody CopyOnWriteArrayList<Long> rids) 
	{
		storeIssueMasterCUDService.delSelectStoreIssueMastersByRequests(rids);
		return;
	}

	@DeleteMapping("/delSelectStoreIssueMastersByLocation")
	public void delSelectStoreIssueMastersByLocation(@RequestBody CopyOnWriteArrayList<Long> lids) 
	{
		storeIssueMasterCUDService.delSelectStoreIssueMastersByLocation(lids);
		return;
	}

	@DeleteMapping("/delSelectStoreIssueMastersLineItemsForRequestsNotDone")
	public void delSelectStoreIssueMastersLineItemsForRequestsNotDone(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		storeIssueMasterCUDService.delSelectStoreIssueMastersLineItemsForRequestsNotDone(ids);
		return;
	}

	@DeleteMapping("/delSelectStoreIssueMastersLineItemsForRequestsDone")
	public void delSelectStoreIssueMastersLineItemsForRequestsDone(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		storeIssueMasterCUDService.delSelectStoreIssueMastersLineItemsForRequestsDone(ids);
		return;
	}

	@DeleteMapping("/delSelectStoreIssueMastersLineItemsForNotOkStatus")
	public void delSelectStoreIssueMastersLineItemsForNotOkStatus(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		storeIssueMasterCUDService.delSelectStoreIssueMastersLineItemsForNotOkStatus(ids);
		return;
	}
	
	@DeleteMapping("/delSelectStoreIssueMastersLineItemsForForOkStatus")
	public void delSelectStoreIssueMastersLineItemsForForOkStatus(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		storeIssueMasterCUDService.delSelectStoreIssueMastersLineItemsForForOkStatus(ids);
		return;
	}

	@DeleteMapping("/delAllStoreIssueMasters()")
	public void delAllStoreIssueMasters() 
	{
		storeIssueMasterCUDService.delAllStoreIssueMasters();
		return;
	}
}