package consignment_details_mgmt.model.repo.cud;

import java.security.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import consignment_details_mgmt.model.master.ConsignmentDetail;
import consignment_details_mgmt.model.master.ConsignmentDetailPK;

@Repository("consignmentDetailsCUDRepo")
public interface ConsignmentDetailsCUD_Repo extends JpaRepository<ConsignmentDetail, ConsignmentDetailPK> 
{

	@Modifying
	@Query(value = "delete from JOB_CONSIGNMENT_DETAILS where CONSIGNMENT_SEQ_NO in :ids", nativeQuery = true)
	void delSelectConsignmentDetails(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Modifying
	@Query(value = "delete from from  JOB_CONSIGNMENT_DETAILS where resource_SEQ_NO in :rids", nativeQuery = true)
	void delSelectConsignmentDetailsByResources(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Modifying
	@Query(value = "delete from from  JOB_CONSIGNMENT_DETAILS where par_CONSIGNMENT_SEQ_NO in :aids", nativeQuery = true)
	void delSelectConsignmentDetailsByAssets(@Param("aids") CopyOnWriteArrayList<Long> aids);

	@Modifying
	@Query(value = "update store_issue_master set qty = qty + :qty where REQUEST_ON = :reqDtTm and STORE_REQUEST_SEQ_NO = :reqid and resource_seq_no = :rid", nativeQuery = true)
	void addIssueConsignmentQty(@Param("reqid") Long reqid, @Param("reqDtTm") Timestamp reqDtTm, @Param("rid") Long rid, @Param("qty") Long qty);

	@Modifying
	@Query(value = "update store_issue_master set qty = qty - :qty where REQUEST_ON = :reqDtTm and STORE_REQUEST_SEQ_NO = :reqid and resource_seq_no = :rid", nativeQuery = true)
	void subIssueConsignmentQty(@Param("reqid") Long reqid, @Param("reqDtTm") Timestamp reqDtTm, @Param("rid") Long rid, @Param("qty") Long qty);

	@Modifying
	@Query(value = "update store_recieve_master set qty = qty + :qty where REQUEST_ON = :reqDtTm and STORE_REQUEST_SEQ_NO = :reqid and resource_seq_no = :rid", nativeQuery = true)
	void addRecieveConsignmentQty(@Param("reqid") Long reqid, @Param("reqDtTm") Timestamp reqDtTm, @Param("rid") Long rid, @Param("qty") Long qty);

	@Modifying
	@Query(value = "update store_recieve_master set qty = qty - :qty where REQUEST_ON = :reqDtTm and STORE_REQUEST_SEQ_NO = :reqid and resource_seq_no = :rid", nativeQuery = true)
	void subRecieveConsignmentQty(@Param("reqid") Long reqid, @Param("reqDtTm") Timestamp reqDtTm, @Param("rid") Long rid, @Param("qty") Long qty);

	@Modifying
	@Query(value = "update store_recieve_master set ok_flag = 'Y' where REQUEST_ON = :reqDtTm and STORE_REQUEST_SEQ_NO = :reqid and resource_seq_no = :rid", nativeQuery = true)
	void updOkStatus(@Param("reqid") Long reqid, @Param("reqDtTm") Timestamp reqDtTm, @Param("rid") Long rid);
	
	@Modifying
	@Query(value = "update store_recieve_master set ok_flag = 'N' where REQUEST_ON = :reqDtTm and STORE_REQUEST_SEQ_NO = :reqid and resource_seq_no = :rid", nativeQuery = true)
	void updNOkStatus(@Param("reqid") Long reqid, @Param("reqDtTm") Timestamp reqDtTm, @Param("rid") Long rid);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set doneflag = 'Y' where (CONSIGNMENT_seq_no = :id and asset_seq_no = :aid)", nativeQuery = true)
	void updConsignmentAssetDetailDone(@Param("id") Long id, @Param("aid") Long aid);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set doneflag = 'Y' where (CONSIGNMENT_seq_no = :id and resource_seq_no = :rid)", nativeQuery = true)
	void updConsignmentResourceDetailDone(@Param("id") Long id, @Param("rid") Long rid);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set doneflag = :st where (CONSIGNMENT_seq_no = :id and asset_seq_no = :aid)", nativeQuery = true)
	void updConsignmentDetailAssetDoneStatus(@Param("id") Long id, @Param("aid") Long aid, @Param("st") Character st);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set doneflag = :st where (CONSIGNMENT_seq_no = :id and resource_seq_no = :rid)", nativeQuery = true)
	void updConsignmentDetailResourceDoneStatus(@Param("id") Long id, @Param("rid") Long rid, @Param("st") Character st);

	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set okflag = 'Y' where (CONSIGNMENT_seq_no = :id and resource_seq_no = :rid)", nativeQuery = true)
	void updConsignmentResourceDetailOk(@Param("id") Long id, @Param("rid") Long rid);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set okflag = 'Y' where (CONSIGNMENT_seq_no = :id and asset_seq_no = :aid)", nativeQuery = true)
	void updConsignmentAssetDetailOk(@Param("id") Long id, @Param("aid") Long aid);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set okflag = :st where (CONSIGNMENT_seq_no = :id and resource_seq_no = :rid)", nativeQuery = true)
	void updConsignmentResourceDetailOkStatus(@Param("id") Long id, @Param("rid") Long rid, @Param("st") Character st);

	@Modifying
	@Query(value = "update store_CONSIGNMENT_details set okflag = :st where (CONSIGNMENT_seq_no = :id and asset_seq_no = :aid)", nativeQuery = true)
	void updConsignmentAssetDetailOkStatus(@Param("scid") Long id, @Param("aid") Long aid, @Param("st") Character st);

	@Query(value = "update STORE_CONSIGNMENT_DETAIL set STORE_MOVEMENT_SEQ_no = :mid where (CONSIGNMENT_seq_no = :id) and resource_seq_no= :rid and qty= :qty)", nativeQuery = true)
	void updConsignmentMasterMovementNoForResource(@Param("mid") Long mid, @Param("cid") Long cid, @Param("rid") Long rid, @Param("qty") Float qty);

	@Query(value = "update STORE_CONSIGNMENT_DETAIL set STORE_MOVEMENT_SEQ_no = :mid where (CONSIGNMENT_seq_no = :id) and asset_seq_no= :rid and qty= :qty)", nativeQuery = true)
	void updConsignmentMasterMovementNoForAsset(@Param("mid") Long mid, @Param("cid") Long cid, @Param("aid") Long aid);
}
