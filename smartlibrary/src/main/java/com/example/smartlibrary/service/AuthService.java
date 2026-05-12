package com.example.smartlibrary.service;

import com.example.smartlibrary.entity.Reader;
import com.example.smartlibrary.entity.Role;
import com.example.smartlibrary.repository.ReaderRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final ReaderRepository readerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(ReaderRepository readerRepository,
                       PasswordEncoder passwordEncoder) {
        this.readerRepository = readerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(String fullName, String email, String password) {
        if (readerRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Reader reader = new Reader();
        reader.setFullName(fullName);
        reader.setEmail(email);
        reader.setPassword(passwordEncoder.encode(password));
        reader.setRole(Role.USER);

        readerRepository.save(reader);
    }
}