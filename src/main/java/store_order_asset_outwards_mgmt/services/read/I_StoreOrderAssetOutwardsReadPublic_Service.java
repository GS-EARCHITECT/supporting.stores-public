package store_order_asset_outwards_mgmt.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import store_order_asset_outwards_mgmt.model.dto.StoreOrderAssetOutward_DTO;

public interface I_StoreOrderAssetOutwardsReadPublic_Service
{
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetOutward_DTO>> getAllStoreOutwards();
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetOutward_DTO>> getSelectOrderOutwards( CopyOnWriteArrayList<Long> sids);
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetOutward_DTO>> getAllRowsForMode( Short mode);
	public CompletableFuture<CopyOnWriteArrayList<Long>> getAllSeqNosForMode( Long mode);
	public CompletableFuture<Character> getIsbookedStatus( Long storeReqSeqNo);
	public CompletableFuture<Character> getIsDoneStatus( Long storeReqSeqNo);
	public CompletableFuture<Character> getIsOkStatus( Long storeReqSeqNo);
	public CompletableFuture<Float> getOrderRequestedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountRequestedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountRequestedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountRequestedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getOrderAllocatedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountAllocatedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountAllocatedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountAllocatedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getOrderBookedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountBookedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountBookedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountBookedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getOrderMovedFlag( Long storeReqSeqNo);
	public CompletableFuture<Float> getCountMovedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountMovedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getCountMovedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode);
	public CompletableFuture<Float> getTotalRowCount();
	public CompletableFuture<Float> getTotalRowsForAssetsBeforeThisDTTM( String dTTm,  Long assetSeqNo,  Short mode);

}