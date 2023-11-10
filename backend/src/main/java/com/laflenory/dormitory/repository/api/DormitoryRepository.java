package com.laflenory.dormitory.repository.api;

import com.laflenory.dormitory.model.entity.Dormitory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DormitoryRepository extends CrudRepository<Dormitory, UUID> {
    Optional<Dormitory> findByNumber(int dormitoryNumber);
}
