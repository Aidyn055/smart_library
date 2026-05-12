package com.example.smartlibrary.service;

import com.example.smartlibrary.entity.Reader;
import com.example.smartlibrary.repository.ReaderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthServiceTest {

    @Test
    void register_shouldCreateUser() {

        ReaderRepository readerRepository =
                Mockito.mock(ReaderRepository.class);

        PasswordEncoder passwordEncoder =
                Mockito.mock(PasswordEncoder.class);

        AuthService authService =
                new AuthService(readerRepository, passwordEncoder);

        Mockito.when(readerRepository.findByEmail("test@gmail.com"))
                .thenReturn(Optional.empty());

        Mockito.when(passwordEncoder.encode("123"))
                .thenReturn("encodedPassword");

        authService.register(
                "Aidyn",
                "test@gmail.com",
                "123"
        );

        ArgumentCaptor<Reader> captor =
                ArgumentCaptor.forClass(Reader.class);

        Mockito.verify(readerRepository)
                .save(captor.capture());

        Reader savedReader = captor.getValue();

        assertEquals("Aidyn", savedReader.getFullName());
        assertEquals("test@gmail.com", savedReader.getEmail());
        assertEquals("encodedPassword", savedReader.getPassword());
    }
}