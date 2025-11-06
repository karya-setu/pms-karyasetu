package com.gfss.pms.Service.Impl;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.PMSUserRepo;
import com.gfss.pms.Service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    private PMSUserRepo repo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public PMSUser saveUser(PMSUser user){
       return repo.save(user);
    }

    @Override
    public PMSUser login(String username, String password) {
//        PMSUser user = repo.findByUsername(username);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return user;
//        }
        return null;
    }
}