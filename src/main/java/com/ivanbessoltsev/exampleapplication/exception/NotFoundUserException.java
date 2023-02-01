package com.ivanbessoltsev.exampleapplication.exception;

import com.ivanbessoltsev.exampleapplication.constant.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(Integer id) {
        super(String.format(Errors.User.NOT_FOUND, id));
    }
}
