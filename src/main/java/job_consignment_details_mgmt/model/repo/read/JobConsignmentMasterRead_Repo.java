package job_consignment_details_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_consignment_master_mgmt.model.master.JobConsignmentMaster;

@Repository("jobConsignmentMasterReadRepo")
public interface JobConsignmentMasterRead_Repo extends JpaRepository<JobConsignmentMaster, Long> 
{

	@Query(value = "select * from JOB_CONSIGNMENT_MASTER where CONSIGNMENT_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentMaster> getSelectJobConsignmentMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where store_request_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentMaster> getSelectJobConsignmentMastersByRequests(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where par_CONSIGNMENT_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentMaster> getSelectJobConsignmentMastersByParents(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where from_party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentMaster> getSelectJobConsignmentMastersForParties(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where to_party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobConsignmentMaster> getSelectJobConsignmentMastersToParties(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	
}