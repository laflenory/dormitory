package com.laflenory.dormitory.web.controller.impl.rest;

import com.laflenory.dormitory.model.entity.University;
import com.laflenory.dormitory.service.api.university.UniversityCrudService;
import com.laflenory.dormitory.web.ApplicationResponse;
import com.laflenory.dormitory.web.controller.api.rest.UniversityRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UniversityRestControllerImpl extends UniversityRestController {
    private final UniversityCrudService universityCrudService;

    @PostMapping
    public ApplicationResponse<University> create(@RequestBody University entity) {
        return null;
    }

    @GetMapping("/{universityId}")
    public ApplicationResponse<University> read(@PathVariable UUID entityId) {
        return null;
    }

    @PutMapping
    public ApplicationResponse<University> update(@RequestBody University entity) {
        return null;
    }

    @DeleteMapping("/{universityId}")
    public Object delete(@PathVariable UUID entityId) {
        return null;
    }
}
