package ru.skypro.homework.dto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CreateOrUpdateAdDto {
    private String title;
    private String price;
    private String description;
}
