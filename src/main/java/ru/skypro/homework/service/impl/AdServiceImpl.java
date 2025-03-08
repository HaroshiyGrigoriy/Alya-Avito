package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.mappers.AdMapper;
import ru.skypro.homework.models.AdEntity;
import ru.skypro.homework.repositories.AdRepository;
import ru.skypro.homework.service.AdService;
@Service
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {
    private final AdMapper adMapper;
    private final AdRepository repository;

    @Override
    public AdsDto getAllAds() {
        return adMapper.adsDto(repository.findAll());
    }

    @Override
    public AdDto createAd(AdEntity ad) {

        return ;
    }
}
