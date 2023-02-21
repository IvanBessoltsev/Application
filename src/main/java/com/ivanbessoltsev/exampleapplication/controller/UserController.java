package com.ivanbessoltsev.exampleapplication.controller;

import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.filter.RequestFilterDTO;
import com.ivanbessoltsev.exampleapplication.model.dto.user.CreateUserDTO;
import com.ivanbessoltsev.exampleapplication.model.entity.User;
import com.ivanbessoltsev.exampleapplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @GetMapping(Urls.User.Id.FULL)
    @Operation(method = "GET", summary = "Получение работника по id")
    private User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping(Urls.User.Id.FULL)
    @Operation(method = "GET", summary = "Получение работника по id")
    private void deleteById(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PostMapping(Urls.User.FULL)
    @Operation(method = "POST", summary = "Создание нового работника")
    private CreateUserDTO createEmployee(CreateUserDTO createUserDTO) {
        return userService.create(createUserDTO);
    }

    @GetMapping(Urls.User.FULL)
    @Operation(method = "GET", summary = "Получение всех работников c фильтрацией")
    private List<User> findAllByFilter(RequestFilterDTO requestFilterDTO) {
        return userService.findAllByFilter(requestFilterDTO);
    }

    @GetMapping(Urls.User.All.FULL)
    @Operation(method = "GET", summary = "Получение всех работников")
    private List<User> findAllUsers() {
        return userService.findAllUsers();
    }

}
