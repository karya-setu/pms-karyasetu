package com.gfss.pms.Controller;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Service.PMSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/user")
public class PMSUserController {

    @Autowired
    private PMSUserService service;

    // ✅ Register new user
    @PostMapping("/register")
    public PMSUser register(@RequestBody PMSUser user) {
        return service.saveUser(user);
    }

    // ✅ Login existing user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        PMSUser user = service.login(username, password);

        if (user != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("username", user.getUsername());
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
        }
    }

    // ✅ Get all users (from your branch)
    @GetMapping("/all")
    public List<PMSUser> getAllUsers() {
        return service.getAllUsers();
    }
}
