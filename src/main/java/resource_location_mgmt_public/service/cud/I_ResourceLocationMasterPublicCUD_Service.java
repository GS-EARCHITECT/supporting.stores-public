package resource_location_mgmt_public.service.cud;

import java.util.concurrent.CompletableFuture;

public interface I_ResourceLocationMasterPublicCUD_Service
{
    public CompletableFuture<Void> addPartyLocationResourceQoh(Long id, Float qty, Long loc, Long py);
    public CompletableFuture<Void> subPartyLocationResourceQoh(Long id, Float qty, Long loc, Long py);
    public CompletableFuture<Void> setPartyLocationResourceQoh(Long id, Float qty, Long loc, Long py);
    
}