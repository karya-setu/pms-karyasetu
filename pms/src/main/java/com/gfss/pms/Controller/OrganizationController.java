package com.gfss.pms.Controller;

import com.gfss.pms.DTO.OrganizationCreateRequestDTO;
import com.gfss.pms.DTO.OrganizationCreateResponseDTO;
import com.gfss.pms.Entity.Organization;
import com.gfss.pms.Service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    // Super Admin registers organization + admin
    @PostMapping
    public OrganizationCreateResponseDTO createOrganization(
            @RequestBody OrganizationCreateRequestDTO dto
    ) {
        return organizationService.createOrganization(dto);
    }

    @GetMapping
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable String id) {
        return organizationService.getOrganizationById(id);
    }

    @PutMapping("/{id}")
    public Organization updateOrganization(
            @PathVariable String id,
            @RequestBody Organization organization
    ) {
        return organizationService.updateOrganization(id, organization);
    }

    // Super Admin removes company from software
    @DeleteMapping("/{id}")
    public String removeOrganization(@PathVariable String id) {
        organizationService.removeOrganizationFromSoftware(id);
        return "Organization removed from software successfully";
    }
}
