package com.gfss.pms.Controller;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.PMSUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class PMSUserController {

    @Autowired
    private PMSUserRepository repository;

    @PostMapping("/add")
    public PMSUser addUser(@RequestBody PMSUser user) {
        return repository.save(user);
    }

    @GetMapping("/all")
    public List<PMSUser> getAllUsers() {
        return repository.findAll();
    }
}
