package com.laflenory.dormitory.service.impl.user;

import com.laflenory.dormitory.model.entity.User;
import com.laflenory.dormitory.repository.api.UserRepository;
import com.laflenory.dormitory.service.api.user.UserCrudService;
import com.laflenory.dormitory.web.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCrudServiceImpl extends UserCrudService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) throws EntityExistsException, EntityCreateException {
        if (this.userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new EntityExistsException("Пользователь уже существует.");
        }

        try {
            return this.userRepository.save(user);
        } catch (Exception error) {
            throw new EntityCreateException("Произошла ошибка при добавлении пользователя.");
        }
    }

    @Override
    public User read(UUID userId) throws EntityNotFoundException, EntityCreateException {
        try {
            return this.userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("Пользователя не существует."));
        } catch (EntityNotFoundException error) {
            throw new EntityCreateException("Не удалось получить пользователя: " + error.getMessage());
        } catch (Exception error) {
            throw new EntityCreateException("Не удалось получить пользователя.");
        }
    }

    @Override
    public User update(User user) throws EntityUpdateException {
        try {
            var targetUser = this.read(user.getId());
            targetUser.setUsername(user.getUsername());
            targetUser.setPassword(user.getPassword());
            return this.userRepository.save(targetUser);
        } catch (EntityNotFoundException error) {
            throw new EntityUpdateException("Произошла ошибка при обновлении данных пользователя: " + error.getMessage());
        } catch (Exception error) {
            throw new EntityUpdateException("Произошла ошибка при обновлении данных пользователя.");
        }
    }

    @Override
    public void delete(UUID userId) throws EntityDeleteException {
        try {
            this.userRepository.deleteById(this.read(userId).getId());
        } catch (EntityNotFoundException error) {
            throw new EntityDeleteException("Произошла ошибка при удалении данных пользователя: " + error.getMessage());
        } catch (Exception error) {
            throw new EntityDeleteException("Произошла ошибка при удалении данных пользователя.");
        }
    }
}
