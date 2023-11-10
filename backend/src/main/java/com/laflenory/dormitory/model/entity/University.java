package com.laflenory.dormitory.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "universities")
public class University extends BaseEntity {
    @OneToMany(mappedBy = "university")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Dormitory> dormitories = new ArrayList<>();

    @Column(name = "university_name", nullable = false)
    private String universityName;

    @Column(name = "duration_of_study", nullable = false)
    private int durationOfStudy;
}
