package com.ivanbessoltsev.exampleapplication.predicate;

import com.ivanbessoltsev.exampleapplication.filter.RequestFilterDTO;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


import static com.ivanbessoltsev.exampleapplication.model.entity.QUser.user;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QPredicates {

    private final List<Predicate> predicates = new ArrayList<>();

    public <T> QPredicates add(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public Predicate buildAnd() {
        return (Predicate) ExpressionUtils.allOf(predicates);
    }

    public Predicate buildOr() {
        return (Predicate) ExpressionUtils.anyOf(predicates);
    }

    public static QPredicates builder() {
        return new QPredicates();
    }


}

//    public BooleanExpression buildPredicates(RequestFilterDTO requestFilterDTO) {
//        BooleanExpression predicate = user.firstName.containsIgnoreCase(requestFilterDTO.getFirstName())
//                .and(user.lastName.containsIgnoreCase(requestFilterDTO.getLastName()))
//                .and(user.middleName.containsIgnoreCase(requestFilterDTO.getMiddleName()))
//                .and(user.dateOfEmployment.between(requestFilterDTO.getStartDateOfEmployment(), requestFilterDTO.getEndDateOfEmployment()))
//                .and(user.dateOfDismissal.between(requestFilterDTO.getStartDateOfDismissal(), requestFilterDTO.getEndDateOfDismissal()))
//                .and(familyMember.relation.eq(Relation.valueOf(requestFilterDTO.getRelation())));
//        return predicate;


