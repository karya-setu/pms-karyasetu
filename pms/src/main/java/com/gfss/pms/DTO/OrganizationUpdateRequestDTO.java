package com.gfss.pms.DTO;

import lombok.Data;

@Data
public class OrganizationUpdateRequestDTO {

    private String name;
    private String email;
    private String contactNumber;
    private String address;
    private boolean active;
}
