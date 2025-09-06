package com.microservice.utils;

import com.microservice.dto.UserDTO;
import com.microservice.entities.User;
import lombok.Builder;


public class Mapper {

    public static UserDTO toDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .dob(user.getDob())
                .about(user.getAbout())
                .build();
    }

    public static User toEntity(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .dob(userDTO.getDob())
                .about(userDTO.getAbout())
                .build();
    }
}
