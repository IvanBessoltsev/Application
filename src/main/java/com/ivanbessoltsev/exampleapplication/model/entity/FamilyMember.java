package com.ivanbessoltsev.exampleapplication.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ivanbessoltsev.exampleapplication.enums.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "users")
@Table(name = "family_member")
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "family_member_id_seq")
    @SequenceGenerator(name = "family_member_id_seq", sequenceName = "family_member_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "relation", nullable = false)
    @Enumerated(EnumType.STRING)
    private Relation relation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
