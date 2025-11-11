package com.gfss.pms.Controller;


import com.gfss.pms.DTO.AuthRequest;
import com.gfss.pms.DTO.AuthResponse;
import com.gfss.pms.DTO.SignupRequest;
import com.gfss.pms.DTO.SignupResponse;
import com.gfss.pms.Service.AuthUserService;
import com.gfss.pms.Service.Impl.CustomUserDetailsService;
import com.gfss.pms.Util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public SignupResponse register(@RequestBody SignupRequest request){
      return authUserService.registerUser(request) ;

    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getEmail());
        final String jwtToken = jwtUtil.generateToken(userDetails);

        return new AuthResponse(
                request.getEmail(),
                "Login successful",
                jwtToken
        );
    }



}