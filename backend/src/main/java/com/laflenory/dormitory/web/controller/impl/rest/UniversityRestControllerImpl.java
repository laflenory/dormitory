package com.laflenory.dormitory.web.controller.impl.rest;

import com.laflenory.dormitory.model.entity.University;
import com.laflenory.dormitory.service.api.university.UniversityCrudService;
import com.laflenory.dormitory.web.ApplicationResponse;
import com.laflenory.dormitory.web.controller.api.rest.UniversityRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/university")
@RequiredArgsConstructor
public class UniversityRestControllerImpl extends UniversityRestController {
    private final UniversityCrudService universityCrudService;

    @PostMapping
    public ApplicationResponse<University> create(@RequestBody University university) {
        return new ApplicationResponse<>(
                "Университет был успешно добавлен.",
                this.universityCrudService.create(university)
        );
    }

    @GetMapping("/{universityId}")
    public ApplicationResponse<University> read(@PathVariable UUID universityId) {
        return new ApplicationResponse<>(
                "Университет был успешно получен.",
                this.universityCrudService.read(universityId)
        );
    }

    @PutMapping
    public ApplicationResponse<University> update(@RequestBody University university) {
        return new ApplicationResponse<>(
                "Университет был успешно обовлён.",
                this.universityCrudService.update(university)
        );
    }

    @DeleteMapping("/{universityId}")
    public ApplicationResponse<?> delete(@PathVariable UUID universityId) {
        this.universityCrudService.delete(universityId);

        return new ApplicationResponse<>(
                "Университет был успешно удалён.",
                null
        );
    }
}
