package storeMovementManager.issue.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import storeMovementManager.issue.model.dto.StoreIssueMaster_DTO;

public interface I_StoreIssueRead_Service
{
	public CompletableFuture<CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>>> getAllStoreIssueMasters();
	//public CompletableFuture<Void> check_Processed();	
	public Float getTotalRequestItemQtyForStoreRequest(Long sid,  Long rid);
	public Float getTotalRequestQtyForLineItem(Long sid);
	public Float getTotalQCItemQtyForStoreRequest(Long sid,  Long rid);
	public Float getTotalQCQtyForLineItem(Long sid);
	public Float getTotalProcessedItemQtyForStoreRequest(Long sid,  Long rid);
	public Float getTotalProcessedQtyForLineItem(Long sid);
	public Float getTotalConsignItemQtyForStoreRequest(Long sid,  Long rid);
	public Float getTotalConsignQtyForLineItem(Long sid);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByRequests( CopyOnWriteArrayList<Long> rids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersByLocation( CopyOnWriteArrayList<Long> lids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForRequestsDone( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreIssueMaster_DTO>> getSelectStoreIssueMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids);
}