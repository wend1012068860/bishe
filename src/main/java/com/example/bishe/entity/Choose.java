package com.example.bishe.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Choose {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer courseId;
    private String teacherNumber;
    private String studentNumber;

    public Choose(Integer courseId, String teacherNumber, String studentNumber) {
        this.courseId = courseId;
        this.teacherNumber = teacherNumber;
        this.studentNumber = studentNumber;
    }

    public Choose() {
    }
}
