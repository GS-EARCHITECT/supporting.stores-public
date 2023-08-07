package consignment_details_mgmt.controller.cud;

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
import consignment_details_mgmt.model.dto.ConsignmentDetail_DTO;
import consignment_details_mgmt.services.cud.I_ConsignmentDetailsCUD_Service;

@RestController
@RequestMapping("/consignmentDetailsCUDMgmt")
public class ConsignmentDetailsCUD_Controller {
	@Autowired
	private I_ConsignmentDetailsCUD_Service consignmentDetailsCUDService;

	@PostMapping("/newConsignmentDetail")
	public ResponseEntity<ConsignmentDetail_DTO> newConsignmentDetail(
			@RequestBody ConsignmentDetail_DTO consignmentDetail_DTO) {
		CompletableFuture<ConsignmentDetail_DTO> future = null;
		ConsignmentDetail_DTO consignmentDetail_DTO2 = null;
		try {
			future = consignmentDetailsCUDService.newConsignmentDetail(consignmentDetail_DTO);
			consignmentDetail_DTO2 = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(consignmentDetail_DTO2, HttpStatus.OK);
	}

	@PutMapping("/updConsignmentDetail")
	public void updConsignmentDetail(@RequestBody ConsignmentDetail_DTO consignmentDetail_DTO) {
		consignmentDetailsCUDService.updConsignmentDetail(consignmentDetail_DTO);
		return;
	}

	@PutMapping("/updConsignmentAssetDetailDone/{id}/{aid}")
	public void updConsignmentAssetDetailDone(@PathVariable Long id, @PathVariable Long aid)
	{
		consignmentDetailsCUDService.updConsignmentAssetDetailDone(id, aid);
		return;
	}
	
	@PutMapping("/updConsignmentResourceDetailDone/{id}/{aid}")
	public void updConsignmentResourceDetailDone(@PathVariable Long id, @PathVariable Long rid)
	{
		consignmentDetailsCUDService.updConsignmentResourceDetailDone(id, rid);
		return;
	}
	
	@PutMapping("/updConsignmentDetailAssetDoneStatus/{id}/{aid}/{st}")
	public void updConsignmentDetailAssetDoneStatus(@PathVariable Long id, @PathVariable Long aid, @PathVariable Character st)
	{
		consignmentDetailsCUDService.updConsignmentDetailAssetDoneStatus(id, aid, st);
		return;
	}

	@PutMapping("/updConsignmentDetailResourceDoneStatus/{id}/{rid}/{st}")
	public void updConsignmentDetailResourceDoneStatus(@PathVariable Long id, @PathVariable Long rid, @PathVariable Character st)
	{
		consignmentDetailsCUDService.updConsignmentDetailResourceDoneStatus(id, rid, st);
		return;
	}

	@PutMapping("/updConsignmentResourceDetailOk/{id}/{rid}")
	public void updConsignmentResourceDetailOk(@PathVariable Long id, @PathVariable Long rid)
	{
		consignmentDetailsCUDService.updConsignmentResourceDetailOk(id, rid);
		return;
	}

	@PutMapping("/updConsignmentAssetDetailOk/{id}/{aid}")
	public void updConsignmentAssetDetailOk(@PathVariable Long id, @PathVariable Long aid)
	{
		consignmentDetailsCUDService.updConsignmentAssetDetailOk(id, aid);
		return;
	}

	@PutMapping("/updConsignmentResourceDetailOkStatus/{id}/{rid}/{st}")
	public void updConsignmentResourceDetailOkStatus(@PathVariable Long id, @PathVariable Long rid, @PathVariable Character st)
	{
		consignmentDetailsCUDService.updConsignmentResourceDetailOkStatus(id, rid, st);
		return;
	}
	
	@PutMapping("/updConsignmentAssetDetailOkStatus/{id}/{aid}/{st}")
	public void updConsignmentAssetDetailOkStatus(@PathVariable Long id, @PathVariable Long aid, @PathVariable Character st)
	{
		consignmentDetailsCUDService.updConsignmentAssetDetailOkStatus(id, aid, st);
		return;
	}
	
	@PutMapping("/updConsignmentMasterMovementNoForResource/{mid}/{cid}/{rid}/{qty}")
	public void updConsignmentMasterMovementNoForResource(@PathVariable Long mid, @PathVariable Long cid, @PathVariable Long rid, @PathVariable Float qty)
	{
		consignmentDetailsCUDService.updConsignmentMasterMovementNoForResource(mid, cid, rid, qty);
		return;
	}

	@PutMapping("/updConsignmentMasterMovementNoForAsset/{mid}/{cid}/{rid}")
	public void updConsignmentMasterMovementNoForAsset(@PathVariable Long mid, @PathVariable Long cid, @PathVariable Long rid)
	{
		consignmentDetailsCUDService.updConsignmentMasterMovementNoForAsset(mid, cid, rid);
		return;
	}

	@DeleteMapping("/delSelectJobDetailsForResources")
	public void delSelectJobDetailsForResources(@RequestBody CopyOnWriteArrayList<Long> rids) {
		consignmentDetailsCUDService.delSelectConsignmentDetailsByResources(rids);
		return;
	}

	@DeleteMapping("/delSelectJobDetailsForAssets")
	public void delSelectJobDetailsForAssets(@RequestBody CopyOnWriteArrayList<Long> aids) {
		consignmentDetailsCUDService.delSelectConsignmentDetailsByAssets(aids);
		return;
	}

	@DeleteMapping("/delAllConsignmentJobDetails")
	public void delAllConsignmentJobDetails() {
		consignmentDetailsCUDService.delAllConsignmentDetails();
		return;
	}

}