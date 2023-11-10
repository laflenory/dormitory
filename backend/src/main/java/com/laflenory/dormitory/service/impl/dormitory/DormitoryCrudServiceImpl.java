package com.laflenory.dormitory.service.impl.dormitory;

import com.laflenory.dormitory.model.entity.Dormitory;
import com.laflenory.dormitory.repository.api.DormitoryRepository;
import com.laflenory.dormitory.service.api.dormitory.DormitoryCrudService;
import com.laflenory.dormitory.web.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DormitoryCrudServiceImpl extends DormitoryCrudService {
    private final DormitoryRepository dormitoryRepository;

    public Dormitory create(Dormitory dormitory) {
        if (this.dormitoryRepository.findByNumber(dormitory.getNumber()).isPresent()) {
            throw new EntityExistsException("Общежитие уже существует.");
        }

        try {
            return this.dormitoryRepository.save(dormitory);
        } catch (Exception error) {
            throw new EntityCreateException("Произошла ошибка при добавлении общежития.");
        }
    }

    public Dormitory read(UUID dormitoryId) {
        try {
            return this.dormitoryRepository.findById(dormitoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Общежития не существует."));
        } catch (EntityNotFoundException error) {
            throw new EntityReadException("Не удалось получить общежитие -> " + error.getMessage());
        } catch (Exception error) {
            throw new EntityReadException("Не удалось получить общежитие.");
        }
    }

    public Dormitory update(Dormitory dormitory) {
        return null;
    }

    public void delete(UUID dormitoryId) {
        try {
            this.dormitoryRepository.deleteById(this.read(dormitoryId).getId());
        } catch (EntityReadException error) {
            throw new EntityDeleteException("Произошла ошибка при удалении общежития -> " + error.getMessage());
        } catch (Exception error) {
            throw new EntityDeleteException("Произошла ошибка при удалении общежития.");
        }
    }
}
