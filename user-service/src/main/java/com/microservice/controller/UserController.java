package com.microservice.controller;

import com.microservice.dto.UserDTO;
import com.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service/v1/")
public class UserController
{
    @Autowired
    private UserService userService;

    //Create or Save user
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO)
    {
        UserDTO createdUser = userService.saveUser(userDTO);
        return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
    }

    //Get User
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        List<UserDTO> userDTOS = userService.allUsers();
        return  new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    // Get single User
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id)
    {
        UserDTO user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO)
    {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }


}
