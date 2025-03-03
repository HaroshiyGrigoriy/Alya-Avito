package ru.skypro.homework.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@RequiredArgsConstructor
@Setter
@Getter
public class CreateOrUpdateDto {
    private String text;
}
