package com.gft.exam.ms.marl.data.specification;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<T, U> {

    private final String wildcard = "%";

    public abstract Specification<T> getFilter(U request);

    protected String containsLowerCase(String searchField) {
        return wildcard + searchField.toLowerCase() + wildcard;
    }
    
    protected String equalsLowerCase(String searchField) {
        return searchField.toLowerCase();
    }
    
}
