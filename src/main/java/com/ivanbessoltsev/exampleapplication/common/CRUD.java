package com.ivanbessoltsev.exampleapplication.common;

import java.util.List;

public interface CRUD <T> {

    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);

}
