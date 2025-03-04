package ru.skypro.homework.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CreateOrUpdateAdDto {
    private String title;
    private String price;
    private String description;
}
