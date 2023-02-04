package com.ivanbessoltsev.exampleapplication.exception;

import com.ivanbessoltsev.exampleapplication.constant.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundDepartmentException extends RuntimeException {

    public NotFoundDepartmentException(Integer id) {
        super(String.format(Errors.Department.NOT_FOUND, id));
    }
}

