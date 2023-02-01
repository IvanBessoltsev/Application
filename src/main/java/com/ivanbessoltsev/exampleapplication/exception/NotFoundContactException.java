package com.ivanbessoltsev.exampleapplication.exception;

import com.ivanbessoltsev.exampleapplication.constant.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundContactException extends RuntimeException {

    public NotFoundContactException(Integer id) {
        super(String.format(Errors.Contact.NOT_FOUND, id));
    }

}
