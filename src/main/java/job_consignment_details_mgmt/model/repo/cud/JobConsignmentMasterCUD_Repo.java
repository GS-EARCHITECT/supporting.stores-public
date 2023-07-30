package job_consignment_details_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_consignment_master_mgmt.model.master.JobConsignmentMaster;

@Repository("jobConsignmentMasterCUDRepo")
public interface JobConsignmentMasterCUD_Repo extends JpaRepository<JobConsignmentMaster, Long> 
{

	@Query(value = "delete from JOB_CONSIGNMENT_MASTER where CONSIGNMENT_SEQ_NO in :ids", nativeQuery = true)
	void delSelectJobConsignmentMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "delete from  JOB_CONSIGNMENT_MASTER where store_request_SEQ_NO in :ids ", nativeQuery = true)
	void delSelectJobConsignmentMastersByRequests(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "delete from  JOB_CONSIGNMENT_MASTER where par_CONSIGNMENT_SEQ_NO in :ids", nativeQuery = true)
	void delSelectJobConsignmentMastersByParents(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Query(value = "delete from  JOB_CONSIGNMENT_MASTER where from_party_SEQ_NO in :ids", nativeQuery = true)
	void delSelectJobConsignmentMastersForParties(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "delete from  JOB_CONSIGNMENT_MASTER where to_party_SEQ_NO in :ids", nativeQuery = true)
	void delSelectJobConsignmentMastersToParties(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	
}