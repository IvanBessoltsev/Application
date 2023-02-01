package com.ivanbessoltsev.exampleapplication.controller;

import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.model.entity.City;
import com.ivanbessoltsev.exampleapplication.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping(Urls.City.FULL)
    @Operation(method = "GET", summary = "Получение всех городов")
    private List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping(Urls.City.Id.FULL)
    @Operation(method = "GET", summary = "Получение города по id")
    private City findById(@PathVariable Integer id) {
        return cityService.findById(id);
    }

    @DeleteMapping(Urls.City.Id.FULL)
    @Operation(method = "DELETE", summary = "Удаление города по id")
    private void deleteById(@PathVariable Integer id) {
        cityService.delete(id);
    }

}
