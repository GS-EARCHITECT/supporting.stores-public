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
	@Query(value = "select * from JOB_CONSIGNMENT_DETAILS where CONSIGNMENT_SEQ_NO in :ids ORDER BY CONSIGNMENT_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetails(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_DETAILS where resource_SEQ_NO in :rids ORDER BY resource_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsByResources(@Param("rids") CopyOnWriteArrayList<Long> rids);

	@Query(value = "SELECT * from  JOB_CONSIGNMENT_DETAILS where par_CONSIGNMENT_SEQ_NO in :aids ORDER BY asset_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsByAssets(@Param("aids") CopyOnWriteArrayList<Long> aids);
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(doneflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsPending();
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(doneflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsDelivered();
	
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(okflag)) <> 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsCanBeProcessed();
		
	@Query(value = "SELECT * from  Consignment_MASTER where upper(trim(okflag)) = 'Y' ORDER BY shipping_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ConsignmentDetail> getSelectConsignmentDetailsCannotBeProcessed();

}