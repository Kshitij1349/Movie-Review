package com.kshitu.MovieRating.service;

import com.kshitu.MovieRating.repository.UserRepo;
import com.kshitu.MovieRating.dto.UserRequestDTO;
import com.kshitu.MovieRating.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kshitu.MovieRating.model.user;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public UserResponseDTO addUser(String name) {
        user u=new user();
        u.setName(name);
        user saved=repo.save(u);

        return new UserResponseDTO(
                saved.getId(),
                saved.getName()
        );

    }

    public List<UserResponseDTO> getAllUser() {
        List<user> u=repo.findAll();

        List<UserResponseDTO> DTO=new ArrayList<>();

        for(user user: u)
        {
            UserResponseDTO obj=new UserResponseDTO(
                    user.getId(),
                    user.getName()
            );
            DTO.add(obj);
        }

        return DTO;
    }


    public UserResponseDTO getUserById(Long id) {
        user u=repo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));

        return new UserResponseDTO(
                u.getId(),
                u.getName()
        );
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO json) {
        user u=repo.findById(id).orElseThrow(()-> new RuntimeException("User not found for updating"));
        u.setName(json.name());

        repo.save(u);

        return new UserResponseDTO(
                u.getId(),
                u.getName()
        );
    }

    public UserResponseDTO deleteUser(Long id) {
        user u=repo.findById(id).orElseThrow(()-> new RuntimeException("Movie not found for deleting it"));
        repo.deleteById(id);

        return new UserResponseDTO(
                u.getId(),
                u.getName()
        );
    }
}
