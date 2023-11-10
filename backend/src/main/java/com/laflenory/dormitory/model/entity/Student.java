package com.laflenory.dormitory.model.entity;

import com.laflenory.dormitory.model.enumeration.StudentGender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "students")
public class Student extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User details;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudentGender gender = StudentGender.MALE;

    @OneToOne
    @JoinColumn(name = "university_id")
    private University university;

    @Column(name = "year_of_admission", nullable = false)
    private int yearOfAdmission;

    @Column(name = "date_of_withdrawal")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-mm-dd")
    private Date dateOfWithdrawal;
}
