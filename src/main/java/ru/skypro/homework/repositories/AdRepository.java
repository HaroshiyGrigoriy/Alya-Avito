package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.models.AdEntity;

@Repository
public interface AdRepository extends JpaRepository<AdEntity, Integer> {
}
