package com.gfss.pms.Service;

import com.gfss.pms.DTO.OrganizationCreateRequestDTO;
import com.gfss.pms.DTO.OrganizationCreateResponseDTO;
import com.gfss.pms.Entity.Organization;

import java.util.List;

public interface OrganizationService {

    OrganizationCreateResponseDTO createOrganization(OrganizationCreateRequestDTO dto);

    List<Organization> getAllOrganizations();

    Organization getOrganizationById(String id);

    Organization updateOrganization(String id, Organization organization);

    void removeOrganizationFromSoftware(String id);
}
