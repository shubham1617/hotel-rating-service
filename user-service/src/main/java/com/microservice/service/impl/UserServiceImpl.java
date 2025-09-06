package com.microservice.service.impl;

import com.microservice.dto.UserDTO;
import com.microservice.entities.User;
import com.microservice.exceptions.ResourceNotFoundException;
import com.microservice.repository.UserRepo;
import com.microservice.service.UserService;
import com.microservice.utils.Mapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }


    @Override
    public UserDTO saveUser(UserDTO userDTO)
    {
        User user = Mapper.toEntity(userDTO);
        user.setId(UUID.randomUUID().toString());
        userRepo.save(user);
        return Mapper.toDto(user);
    }

    @Override
    public List<UserDTO> allUsers()
    {
        List<User> allUser = userRepo.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (User user : allUser)
        {
            UserDTO dto = Mapper.toDto(user);
            result.add(dto);
        }
        return result;
    }

    @Override
    public UserDTO getUser(String id)
    {
        User userById = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found !!" + id));
        UserDTO userDTO = Mapper.toDto(userById);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO)
    {
        User user =userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found !!" + id));
        User updatedUser = Mapper.toEntity(userDTO);
        updatedUser.setId(user.getId());
        User save = userRepo.save(updatedUser);
        UserDTO savedUser = Mapper.toDto(save);
        return savedUser;
    }

    @Override
    public void deleteUser(String id)
    {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found !!" + id));
        userRepo.delete(user);
    }


}
