package com.ivanbessoltsev.exampleapplication.controller;


import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.service.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping(value = Urls.Photo.Id.FULL, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(method = "POST", summary = "Добавление фото пользователю")
    private HttpStatus createNewPhoto(@PathVariable Integer id, @RequestParam MultipartFile file) throws IOException {
        return photoService.createPhotoById(id, file);
    }

    @GetMapping(value = Urls.Photo.Id.FULL, produces = MediaType.IMAGE_JPEG_VALUE)
    @Operation(method = "GET", summary = "Получение фото по id")
    private byte[] getPhoto(@PathVariable Integer id) throws IOException {
        return photoService.getPhotoById(id);
    }

    @DeleteMapping(value = Urls.Photo.Id.FULL)
    @Operation(method = "DELETE", summary = "Удаление фото по ID")
    private HttpStatus deletePhotoById(Integer id) {
        photoService.deletePhotoById(id);
        return HttpStatus.OK;
    }

//    @PutMapping
//    @Operation(method = "PUT", summary = "Удаление фото по ID")
//    private HttpStatus updatePhotoById() {
//
//    }

}
