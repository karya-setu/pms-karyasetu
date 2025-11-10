package com.gfss.pms.Controller;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Service.PMSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class PMSUserController {

    @Autowired
    private PMSUserService userService;

    // Create user
    @PostMapping("/create")
    public ResponseEntity<PMSUser> createUser(@RequestBody PMSUser user) {
        PMSUser createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<PMSUser>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<PMSUser> getUserById(@PathVariable String id) {
        Optional<PMSUser> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<PMSUser> updateUser(@PathVariable String id, @RequestBody PMSUser updatedUser) {
        PMSUser user = userService.updateUser(id, updatedUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
