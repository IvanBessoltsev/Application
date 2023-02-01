package com.ivanbessoltsev.exampleapplication.service;

import com.ivanbessoltsev.exampleapplication.model.entity.Transport;
import com.ivanbessoltsev.exampleapplication.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TransportService {

    private final TransportRepository transportRepository;

    public Transport findByModel(String model) {
        return transportRepository.findByModel(model).orElseThrow(() -> new RuntimeException());
    }

    public List<Transport> findAll() {
        return transportRepository.findAll();
    }

    public List<Transport> findGreaterThan(Integer age) {
        return transportRepository.findByAgeGreaterThan(age);
    }

    public Transport create() {
        Transport t = new Transport();
//        t.setMaker();
//        t.setModel();
//        t.setAge();
//        t.setColor();
//        t.setCountWheels();
        transportRepository.save(t);
        return t;
    }
}
