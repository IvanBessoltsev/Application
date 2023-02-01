package com.ivanbessoltsev.exampleapplication.controller;

import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.model.entity.City;
import com.ivanbessoltsev.exampleapplication.model.entity.Contact;
import com.ivanbessoltsev.exampleapplication.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping(Urls.Contact.FULL)
    @Operation(method = "GET", summary = "Получение всех контактов")
    public List<Contact> fidAll() {
        return contactService.findAll();
    }

    @GetMapping(Urls.Contact.Id.FULL)
    @Operation(method = "GET", summary = "Получение контакта по id")
    private Contact findById(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @DeleteMapping(Urls.Contact.Id.FULL)
    @Operation(method = "DELETE", summary = "Удаление контакта по id")
    private void deleteById(@PathVariable Integer id) {
        contactService.delete(id);
    }


}
