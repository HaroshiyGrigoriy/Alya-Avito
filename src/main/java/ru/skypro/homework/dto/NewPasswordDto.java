package ru.skypro.homework.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class NewPasswordDto {
    private String newPassword;
    private String currentPassword;

}
