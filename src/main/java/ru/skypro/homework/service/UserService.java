package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

public interface UserService {
    void updatePassword(NewPasswordDto dto, Authentication authentication);

    UserDto getUser(Authentication authentication);

    UpdateUserDto updateUser(UpdateUserDto dto, Authentication authentication);
}

