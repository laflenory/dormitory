package com.laflenory.dormitory.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "universities")
public class University extends BaseEntity {
    @Column(name = "university_name", nullable = false)
    private String universityName;

    @Column(name = "duration_of_study", nullable = false)
    private int durationOfStudy;
}
