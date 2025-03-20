package ru.skypro.homework.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageServiceForAd implements ImageService {
    @Value("${images.root}")
    private String imagesRoot;

    @Override
    public String saveImage(MultipartFile file, int id) throws IOException {
        Path pathDir = Paths.get(imagesRoot, "ads", String.valueOf(id));
        Files.createDirectories(pathDir);

        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isBlank()) {
            fileName = "image";
        }
        return null;
    }
}
