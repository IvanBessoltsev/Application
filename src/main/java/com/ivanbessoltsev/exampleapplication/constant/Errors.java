package com.ivanbessoltsev.exampleapplication.constant;

public interface Errors {

    interface User {
        String NOT_FOUND = "Пользователь с id %s не существует";
    }

    interface Contact {
        String NOT_FOUND = "Контакт с id %s не существует";
    }
}
