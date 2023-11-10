package com.laflenory.dormitory.web.controller.impl.rest;

import com.laflenory.dormitory.model.entity.User;
import com.laflenory.dormitory.service.api.user.UserCrudService;
import com.laflenory.dormitory.web.ApplicationResponse;
import com.laflenory.dormitory.web.controller.api.rest.UserRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestControllerImpl extends UserRestController {
    protected final UserCrudService userCrudService;

    @PostMapping
    @Override
    public ApplicationResponse<User> create(@RequestBody User user) {
        return new ApplicationResponse<>(
                "Пользователь был успешно добавлен.",
                this.userCrudService.create(user)
        );
    }

    @GetMapping
    @Override
    public ApplicationResponse<User> read(@PathVariable UUID userId) {
        return new ApplicationResponse<>(
                "Пользователь был успешно получен",
                this.userCrudService.read(userId)
        );
    }

    @PutMapping
    @Override
    public ApplicationResponse<User> update(@RequestBody User user) {
        return new ApplicationResponse<>(
                "Пользователь был успешно обновлён.",
                this.userCrudService.update(user)
        );
    }

    @DeleteMapping
    @Override
    public void delete(UUID userId) {
        this.userCrudService.delete(userId);
    }
}
