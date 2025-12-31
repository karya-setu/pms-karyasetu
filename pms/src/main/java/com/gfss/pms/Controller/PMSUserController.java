package com.gfss.pms.Controller;

import com.gfss.pms.dto.PMSUserRequestDTO;
import com.gfss.pms.dto.PMSUserResponseDTO;
import com.gfss.pms.Service.PMSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class PMSUserController {

    public PMSUserController() {
        System.out.println("✅ PMSUserController Loaded Successfully!");
    }

    @Autowired
    private PMSUserService userService;

    // Create user
    @PostMapping("/create")
    public ResponseEntity<PMSUserResponseDTO> createUser(@RequestBody PMSUserRequestDTO requestDTO) {
        PMSUserResponseDTO createdUser = userService.createUser(requestDTO);
        return ResponseEntity.ok(createdUser);
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<PMSUserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<PMSUserResponseDTO> getUserById(@PathVariable String id) {
        Optional<PMSUserResponseDTO> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<PMSUserResponseDTO> updateUser(@PathVariable String id,
                                                         @RequestBody PMSUserRequestDTO requestDTO) {
        Optional<PMSUserResponseDTO> updated = userService.updateUser(id, requestDTO);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
