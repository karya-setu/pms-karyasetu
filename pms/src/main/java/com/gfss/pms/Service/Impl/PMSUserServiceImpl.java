package com.gfss.pms.Service.Impl;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.Repository.PMSUserRepo;
import com.gfss.pms.Service.PMSUserService;
import com.gfss.pms.dto.PMSUserRequestDTO;
import com.gfss.pms.dto.PMSUserResponseDTO;
import com.gfss.pms.mapper.PMSUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PMSUserServiceImpl implements PMSUserService {

    @Autowired
    private PMSUserRepo userRepo;

    // ✅ Create User
    @Override
    public PMSUserResponseDTO createUser(PMSUserRequestDTO requestDTO) {
        PMSUser user = PMSUserMapper.toEntity(requestDTO);
        PMSUser savedUser = userRepo.save(user);
        return PMSUserMapper.toResponseDTO(savedUser);
    }

    // ✅ Get All Users
    @Override
    public List<PMSUserResponseDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(PMSUserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get User By ID
    @Override
    public Optional<PMSUserResponseDTO> getUserById(String id) {
        return userRepo.findById(id)
                .map(PMSUserMapper::toResponseDTO);
    }

    // ✅ Update User
    @Override
    public Optional<PMSUserResponseDTO> updateUser(String id, PMSUserRequestDTO requestDTO) {
        Optional<PMSUser> existingUserOpt = userRepo.findById(id);

        if (existingUserOpt.isPresent()) {
            PMSUser user = existingUserOpt.get();

            if (requestDTO.getFirstName() != null)
                user.setFirstName(requestDTO.getFirstName());

            if (requestDTO.getLastName() != null)
                user.setLastName(requestDTO.getLastName());

            if (requestDTO.getEmail() != null)
                user.setEmail(requestDTO.getEmail());

            if (requestDTO.getPhone() != null)
                user.setPhone(requestDTO.getPhone());

            if (requestDTO.getPassword() != null)
                user.setPassword(requestDTO.getPassword());

            if (requestDTO.getStatus() != null)
                user.setStatus(requestDTO.getStatus());

            PMSUser updatedUser = userRepo.save(user);
            return Optional.of(PMSUserMapper.toResponseDTO(updatedUser));
        }

        return Optional.empty();
    }

    // ✅ Delete User
    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
