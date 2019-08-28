package com.clearsky.javabase.domain.repository;

public interface Repository<T> {
    T Get(Object id);
    void Save(T t);
}
