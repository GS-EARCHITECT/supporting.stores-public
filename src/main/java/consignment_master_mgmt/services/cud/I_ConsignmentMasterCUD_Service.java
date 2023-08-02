package consignment_master_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;

public interface I_ConsignmentMasterCUD_Service 
{	
	public CompletableFuture<ConsignmentMaster_DTO> newConsignmentMaster(ConsignmentMaster_DTO jobConsignmentMaster_DTO);
	public CompletableFuture<Void> updConsignmentMaster(ConsignmentMaster_DTO jobConsignmentMaster_DTO);
	public CompletableFuture<Void> updConsignmentMasterDone(Long id);	
	public CompletableFuture<Void> updConsignmentMasterDoneStatus(Long id, Character st);
	public CompletableFuture<Void> updConsignmentMasterOk(Long id);
	public CompletableFuture<Void> updConsignmentMasterOkStatus(Long scid, Character st);
	public CompletableFuture<Void> delSelectConsignmentMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<Void> delSelectConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delSelectConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<Void> delAllConsignmentMasters();
	
	
}