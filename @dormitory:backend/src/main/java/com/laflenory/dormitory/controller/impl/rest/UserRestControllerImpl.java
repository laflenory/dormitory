package com.laflenory.dormitory.controller.impl.rest;

import com.laflenory.dormitory.controller.api.rest.UserRestController;
import com.laflenory.dormitory.model.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public class UserRestControllerImpl extends UserRestController {
    @Override
    public User create(User user) {
        return this.userCrudService.create(user);
    }

    @Override
    public User read(@PathVariable UUID userId) {
        return this.userCrudService.read(userId);
    }

    @Override
    public User update(User user) {
        return this.userCrudService.update(user);
    }

    @Override
    public void delete(UUID userId) {
        this.userCrudService.delete(userId);
    }
}
