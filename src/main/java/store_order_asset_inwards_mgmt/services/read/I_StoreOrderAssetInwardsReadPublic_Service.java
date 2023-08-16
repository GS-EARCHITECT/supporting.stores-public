package store_order_asset_inwards_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import store_order_asset_inwards_mgmt.model.dto.StoreOrderAssetInward_DTO;

public interface I_StoreOrderAssetInwardsReadPublic_Service
{
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getAllStoreInwards();
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getSelectOrderInwards( CopyOnWriteArrayList<Long> sids);
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getAllRowsForMode( Short mode);
	public CompletableFuture<CopyOnWriteArrayList<Long>> getAllSeqNosForMode( Long mode);
	public CompletableFuture<Character> getIsbookedStatus( Long storeReqSeqNo);
	public CompletableFuture<Character> getIsDoneStatus( Long storeReqSeqNo);
	public CompletableFuture<Character> getIsOkStatus( Long storeReqSeqNo);
	public CompletableFuture<Character> getOrderRequestedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountRequestedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountRequestedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountRequestedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Character> getOrderAllocatedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountAllocatedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountAllocatedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountAllocatedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Character> getOrderBookedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountBookedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountBookedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountBookedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Character> getOrderMovedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountMovedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountMovedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountMovedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getTotalRowCount();
	public CompletableFuture<Float> getTotalRowsForAssetsBeforeThisDTTM( String dTTm,  Long assetSeqNo,  Short mode);

}