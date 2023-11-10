package com.laflenory.dormitory.service.api.user;

import com.laflenory.dormitory.model.entity.User;
import com.laflenory.dormitory.repository.api.UserRepository;
import com.laflenory.dormitory.service.api.BaseCrudService;

public abstract class UserCrudService implements BaseCrudService<User> {
    protected UserRepository userRepository;
}
