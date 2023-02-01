package com.ivanbessoltsev.exampleapplication.repository;

import com.ivanbessoltsev.exampleapplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {

}
