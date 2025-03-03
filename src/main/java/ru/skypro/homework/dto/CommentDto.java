package ru.skypro.homework.dto;

import lombok.*;

@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CommentDto {
    private int author;
    private String authorImage;
    private String authorFirstName;
    private long createAd;
    private int pk;
    private String text;
}
