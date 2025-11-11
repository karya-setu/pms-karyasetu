package com.gfss.pms.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String userId;
    private String message; //Example: "User registered succesfully"
    private String token; //JWT Token after login
}
