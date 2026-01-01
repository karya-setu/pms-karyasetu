package com.gfss.pms.DTO;

import lombok.Data;

@Data
public class OrganizationCreateRequestDTO {

    // Organization details
    private String name;
    private String email;
    private String contactNumber;
    private String address;

    // Admin details (Super Admin provides this)
    private String adminFirstName;
    private String adminLastName;
    private String adminEmail;
    private String adminPassword;
    private String adminPhone;
}
