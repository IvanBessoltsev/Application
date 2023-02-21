package com.ivanbessoltsev.exampleapplication.service;

import com.ivan.bessoltsev.service.DemoService;
import com.ivanbessoltsev.exampleapplication.exception.NotFoundUserException;
import com.ivanbessoltsev.exampleapplication.filter.RequestFilterDTO;
import com.ivanbessoltsev.exampleapplication.mapping.UserMapper;
import com.ivanbessoltsev.exampleapplication.model.dto.user.CreateUserDTO;
import com.ivanbessoltsev.exampleapplication.model.entity.User;
import com.ivanbessoltsev.exampleapplication.model.entity.User_;
import com.ivanbessoltsev.exampleapplication.predicate.BuildPredicateByFilter;
import com.ivanbessoltsev.exampleapplication.predicate.QPredicates;
import com.ivanbessoltsev.exampleapplication.projection.NameAndCount;
import com.ivanbessoltsev.exampleapplication.repository.UserRepository;
import com.querydsl.core.types.Predicate;
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
    private final BuildPredicateByFilter buildPredicateByFilter;


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
        Predicate predicate = buildPredicateByFilter.buildPredicate(requestFilterDTO);
        Sort sort = Sort.by(User_.LAST_NAME).ascending().and(Sort.by(User_.FIRST_NAME)).ascending();
        return (List<User>) userRepository.findAll(predicate, sort);
    }

    public List<NameAndCount> getInfoUsersByDepartment() {
        return userRepository.countUsersByDepartment();
    }

    public List<NameAndCount> getInfoCountUsersByCity() {
        return userRepository.countUsersByCity();
    }

    public List<NameAndCount> countChildrenByUser() {
        return userRepository.countChildrenByUser();
    }
}
