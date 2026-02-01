package com.codeexample.springbootrestapi.services;

import com.codeexample.springbootrestapi.dto.SignUpDTO;
import com.codeexample.springbootrestapi.dto.UserDTO;
import com.codeexample.springbootrestapi.entities.UserEntity;
import com.codeexample.springbootrestapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    // Injecting UserRepository Bean
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;



    // Use the UserRepository to find the username using the method.
    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    // This method first checks if the user already exists in the database, if not it is created
    public UserDTO signup(SignUpDTO signUpDTO) {
        // Converting The DTO to Entity
        UserEntity userEntity = modelMapper.map(signUpDTO, UserEntity.class);
        // Checking if the User already exists or not by id
        if(userRepository.existsById(userEntity.getId())) {
            throw new BadCredentialsException("User already exists!");
        }
        else{
            // Saving the entity in the database
            userEntity.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
            userRepository.save(userEntity);
            // Returning the DTO
            return modelMapper.map(userEntity, UserDTO.class);
        }
    }
}
