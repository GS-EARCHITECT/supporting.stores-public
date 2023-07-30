package job_consignment_master_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_consignment_master_mgmt.model.dto.JobConsignmentMaster_DTO;

public interface I_JobConsignmentMasterRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getAllJobConsignmentMasters();
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids);
}