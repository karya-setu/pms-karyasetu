package com.gfss.pms.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}
