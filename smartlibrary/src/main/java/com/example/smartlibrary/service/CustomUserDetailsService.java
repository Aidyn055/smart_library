package com.example.smartlibrary.service;

import com.example.smartlibrary.entity.Reader;
import com.example.smartlibrary.repository.ReaderRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ReaderRepository readerRepository;

    public CustomUserDetailsService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Reader reader = readerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(reader.getEmail())
                .password(reader.getPassword())
                .authorities(reader.getRole().name())
                .build();
    }
}