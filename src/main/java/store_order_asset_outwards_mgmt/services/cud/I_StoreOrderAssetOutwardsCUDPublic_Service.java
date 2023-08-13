package store_order_asset_outwards_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import store_order_asset_outwards_mgmt.model.dto.StoreOrderAssetOutward_DTO;

public interface I_StoreOrderAssetOutwardsCUDPublic_Service
{
	public CompletableFuture<StoreOrderAssetOutward_DTO> newStoreOrderOutward(StoreOrderAssetOutward_DTO storeOrderAssetOutward_DTO);
	public CompletableFuture<Void> updStoreOrderOutward(StoreOrderAssetOutward_DTO storeOrderAssetOutward_DTO);
	public CompletableFuture<Void> delStoreOrderOutward(Long rno);
	public CompletableFuture<Void> delSelectStoreOrdersOutward(CopyOnWriteArrayList<Long> rnos);
	public CompletableFuture<Void> setFlagRequested( Character flag,  Long storeReqSeqNo);
	public CompletableFuture<Void> setFlagBooked( Character flag,  Long storeReqSeqNo);
	public CompletableFuture<Void> setFlagAllocated( Character flag,  Long storeReqSeqNo);
	public CompletableFuture<Void> setFlagMoved( Character flag,  Long storeReqSeqNo);
	public CompletableFuture<Void> updateBookStatus( Long storeReqSeqNo,  Character st);
	public CompletableFuture<Void> clearBookStatus( Long storeReqSeqNo);
	public CompletableFuture<Void> updateOKFlag( Long storeReqSeqNo,  Character st);
	public CompletableFuture<Void> clearOKFlag( Long storeReqSeqNo);
	public CompletableFuture<Void> updateDoneFlag( Long storeReqSeqNo,  Character st);
	public CompletableFuture<Void> clearDoneFlag( Long storeReqSeqNo);
}