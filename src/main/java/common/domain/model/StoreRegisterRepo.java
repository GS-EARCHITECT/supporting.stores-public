package common.domain.model;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository("storeRegisterRepo")
public interface StoreRegisterRepo extends CrudRepository<StoreRegister, Integer> 
{
@Query(value = "SELECT is_booked FROM STORE_ORDER_MASTER where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Optional<Character> getIsbookedStatus(@Param("storeReqSeqNo") Integer storeReqSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_allocated),0) FROM STORE_ORDER_MASTER where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn=0",nativeQuery = true) 
float getTotalQtyAllocForItem(@Param("storeReqSeqNo") Integer storeReqSeqNo, @Param("itemSeqNo") Integer itemSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM STORE_ORDER_MASTER where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn=0",nativeQuery = true) 
float getTotalQtyRequestedForItem(@Param("storeReqSeqNo") Integer storeReqSeqNo, @Param("itemSeqNo") Integer itemSeqNo);

@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDER_MASTER where ITEM_SEQ_NO=:itemSeqNo and STORE_REQUEST_SEQ_NO<:storeReqSeqNo",nativeQuery = true) 
Integer getTotalRowsForItemsBefore(@Param("itemSeqNo") Integer itemSeqNo, @Param("storeReqSeqNo") Integer storeReqSeqNo);

@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDER_MASTER",nativeQuery = true) 
Integer getTotalRowCount();

@Query(value = "SELECT * FROM STORE_ORDER_MASTER ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO",nativeQuery = true) 
Optional<ArrayList<StoreRegister>> getAllRows();

@Query(value = "SELECT qty_requested FROM STORE_ORDER_MASTER where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
float getRegisterRequestQty(@Param("storeReqSeqNo") Integer storeReqSeqNo);

@Query(value = "SELECT * FROM STORE_ORDER_MASTER  where MODE_TXN=0 ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO",nativeQuery = true) 
Optional<ArrayList<StoreRegister>> getAllRowsForMode0();

@Query(value = "SELECT store_request_seq_no FROM STORE_ORDER_MASTER where MODE_TXN=0 ORDER BY STORE_REQUEST_SEQ_NO",nativeQuery = true) 
Optional<ArrayList<Integer>> getAllSeqNosForMode(@Param("mode_Txn") Integer mode_Txn);

@Query(value = "SELECT * FROM STORE_ORDER_MASTER  where MODE_TXN=:mode_Txn ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO",nativeQuery = true) 
Optional<ArrayList<StoreRegister>> getAllRowsForMode(@Param("mode_Txn") Integer mode_Txn);

@Query(value = "SELECT * FROM STORE_ORDER_MASTER  where MODE_TXN=1 ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO",nativeQuery = true) 
Optional<ArrayList<StoreRegister>> getAllRowsForMode1();

@Modifying
@Query(value="update STORE_ITEM_MASTER set QOH = QOH - :qoh where ITEM_SEQ_NO = :itemSeqNo", nativeQuery = true)
void updateItemMasterDeductQty(@Param(value = "qoh") float qoh, @Param(value = "itemSeqNo") Integer itemSeqNo);

@Modifying
@Query(value="update STORE_ITEM_MASTER set QOH = QOH + :qoh where ITEM_SEQ_NO = :itemSeqNo", nativeQuery = true)
void updateItemMasterAddQty(@Param(value = "qoh") float qoh, @Param(value = "itemSeqNo") Integer itemSeqNo);

@Modifying
@Query(value="update STORE_ITEM_MASTER set QOH = 0 where ITEM_SEQ_NO = :itemSeqNo", nativeQuery = true)
void updateItemMasterQtyToZero(@Param(value = "itemSeqNo") Integer itemSeqNo);

@Nullable
@Query(value="SELECT coalesce((select qoh from STORE_ITEM_MASTER where ITEM_SEQ_NO = :itemSeqNo),0) AS qoh FROM DUAL", nativeQuery = true)
float getItemQty(@Param(value = "itemSeqNo") Integer itemSeqNo);

@Modifying
@Query(value="update STORE_ORDER_MASTER set QTY_ALLOCATED = QTY_ALLOCATED + :neededQty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateStoreAlloc(@Param(value = "neededQty") float neededQty, @Param(value = "storeReqSeqNo") Integer storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_MASTER set QTY_BOOKED = QTY_BOOKED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateQtyBooked(@Param(value = "qty") float qty, @Param(value = "storeReqSeqNo") Integer storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_MASTER set IS_BOOKED = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateBookStatus(@Param(value = "storeReqSeqNo") Integer storeReqSeqNo);
} 

