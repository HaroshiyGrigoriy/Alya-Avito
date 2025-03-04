package ru.skypro.homework.dto;

import lombok.*;
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class UpdateUserDto {
    private String firstName;
    private String lastName;
    private String phone;
}
