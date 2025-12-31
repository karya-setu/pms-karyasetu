package com.gfss.pms.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PMSUserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private LocalDate dateJoined;
    private String status;
}
