package com.laflenory.dormitory.web.controller.impl.rest;

import com.laflenory.dormitory.model.entity.Dormitory;
import com.laflenory.dormitory.service.api.dormitory.DormitoryCrudService;
import com.laflenory.dormitory.web.ApplicationResponse;
import com.laflenory.dormitory.web.controller.api.rest.DormitoryRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/dormitory")
@RequiredArgsConstructor
public class DormitoryRestControllerImpl extends DormitoryRestController {
    private final DormitoryCrudService dormitoryCrudService;

    @PostMapping
    public ApplicationResponse<Dormitory> create(@RequestBody Dormitory dormitory) {
        return new ApplicationResponse<>(
                "Общежитие было успешно добавлено.",
                this.dormitoryCrudService.create(dormitory)
        );
    }

    @GetMapping
    public ApplicationResponse<Dormitory> read(@PathVariable UUID dormitoryId) {
        return new ApplicationResponse<>(
                "Общежитие было успешно получено.",
                this.dormitoryCrudService.read(dormitoryId)
        );
    }

    @PutMapping
    public ApplicationResponse<Dormitory> update(@RequestBody Dormitory dormitory) {
        return new ApplicationResponse<>(
                "Общежитие было успешно обновлено.",
                this.dormitoryCrudService.update(dormitory)
        );
    }

    @DeleteMapping
    public ApplicationResponse<?> delete(@PathVariable UUID dormitoryId) {
        this.dormitoryCrudService.delete(dormitoryId);

        return new ApplicationResponse<>(
                "Общежитие было успешно удалено.",
                null
        );
    }
}
