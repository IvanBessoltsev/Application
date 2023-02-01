package com.ivanbessoltsev.exampleapplication.service;


import com.ivanbessoltsev.exampleapplication.common.CRUD;
import com.ivanbessoltsev.exampleapplication.model.entity.City;
import com.ivanbessoltsev.exampleapplication.repository.TransportRepository;
import com.ivanbessoltsev.exampleapplication.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService implements CRUD<City> {

    private final CityRepository cityRepository;
    private final TransportRepository transportRepository;



    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Integer id) {
        return cityRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }
}
