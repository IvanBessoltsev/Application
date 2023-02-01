package com.ivanbessoltsev.exampleapplication.repository;


import com.ivanbessoltsev.exampleapplication.model.entity.Transport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransportRepository extends MongoRepository<Transport, String> {

    Optional<Transport> findByModel(String model);

    List<Transport> findByAgeGreaterThan(Integer age);

}
