package com.ivanbessoltsev.exampleapplication.model.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Data
@Document(value = "transport")
public class Transport {
    private String id;
    private String maker;
    private String model;
    private Integer age;
    private String color;
    private Integer countWheels;
}
