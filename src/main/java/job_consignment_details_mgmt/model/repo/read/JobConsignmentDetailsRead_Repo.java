package job_consignment_details_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_consignment_details_mgmt.model.master.JobConsignmentDetail;
import job_consignment_details_mgmt.model.master.JobConsignmentDetailPK;

@Repository("jobConsignmentDetailsReadRepo")
public interface JobConsignmentDetailsRead_Repo extends JpaRepository<JobConsignmentDetail, JobConsignmentDetailPK> 
{

	@Query(value = "select * from JOB_CONSIGNMENT_DETAILS where CONSIGNMENT_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentDetail> getSelectJobConsignmentDetails(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_DETAILS where resource_SEQ_NO in :rids ORDER BY resource_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentDetail> getSelectJobConsignmentDetailsByResources(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_DETAILS where par_CONSIGNMENT_SEQ_NO in :aids ORDER BY asset_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentDetail> getSelectJobConsignmentDetailsByAssets(@Param("aids") CopyOnWriteArrayList<Long> aids);
	
}