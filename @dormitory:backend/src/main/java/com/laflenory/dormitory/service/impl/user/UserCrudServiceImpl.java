package com.laflenory.dormitory.service.impl.user;

import com.laflenory.dormitory.model.entity.User;
import com.laflenory.dormitory.service.api.user.UserCrudService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserCrudServiceImpl extends UserCrudService {
    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User read(UUID userId) {
        return this.userRepository.findById(userId).orElse(null);
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(UUID userId) {
        this.userRepository.deleteById(userId);
    }
}
