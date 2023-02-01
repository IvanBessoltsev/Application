package com.ivanbessoltsev.exampleapplication.repository;

import com.ivanbessoltsev.exampleapplication.model.entity.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {
}
