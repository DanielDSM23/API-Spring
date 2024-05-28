package com.example.APIJeuxOlympiques.service;

import com.example.APIJeuxOlympiques.model.User;
import com.example.APIJeuxOlympiques.repository.UserRepository;
import com.example.APIJeuxOlympiques.response.RegisterResponse;
import com.example.APIJeuxOlympiques.response.SignInResponse;
import com.example.APIJeuxOlympiques.security.config.AuthService;
import com.example.APIJeuxOlympiques.security.config.JwtService;
import com.example.APIJeuxOlympiques.dto.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final AuthService authenticationService;
    private final UserRepository userRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepo.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Email not found"));
    }


    public ResponseEntity<RegisterResponse> signUp(User user){
        if(userRepo.findByEmail(user.getEmail()).isEmpty()){
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepo.save(user);
        }
        else{
            return new ResponseEntity<RegisterResponse>(new RegisterResponse(null, "Email used by another account"), HttpStatus.CONFLICT);
        }
        User createdUser = userRepo.findByEmail(user.getEmail()).get();
        String token = jwtService.generateToken(user);
        return new ResponseEntity<RegisterResponse>(new RegisterResponse(token, "User created with success"), HttpStatus.CREATED);
    }

    public ResponseEntity<SignInResponse> login(LoginDto loginDto){
        User authenticatedUser = authenticationService.authenticate(loginDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        return new ResponseEntity<SignInResponse>(new SignInResponse(jwtToken), HttpStatus.OK);
    }
}
