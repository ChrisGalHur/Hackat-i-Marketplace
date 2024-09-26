package org.example.service;

import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.exception.InvalidPasswordException;
import org.example.exception.UserAlreadyExistsException;
import org.example.exception.UserNotFound;
import org.example.exception.UserServiceException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.security.JwtTokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        try {
            // Check if the user already exists
            if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("User with email " + userDTO.getEmail() + " already exists");
            }

            // convertir UserDTO a User utilizando librería ModelMapper
            User user = modelMapper.map(userDTO, User.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user = userRepository.save(user);

            return modelMapper.map(user, UserDTO.class);
        } catch (Exception e) {
            throw new UserServiceException("Error registering user: "+ e.getMessage());
        }
    }

    @Override
    public String login(LoginDTO loginDTO) {
        try{
            User user = userRepository.findByEmail(loginDTO.getEmail())
                    .orElseThrow(() -> new UserNotFound("User with email " + loginDTO.getEmail() + " not found"));

            if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
                throw new InvalidPasswordException("Invalid password");
            }
        }catch (Exception e){
            throw new UserServiceException("Error logging in: "+ e.getMessage());
        }
        return tokenProvider.generateToken(loginDTO.getEmail());
    }
}
