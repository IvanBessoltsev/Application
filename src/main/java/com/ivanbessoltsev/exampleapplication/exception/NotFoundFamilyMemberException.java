package com.ivanbessoltsev.exampleapplication.exception;

import com.ivanbessoltsev.exampleapplication.constant.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundFamilyMemberException extends RuntimeException {

    public NotFoundFamilyMemberException(Integer id) {
        super(String.format(Errors.FamilyMember.NOT_FOUND, id));
    }
}
