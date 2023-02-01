package com.ivanbessoltsev.exampleapplication.predicate;

import com.ivanbessoltsev.exampleapplication.filter.RequestFilterDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;

import static com.ivanbessoltsev.exampleapplication.model.entity.QUser.*;


@Component
public class BuildPredicatesByFilter {

    public BooleanExpression buildPredicates(RequestFilterDTO requestFilterDTO) {
        BooleanExpression predicate = user.firstName.containsIgnoreCase(requestFilterDTO.getFirstName())
                .and(user.lastName.containsIgnoreCase(requestFilterDTO.getLastName()))
                .and(user.middleName.containsIgnoreCase(requestFilterDTO.getMiddleName()))
                .and(user.dateOfEmployment.between(requestFilterDTO.getStartDateOfEmployment(), requestFilterDTO.getEndDateOfEmployment()))
                .and(user.dateOfDismissal.between(requestFilterDTO.getStartDateOfDismassal(), requestFilterDTO.getEndDateOfDismassal()));

        return predicate;
    }
}
