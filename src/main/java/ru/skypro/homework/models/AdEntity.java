package ru.skypro.homework.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class AdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private int price;
    private String image;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    @OneToMany
    private List<CommentEntity> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdEntity adEntity = (AdEntity) o;
        return id == adEntity.id
                && price == adEntity.price
                && Objects.equals(title, adEntity.title)
                && Objects.equals(description, adEntity.description)
                && Objects.equals(image, adEntity.image)
                && Objects.equals(author, adEntity.author)
                && Objects.equals(comments, adEntity.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, image, author, comments);
    }
}
