package org.example.controller;

import org.example.service.ServicePhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("api/photos")
public class RestControllerPhotos {
    @Autowired
    protected ServicePhoto service;

    @PostMapping("/save")
    public ResponseEntity<?> savePhoto(@RequestParam("photo") MultipartFile file) {
        try {
            // Check if the received file is not empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Empty file received");
            }

            // Convert the received file to a byte array
            byte[] fileBytes = file.getBytes();

            // Save the photo to the database using the service
            service.savePhoto(fileBytes);

            // Return a success message or saved photo details
            return ResponseEntity.ok("Photo successfully saved on the backend");
        } catch (IOException e) {
            // Handle IO exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save photo on the backend: " + e.getMessage());
        }
    }

    @GetMapping("/options")
    public ResponseEntity<List<String>> getMultipleImages() {
        try {
            List<String> images = service.getOptions();
            return ResponseEntity.ok(images);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
