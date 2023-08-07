package consignment_master_mgmt.model.repo.cud;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import consignment_master_mgmt.model.master.ConsignmentMaster;

@Repository("consignmentMasterCUDRepo")
public interface ConsignmentMasterCUD_Repo extends JpaRepository<ConsignmentMaster, Long> 
{

	@Query(value = "delete from store_CONSIGNMENT_MASTER where CONSIGNMENT_SEQ_NO in :ids", nativeQuery = true)
	void delSelectConsignmentMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "delete from  store_CONSIGNMENT_MASTER where par_CONSIGNMENT_SEQ_NO in :ids", nativeQuery = true)
	void delSelectConsignmentMastersByParents(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Query(value = "delete from  store_CONSIGNMENT_MASTER where from_party_SEQ_NO in :ids", nativeQuery = true)
	void delSelectConsignmentMastersForParties(@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "delete from  store_CONSIGNMENT_MASTER where to_party_SEQ_NO in :ids", nativeQuery = true)
	void delSelectConsignmentMastersToParties(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_MASTER set doneflag = 'Y' where CONSIGNMENT_seq_no = :id", nativeQuery = true)
	void updConsignmentMasterDone(@Param("scid") Long id);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_MASTER set doneflag = :st where CONSIGNMENT_seq_no = :id", nativeQuery = true)
	void updConsignmentMasterDoneStatus(@Param("id") Long id, @Param("st") Character st);
		
	@Modifying
	@Query(value = "update store_CONSIGNMENT_MASTER set okflag = 'Y' where CONSIGNMENT_seq_no = :id", nativeQuery = true)
	void updConsignmentMasterOk(@Param("id") Long id);
	
	@Modifying
	@Query(value = "update store_CONSIGNMENT_MASTER set okflag = :st where CONSIGNMENT_seq_no = :id", nativeQuery = true)
	void updConsignmentMasterOkStatus(@Param("scid") Long scid, @Param("st") Character st);
	
}