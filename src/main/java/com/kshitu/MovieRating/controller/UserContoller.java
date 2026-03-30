package com.kshitu.MovieRating.controller;

import com.kshitu.MovieRating.dto.UserRequestDTO;
import com.kshitu.MovieRating.dto.UserResponseDTO;
import com.kshitu.MovieRating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserContoller {

    @Autowired
    UserService service;

    @PostMapping
    public UserResponseDTO addUser(@RequestBody UserRequestDTO json)
    {
        return service.addUser(json.name());
    }

    @GetMapping
    public List<UserResponseDTO> getAllUser()
    {
        return service.getAllUser();
    }

    @GetMapping("/{user_id}")
    public UserResponseDTO getUserById(@PathVariable("user_id") Long id)
    {
        return service.getUserById(id);
    }

    @PutMapping("/{user_id}")
    public UserResponseDTO updateUser(@PathVariable("user_id") Long id, @RequestBody UserRequestDTO json)
    {
        return service.updateUser(id,json);
    }

    @DeleteMapping("/{user_id}")
    public UserResponseDTO deleteUser(@PathVariable("user_id") Long id)
    {
        return service.deleteUser(id);
    }
}
