package store_order_asset_inwards_mgmt.model.repo.cud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import store_order_asset_inwards_mgmt.model.master.StoreOrderAssetInward;

@Repository("storeOrderAssetInwardsCUDPublicRepo")
public interface StoreOrderAssetInwardsCUDPublic_Repo extends JpaRepository<StoreOrderAssetInward, Long> 
{
@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set FLAG_REQUESTED = :flag where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagRequested(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set FLAG_BOOKED = FLAG_BOOKED where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagBooked(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set FLAG_Allocated = FLAG_Allocated where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagAllocated(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set FLAG_Moved = FLAG_Moved where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void setFlagMoved(@Param(value = "flag") Character flag, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set IS_BOOKED = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set IS_BOOKED = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set OKFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set OKFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set DONEFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying
@Query(value="update STORE_ORDERASSET_OUTWARDS set DONEFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);
} 
