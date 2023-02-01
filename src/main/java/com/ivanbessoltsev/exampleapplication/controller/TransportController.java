package com.ivanbessoltsev.exampleapplication.controller;

import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.model.entity.Transport;
import com.ivanbessoltsev.exampleapplication.service.TransportService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransportController {

    private final TransportService transportService;

    @Operation(method = "GET", summary = "Получение всего транспорта")
    @GetMapping(Urls.Transport.FULL)
    private List<Transport> findAll() {
        return transportService.findAll();
    }

    @Operation(method = "GET", summary = "Получение по возрасту больше")
    @GetMapping(Urls.Transport.Age.FULL)
    private List<Transport> findGreaterThen(@PathVariable Integer age) {
        return transportService.findGreaterThan(age);
    }




}
