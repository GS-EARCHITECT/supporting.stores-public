package resource_location_mgmt_public.model.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import common.domain.model.master.ResourceLocationMaster;
import common.domain.model.master.ResourceLocationMasterPK;

@Repository("resourceLocationMasterPublicReadRepo")
public interface ResourceLocationMasterPublicRead_Repo extends JpaRepository<ResourceLocationMaster, ResourceLocationMasterPK> 
{
	@Query(value = "SELECT coalesce(qoh,0) FROM RESOURCE_LOCATION_MASTER a WHERE ((a.resource_seq_no = :rid) and (a.location_seq_no = :lid) and (a.party_seq_no = :pid))", nativeQuery = true)
	Float getResourceQoh(@Param("rid") Long rid, @Param("pid") Long pid, @Param("lid") Long lid);

	@Query(value = "select * FROM RESOURCE_LOCATION_MASTER a WHERE a.location_seq_no in :lids order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<ResourceLocationMaster> getSelectResourcesByLocations(@Param("lids") CopyOnWriteArrayList<Long> lidss);

	@Query(value = "select * FROM RESOURCE_LOCATION_MASTER a WHERE a.party_seq_no in :lids order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<ResourceLocationMaster> getSelectResourcesByParties(@Param("pids") CopyOnWriteArrayList<Long> pidss);
	
	@Query(value = "select * FROM RESOURCE_LOCATION_MASTER a WHERE a.resource_seq_no in :rids order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<ResourceLocationMaster> getSelectResources(@Param("rids") CopyOnWriteArrayList<Long> ridss);

}
