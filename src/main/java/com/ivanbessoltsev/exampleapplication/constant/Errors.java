package com.ivanbessoltsev.exampleapplication.constant;

public interface Errors {

    interface User {
        String NOT_FOUND = "Пользователь с ID %s не существует";
    }

    interface Contact {
        String NOT_FOUND = "Контакт с ID %s не существует";
    }

    interface City {
        String NOT_FOUND = "Город с ID %s не существует";
    }

    interface Department {
        String NOT_FOUND = "Отдел с ID %s не существует";
    }

    interface FamilyMember {
        String NOT_FOUND = "Член семьи с ID %s не существует";
    }

    interface Photo {
        String NOT_FOUND = "Фото с ID %s не существует";
    }

    interface Transport {
        String NOT_FOUND = "Транспорт семьи с ID %s не существует";
    }


}
