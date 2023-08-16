package store_order_asset_inwards_mgmt.model.repo.read;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import store_order_asset_inwards_mgmt.model.master.StoreOrderAssetInward;

@Repository("storeOrderAssetInwardsReadPublicRepo")
public interface StoreOrderAssetInwardsReadPublic_Repo extends JpaRepository<StoreOrderAssetInward, Long> 
{

//Requested Status
@Query(value = "SELECT is_booked FROM STORE_ORDERASSET_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getIsbookedStatus(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT doneflag FROM STORE_ORDERASSET_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getIsDoneStatus(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT okflag FROM STORE_ORDERASSET_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getIsOkStatus(@Param("storeReqSeqNo") Long storeReqSeqNo);

//Requested QTY Queries
@Query(value = "SELECT COALESCE(flag_Requested,' ') FROM STORE_ORDERASSET_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getOrderRequestedFlag(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO= :assetSeqNo and job_work_SEQ_NO = :jobWorkSeqNo and mode_txn = :mode and upper(trim(flag_requested))<> 'Y' and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getCountRequestedForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and STORE_REQUEST_SEQ_NO < :storeReqSeqNo and upper(trim(flag_requested))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountRequestedBeforeThisRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and FROM_DTTM < :dTTm and upper(trim(flag_requested))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountRequestedBeforeDTTM(@Param("dTTm") Timestamp dTTm, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

// Allocated QTY Queries
@Query(value = "SELECT COALESCE(flag_Allocated,' ') FROM STORE_ORDERASSET_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getOrderAllocatedFlag(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO= :assetSeqNo and job_work_SEQ_NO = :jobWorkSeqNo and mode_txn = :mode and upper(trim(flag_Allocated))<> 'Y' and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getCountAllocatedForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and STORE_REQUEST_SEQ_NO < :storeReqSeqNo and upper(trim(flag_Allocated))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountAllocatedBeforeThisRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and FROM_DTTM < :dTTm and upper(trim(flag_Allocated))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountAllocatedBeforeDTTM(@Param("dTTm") Timestamp dTTm, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

//Booked QTY Queries
@Query(value = "SELECT COALESCE(flag_Booked,' ') FROM STORE_ORDERASSET_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getOrderBookedFlag(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO= :assetSeqNo and job_work_SEQ_NO = :jobWorkSeqNo and mode_txn = :mode and upper(trim(flag_Booked))<> 'Y' and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getCountBookedForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and STORE_REQUEST_SEQ_NO < :storeReqSeqNo and upper(trim(flag_Booked))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountBookedBeforeThisRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and FROM_DTTM < :dTTm and upper(trim(flag_Booked))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountBookedBeforeDTTM(@Param("dTTm") Timestamp dTTm, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);


//Moved QTY Queries
@Query(value = "SELECT COALESCE(flag_Moved,' ') FROM STORE_ORDERASSET_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getOrderMovedFlag(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO= :assetSeqNo and job_work_SEQ_NO = :jobWorkSeqNo and mode_txn = :mode and upper(trim(flag_Moved))<> 'Y' and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getCountMovedForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and STORE_REQUEST_SEQ_NO < :storeReqSeqNo and upper(trim(flag_Moved))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountMovedBeforeThisRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT count(*) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and FROM_DTTM < :dTTm and upper(trim(flag_Moved))<> 'Y' and mode_txn= :mode",nativeQuery = true) 
Float getCountMovedBeforeDTTM(@Param("dTTm") Timestamp dTTm, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);


//Other QTY Queries
@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDERASSET_OUTWARDS",nativeQuery = true) 
Float getTotalRowCount();

@Query(value = "SELECT * FROM STORE_ORDERASSET_OUTWARDS where upper(trim(doneflag))<> 'Y' ORDER BY STORE_REQUEST_SEQ_NO, Asset_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<StoreOrderAssetInward> getAllOrderAssetInwards();

@Query(value = "SELECT * FROM STORE_ORDERASSET_OUTWARDS  where MODE_TXN= :mode and upper(trim(doneflag))<> 'Y' ORDER BY STORE_REQUEST_SEQ_NO, Asset_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<StoreOrderAssetInward> getAllRowsForMode(@Param("mode") Short mode);

@Query(value = "SELECT store_request_seq_no FROM STORE_ORDERASSET_OUTWARDS where MODE_TXN=:mode and upper(trim(doneflag))<> 'Y'  ORDER BY STORE_REQUEST_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<Long> getAllSeqNosForMode(@Param("mode") Long mode);

@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDERASSET_OUTWARDS where Asset_SEQ_NO=:assetSeqNo and mode_txn = :mode and FROM_DTTM < :dTTm  and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalRowsForAssetsBeforeThisDTTM(@Param("dTTm") Timestamp dTTm, @Param("assetSeqNo") Long assetSeqNo, @Param("mode") Short mode);

} 

