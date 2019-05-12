package com.example.bishe.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private Integer studentId;

    @Column(name = "studentNumber")
    @Excel(name = "学号", orderNum = "1")
    private String studentNumber;

    @Column(name = "studentName")
    @Excel(name = "姓名", orderNum = "2")
    private String studentName;

    @Column(name = "studentClass")
    @Excel(name = "班级", orderNum = "3")
    private String studentClass;

    @Column(name = "studentProfession")
    @Excel(name = "专业", orderNum = "4")
    private String studentProfession;

    @Column(name = "studentAcademy")
    @Excel(name = "学院", orderNum = "5")
    private String studentAcademy;

    @Column(name = "studentInTime")
    @Excel(name = "入学时间", orderNum = "6")
    private String studentInTime;

    @Column(name = "studentContact")
    @Excel(name = "联系方式", orderNum = "7")
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
