package com.example.APIJeuxOlympiques.user;

import com.example.APIJeuxOlympiques.security.config.AuthService;
import com.example.APIJeuxOlympiques.security.config.JwtService;
import com.example.APIJeuxOlympiques.user.register.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


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


    public ResponseEntity<String> signUp(User user){
        if(userRepo.findByEmail(user.getEmail()).isEmpty()){
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepo.save(user);
        }
        else{
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        User createdUser = userRepo.findByEmail(user.getEmail()).get();
        String token = jwtService.generateToken(user);
        return new ResponseEntity<>("User created, token : "+token, HttpStatus.CREATED);
    }

    public ResponseEntity<String> login(LoginDto loginDto){
        User authenticatedUser = authenticationService.authenticate(loginDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }
}
