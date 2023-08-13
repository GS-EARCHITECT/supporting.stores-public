package resource_location_mgmt_public.model.cud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import common.domain.model.master.ResourceLocationMaster;
import common.domain.model.master.ResourceLocationMasterPK;

@Repository("resourceLocationMasterPublicCUDRepo")
public interface ResourceLocationMasterPublicCUD_Repo extends JpaRepository<ResourceLocationMaster, ResourceLocationMasterPK> 
{
	@Query(value = "update RESOURCE_LOCATION_MASTER set qoh = qoh + :qty WHERE ((a.resource_seq_no = :rid) and (a.location_seq_no = :lid) and (a.company_seq_no = :pid))", nativeQuery = true)
	void addResourceQoh(@Param("rid") Long rid, @Param("qty") Float qty, @Param("lid") Long lid, @Param("pid") Long pid);

	@Query(value = "update RESOURCE_LOCATION_MASTER set qoh = qoh - :qty WHERE ((a.resource_seq_no = :rid) and (a.location_seq_no = :lid) and (a.company_seq_no = :pid))", nativeQuery = true)
	void subResourceQoh(@Param("rid") Long rid, @Param("qty") Float qty, @Param("lid") Long lid, @Param("pid") Long pid);
	
	@Query(value = "update RESOURCE_LOCATION_MASTER set qoh = :qty WHERE ((a.resource_seq_no = :rid) and (a.location_seq_no = :lid) and (a.company_seq_no = :pid))", nativeQuery = true)
	void setResourceQoh(@Param("rid") Long rid, @Param("qty") Float qty, @Param("lid") Long lid, @Param("pid") Long pid);
}
