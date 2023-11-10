package com.laflenory.dormitory.web.controller.api;

import com.laflenory.dormitory.web.ApplicationResponse;

public interface BaseRestController<T, U> {
    ApplicationResponse<T> create(T entity);

    ApplicationResponse<T> read(U entityId);

    ApplicationResponse<T> update(T entity);

    ApplicationResponse<?> delete(U entityId);
}
