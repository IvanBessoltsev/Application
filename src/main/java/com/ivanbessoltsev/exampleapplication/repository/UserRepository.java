package com.ivanbessoltsev.exampleapplication.repository;

import com.ivanbessoltsev.exampleapplication.model.entity.User;
import com.ivanbessoltsev.exampleapplication.projection.NameAndCount;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {

    //    @EntityGraph(attributePaths = "User.department")
    @Query(value = "SELECT COUNT(login) AS COUNT, d.name AS NAME " +
                   "FROM user_local u inner join department d ON d.id = u.department_id " +
                   "group by d.name", nativeQuery = true)
    List<NameAndCount> countUsersByDepartment();

    @Query(value = "SELECT COUNT(u.id) AS COUNT, c2.name AS NAME FROM user_local u " +
            "inner join contact c on u.id = c.user_id " +
            "inner join city c2 on c2.id = c.city_id " +
            "group by c2.name", nativeQuery = true)
    List<NameAndCount> countUsersByCity();


}
