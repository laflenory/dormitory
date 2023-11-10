package com.laflenory.dormitory.service.api;

import com.laflenory.dormitory.web.exception.*;

public interface BaseCrudService<T, U> {
    T create(T entity) throws EntityExistsException, EntityCreateException;

    T read(U entityId) throws EntityReadException;

    T update(T entity) throws EntityUpdateException;

    void delete(U entityId) throws EntityDeleteException;
}
