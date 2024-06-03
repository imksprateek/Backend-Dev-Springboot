package me.ksprateek.mongodemo.service;

import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.product.Photo;
import me.ksprateek.mongodemo.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository repository;

    public String addPhoto(MultipartFile file) throws IOException {
        Photo photo = Photo.builder()
                .image(new Binary(BsonBinarySubType.BINARY, file.getBytes()))
                .build();
        photo = repository.insert(photo);

        return photo.getId();
    }

    public  byte[] getPhoto(String id) {
        return repository.findById(id).get().getImage().getData();
    }
}
