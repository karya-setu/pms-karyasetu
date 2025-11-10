package com.gfss.pms.Service;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.PMSUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PMSUserService {

    @Autowired
    private PMSUserRepo userRepo;

    // Create user
    public PMSUser createUser(PMSUser user) {
        return userRepo.save(user);
    }

    // Get all users
    public List<PMSUser> getAllUsers() {
        return userRepo.findAll();
    }

    // Get user by ID
    public Optional<PMSUser> getUserById(String id) {
        return userRepo.findById(id);
    }

    // Update user
    public PMSUser updateUser(String id, PMSUser updatedUser) {
        Optional<PMSUser> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            PMSUser user = existingUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setPassword(updatedUser.getPassword());
            user.setDateJoined(updatedUser.getDateJoined());
            user.setStatus(updatedUser.getStatus());
            return userRepo.save(user);
        } else {
            return null;
        }
    }

    // Delete user
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
