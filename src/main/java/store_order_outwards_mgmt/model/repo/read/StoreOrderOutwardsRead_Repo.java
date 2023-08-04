package store_order_outwards_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import store_order_outwards_mgmt.model.master.StoreOrderOutward;

@Repository("storeOrderOutwardsRepo")
public interface StoreOrderOutwardsRead_Repo extends JpaRepository<StoreOrderOutward, Long> 
{
@Query(value = "SELECT is_booked FROM STORE_ORDER_INWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getIsbookedStatus(@Param("storeReqSeqNo") Long storeReqSeqNo);

// Allocated QTY Queries
@Query(value = "SELECT COALESCE(qty_allocated,0) FROM STORE_ORDER_INWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Float getOrderOutwardsAllocatedQty(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_allocated),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and job_work_SEQ_NO< :jobWorkSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyAllocForItemForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_allocated),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO = :srSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyAllocForItemForStoreRequest(@Param("srSeqNo") Long srSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_allocated),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode",nativeQuery = true) 
Float getTotalQtyAllocForItemBeforeThis(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode);

//Requested QTY Queries
@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM STORE_ORDER_INWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Float getOrderOutwardsRequestQty(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and job_work_SEQ_NO< :jobWorkSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyRequestedForItemForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO = :srSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyRequestedForItemForStoreRequest(@Param("srSeqNo") Long srSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn = :mode",nativeQuery = true) 
Float getTotalQtyRequestedForItemBeforeThis(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode);

//Booked QTY Queries
@Query(value = "SELECT COALESCE(SUM(qty_booked),0) FROM STORE_ORDER_INWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Float getOrderOutwardsBookedQty(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_booked),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and job_work_SEQ_NO< :jobWorkSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyBookedForItemForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_booked),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO = :srSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyBookedForItemForStoreRequest(@Param("srSeqNo") Long srSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_booked),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn = :mode",nativeQuery = true) 
Float getTotalQtyBookedForItemBeforeThis(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode);

//Moved QTY Queries
@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM STORE_ORDER_INWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Float getOrderOutwardsMovedQty(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and job_work_SEQ_NO< :jobWorkSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyMovedForItemForJob(@Param("jobWorkSeqNo") Long jobWorkSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO = :srSeqNo and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyMovedForItemForStoreRequest(@Param("srSeqNo") Long srSeqNo, @Param("itemSeqNo") Long itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn = :mode and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalQtyMovedForItemBeforeThis(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn = :mode and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalRowsForItemsBeforeThisModeBasis(@Param("itemSeqNo") Long itemSeqNo, @Param("storeReqSeqNo") Long storeReqSeqNo, @Param("mode") Short mode);

@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDER_INWARDS where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn = :mode and upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
Float getTotalRowsForItemsBeforeThis(@Param("itemSeqNo") Long itemSeqNo, @Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDER_INWARDS",nativeQuery = true) 
Float getTotalRowCount();

@Query(value = "SELECT * FROM STORE_ORDER_INWARDS where upper(trim(doneflag))<> 'Y' ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<StoreOrderOutward> getAllOrderOutwards();

@Query(value = "SELECT * FROM STORE_ORDER_INWARDS  where MODE_TXN= :mode and upper(trim(doneflag))<> 'Y' ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<StoreOrderOutward> getAllRowsForMode(@Param("mode") Short mode);

@Query(value = "SELECT store_request_seq_no FROM STORE_ORDER_INWARDS where MODE_TXN=:mode and upper(trim(doneflag))<> 'Y'  ORDER BY STORE_REQUEST_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<Long> getAllSeqNosForMode(@Param("mode") Long mode);

} 

