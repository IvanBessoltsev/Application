package com.ivanbessoltsev.exampleapplication.exception;

import com.ivanbessoltsev.exampleapplication.constant.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundCityException extends RuntimeException {

    public NotFoundCityException(Integer id) {
        super(String.format(Errors.City.NOT_FOUND, id));
    }
}
