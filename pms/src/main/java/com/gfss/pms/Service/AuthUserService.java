package com.gfss.pms.Service;

import com.gfss.pms.DTO.SignupRequest;
import com.gfss.pms.DTO.SignupResponse;
import com.gfss.pms.Entity.PMSUser;

public interface AuthUserService {
    SignupResponse registerUser(SignupRequest request);
    String findByUserId();
}