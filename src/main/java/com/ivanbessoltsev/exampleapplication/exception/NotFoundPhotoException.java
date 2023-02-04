package com.ivanbessoltsev.exampleapplication.exception;

import com.ivanbessoltsev.exampleapplication.constant.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundPhotoException extends RuntimeException {

    public NotFoundPhotoException(Integer id) {
        super(String.format(Errors.Photo.NOT_FOUND, id));
    }
}
