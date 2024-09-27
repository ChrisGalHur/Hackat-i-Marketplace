package org.example.service;

import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.User;

import java.util.Map;

public interface IUserService {

    Map<String, Object> registerUser(UserDTO userDTO);

    Map<String, Object> login(LoginDTO loginDTO);

    Map<String, Object> updateUser(String id, UserDTO userDTO);

    Map<String,Object> createResponse(String message, User user);

    Map<String, Object> getUser(String id);
}
