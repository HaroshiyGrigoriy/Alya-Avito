package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.AdService;

import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    private final AdService adService;

    @GetMapping
    public ResponseEntity<AdsDto> getAllAds() {

        return ResponseEntity.ok().body(adService.getAllAds());
    }

    @PostMapping
    public ResponseEntity<AdDto> addAd(@RequestPart("properties") CreateOrUpdateAdDto dto,
                                       @RequestPart("image") MultipartFile multipartFile,
                                       @AuthenticationPrincipal UserDetails details) {


        return ResponseEntity.status(HttpStatus.CREATED).body(adService.createAd(dto, multipartFile, details));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdDto> getAdInfo(@PathVariable int id) {
        return ResponseEntity.ok(adService.getAdById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdDto> updateAd(@PathVariable int id,
                                          @RequestBody CreateOrUpdateAdDto adDto) {
        return ResponseEntity.ok(adService.updateAd(id, adDto));
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

    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDto> createCommentForAd(@PathVariable int id, @RequestBody CommentDto dto) {
        CommentDto comment = new CommentDto();
        dto.setPk(10);
        dto.setAuthor(2);
        dto.setAuthorFirstName("Petr");
        dto.setText(dto.getText());
        dto.setCreateAd(System.currentTimeMillis());
        dto.setAuthorImage("https://example.com/avatar.png");
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/{id}/comments/{commentId}")
    public ResponseEntity<Void> deleteCommentForAd(@PathVariable int adId,
                                                   @PathVariable int commentId) {
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentForAd(@PathVariable int adId,
                                                         @PathVariable int commentId,
                                                         @RequestBody CommentDto dto) {
        CommentDto updated = new CommentDto();
        updated.setPk(commentId);
        updated.setAuthor(2);
        updated.setAuthorFirstName("Petr");
        updated.setAuthorImage("https://example.com/avatar2.png");
        updated.setCreateAd(System.currentTimeMillis());
        updated.setText(dto.getText());
        return ResponseEntity.ok(updated);
    }
}
