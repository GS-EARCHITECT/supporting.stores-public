package job_consignment_details_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_consignment_details_mgmt.model.dto.JobConsignmentDetail_DTO;

public interface I_JobConsignmentDetailsRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getAllJobConsignmentDetails();
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetails(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetailsByResources(CopyOnWriteArrayList<Long> rids);
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> aids);
}