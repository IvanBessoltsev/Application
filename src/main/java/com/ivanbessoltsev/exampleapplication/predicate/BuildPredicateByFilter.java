package com.ivanbessoltsev.exampleapplication.predicate;

import com.ivanbessoltsev.exampleapplication.enums.Relation;
import com.ivanbessoltsev.exampleapplication.filter.RequestFilterDTO;
import com.ivanbessoltsev.exampleapplication.model.entity.QContact;
import com.ivanbessoltsev.exampleapplication.model.entity.QFamilyMember;
import com.querydsl.core.types.Predicate;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import static com.ivanbessoltsev.exampleapplication.model.entity.QFamilyMember.*;
import static com.ivanbessoltsev.exampleapplication.model.entity.QUser.user;


@Component
public class BuildPredicateByFilter {

    public Predicate buildPredicate(RequestFilterDTO requestFilterDTO) {
        return QPredicates.builder()
                .add(requestFilterDTO.getFirstName(), user.firstName::containsIgnoreCase)
                .add(requestFilterDTO.getMiddleName(), user.middleName::containsIgnoreCase)
                .add(requestFilterDTO.getLastName(), user.lastName::containsIgnoreCase)
                .add(requestFilterDTO.getRelation(), str-> familyMember.relation.eq(Relation.valueOf(str)))
                .buildAnd();
    }
}

