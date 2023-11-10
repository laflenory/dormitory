package com.laflenory.dormitory.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "students")
public class Student extends BaseEntity {
    @Column(name = "year_of_admission", nullable = false)
    private int yearOfAdmission;

    @Column(name = "date_of_withdrawal")
    private LocalTime dateOfWithdrawal;
}
