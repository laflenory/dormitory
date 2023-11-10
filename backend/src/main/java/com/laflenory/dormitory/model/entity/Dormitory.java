package com.laflenory.dormitory.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "dormitories")
public class Dormitory extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "number_of_rooms", nullable = false)
    private int numberOfRooms;

    @Column(name = "availability", nullable = false)
    private boolean availability = true;
}
