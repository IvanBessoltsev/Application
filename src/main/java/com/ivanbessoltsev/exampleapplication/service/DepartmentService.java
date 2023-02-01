package com.ivanbessoltsev.exampleapplication.service;

import com.ivanbessoltsev.exampleapplication.common.CRUD;
import com.ivanbessoltsev.exampleapplication.model.entity.Department;
import com.ivanbessoltsev.exampleapplication.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements CRUD<Department> {

    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

}
