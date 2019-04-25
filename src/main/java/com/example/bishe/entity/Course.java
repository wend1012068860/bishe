package com.example.bishe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private Integer courseId;
    private String courseName;
    private String courseNature;
    private Integer coursePoint;
    private String courseTeacher;
    private Integer courseLimitNum;
    private Integer courseChooseNum;
    private String courseTp;

    public Course(String courseName, String courseNature, Integer coursePoint, String courseTeacher, Integer courseLimitNum, Integer courseChooseNum, String courseTp) {
        this.courseName = courseName;
        this.courseNature = courseNature;
        this.coursePoint = coursePoint;
        this.courseTeacher = courseTeacher;
        this.courseLimitNum = courseLimitNum;
        this.courseChooseNum = courseChooseNum;
        this.courseTp = courseTp;
    }

    public Course() {
    }

}
