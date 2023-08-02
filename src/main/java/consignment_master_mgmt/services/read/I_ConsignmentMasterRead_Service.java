package consignment_master_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;

public interface I_ConsignmentMasterRead_Service 
{	
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getAllConsignmentMasters();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersComingIn();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersGoingOut();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersPending();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersDelivered();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCanBeProcessed();
	public CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> getSelectConsignmentMastersCannotBeProcessed();
}