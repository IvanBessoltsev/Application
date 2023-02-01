package com.ivanbessoltsev.exampleapplication.service;

import com.ivanbessoltsev.exampleapplication.model.entity.User;
import com.ivanbessoltsev.exampleapplication.model.entity.Photo;
import com.ivanbessoltsev.exampleapplication.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService {

    @Value("${uploadFolder}")
    private String uploadFolder;
    private final PhotoRepository photoRepository;
    private final UserService userService;


    @Transactional
    public HttpStatus createPhotoById(Integer id, MultipartFile file) throws IOException {
        String fileName = getFileName(file);
        User user = userService.findById(id);

        saveUploadedFiles(file, fileName);

        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setUser(user);
        photoRepository.save(photo);

        return HttpStatus.OK;
    }

    public byte[] getPhotoById(Integer id) throws IOException {
        Photo photo = photoRepository.findById(id).orElseThrow();
        File file = new File(uploadFolder + photo.getFileName());
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = fis.readAllBytes();
        return bytes;

    }

    private void saveUploadedFiles(MultipartFile file, String fileName) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        File outputFile = new File(uploadFolder + fileName);
        ImageIO.write(bufferedImage, "jpg", outputFile);
    }

    private String getFileName(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "." + file.getOriginalFilename();
        return fileName;
    }

    @Transactional
    public HttpStatus deletePhotoById(Integer id) {
        photoRepository.deleteById(id);
        return HttpStatus.OK;
    }
}



