package com.ivanbessoltsev.exampleapplication.service;

import com.ivanbessoltsev.exampleapplication.common.CRUD;
import com.ivanbessoltsev.exampleapplication.model.entity.FamilyMember;
import com.ivanbessoltsev.exampleapplication.repository.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyMemberService implements CRUD<FamilyMember> {

    private final FamilyMemberRepository familyMemberRepository;

    public List<FamilyMember> findAll() {
        return familyMemberRepository.findAll();
    }

    @Override
    public FamilyMember findById(Integer id) {
        return familyMemberRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        familyMemberRepository.deleteById(id);
    }
}

