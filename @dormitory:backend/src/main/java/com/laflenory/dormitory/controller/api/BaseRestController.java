package com.laflenory.dormitory.controller.api;

import org.springframework.web.bind.annotation.*;

public interface BaseRestController<T, U> {
    @PostMapping
    T create(T entity);

    @GetMapping("/{entityId}")
    T read(@PathVariable U entityId);

    @PutMapping
    T update(T entity);

    @DeleteMapping("/{entityId}")
    void delete(@PathVariable U entityId);
}
