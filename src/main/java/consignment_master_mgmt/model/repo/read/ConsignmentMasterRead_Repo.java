package consignment_master_mgmt.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import consignment_master_mgmt.model.master.ConsignmentMaster;

@Repository("consignmentMasterReadRepo")
public interface ConsignmentMasterRead_Repo extends JpaRepository<ConsignmentMaster, Long> 
{

	@Query(value = "select * from JOB_CONSIGNMENT_MASTER where CONSIGNMENT_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where store_request_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersByRequests(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where par_CONSIGNMENT_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersByParents(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where from_party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersForParties(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_MASTER where to_party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersToParties(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(inflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersComingIn();

	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(inflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersGoingOut();
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(doneflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersPending();
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(doneflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersDelivered();
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(okflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersCanBeProcessed();
		
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(okflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersCannotBeProcessed();
	
}