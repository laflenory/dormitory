package com.laflenory.dormitory.repository.api;

import com.laflenory.dormitory.model.entity.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UniversityRepository extends CrudRepository<University, UUID> {
    Optional<University> findByUniversityName(String universtiyName);
}
