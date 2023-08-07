package store_stock_movement_mgmt.recieve.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store_stock_movement_mgmt.recieve.model.master.StoreRecieveMaster;

@Repository("storeRecieveMasterCUDRepo")
public interface StoreRecieveMasterCUD_Repo extends CrudRepository<StoreRecieveMaster, Long> 
{
@Modifying
@Query(value="update TRANSACTION_ITEM_DETAILS set BY_STORE_VERIFICATION_FLAG = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateStoreVerifiedStatus(@Param(value = "storeReqSeqNo") Integer storeReqSeqNo);

//UPD various status for movement line item - BEGIN
@Query(value = "update STORE_RECIEVE_MASTER set okflag = :st where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updOkStatusForLineItem(@Param("id") Long id, @Param("st") Character st);

@Query(value = "update STORE_RECIEVE_MASTER set okflag = 'Y' where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updOkFlagForLineItem(@Param("id") Long id);

@Query(value = "update STORE_RECIEVE_MASTER set doneflag = :st where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updDoneStatusForLineItem(@Param("id") Long id, @Param("st") Character st);

@Query(value = "update STORE_RECIEVE_MASTER set doneflag = 'Y' where STORE_movement_SEQ_NO=:id",nativeQuery = true) 
void updDoneFlagForLineItem(@Param("id") Long id);

//UPD various status for movement line item - END

// UPD various QTYs for order request and movement line items - BEGIN 
@Query(value = "update STORE_RECIEVE_MASTER set recieved_qty = recieved_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addRecievedQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Query(value = "update STORE_RECIEVE_MASTER set recieved_qty = recieved_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subRecievedQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Query(value = "update STORE_RECIEVE_MASTER set quality_qty = quality_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addQualityQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Query(value = "update STORE_RECIEVE_MASTER set quality_qty = quality_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subQualityQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Query(value = "update STORE_RECIEVE_MASTER set processed_qty = processed_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addProcessQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Query(value = "update STORE_RECIEVE_MASTER set processed_qty = processed_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subProcessQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Query(value = "update STORE_RECIEVE_MASTER set consign_qty = consign_qty + :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void addConsignQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

@Query(value = "update STORE_RECIEVE_MASTER set consign_qty = consign_qty - :qty where STORE_movement_SEQ_NO=:sid",nativeQuery = true) 
void subConsignQtyForLineItem(@Param("sid") Long sid, @Param("qty") Float qty);

//UPD various QTYs for order request and movement line items - END 

//DEL recieve masters - BEGIN
@Query(value = "delete   from STORE_RECIEVE_MASTER where store_movement_SEQ_NO in :ids ", nativeQuery = true)
void delSelectStoreRecieveMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where store_request_SEQ_NO in :rids ", nativeQuery = true)
void delSelectStoreRecieveMastersByRequests(@Param("rids") CopyOnWriteArrayList<Long> rids);

@Query(value = "delete   from STORE_RECIEVE_MASTER where location_SEQ_NO in :ids ", nativeQuery = true)
void delSelectStoreRecieveMastersByLocation(@Param("lids") CopyOnWriteArrayList<Long> lids);

@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) <> 'Y') ", nativeQuery = true)
void delSelectStoreRecieveMastersLineItemsForRequestsNotDone(@Param("rids") CopyOnWriteArrayList<Long> ids);

@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) = 'Y') ", nativeQuery = true)
void delSelectStoreRecieveMastersLineItemsForRequestsDone(@Param("rids") CopyOnWriteArrayList<Long> ids);

@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) <> 'Y') ", nativeQuery = true)
void delSelectStoreRecieveMastersLineItemsForNotOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) = 'Y') ", nativeQuery = true)
void delSelectStoreRecieveMastersLineItemsForForOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

//DEL recieve masters - END


} 

