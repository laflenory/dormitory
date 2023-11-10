package com.laflenory.dormitory.service.impl.university;

import com.laflenory.dormitory.model.entity.University;
import com.laflenory.dormitory.repository.api.UniversityRepository;
import com.laflenory.dormitory.service.api.university.UniversityCrudService;
import com.laflenory.dormitory.web.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UniversityCrudServiceImpl extends UniversityCrudService {
    private final UniversityRepository universityRepository;

    public University create(University university) {
        if (this.universityRepository.findByUniversityName(university.getUniversityName()).isPresent()) {
            throw new EntityExistsException("Университет уже существует.");
        }

        try {
            return this.universityRepository.save(university);
        } catch (Exception error) {
            throw new EntityCreateException("Произошла ошибка при добавлении университета.");
        }
    }

    public University read(UUID universityId) {
        try {
            return this.universityRepository.findById(universityId)
                    .orElseThrow(() -> new EntityNotFoundException("Университета не существует."));
        } catch (EntityNotFoundException error) {
            throw new EntityReadException("Не удалось получить университет: " + error.getMessage());
        } catch (Exception error) {
            throw new EntityReadException("Не удалось получить университет.");
        }
    }

    public University update(University university) {
        try {
            var targetUniversity = this.read(university.getId());
            targetUniversity.setUniversityName(university.getUniversityName());
            targetUniversity.setDurationOfStudy(university.getDurationOfStudy());
            return universityRepository.save(university);
        } catch (EntityNotFoundException error) {
            throw new EntityUpdateException("Произошла ошибка при обновлении данных университета: " + error.getMessage());
        } catch (Exception error) {
            throw new EntityUpdateException("Произошла ошибка при обновлении данных университета.");
        }
    }

    public void delete(UUID universityId) {
        try {
            this.universityRepository.delete(this.read(universityId));
        } catch (EntityReadException error) {
            throw new EntityDeleteException("Произошла ошибка при удалении университета: " + error.getMessage());
        } catch (Exception error) {
            throw new EntityDeleteException("Произошла ошибка при удалении университета.");
        }
    }
}
