package com.gfss.pms.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PMSUserResponseDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateJoined;
    private String status;
}
