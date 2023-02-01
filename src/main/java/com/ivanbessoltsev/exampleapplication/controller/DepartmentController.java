package com.ivanbessoltsev.exampleapplication.controller;

import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.model.entity.Department;
import com.ivanbessoltsev.exampleapplication.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(Urls.Department.FULL)
    @Operation(method = "GET", summary = "Получение всех департаментов")
    private List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping(Urls.Department.Id.FULL)
    @Operation(method = "GET", summary = "Получение департамента по id")
    private Department findById(@PathVariable Integer id) {
        return departmentService.findById(id);
    }

    @DeleteMapping(Urls.Department.Id.FULL)
    @Operation(method = "DELETE", summary = "Удаление департамента по id")
    private void deleteById(@PathVariable Integer id) {
        departmentService.delete(id);
    }

}
