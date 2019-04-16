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
    private String courseLimitNum;
    private String courseChooseNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    private String courseTp;

    public Course(String courseName, String courseNature, Integer coursePoint, String courseTeacher, String courseLimitNum, String courseChooseNum, Date beginTime, Date endTime, String courseTp) {
        this.courseName = courseName;
        this.courseNature = courseNature;
        this.coursePoint = coursePoint;
        this.courseTeacher = courseTeacher;
        this.courseLimitNum = courseLimitNum;
        this.courseChooseNum = courseChooseNum;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.courseTp = courseTp;
    }

    public Course() {
    }

}
