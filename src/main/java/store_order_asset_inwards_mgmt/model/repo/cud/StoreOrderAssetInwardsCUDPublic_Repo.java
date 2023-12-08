package store_order_asset_inwards_mgmt.model.repo.cud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import store_order_asset_inwards_mgmt.model.master.StoreOrderAssetInward;

@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
@Repository("storeOrderAssetInwardsCUDPublicRepoOnLine")
public interface StoreOrderAssetInwardsCUDPublic_Repo extends JpaRepository<StoreOrderAssetInward, Long> 
{
@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set FLAG_REQUESTED = :flag where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagRequested(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set FLAG_BOOKED = :flag where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagBooked(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set FLAG_Allocated = :flag where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagAllocated(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set FLAG_Moved = :flag where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagMoved(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set IS_BOOKED = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set IS_BOOKED = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set OKFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set OKFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set DONEFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set DONEFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying(clearAutomatically = true)
@Query(value="update STORE_ORDERASSET_INWARDS set DeleteFLAG = 'Y' where job_work_seq_no = :jobWorkSeqNo", nativeQuery = true)
void markDeleteByJob(@Param(value = "jobWorkSeqNo") Long jobWorkSeqNo);
} 
