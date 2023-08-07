package consignment_details_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import consignment_details_mgmt.model.master.ConsignmentDetail;
import consignment_details_mgmt.model.master.ConsignmentDetailPK;

@Repository("jobConsignmentDetailsReadRepo")
public interface ConsignmentDetailsRead_Repo extends JpaRepository<ConsignmentDetail, ConsignmentDetailPK> 
{
	@Query(value = "SELECT coalesce(sum(qty),0) from  Consignment_DETAILS where (upper(trim(doneflag)) <> 'Y' and consignment_seq_no = :cid and asset_seq_no = :aid)", nativeQuery = true)
	Float getTotalSelectConsignmentAssetDetailsPendingForConsignment(@Param("cid") Long cid, @Param("aid") Long aid);
	
	@Query(value = "SELECT coalesce(sum(qty),0) from  Consignment_DETAILS where (upper(trim(doneflag)) <> 'Y' and consignment_seq_no = :cid and resource_seq_no = :rid)", nativeQuery = true)
	Float getTotalSelectConsignmentResourceDetailsPendingForConsignment(@Param("cid") Long cid, @Param("rid") Long rid);
	
	@Query(value = "select * from CONSIGNMENT_DETAILS where CONSIGNMENT_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetails(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  CONSIGNMENT_DETAILS where resource_SEQ_NO in :rids ORDER BY resource_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsByResources(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Query(value = "SELECT * from  CONSIGNMENT_DETAILS where par_CONSIGNMENT_SEQ_NO in :aids ORDER BY asset_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsByAssets(@Param("aids") CopyOnWriteArrayList<Long> aids);
	
	@Query(value = "SELECT * from  store_Consignment_DETAILS where ((store_movement_seq_no IS not null or store_movement_seq_no > 0) and upper(trim(doneflag)) <> 'Y') ORDER BY consignment_SEQ_NO;", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsPending();
	
	@Query(value = "SELECT * from  store_Consignment_DETAILS where ((CONSIGNMENT_SEQ_NO = :cid) and ((resource_seq_no IS NOT NULL 0) and (resource_seq_no > 0)) and (store_movement_seq_no IS not null or store_movement_seq_no > 0) and upper(trim(doneflag)) <> 'Y') ORDER BY consignment_SEQ_NO;", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentResourceDetailsPending(@Param("cid") Long cid);

	@Query(value = "SELECT * from  store_Consignment_DETAILS where ((CONSIGNMENT_SEQ_NO = :cid) and ((asset_seq_no IS NOT NULL 0) and (asset_seq_no > 0)) and (store_movement_seq_no IS null or store_movement_seq_no = 0) and upper(trim(doneflag)) <> 'Y') ORDER BY consignment_SEQ_NO;", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentAssetDetailsPending(@Param("cid") Long cid);

	@Query(value = "SELECT * from  Consignment_DETAILS where (upper(trim(doneflag)) <> 'Y' and consignment_seq_no = :cid and resource_seq_no = :rid) ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentResourceDetailsPendingForConsignment(@Param("cid") Long cid, @Param("rid") Long rid);
	
	@Query(value = "SELECT * from  Consignment_DETAILS where (upper(trim(doneflag)) <> 'Y' and consignment_seq_no = :cid and asset_seq_no = :aid) ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentAssetDetailsPendingForConsignment(@Param("cid") Long cid, @Param("aid") Long aid);
	
	@Query(value = "SELECT * from  Consignment_DETAILS where upper(trim(doneflag)) = 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsDelivered();
	
	@Query(value = "SELECT * from  Consignment_DETAILS where upper(trim(okflag)) <> 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsCanBeProcessed();
		
	@Query(value = "SELECT * from  Consignment_DETAILS where upper(trim(okflag)) = 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsCannotBeProcessed();

	@Query(value = "select * from CONSIGNMENT_DETAILS where store_movement_SEQ_NO = :mid ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentMastersByMovement(@Param("mid") Long mid);

	@Query(value = "SELECT * from  Consignment_DETAILS where (store_movement_SEQ_NO = :mid and upper(trim(doneflag)) <> 'Y' and resource_seq_no = :rid) ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentResourceDetailsPendingForMovement(@Param("mid") Long mid, @Param("rid") Long rid);
	
	@Query(value = "SELECT * from  Consignment_DETAILS where (store_movement_SEQ_NO = :mid and upper(trim(doneflag)) <> 'Y' and asset_seq_no = :aid) ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentAssetDetailsPendingForMovement(@Param("mid") Long mid, @Param("aid") Long aid);

}