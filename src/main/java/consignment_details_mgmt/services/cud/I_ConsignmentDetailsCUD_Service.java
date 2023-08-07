package consignment_details_mgmt.services.cud;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import consignment_details_mgmt.model.dto.ConsignmentDetail_DTO;

public interface I_ConsignmentDetailsCUD_Service 
{	
	public CompletableFuture<ConsignmentDetail_DTO> newConsignmentDetail(ConsignmentDetail_DTO jobConsignmentDetail_DTO);
	public CompletableFuture<Void> updConsignmentDetail(ConsignmentDetail_DTO jobConsignmentDetail_DTO);
	public CompletableFuture<Void> delSelectConsignmentDetails(CopyOnWriteArrayList<Long> ids);	
	public CompletableFuture<Void> delSelectConsignmentDetailsByResources(CopyOnWriteArrayList<Long> rids);
	public CompletableFuture<Void> delSelectConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> aids);
	public CompletableFuture<Void> delAllConsignmentDetails();
	public CompletableFuture<Void> updConsignmentAssetDetailDone(Long id, Long aid);
	public CompletableFuture<Void> updConsignmentResourceDetailDone(Long id, Long rid);
	public CompletableFuture<Void> updConsignmentDetailAssetDoneStatus(Long id, Long aid,  Character st);
	public CompletableFuture<Void> updConsignmentDetailResourceDoneStatus(Long id, Long rid,  Character st);
	public CompletableFuture<Void> updConsignmentResourceDetailOk(Long id, Long rid);
	public CompletableFuture<Void> updConsignmentAssetDetailOk(Long id, Long aid);
	public CompletableFuture<Void> updConsignmentResourceDetailOkStatus(Long id, Long rid, Character st);
	public CompletableFuture<Void> updConsignmentAssetDetailOkStatus(Long id, Long aid, Character st);
	public CompletableFuture<Void> updConsignmentMasterMovementNoForResource(Long mid, Long cid, Long rid, Float qty);
	public CompletableFuture<Void> updConsignmentMasterMovementNoForAsset(Long mid, Long cid, Long aid);
}