package com.gfss.pms.Service.Impl;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repo.PMSUserRepo;
import com.gfss.pms.Service.PMSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PMSUserServiceImpl implements PMSUserService {
    @Autowired
    private PMSUserRepo repo;
    @Override
    public PMSUser saveUser(PMSUser user){
       return repo.save(user);
    }
}