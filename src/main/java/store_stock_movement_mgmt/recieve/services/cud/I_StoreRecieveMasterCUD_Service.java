package store_stock_movement_mgmt.recieve.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import store_stock_movement_mgmt.recieve.model.dto.StoreRecieveMaster_DTO;

public interface I_StoreRecieveMasterCUD_Service
{
	public CompletableFuture<StoreRecieveMaster_DTO> newRecieveMaster(StoreRecieveMaster_DTO storeRecieveMaster_DTO);
	//public CompletableFuture<Void> check_Processed();	
	//CompletableFuture<Void> updateStoreVerifiedStatus( Integer storeReqSeqNo);
	CompletableFuture<Void> updOkStatusForLineItem( Long id,  Character st);
	CompletableFuture<Void> updOkFlagForLineItem( Long id);
	CompletableFuture<Void> updDoneStatusForLineItem( Long id,  Character st);
	CompletableFuture<Void> updDoneFlagForLineItem( Long id);
	CompletableFuture<Float> addRecieveQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> subRecieveQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> addQualityQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> subQualityQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Void> delSelectStoreRecieveMasters( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreRecieveMastersByRequests( CopyOnWriteArrayList<Long> rids);
	CompletableFuture<Void> delSelectStoreRecieveMastersByLocation( CopyOnWriteArrayList<Long> lids);
	CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForRequestsDone( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreRecieveMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delAllStoreRecieveMasters();

}