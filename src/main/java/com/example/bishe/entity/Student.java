package com.example.bishe.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue

    private Integer studentId;
    private String studentNumber;
    private String studentName;
    private String studentClass;
    private String studentProfession;
    private String studentAcademy;
    private String studentInTime;
    private String studentContact;

    public Student(String studentNumber, String studentName, String studentClass, String studentProfession, String studentAcademy, String studentInTime, String studentContact) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentProfession = studentProfession;
        this.studentAcademy = studentAcademy;
        this.studentInTime = studentInTime;
        this.studentContact = studentContact;
    }

    public Student() {
    }
}
