package ru.skypro.homework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;

import java.util.Collections;

@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {
    @GetMapping
    public ResponseEntity<AdsDto> getAllAds() {
        AdsDto adsDto = new AdsDto();
        adsDto.setCount(1);
        AdDto adDto = new AdDto();
        adDto.setPk(1);
        adDto.setTitle("Слон");
        adDto.setPrice(1000000);
        adDto.setImage("https://picsum.photos/300/200");
        adsDto.setResults(Collections.singletonList(adDto));
        return ResponseEntity.ok().body(adsDto);
    }

    @PostMapping
    public ResponseEntity<AdDto> addAd(@RequestPart("properties") CreateOrUpdateAdDto dto,
                                       @RequestPart("image") MultipartFile multipartFile) {
        AdDto adDto = new AdDto();
        adDto.setPk(101);
        adDto.setAuthor(1);
        adDto.setTitle(dto.getTitle());
        adDto.setPrice(Integer.parseInt(dto.getPrice()));
        adDto.setImage("https://picsum.photos/300/200");

        return ResponseEntity.status(HttpStatus.CREATED).body(adDto);
    }


}
