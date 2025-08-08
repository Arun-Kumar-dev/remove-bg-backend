package com.SaazApp.remove.Service.Impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SaazApp.remove.Dto.UserDTO;
import com.SaazApp.remove.Entity.UserEntity;
import com.SaazApp.remove.Service.UserService;
import com.SaazApp.remove.repository.UserRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
          Optional<UserEntity>optionalUser= userRepository.findByClerkId(userDTO.getClerkId());
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setPhotoUrl(userDTO.getPhotoUrl());
            if (userDTO.getCredits() != null) {
                existingUser.setCredits(userDTO.getCredits());
            }
            existingUser = userRepository.save(existingUser);
            return mapToDTO(existingUser);
        }
        UserEntity newUser = mapToEntity(userDTO);
        userRepository.save(newUser);
        return mapToDTO(newUser);
    }

     @Override
    public UserDTO getUserByClerkId(String clerkId) {
       UserEntity usereEntity = userRepository.findByClerkId(clerkId)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return mapToDTO(usereEntity);
    }

     @Override
    public void deleteUserByClerkId(String clerkId) {
        UserEntity userEntity = userRepository.findByClerkId(clerkId)
                 .orElseThrow(() -> new UsernameNotFoundException("User not fount"));
        userRepository.delete(userEntity);
    }

    private UserDTO mapToDTO(UserEntity newUser) {
       return UserDTO.builder()
                     .clerkId(newUser.getClerkId())
                     .credits(newUser.getCredits())
                     .email(newUser.getEmail())
                     .firstName(newUser.getFirstName())
                     .lastName(newUser.getLastName())
                     .build();
    }

    private UserEntity mapToEntity(UserDTO userDTO) {
       return  UserEntity.builder()
                  .clerkId(userDTO.getClerkId())
                  .email(userDTO.getEmail())
                  .firstName(userDTO.getFirstName())
                  .lastName(userDTO.getLastName())
                  .photoUrl(userDTO.getPhotoUrl())
                  .build();
    }
}
