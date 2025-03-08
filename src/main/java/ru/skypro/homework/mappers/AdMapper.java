package ru.skypro.homework.mappers;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.models.AdEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdMapper {
    public AdDto toAdDto(AdEntity ad) {
        AdDto  dto= new AdDto();
        dto.setPk(ad.getId());
        dto.setTitle(ad.getTitle());
        dto.setPrice(ad.getPrice());
        dto.setImage(ad.getImage());
        dto.setAuthor(ad.getAuthor().getId());
        return dto;
    }

    public AdsDto adsDto(List<AdEntity> adEntities) {
        AdsDto dto = new AdsDto();
        dto.setCount(adEntities.size());
        List<AdDto> list = new ArrayList<>();
        for (AdEntity adEntity : adEntities) {
            AdDto adDto = toAdDto(adEntity);
            list.add(adDto);
        }
        dto.setResults(list);
        return dto;
    }
}
