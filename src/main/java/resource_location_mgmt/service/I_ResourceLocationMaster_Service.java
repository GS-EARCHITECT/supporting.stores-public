package resource_location_mgmt.service;

import java.util.ArrayList;
import resource_location_mgmt.model.dto.ResourceLocationMaster_DTO;

public interface I_ResourceLocationMaster_Service
{
    abstract public ResourceLocationMaster_DTO newCompanyLocationResource(ResourceLocationMaster_DTO resourceLocationMaster_DTO);
    abstract public ArrayList<ResourceLocationMaster_DTO> getAllCompanyLocationResources();        
    abstract public ArrayList<ResourceLocationMaster_DTO> getSelectCompanyResourcesLocations(ArrayList<Long> cos, ArrayList<Long> locs);
    abstract public Float getCompanyLocationResourceQoh(Long id, Long co, Long loc);
    abstract public void setCompanyLocationResourceQoh(Long id, Float qty, Long loc, Long co);        
    abstract public void updCompanyResourceLocation(ResourceLocationMaster_DTO resourceLocationMaster_DTO);
    abstract public void delSelectCompanyResourcesLocations(ArrayList<Long> cos, ArrayList<Long> locs);
    abstract public void delAllCompanyLocationResources();    
}