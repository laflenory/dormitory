package com.laflenory.dormitory.service.api;

import java.util.UUID;

public interface BaseCrudService<T> {
    T create(T entity);
    T read(UUID entityId);
    T update(T entity);
    void delete(UUID entityId);
}
