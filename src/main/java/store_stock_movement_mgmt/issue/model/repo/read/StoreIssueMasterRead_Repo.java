package store_stock_movement_mgmt.issue.model.repo.read;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store_stock_movement_mgmt.issue.model.master.StoreIssueMaster;

@Repository("storeIssueMasterReadRepo")
public interface StoreIssueMasterRead_Repo extends JpaRepository<StoreIssueMaster, Long> 
{
@Query(value = "SELECT BY_STORE_VERIFICATION_FLAG FROM TRANSACTION_ITEM_DETAILS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Optional<CopyOnWriteArrayList<Character>> getStoreVerifiedStatus(@Param("storeReqSeqNo") Integer storeReqSeqNo);

@Query(value = "SELECT * FROM STORE_ISSUE_MASTER where processed_qty < request_qty ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO, REQUEST_ON",nativeQuery = true) 
Optional<CopyOnWriteArrayList<StoreIssueMaster>> getAllRowsPendingProcessing();

// GET various QTYs for order request and movement line items - BEGIN 
@Query(value = "SELECT COALESCE(SUM(request_qty),0) FROM STORE_ISSUE_MASTER where (STORE_REQUEST_SEQ_NO=:sid and resource_SEQ_NO=:rid)",nativeQuery = true) 
Float getTotalRequestItemQtyForStoreRequest(@Param("sid") Long sid, @Param("rid") Long rid);

@Query(value = "SELECT COALESCE(request_qty,0) FROM STORE_ISSUE_MASTER where STORE_movement_SEQ_NO=:mid",nativeQuery = true) 
Float getRequestQtyForLineItem(@Param("mid") Long mid);

@Query(value = "SELECT COALESCE(SUM(quality_qty),0) FROM STORE_ISSUE_MASTER where (STORE_REQUEST_SEQ_NO=:sid and resource_SEQ_NO=:rid)",nativeQuery = true) 
Float getTotalQCItemQtyForStoreRequest(@Param("sid") Long sid, @Param("rid") Long rid);

@Query(value = "SELECT COALESCE(quality_qty,0) FROM STORE_ISSUE_MASTER where STORE_movement_SEQ_NO=:mid",nativeQuery = true) 
Float getQCQtyForLineItem(@Param("mid") Long mid);

@Query(value = "SELECT COALESCE(SUM(processed_qty),0) FROM STORE_ISSUE_MASTER where (STORE_REQUEST_SEQ_NO=:sid and resource_SEQ_NO=:rid)",nativeQuery = true) 
Float getTotalProcessedItemQtyForStoreRequest(@Param("sid") Long sid, @Param("rid") Long rid);

@Query(value = "SELECT COALESCE(processed_qty,0) FROM STORE_ISSUE_MASTER where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
Float getProcessedQtyForLineItem(@Param("mid") Long mid);

@Query(value = "SELECT COALESCE(SUM(consign_qty),0) FROM STORE_ISSUE_MASTER where (STORE_REQUEST_SEQ_NO=:sid and resource_SEQ_NO=:rid)",nativeQuery = true) 
Float getTotalConsignItemQtyForStoreRequest(@Param("sid") Long sid, @Param("rid") Long rid);

@Query(value = "SELECT COALESCE(consign_qty,0) FROM STORE_ISSUE_MASTER where STORE_movement_SEQ_NO=:mid",nativeQuery = true) 
Float getConsignQtyForLineItem(@Param("mid") Long mid);

//GET various QTYs for order request and movement line items - END 

//GET issue masters - BEGIN
@Query(value = "select * from STORE_ISSUE_MASTER where store_movement_SEQ_NO in :ids ORDER BY store_request_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<StoreIssueMaster> getSelectStoreIssueMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

@Query(value = "SELECT * from  STORE_ISSUE_MASTER where store_request_SEQ_NO in :rids ORDER BY store_request_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<StoreIssueMaster> getSelectStoreIssueMastersByRequests(@Param("rids") CopyOnWriteArrayList<Long> rids);

@Query(value = "select * from STORE_ISSUE_MASTER where location_SEQ_NO in :ids ORDER BY location_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<StoreIssueMaster> getSelectStoreIssueMastersByLocations(@Param("lids") CopyOnWriteArrayList<Long> lids);

@Query(value = "SELECT * from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) <> 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<StoreIssueMaster> getSelectStoreIssueMastersLineItemsForRequestsNotDone(@Param("rids") CopyOnWriteArrayList<Long> rids);

@Query(value = "SELECT * from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) = 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<StoreIssueMaster> getSelectStoreIssueMastersLineItemsForRequestsDone(@Param("rids") CopyOnWriteArrayList<Long> rids);

@Query(value = "SELECT * from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) <> 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<StoreIssueMaster> getSelectStoreIssueMastersLineItemsForNotOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

@Query(value = "SELECT * from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) = 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<StoreIssueMaster> getSelectStoreIssueMastersLineItemsForForOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

//GET issue masters - END



} 

