package store_order_resource_outwards_mgmt.model.repo.cud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import store_order_resource_outwards_mgmt.model.master.StoreOrderResourceOutward;

@Repository("storeOrderResourceOutwardsCUDPublicRepo")
public interface StoreOrderResourceOutwardsCUDPublic_Repo extends JpaRepository<StoreOrderResourceOutward, Long> 
{

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_REQUESTED = QTY_REQUESTED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyRequested(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);
	
@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_REQUESTED = QTY_REQUESTED - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyRequested(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_REQUESTED = :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setQtyRequested(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_BOOKED = QTY_BOOKED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_BOOKED = QTY_BOOKED - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_BOOKED = QTY_BOOKED where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_Allocated = QTY_Allocated + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyAllocated(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_Allocated = QTY_Allocated - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyAllocated(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_Allocated = QTY_Allocated where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setQtyAllocated(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_Moved = QTY_Moved + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyMoved(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_Moved = QTY_Moved - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyMoved(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set QTY_Moved = QTY_Moved where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setQtyMoved(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set IS_BOOKED = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set IS_BOOKED = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set OKFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set OKFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set DONEFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying
@Query(value="update STORE_ORDERRESOURCE_OUTWARDS set DONEFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);
} 
