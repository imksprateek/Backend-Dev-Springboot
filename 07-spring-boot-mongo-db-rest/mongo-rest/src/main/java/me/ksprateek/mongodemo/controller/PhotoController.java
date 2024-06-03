package me.ksprateek.mongodemo.controller;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.product.Photo;
import me.ksprateek.mongodemo.service.PhotoService;
import org.bson.types.Binary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/photos")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService service;

    @PostMapping("/add")
    public String addPhoto(@RequestParam(value = "photo") MultipartFile file) throws IOException {
        String id = service.addPhoto(file);
        return id;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPhoto(@PathVariable String id) {
        byte[] imageData = service.getPhoto(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
