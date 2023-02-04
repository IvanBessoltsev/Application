package com.ivanbessoltsev.exampleapplication.service;

import com.ivanbessoltsev.exampleapplication.exception.NotFoundUserException;
import com.ivanbessoltsev.exampleapplication.filter.RequestFilterDTO;
import com.ivanbessoltsev.exampleapplication.mapping.UserMapper;
import com.ivanbessoltsev.exampleapplication.model.dto.user.CreateUserDTO;
import com.ivanbessoltsev.exampleapplication.model.entity.User;
import com.ivanbessoltsev.exampleapplication.model.entity.User_;
import com.ivanbessoltsev.exampleapplication.predicate.BuildPredicatesByFilter;
import com.ivanbessoltsev.exampleapplication.projection.NameAndCount;
import com.ivanbessoltsev.exampleapplication.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final BuildPredicatesByFilter buildPredicatesByFilter;


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundUserException(id));
    }

    @Transactional
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public CreateUserDTO create(CreateUserDTO createUserDTO) {
        User user = userMapper.toUser(createUserDTO);
        userRepository.save(user);
        return createUserDTO;
    }

    public List<User> findAllByFilter(RequestFilterDTO requestFilterDTO) {
        BooleanExpression predicate = buildPredicatesByFilter.buildPredicates(requestFilterDTO);
        Sort sort = Sort.by(User_.LAST_NAME).ascending().and(Sort.by(User_.FIRST_NAME)).ascending();
        return (List<User>) userRepository.findAll(predicate, sort);
    }

    public List<NameAndCount> getInfoUsersByDepartment(){
        return userRepository.countUsersByDepartment();
    }

    public List<NameAndCount> getInfoCountUsersByCity() {
        return userRepository.countUsersByCity();
    }
}
