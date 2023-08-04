package store_stock_movement_mgmt.recieve.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import store_stock_movement_mgmt.recieve.model.dto.StoreRecieveMaster_DTO;

public interface I_StoreRecieveMasterRead_Service
{
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getAllStoreRecieveMasters();
	//public CompletableFuture<Void> check_Processed();	
	public CompletableFuture<Float> getTotalRecieveItemQtyForStoreRequest(Long sid,  Long rid);
	public CompletableFuture<Float> getRecieveQtyForLineItem(Long mid);
	public CompletableFuture<Float> getTotalQCItemQtyForStoreRequest(Long sid,  Long rid);
	public CompletableFuture<Float> getQCQtyForLineItem(Long mid);
	public CompletableFuture<Float> getTotalConsignItemQtyForStoreRequest(Long sid,  Long rid);
	public CompletableFuture<Float> getConsignQtyForLineItem(Long mid);
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersByRequests( CopyOnWriteArrayList<Long> rids);
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersByLocations( CopyOnWriteArrayList<Long> lids);
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForRequestsDone( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<StoreRecieveMaster_DTO>> getSelectStoreRecieveMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids);
}