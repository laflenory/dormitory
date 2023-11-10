package com.laflenory.dormitory.service.api;

public interface BaseCrudService<T, U> {
    T create(T entity);
    T read(U entityId);
    T update(T entity);
    void delete(U entityId);
}
