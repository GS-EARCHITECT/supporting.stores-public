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

	@Query(value = "select * from STORE_CONSIGNMENT_MASTER where CONSIGNMENT_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  STORE_CONSIGNMENT_MASTER where par_CONSIGNMENT_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersByParents(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Query(value = "SELECT * from  STORE_CONSIGNMENT_MASTER where from_party_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersForParties(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  STORE_CONSIGNMENT_MASTER where to_party_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersToParties(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(inflag)) = 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersComingIn();

	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(inflag)) <> 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersGoingOut();
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(doneflag)) <> 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersPending();
	
	@Query(value = "SELECT * from  Consignment_MASTER where (upper(trim(inflag)) = 'Y' and upper(trim(doneflag)) <> 'Y') ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentInMastersPending();
	
	@Query(value = "SELECT * from  Consignment_MASTER where (upper(trim(inflag)) <> 'Y' and upper(trim(doneflag)) <> 'Y') ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentOutMastersPending();
		
	@Query(value = "SELECT * from  Consignment_MASTER where (upper(trim(inflag)) <> 'Y' and upper(trim(doneflag)) = 'Y') ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersAppliedOutwards();
	
	@Query(value = "SELECT * from  Consignment_MASTER where (upper(trim(inflag)) = 'Y' and upper(trim(doneflag)) = 'Y') ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersAppliedInwards();
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(okflag)) <> 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersCanBeProcessed();
		
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(okflag)) = 'Y' ORDER BY consignment_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentMaster> getSelectConsignmentMastersCannotBeProcessed();
	
}