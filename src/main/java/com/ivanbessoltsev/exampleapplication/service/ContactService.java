package com.ivanbessoltsev.exampleapplication.service;

import com.ivanbessoltsev.exampleapplication.common.CRUD;
import com.ivanbessoltsev.exampleapplication.exception.NotFoundContactException;
import com.ivanbessoltsev.exampleapplication.model.entity.Contact;
import com.ivanbessoltsev.exampleapplication.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService implements CRUD<Contact> {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElseThrow(()-> new NotFoundContactException(id));
    }


    @Override
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }




}

