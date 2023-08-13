package resource_location_mgmt_public.service.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import common.domain.model.dto.ResourceLocationMaster_DTO;
import common.domain.model.master.ResourceLocationMasterPK;

public interface I_ResourceLocationMasterPublicRead_Service
{
	public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getAllPartyLocationResources();        
    public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesPartyLocations(CopyOnWriteArrayList<ResourceLocationMasterPK> resourceLocationMasterPKs);
    public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByLocations( CopyOnWriteArrayList<Long> lidss);
    public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByParties(CopyOnWriteArrayList<Long> pids);
    public CompletableFuture<CopyOnWriteArrayList<ResourceLocationMaster_DTO>> getSelectResources(CopyOnWriteArrayList<Long> ridss);    
    public CompletableFuture<Float> getResourceQoh(Long rid, Long pid, Long lid);
    
}