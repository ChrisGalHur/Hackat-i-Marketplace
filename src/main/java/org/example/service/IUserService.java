package org.example.service;

import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.User;

public interface IUserService {

    UserDTO registerUser(UserDTO userDTO);

    String login(LoginDTO loginDTO);
}
