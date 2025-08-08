package com.SaazApp.remove.Service;

import com.SaazApp.remove.Dto.UserDTO;

public interface UserService {
    
    UserDTO saveUser(UserDTO userDTO);

    UserDTO getUserByClerkId(String clerkId);

    void deleteUserByClerkId(String clerkId);
}
