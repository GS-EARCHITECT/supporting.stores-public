package storeMovementManager.model;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("storeIssueRepo")
public interface StoreIssueRepo extends CrudRepository<StoreIssueMaster, StoreMovementMasterPK> 
{
@Query(value = "SELECT BY_STORE_VERIFICATION_FLAG FROM TRANSACTION_ITEM_DETAILS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Optional<ArrayList<Character>> getStoreVerifiedStatus(@Param("storeReqSeqNo") Integer storeReqSeqNo);

@Modifying
@Query(value="update TRANSACTION_ITEM_DETAILS set BY_STORE_VERIFICATION_FLAG = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateStoreVerifiedStatus(@Param(value = "storeReqSeqNo") Integer storeReqSeqNo);

@Query(value = "SELECT * FROM STORE_ISSUE_MASTER where processed_qty < request_qty ORDER BY STORE_REQUEST_SEQ_NO, ITEM_SEQ_NO, REQUEST_ON",nativeQuery = true) 
Optional<ArrayList<StoreIssueMaster>> getAllRowsPendingProcessing();

@Query(value = "SELECT COALESCE(SUM(processed_qty),0) FROM STORE_ISSUE_MASTER where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
float getTotalProcessedQtyForStoreItem(@Param("storeReqSeqNo") Integer storeReqSeqNo);

} 

