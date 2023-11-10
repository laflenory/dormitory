package com.laflenory.dormitory.web.controller.impl.rest;

import com.laflenory.dormitory.model.entity.Student;
import com.laflenory.dormitory.service.api.student.StudentCrudService;
import com.laflenory.dormitory.web.ApplicationResponse;
import com.laflenory.dormitory.web.controller.api.rest.StudentRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentRestControllerImpl extends StudentRestController {
    private final StudentCrudService studentCrudService;

    @PostMapping
    public ApplicationResponse<Student> create(@RequestBody Student student) {
        return new ApplicationResponse<>(
                "Студент был успешно добавлен.",
                this.studentCrudService.create(student)
        );
    }

    @GetMapping("/{studentId}")
    public ApplicationResponse<Student> read(@PathVariable UUID studentId) {
        return new ApplicationResponse<>(
                "Студент был успешно получен.",
                this.studentCrudService.read(studentId)
        );
    }

    @PutMapping
    public ApplicationResponse<Student> update(@RequestBody Student student) {
        return new ApplicationResponse<>(
                "Студент был успешно обновлён.",
                this.studentCrudService.update(student)
        );
    }

    @DeleteMapping("/{studentId}")
    public ApplicationResponse<?> delete(@PathVariable UUID studentId) {
        this.studentCrudService.delete(studentId);

        return new ApplicationResponse<>(
                "Студент был успешно удалён.",
                null
        );
    }
}
