package store_stock_movement_mgmt.issue.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import store_stock_movement_mgmt.issue.model.dto.StoreIssueMaster_DTO;

public interface I_StoreIssueMasterCUD_Service
{
	public CompletableFuture<StoreIssueMaster_DTO> newIssueMaster(StoreIssueMaster_DTO storeIssueMaster_DTO);
	public CompletableFuture<Void> updIssueMaster(StoreIssueMaster_DTO storeIssueMaster_DTO);
	//public CompletableFuture<Void> check_Processed();	
	//CompletableFuture<Void> updateStoreVerifiedStatus( Integer storeReqSeqNo);
	CompletableFuture<Void> updOkStatusForLineItem( Long id,  Character st);
	CompletableFuture<Void> updOkFlagForLineItem( Long id);
	CompletableFuture<Void> updDoneStatusForLineItem( Long id,  Character st);
	CompletableFuture<Void> updDoneFlagForLineItem( Long id);
	CompletableFuture<Float> addRequestQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> subRequestQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> addQualityQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> subQualityQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> addProcessQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> subProcessQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> addConsignQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Float> subConsignQtyForLineItem( Long sid,  Float qty);
	CompletableFuture<Void> delSelectStoreIssueMasters( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreIssueMastersByRequests( CopyOnWriteArrayList<Long> rids);
	CompletableFuture<Void> delSelectStoreIssueMastersByLocation( CopyOnWriteArrayList<Long> lids);
	CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForRequestsNotDone( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForRequestsDone( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForNotOkStatus( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delSelectStoreIssueMastersLineItemsForForOkStatus( CopyOnWriteArrayList<Long> ids);
	CompletableFuture<Void> delAllStoreIssueMasters();

}