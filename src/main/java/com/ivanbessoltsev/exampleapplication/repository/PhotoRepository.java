package com.ivanbessoltsev.exampleapplication.repository;

import com.ivanbessoltsev.exampleapplication.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findPhotosByUserId(Integer id);
}
