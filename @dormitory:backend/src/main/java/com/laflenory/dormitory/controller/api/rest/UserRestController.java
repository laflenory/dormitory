package com.laflenory.dormitory.controller.api.rest;

import com.laflenory.dormitory.controller.api.BaseRestController;
import com.laflenory.dormitory.model.entity.User;
import com.laflenory.dormitory.service.api.user.UserCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public abstract class UserRestController implements BaseRestController<User, UUID> {
    protected UserCrudService userCrudService;
}
