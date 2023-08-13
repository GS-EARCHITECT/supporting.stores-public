package store_order_asset_inwards_mgmt.controller.read;

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

import store_order_asset_inwards_mgmt.model.dto.StoreOrderAssetInward_DTO;
import store_order_asset_inwards_mgmt.services.read.I_StoreOrderAssetInwardsReadPublic_Service;

@RestController
@RequestMapping("/storeOrderAssetInwardsReadPublicMgmt")
public class StoreOrderAssetInwardsReadPublic_Controller {
	@Autowired
	private I_StoreOrderAssetInwardsReadPublic_Service storeOrderAssetInwardsReadPublicServ;

	@GetMapping(value = "/getAllStoreInwards", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getAllStoreInwards() {
		CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> stMaster_DTOs = null;
		CopyOnWriteArrayList<StoreOrderAssetInward_DTO> stMasterList = null;
		try {
			stMaster_DTOs = storeOrderAssetInwardsReadPublicServ.getAllStoreInwards();
			stMasterList = stMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(stMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectOrderInwards", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getSelectOrderInwards(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> stMaster_DTOs = null;
		CopyOnWriteArrayList<StoreOrderAssetInward_DTO> stMasterList = null;
		try {
			stMaster_DTOs = storeOrderAssetInwardsReadPublicServ.getSelectOrderInwards(ids);
			stMasterList = stMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(stMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllRowsForMode/{md}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getAllRowsForMode(@PathVariable Short md) {
		CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> stMaster_DTOs = null;
		CopyOnWriteArrayList<StoreOrderAssetInward_DTO> stMasterList = null;
		try {
			stMaster_DTOs = storeOrderAssetInwardsReadPublicServ.getAllRowsForMode(md);
			stMasterList = stMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(stMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getIsBookedStatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Character> getIsBookedStatus(@PathVariable Long id) {
		CompletableFuture<Character> future = null;
		Character st = null;
		try {
			future = storeOrderAssetInwardsReadPublicServ.getIsbookedStatus(id);
			st = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(st, HttpStatus.OK);
	}

	@GetMapping(value = "/getIsDoneStatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Character> getIsDoneStatus(@PathVariable Long id) {
		CompletableFuture<Character> future = null;
		Character st = null;
		try {
			future = storeOrderAssetInwardsReadPublicServ.getIsDoneStatus(id);
			st = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(st, HttpStatus.OK);
	}

	@GetMapping(value = "/getIsOkStatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Character> getIsOkStatus(@PathVariable Long id) {
		CompletableFuture<Character> future = null;
		Character st = null;
		try {
			future = storeOrderAssetInwardsReadPublicServ.getIsOkStatus(id);
			st = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(st, HttpStatus.OK);
	}

	@GetMapping(value = "/getOrderRequestedFlag/{sid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getOrderRequestedFlag(@PathVariable Long sid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getOrderRequestedFlag(sid);
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

	@GetMapping(value = "/getCountRequestedForJob/{jid}/{rid}/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountRequestedForJob(@PathVariable Long jid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountRequestedForJob(jid, rid, mid);
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

	@GetMapping(value = "/getCountRequestedBeforeThisRequest/{sid}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountRequestedBeforeThisRequest(@PathVariable Long sid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountRequestedBeforeThisRequest(sid, rid, mid);
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

	@GetMapping(value = "/getCountRequestedBeforeDTTM/{dt}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountRequestedBeforeDTTM(@PathVariable String dt, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountRequestedBeforeDTTM(dt, rid, mid);
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

	@GetMapping(value = "/getOrderAllocatedFlag/{sid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getOrderAllocatedFlag(@PathVariable Long sid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getOrderAllocatedFlag(sid);
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

	@GetMapping(value = "/getCountAllocatedForJob/{jid}/{rid}/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountAllocatedForJob(@PathVariable Long jid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountAllocatedForJob(jid, rid, mid);
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

	@GetMapping(value = "/getCountAllocatedBeforeThisRequest/{sid}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountAllocatedBeforeThisRequest(@PathVariable Long sid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountAllocatedBeforeThisRequest(sid, rid, mid);
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

	@GetMapping(value = "/getCountAllocatedBeforeDTTM/{dt}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountAllocatedBeforeDTTM(@PathVariable String dt, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountAllocatedBeforeDTTM(dt, rid, mid);
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

	@GetMapping(value = "/getOrderBookedFlag/{sid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getOrderBookedFlag(@PathVariable Long sid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getOrderBookedFlag(sid);
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

	@GetMapping(value = "/getCountBookedForJob/{jid}/{rid}/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountBookedForJob(@PathVariable Long jid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountBookedForJob(jid, rid, mid);
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

	@GetMapping(value = "/getCountBookedBeforeThisRequest/{sid}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountBookedBeforeThisRequest(@PathVariable Long sid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountBookedBeforeThisRequest(sid, rid, mid);
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

	@GetMapping(value = "/getCountBookedBeforeDTTM/{dt}/{rid}/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountBookededBeforeDTTM(@PathVariable String dt, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountBookedBeforeDTTM(dt, rid, mid);
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

	@GetMapping(value = "/getMovedFlagForRequest/{sid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getMovedFlagForRequest(@PathVariable Long sid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getOrderMovedFlag(sid);
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

	@GetMapping(value = "/getCountMovedForAssetForJob/{jid}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountMovedForAssetForJob(@PathVariable Long jid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountMovedForJob(jid, rid, mid);
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

	@GetMapping(value = "/getCountMovedForAssetBeforeThisRequest/{sid}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountMovedForAssetBeforeThisRequest(@PathVariable Long sid, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountMovedBeforeThisRequest(sid, rid, mid);
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

	@GetMapping(value = "/getCountMovedBeforeDTTM/{dt}/{rid}/{mid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountMovedBeforeDTTM(@PathVariable String dt, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getCountMovedBeforeDTTM(dt, rid, mid);
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

	@GetMapping(value = "/getTotalRowCount", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountRowCount() {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getTotalRowCount();
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

	@GetMapping(value = "/getCountRowsForAssetsBeforeThisDTTM/{dt}/{rid}/{mid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getCountRowsForAssetsBeforeThisDTTM(@PathVariable String dt, @PathVariable Long rid,
			@PathVariable Short mid) {
		CompletableFuture<Float> qty = null;
		Float result = null;
		try {
			qty = storeOrderAssetInwardsReadPublicServ.getTotalRowsForAssetsBeforeThisDTTM(dt, rid, mid);
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

}
