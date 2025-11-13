package com.gfss.pms.mapper;

import com.gfss.pms.Entity.PMSUser;
import com.gfss.pms.dto.PMSUserRequestDTO;
import com.gfss.pms.dto.PMSUserResponseDTO;

public class PMSUserMapper {

    // Convert RequestDTO → Entity
    public static PMSUser toEntity(PMSUserRequestDTO dto) {
        PMSUser user = new PMSUser();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setDateJoined(dto.getDateJoined());
        user.setStatus(dto.getStatus());
        return user;
    }

    // Convert Entity → ResponseDTO
    public static PMSUserResponseDTO toResponseDTO(PMSUser user) {
        PMSUserResponseDTO dto = new PMSUserResponseDTO();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setDateJoined(user.getDateJoined());
        dto.setStatus(user.getStatus());
        return dto;
    }
}
