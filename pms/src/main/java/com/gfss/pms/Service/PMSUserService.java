package com.gfss.pms.Service;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.PMSUserRepo;
import com.gfss.pms.dto.PMSUserRequestDTO;
import com.gfss.pms.dto.PMSUserResponseDTO;
import com.gfss.pms.mapper.PMSUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PMSUserService {

    @Autowired
    private PMSUserRepo userRepo;

    //  Create user
    public PMSUserResponseDTO createUser(PMSUserRequestDTO requestDTO) {
        PMSUser user = PMSUserMapper.toEntity(requestDTO);
        PMSUser savedUser = userRepo.save(user);
        return PMSUserMapper.toResponseDTO(savedUser);
    }

    // Get all users
    public List<PMSUserResponseDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(PMSUserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    //  Get user by ID
    public Optional<PMSUserResponseDTO> getUserById(String id) {
        return userRepo.findById(id)
                .map(PMSUserMapper::toResponseDTO);
    }

    //  Update user
    public Optional<PMSUserResponseDTO> updateUser(String id, PMSUserRequestDTO requestDTO) {
        Optional<PMSUser> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            PMSUser user = existingUser.get();
            if (requestDTO.getFirstName() != null) user.setFirstName(requestDTO.getFirstName());
            if (requestDTO.getLastName() != null) user.setLastName(requestDTO.getLastName());
            if (requestDTO.getEmail() != null) user.setEmail(requestDTO.getEmail());
            if (requestDTO.getPhone() != null) user.setPhone(requestDTO.getPhone());
            if (requestDTO.getPassword() != null) user.setPassword(requestDTO.getPassword());
            if (requestDTO.getDateJoined() != null) user.setDateJoined(requestDTO.getDateJoined());
            if (requestDTO.getStatus() != null) user.setStatus(requestDTO.getStatus());

            PMSUser updated = userRepo.save(user);
            return Optional.of(PMSUserMapper.toResponseDTO(updated));
        }
        return Optional.empty();
    }

    //  Delete user
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
