package com.ivanbessoltsev.exampleapplication.controller;

import com.ivanbessoltsev.exampleapplication.constant.Urls;
import com.ivanbessoltsev.exampleapplication.model.entity.Department;
import com.ivanbessoltsev.exampleapplication.model.entity.FamilyMember;
import com.ivanbessoltsev.exampleapplication.service.FamilyMemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FamilyMemberController {

    private final FamilyMemberService familyMemberService;

    @GetMapping(Urls.FamilyMember.FULL)
    @Operation(method = "GET", summary = "Получение всех членов семьи")
    private List<FamilyMember> findAll() {
        return familyMemberService.findAll();
    }

    @GetMapping(Urls.FamilyMember.Id.FULL)
    @Operation(method = "GET", summary = "Получение члена семьи по id")
    private FamilyMember findById(@PathVariable Integer id) {
        return familyMemberService.findById(id);
    }

    @DeleteMapping(Urls.FamilyMember.Id.FULL)
    @Operation(method = "DELETE", summary = "Удаление члена семьи по id")
    private void deleteById(@PathVariable Integer id) {
        familyMemberService.delete(id);
    }
}
