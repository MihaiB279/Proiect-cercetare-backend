package org.example.service;

import org.example.model.Photo;
import org.example.repository.RepositoryPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class ServicePhotoImpl implements ServicePhoto {
    @Autowired
    protected RepositoryPhoto repositoryPhoto;

    public void savePhoto(byte[] fileBytes) {
        Photo photo = new Photo();
        photo.setPhotoData(fileBytes);
        repositoryPhoto.save(photo);
    }

    public List<String> getOptions() throws IOException {
        List<String> imagesBase64 = new ArrayList<>();
        List<String> imageNames = Arrays.asList("leaf1.jpg", "leaf2.jpg", "leaf3.jpg");

        for (String imageName : imageNames) {
            String imageDirectory = "C:\\Users\\MihaiBucur\\Desktop\\Facultate anul 3\\PC\\Labs\\lab5_8\\demo-back\\leaves";
            Path imagePath = Paths.get(imageDirectory, imageName);
            byte[] imageBytes = Files.readAllBytes(imagePath);
            String base64Encoded = Base64.getEncoder().encodeToString(imageBytes);
            imagesBase64.add(base64Encoded);
        }
        return imagesBase64;
    }

}
