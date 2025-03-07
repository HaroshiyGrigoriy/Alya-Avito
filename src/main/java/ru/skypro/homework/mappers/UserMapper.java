package ru.skypro.homework.mappers;

import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.models.UserEntity;

public class UserMapper {
    public void toUserEntity(RegisterDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setRole(userDto.getRole());

    }
}
