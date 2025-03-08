package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.models.AdEntity;

import java.util.List;

public interface AdService {
    AdsDto getAllAds();

    AdDto createAd(AdEntity ad);
}
