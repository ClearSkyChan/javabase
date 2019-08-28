package com.clearsky.javabase.Infrastructure.repository;

import com.clearsky.javabase.domain.repository.Repository;

@org.springframework.stereotype.Repository
public class AbstractRepository<T> implements Repository<T> {

    @Override
    public T Get(Object id) {
        return null;
    }

    @Override
    public void Save(Object o) {

    }
}
