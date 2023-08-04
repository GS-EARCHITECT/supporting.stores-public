package store_stock_movement_mgmt.issue.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store_stock_movement_mgmt.issue.model.master.StoreIssueMaster;

@Repository("storeIssueMasterCUDRepo")
public interface StoreIssueMasterCUD_Repo extends CrudRepository<StoreIssueMaster, Long> 
{
@Modifying
@Query(value="update TRANSACTION_ITEM_DETAILS set BY_STORE_VERIFICATION_FLAG = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateStoreVerifiedStatus(@Param(value = "storeReqSeqNo") Integer storeReqSeqNo);

//UPD various status for movement line item - BEGIN
@Modifying
@Query(value = "update STORE_ISSUE_MASTER set okflag = :st where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updOkStatusForLineItem(@Param("id") Long id, @Param("st") Character st);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set okflag = 'Y' where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updOkFlagForLineItem(@Param("id") Long id);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set doneflag = :st where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updDoneStatusForLineItem(@Param("id") Long id, @Param("st") Character st);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set doneflag = 'Y' where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updDoneFlagForLineItem(@Param("id") Long id);

//UPD various status for movement line item - END

// UPD various QTYs for order request and movement line items - BEGIN
@Modifying
@Query(value = "update STORE_ISSUE_MASTER set request_qty = request_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addRequestQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set request_qty = request_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subRequestQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set quality_qty = quality_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addQualityQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set quality_qty = quality_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subQualityQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set processed_qty = processed_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addProcessQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set processed_qty = processed_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subProcessQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set consign_qty = consign_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addConsignQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Modifying
@Query(value = "update STORE_ISSUE_MASTER set consign_qty = consign_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subConsignQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

//UPD various QTYs for order request and movement line items - END 

//DEL issue masters - BEGIN
@Modifying
@Query(value = "delete   from STORE_ISSUE_MASTER where store_movement_SEQ_NO in :ids ", nativeQuery = true)
void delSelectStoreIssueMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

@Modifying
@Query(value = "delete from  STORE_ISSUE_MASTER where store_request_SEQ_NO in :rids ", nativeQuery = true)
void delSelectStoreIssueMastersByRequests(@Param("rids") CopyOnWriteArrayList<Long> rids);

@Modifying
@Query(value = "delete   from STORE_ISSUE_MASTER where location_SEQ_NO in :ids ", nativeQuery = true)
void delSelectStoreIssueMastersByLocation(@Param("lids") CopyOnWriteArrayList<Long> lids);

@Modifying
@Query(value = "delete from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) <> 'Y') ", nativeQuery = true)
void delSelectStoreIssueMastersLineItemsForRequestsNotDone(@Param("rids") CopyOnWriteArrayList<Long> ids);

@Modifying
@Query(value = "delete from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) = 'Y') ", nativeQuery = true)
void delSelectStoreIssueMastersLineItemsForRequestsDone(@Param("rids") CopyOnWriteArrayList<Long> ids);

@Modifying
@Query(value = "delete from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) <> 'Y') ", nativeQuery = true)
void delSelectStoreIssueMastersLineItemsForNotOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

@Modifying
@Query(value = "delete from  STORE_ISSUE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) = 'Y') ", nativeQuery = true)
void delSelectStoreIssueMastersLineItemsForForOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

//DEL issue masters - END


} 

