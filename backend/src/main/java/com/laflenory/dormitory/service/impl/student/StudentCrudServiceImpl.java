package com.laflenory.dormitory.service.impl.student;

import com.laflenory.dormitory.model.entity.Student;
import com.laflenory.dormitory.repository.api.StudentRepository;
import com.laflenory.dormitory.service.api.student.StudentCrudService;
import com.laflenory.dormitory.web.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentCrudServiceImpl extends StudentCrudService {
    private final StudentRepository studentRepository;

    public Student create(Student student) {
        try {
            return this.studentRepository.save(student);
        } catch (Exception error) {
            throw new EntityCreateException("Произошла ошибка при добавлении студента.");
        }
    }

    public Student read(UUID studentId) {
        try {
            return this.studentRepository.findById(studentId)
                    .orElseThrow(() -> new EntityNotFoundException("Студента не существует."));
        } catch (EntityNotFoundException error) {
            throw new EntityReadException("Не удалось получить студента -> " + error.getMessage());
        } catch (Exception error) {
            throw new EntityReadException("Не удалось получить студента.");
        }
    }

    public Student update(Student student) {
        try {
            var targetStudent = this.read(student.getId());
            targetStudent.setGender(student.getGender());
            targetStudent.setYearOfAdmission(student.getYearOfAdmission());
            targetStudent.setDateOfWithdrawal(student.getDateOfWithdrawal());
            return this.studentRepository.save(targetStudent);
        } catch (EntityNotFoundException error) {
            throw new EntityUpdateException("Произошла ошибка при обновлении данных студента -> " + error.getMessage());
        } catch (EntityUpdateException error) {
            throw new EntityUpdateException("Произошла ошибка при обновлении данных студента.");
        }
    }

    public void delete(UUID studentId) {
        try {
            this.studentRepository.deleteById(this.read(studentId).getId());
        } catch (EntityReadException error) {
            throw new EntityDeleteException("Произошла ошибка при удалении студента -> " + error.getMessage());
        } catch (Exception error) {
            throw new EntityDeleteException("Произошла ошибка при удалении студента.");
        }
    }
}
