package ru.skypro.homework.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AdsDto {
    private int count;
    private List<AdDto> results;
}
