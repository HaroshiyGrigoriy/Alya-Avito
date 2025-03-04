package ru.skypro.homework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {
    @PostMapping("/set_password")
    public ResponseEntity<Void> passwordUpdate(@RequestBody NewPasswordDto newPasswordDto) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getUserInfo() {
        UserDto userDto = new UserDto();
        userDto.setEmail("test@user.com");
        userDto.setPhone("+71234567890");
        userDto.setFirstName("Тест");
        userDto.setLastName("Пользователь");
        userDto.setRole(Role.USER);
        return ResponseEntity.ok(userDto);
    }

    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDto> updateUserInfo(@RequestBody UpdateUserDto userDto) {
        return ResponseEntity.status(200).body(userDto);
    }

    @PatchMapping("/me/image")
    public ResponseEntity<Void> updateUserImage() {
        return ResponseEntity.ok().build();
    }
}
