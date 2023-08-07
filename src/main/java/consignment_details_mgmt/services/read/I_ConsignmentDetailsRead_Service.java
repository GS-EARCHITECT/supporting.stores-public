package consignment_details_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.repository.query.Param;

import consignment_details_mgmt.model.dto.ConsignmentDetail_DTO;

public interface I_ConsignmentDetailsRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getAllConsignmentDetails();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetails(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsByResources(CopyOnWriteArrayList<Long> rids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> aids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsPending();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsDelivered();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsCanBeProcessed();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentDetailsCannotBeProcessed();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentResourceDetailsPending(Long cid);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentDetail_DTO>> getSelectConsignmentAssetDetailsPending(Long cid);
}