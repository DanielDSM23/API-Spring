package com.example.APIJeuxOlympiques.security.config;

import com.example.APIJeuxOlympiques.user.User;
import com.example.APIJeuxOlympiques.user.UserRepository;
import com.example.APIJeuxOlympiques.user.UserRole;
import com.example.APIJeuxOlympiques.user.register.LoginDto;
import com.example.APIJeuxOlympiques.user.register.RegistrationRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegistrationRequest input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setUserRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getMail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getMail())
                .orElseThrow();
    }
}
