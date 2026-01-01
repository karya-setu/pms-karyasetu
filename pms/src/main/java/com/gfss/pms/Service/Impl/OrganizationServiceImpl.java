package com.gfss.pms.Service.Impl;

import com.gfss.pms.DTO.OrganizationCreateRequestDTO;
import com.gfss.pms.DTO.OrganizationCreateResponseDTO;
import com.gfss.pms.Entity.Organization;
import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.OrganizationRepository;
import com.gfss.pms.Repository.PMSUserRepo;
import com.gfss.pms.Service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final PMSUserRepo userRepository;

    @Override
    public OrganizationCreateResponseDTO createOrganization(OrganizationCreateRequestDTO dto) {

        // 1️⃣ Create Admin User
        PMSUser admin = PMSUser.builder()
                .firstName(dto.getAdminFirstName())
                .lastName(dto.getAdminLastName())
                .email(dto.getAdminEmail())
                .password(dto.getAdminPassword()) // encrypt later
                .status("ACTIVE")
                .build();

        admin = userRepository.save(admin);

        // 2️⃣ Create Organization (NO BUILDER)
        Organization organization = new Organization();
        organization.setName(dto.getName());
        organization.setEmail(dto.getEmail());
        organization.setContactNumber(dto.getContactNumber());
        organization.setAddress(dto.getAddress());
        organization.setAdminUserId(admin.getUserId());
        organization.setActive(true);

        organization = organizationRepository.save(organization);

        // 3️⃣ RETURN RESPONSE ✅
        return new OrganizationCreateResponseDTO(
                organization.getId(),
                organization.getName(),
                organization.getEmail(),
                admin.getUserId(),
                "Organization registered successfully"
        );
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationById(String id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found"));
    }

    @Override
    public Organization updateOrganization(String id, Organization updatedOrg) {
        Organization org = getOrganizationById(id);

        org.setName(updatedOrg.getName());
        org.setEmail(updatedOrg.getEmail());
        org.setContactNumber(updatedOrg.getContactNumber());
        org.setAddress(updatedOrg.getAddress());

        return organizationRepository.save(org);
    }

    @Override
    public void removeOrganizationFromSoftware(String id) {
        Organization org = getOrganizationById(id);
        org.setActive(false); // Soft delete (company removed from software)
        organizationRepository.save(org);
    }
}
