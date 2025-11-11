package com.gfss.pms.Service.Impl;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.PMSUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PMSUserRepo pmsUserRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PMSUser user= pmsUserRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User DoesNot exist"));
        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}
