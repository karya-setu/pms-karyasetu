package com.gfss.pms.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor   // <-- THIS FIXES YOUR ERROR
public class OrganizationCreateResponseDTO {

    private String organizationId;
    private String organizationName;
    private String organizationEmail;
    private String adminUserId;
    private String message;
}
