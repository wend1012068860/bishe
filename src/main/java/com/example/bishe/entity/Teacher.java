package com.example.bishe.entity;

import lombok.Data;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue

    private Integer teacherId;
    private String teacherNumber;
    private String teacherName;
    private String teacherAcademy;
    private String teacherContact;

    public Teacher(String teacherNumber, String teacherName, String teacherAcademy, String teacherContact) {
        this.teacherNumber = teacherNumber;
        this.teacherName = teacherName;
        this.teacherAcademy = teacherAcademy;
        this.teacherContact = teacherContact;
    }

    public Teacher() {
    }
}
