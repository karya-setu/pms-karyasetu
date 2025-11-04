package com.gfss.pms.Controller;

import com.gfss.pms.Service.PMSUserService;
import com.gfss.pms.Repo.PMSUserRepo;
import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.DTO.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
public class PMSUserController {

    @Autowired
    private PMSUserService service;

    @PostMapping("/register")
    public PMSUser register(@RequestBody PMSUser user){
      return service.saveUser(user);

    }
}