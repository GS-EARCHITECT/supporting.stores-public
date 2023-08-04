package storeMovementManager.issue.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import storeMovementManager.issue.model.dto.StoreIssueMaster_DTO;

public interface I_StoreIssueMasterRead_Service
{
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getAllStoreIssueMasters();
	//public CompletableFuture<Void> check_Processed();	
	public CompletableFuture<Float> getTotalRequestItemQtyForStoreRequest(Long sid,  Long rid);
	public CompletableFuture<Float> getRequestQtyForLineItem(Long mid);
	public CompletableFuture<Float> getTotalQCItemQtyForStoreRequest(Long sid,  Long rid);
	public CompletableFuture<Float> getQCQtyForLineItem(Long mid);
	public CompletableFuture<Float> getTotalProcessedItemQtyForStoreRequest(Long sid,  Long rid);
	public CompletableFuture<Float> getProcessedQtyForLineItem(Long mid);
	public CompletableFuture<Float> getTotalConsignItemQtyForStoreRequest(Long sid,  Long rid);
	public CompletableFuture<Float> getConsignQtyForLineItem(Long mid);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByRequests( CopyOnWriteArrayList<Long> rids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByLocations( CopyOnWriteArrayList<Long> lids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsDone( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids);
}