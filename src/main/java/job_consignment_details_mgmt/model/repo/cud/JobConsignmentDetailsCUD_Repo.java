package job_consignment_details_mgmt.model.repo.cud;

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
	
}