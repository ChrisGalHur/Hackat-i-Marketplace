package org.example.service;

import lombok.extern.slf4j.Slf4j;
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

import java.util.HashMap;
import java.util.Map;

@Slf4j
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
    public Map<String, Object> registerUser(UserDTO userDTO) {
        try {
            // Check if the user already exists in the database
            if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("User with email " + userDTO.getEmail() + " already exists");
            }

            // Convert UserDTO to User using ModelMapper
            User user = modelMapper.map(userDTO, User.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user = userRepository.save(user);

            return createResponse("User registered successfully", user);
        } catch (UserAlreadyExistsException e) {
            log.error("User already exists: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error registering user: {}", e.getMessage());
            throw new UserServiceException("Error registering user: "+ e.getMessage());
        }
    }

    @Override
    public Map<String, Object> login(LoginDTO loginDTO) {
        try{
            User user = userRepository.findByEmail(loginDTO.getEmail())
                    .orElseThrow(() -> new UserNotFound("User with email " + loginDTO.getEmail() + " not found"));

            if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
                throw new InvalidPasswordException("Invalid password");
            }

            return createResponse("User logged in successfully", user);
        }catch (UserNotFound | InvalidPasswordException e){
            log.error("Login error: {}", e.getMessage());
            throw e;
        }catch (Exception e){
            log.error("Error logging in: {}", e.getMessage());
            throw new UserServiceException("Error logging in: "+ e.getMessage());
        }
    }

    @Override
    public Map<String, Object> updateUser(String id, UserDTO userDTO) {
        try{
            userDTO.validateAge(userDTO.getAge());

            //Search the user by id
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFound("User with id " + id + " not found"));

            //Update the user
            user.setName(userDTO.getName());
            user.setSecondName(userDTO.getSecondName());
            user.setEmail(userDTO.getEmail());
            user.setAge(userDTO.getAge());

            //Only update the password if it is not null
            if(userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()){
                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }

            //Save the user
            user = userRepository.save(user);

            return  createResponse("User updated successfully", user);
        }catch (UserNotFound e){
            log.error("Error updating user: {}", e.getMessage());
            throw e;
        }catch (Exception e){
            log.error("Error updating user: {}", e.getMessage());
            throw new UserServiceException("Error updating user: "+ e.getMessage());
        }
    }

    @Override
    public Map<String, Object> getUser(String id) {
        try{
            //Search the user by id
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFound("User with id " + id + " not found"));

            return createResponse("User found", user);
        }catch (UserNotFound e){
            log.error("Error getting user: {}", e.getMessage());
            throw e;
        }catch (Exception e){
            log.error("Error getting user: {}", e.getMessage());
            throw new UserServiceException("Error getting user: "+ e.getMessage());
        }
    }

    @Override
    public Map<String,Object> createResponse(String message, User user){
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("token", tokenProvider.generateToken(user.getEmail()));
        response.put("user", Map.of(
                "id", user.getId(),
                "name", user.getName(),
                "secondName", user.getSecondName(),
                "email", user.getEmail()
        ));
        return response;
    }
}
