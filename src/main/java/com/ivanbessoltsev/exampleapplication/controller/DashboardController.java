package com.ivanbessoltsev.exampleapplication.controller;

import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.model.dto.dashboard.AllInfo;
import com.ivanbessoltsev.exampleapplication.projection.NameAndCount;
import com.ivanbessoltsev.exampleapplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DashboardController {

    private final UserService userService;

    @GetMapping(Urls.Dashboard.CountUsersByDepartment.FULL)
    @Operation(method = "GET", summary = "Получение количества работников по отделам")
    private List<NameAndCount> getInfoCountUsersByDepartment() {
        return userService.getInfoUsersByDepartment();
    }

    @GetMapping(Urls.Dashboard.CountUsersByCity.FULL)
    @Operation(method = "GET", summary = "Получение количества работников по городам")
    private List<NameAndCount> getInfoCountUsersByCity() {
        return userService.getInfoCountUsersByCity();
    }

    @GetMapping(Urls.Dashboard.CountChildrenByUser.FULL)
    @Operation(method = "GET", summary = "Получение количества детей у работника")
    private List<NameAndCount> getInfoCountChildrenByUser() {
        return userService.countChildrenByUser();
    }


}
