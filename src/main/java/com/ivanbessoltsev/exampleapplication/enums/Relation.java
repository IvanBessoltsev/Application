package com.ivanbessoltsev.exampleapplication.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Relation {
    WIFE("Жена"),
    HUSBAND("Муж"),
    SON("Сын"),
    DAUGHTER("Дочь");

   String relation;
}
