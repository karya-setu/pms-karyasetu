package com.gfss.pms.Controller;

import com.gfss.pms.Service.AuthUserService;
import com.gfss.pms.Entity.PMSUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
public class AuthUserController {

    @Autowired
    private AuthUserService service;

    @PostMapping("/register")
    public PMSUser register(@RequestBody PMSUser user){
      return service.saveUser(user);

    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
////        String username = credentials.get("username");
////        String password = credentials.get("password");
////
////        PMSUser user = service.login(username, password);
////
////        if (user != null) {
////            Map<String, Object> response = new HashMap<>();
////            response.put("id", user.getId());
////            response.put("username", user.getUsername());
////            response.put("message", "Login successful!");
////            return ResponseEntity.ok(response);
////        } else {
////            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
//
//        return null;
//        }

}