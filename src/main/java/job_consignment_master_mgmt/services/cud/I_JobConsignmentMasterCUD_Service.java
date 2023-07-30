package job_consignment_master_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_consignment_master_mgmt.model.dto.JobConsignmentMaster_DTO;

public interface I_JobConsignmentMasterCUD_Service 
{	
	public CompletableFuture<JobConsignmentMaster_DTO> newJobConsignmentMaster(JobConsignmentMaster_DTO jobConsignmentMaster_DTO);
	public CompletableFuture<Void> updJobConsignmentMaster(JobConsignmentMaster_DTO jobConsignmentMaster_DTO);
	public CompletableFuture<Void> delSelectJobConsignmentMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectJobConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectJobConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectJobConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectJobConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delAllConsignmentMasters();
}