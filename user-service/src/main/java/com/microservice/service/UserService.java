package com.microservice.service;

import com.microservice.dto.UserDTO;
import com.microservice.entities.User;

import java.util.List;

public interface UserService
{
    //save user details
    public UserDTO saveUser(UserDTO userDTO);

    //get all user
    List<UserDTO> allUsers();

    //get single user
    UserDTO getUser(String id);

    //update user
    UserDTO updateUser(String id, UserDTO userDTO);

    //delete user
    void deleteUser(String id);

}
