package com.gfss.pms.Service.Impl;

import com.gfss.pms.DTO.SignupRequest;
import com.gfss.pms.DTO.SignupResponse;
import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.PMSUserRepo;
import com.gfss.pms.Service.AuthUserService;
import com.gfss.pms.Service.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    private PMSUserRepo pmsUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationFacade authenticationFacade;


    @Override
    public SignupResponse registerUser(SignupRequest request) {
        PMSUser newUser=convertToEntity(request);
        newUser=pmsUserRepo.save(newUser);
        return convertToResponse(newUser);
    }

    @Override
    public String findByUserId() {
        String loggedInUserEmail = authenticationFacade.getAuthntication().getName();
        PMSUser loggedInUser=pmsUserRepo.findByEmail(loggedInUserEmail).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return loggedInUser.getUserId();
    }

    private PMSUser convertToEntity(SignupRequest request){
        return PMSUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .dateJoined(request.getDateJoined())
                .build();
    }

    private SignupResponse convertToResponse(PMSUser registeredUser){
        return SignupResponse.builder()
                .userId(registeredUser.getUserId())
                .firstName(registeredUser.getFirstName())
                .lastName(registeredUser.getLastName())
                .email(registeredUser.getEmail())
                .phone(registeredUser.getPhone())
                .dateJoined(registeredUser.getDateJoined())
                .build();
    }
}