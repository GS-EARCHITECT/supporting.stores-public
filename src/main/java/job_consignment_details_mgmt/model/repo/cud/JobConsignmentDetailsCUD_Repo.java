package job_consignment_details_mgmt.model.repo.cud;

import java.security.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_consignment_details_mgmt.model.master.JobConsignmentDetail;
import job_consignment_details_mgmt.model.master.JobConsignmentDetailPK;

@Repository("jobConsignmentDetailsCUDRepo")
public interface JobConsignmentDetailsCUD_Repo extends JpaRepository<JobConsignmentDetail, JobConsignmentDetailPK> 
{

	@Modifying
	@Query(value = "delete from JOB_CONSIGNMENT_DETAILS where CONSIGNMENT_SEQ_NO in :ids", nativeQuery = true)
	void delSelectJobConsignmentDetails(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Modifying
	@Query(value = "delete from from  JOB_CONSIGNMENT_DETAILS where resource_SEQ_NO in :rids", nativeQuery = true)
	void delSelectJobConsignmentDetailsByResources(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Modifying
	@Query(value = "delete from from  JOB_CONSIGNMENT_DETAILS where par_CONSIGNMENT_SEQ_NO in :aids", nativeQuery = true)
	void delSelectJobConsignmentDetailsByAssets(@Param("aids") CopyOnWriteArrayList<Long> aids);

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
	
}