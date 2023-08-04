package store_order_inwards_mgmt.model.repo.cud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import store_order_inwards_mgmt.model.master.StoreOrderInward;

@Repository("storeOrderInwardsCUDRepo")
public interface StoreOrderInwardsCUD_Repo extends JpaRepository<StoreOrderInward, Long> 
{

@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_ALLOCATED = QTY_ALLOCATED - :neededQty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subStoreAlloc(@Param(value = "neededQty") Float neededQty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);
	
@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_ALLOCATED = QTY_ALLOCATED + :neededQty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addStoreAlloc(@Param(value = "neededQty") Float neededQty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_BOOKED = QTY_BOOKED - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_BOOKED = QTY_BOOKED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_REQUESTED = QTY_REQUESTED - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyRequested(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_REQUESTED = QTY_REQUESTED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyRequested(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set IS_BOOKED = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set IS_BOOKED = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set OKFLAG = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set OKFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set DONEFLAG = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set DONEFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);
} 

