package com.ivanbessoltsev.exampleapplication.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_seq")
    @SequenceGenerator(name = "city_id_seq", sequenceName = "city_id_seq", allocationSize = 1)
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Contact> contacts;
}
