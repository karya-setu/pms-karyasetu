package com.gfss.pms.Service;

import com.gfss.pms.dto.PMSUserRequestDTO;
import com.gfss.pms.dto.PMSUserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PMSUserService {

    PMSUserResponseDTO createUser(PMSUserRequestDTO requestDTO);

    List<PMSUserResponseDTO> getAllUsers();

    Optional<PMSUserResponseDTO> getUserById(String id);

    Optional<PMSUserResponseDTO> updateUser(String id, PMSUserRequestDTO requestDTO);

    void deleteUser(String id);
}