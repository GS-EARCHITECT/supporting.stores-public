package job_consignment_details_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_consignment_details_mgmt.model.dto.JobConsignmentDetail_DTO;

public interface I_JobConsignmentDetailsCUD_Service 
{	
	public CompletableFuture<JobConsignmentDetail_DTO> newJobConsignmentDetail(JobConsignmentDetail_DTO jobConsignmentDetail_DTO);
	public CompletableFuture<Void> updJobConsignmentDetail(JobConsignmentDetail_DTO jobConsignmentDetail_DTO);
	public CompletableFuture<Void> delSelectJobConsignmentDetails(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectJobConsignmentDetailsByResources(CopyOnWriteArrayList<Long> rids);
	public CompletableFuture<Void> delSelectJobConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> aids);
	public CompletableFuture<Void> delAllConsignmentDetails();
}