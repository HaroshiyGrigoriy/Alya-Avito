package ru.skypro.homework.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;


class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private PasswordEncoder encoder;
    @InjectMocks
    private AuthServiceImpl authService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void register_IfEmailIsNew() {
    }

    @Test
    void login() {
    }
}