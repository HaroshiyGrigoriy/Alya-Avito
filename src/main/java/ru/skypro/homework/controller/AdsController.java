package ru.skypro.homework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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

    @GetMapping("/{id}")
    public ResponseEntity<AdDto> getAdInfo(@PathVariable int id) {
        AdDto adDto = new AdDto();
        adDto.setPk(101);
        adDto.setAuthor(1);
        adDto.setTitle(adDto.getTitle());
        adDto.setPrice(adDto.getPrice());
        adDto.setImage("https://picsum.photos/300/200");
        return ResponseEntity.ok(adDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CreateOrUpdateAdDto> updateAd(@PathVariable int id,
                                                        @RequestBody CreateOrUpdateAdDto adDto) {
        AdDto updateAd = new AdDto();
        updateAd.setPk(id);
        updateAd.setAuthor(1);
        updateAd.setTitle(adDto.getTitle());
        updateAd.setPrice(Integer.parseInt(adDto.getPrice()));
        updateAd.setImage("https://example.com/ad_image.png");
        return ResponseEntity.ok(adDto);
    }

    @GetMapping("/me")
    public ResponseEntity<AdsDto> getMyAds() {
        AdsDto ads = new AdsDto();
        ads.setCount(2);

        AdDto ad1 = new AdDto();
        ad1.setPk(1);
        ad1.setAuthor(999); // Текущий пользователь
        ad1.setTitle("Моё объявление 1");
        ad1.setPrice(1234);
        ad1.setImage("https://example.com/ad1.png");

        AdDto ad2 = new AdDto();
        ad2.setPk(2);
        ad2.setAuthor(999);
        ad2.setTitle("Моё объявление 2");
        ad2.setPrice(9999);
        ad2.setImage("https://example.com/ad2.png");

        ads.setResults(Arrays.asList(ad1, ad2));
        return ResponseEntity.ok(ads);
    }

    @PatchMapping("/{id}/image")
    public ResponseEntity<byte[]> updateImage(@PathVariable int id,
                                              @RequestPart MultipartFile image) {
        byte[] bytes = {1, 2, 3, 4, 5};
        return ResponseEntity.ok(bytes);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDto> getCommentsAd(@PathVariable int id) {
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setCount(1);
        CommentDto dto = new CommentDto();
        dto.setPk(10);
        dto.setAuthor(2);
        dto.setAuthorFirstName("Petr");
        dto.setText("Красавчик");
        dto.setCreateAd(System.currentTimeMillis());
        dto.setAuthorImage("https://example.com/avatar.png");

        commentsDto.setResults(Collections.singletonList(dto));
        return ResponseEntity.ok(commentsDto);
    }

}
