package store_stock_movement_mgmt.recieve.model.repo.read;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store_stock_movement_mgmt.recieve.model.master.StoreRecieveMaster;

@Repository("storeRecieveMasterReadRepo")
public interface StoreRecieveMasterRead_Repo extends JpaRepository<StoreRecieveMaster, Long> 
{

	@Query(value = "SELECT BY_STORE_VERIFICATION_FLAG FROM TRANSACTION_ITEM_DETAILS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
	Optional<CopyOnWriteArrayList<Character>> getStoreVerifiedStatus(@Param("storeReqSeqNo") Integer storeReqSeqNo);

	@Query(value = "SELECT * FROM STORE_RECIEVE_MASTER where processed_qty < request_qty ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO, REQUEST_ON",nativeQuery = true) 
	Optional<CopyOnWriteArrayList<StoreRecieveMaster>> getAllRowsPendingProcessing();

	// GET various QTYs for order request and movement line items - BEGIN 
	@Query(value = "SELECT COALESCE(SUM(recieve_qty),0) FROM STORE_RECIEVE_MASTER where (STORE_REQUEST_SEQ_NO=:sid and resource_SEQ_NO=:rid)",nativeQuery = true) 
	Float getTotalRecieveItemQtyForStoreRequest(@Param("sid") Long sid, @Param("rid") Long rid);

	@Query(value = "SELECT COALESCErRecieve_qty,0) FROM STORE_RECIEVE_MASTER where STORE_movemeent_SEQ_NO=:mid",nativeQuery = true) 
	Float getRecieveQtyForLineItem(@Param("mid") Long mid);

	@Query(value = "SELECT COALESCE(SUM(quality_qty),0) FROM STORE_RECIEVE_MASTER where (STORE_REQUEST_SEQ_NO=:sid and resource_SEQ_NO=:rid)",nativeQuery = true) 
	Float getTotalQCItemQtyForStoreRequest(@Param("sid") Long sid, @Param("rid") Long rid);

	@Query(value = "SELECT COALESCE(quality_qty,0) FROM STORE_RECIEVE_MASTER where STORE_movemeent_SEQ_NO=:mid",nativeQuery = true) 
	Float getQCQtyForLineItem(@Param("mid") Long mid);

	@Query(value = "SELECT COALESCE(SUM(consign_qty),0) FROM STORE_RECIEVE_MASTER where (STORE_REQUEST_SEQ_NO=:sid and resource_SEQ_NO=:rid)",nativeQuery = true) 
	Float getTotalConsignItemQtyForStoreRequest(@Param("sid") Long sid, @Param("rid") Long rid);

	@Query(value = "SELECT COALESCE(consign_qty,0) FROM STORE_RECIEVE_MASTER where STORE_movemeent_SEQ_NO=:mid",nativeQuery = true) 
	Float getConsignQtyForLineItem(@Param("mid") Long mid);

	//GET various QTYs for order request and movement line items - END 

	//GET issue masters - BEGIN
	@Query(value = "select * from STORE_RECIEVE_MASTER where store_movement_SEQ_NO in :ids ORDER BY store_request_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<StoreRecieveMaster> getSelectStoreRecieveMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where store_request_SEQ_NO in :rids ORDER BY store_request_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<StoreRecieveMaster> getSelectStoreRecieveMastersByRequests(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Query(value = "select * from STORE_RECIEVE_MASTER where location_SEQ_NO in :ids ORDER BY location_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<StoreRecieveMaster> getSelectStoreRecieveMastersByLocations(@Param("lids") CopyOnWriteArrayList<Long> lids);

	@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) <> 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<StoreRecieveMaster> getSelectStoreRecieveMastersLineItemsForRequestsNotDone(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(doneflag)) = 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<StoreRecieveMaster> getSelectStoreRecieveMastersLineItemsForRequestsDone(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) <> 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<StoreRecieveMaster> getSelectStoreRecieveMastersLineItemsForNotOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  STORE_RECIEVE_MASTER where (store_request_SEQ_NO in :rids and upper(trim(okflag)) = 'Y') ORDER BY store_request_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<StoreRecieveMaster> getSelectStoreRecieveMastersLineItemsForForOkStatus(@Param("rids") CopyOnWriteArrayList<Long> ids);

	//GET issue masters - END



} 

