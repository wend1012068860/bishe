package com.example.bishe.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue
    private Integer teacherId;

    @Column(name = "teacherNumber")
    @Excel(name = "教师编号", orderNum = "1")
    private String teacherNumber;

    @Column(name = "teacherName")
    @Excel(name = "教师姓名", orderNum = "2")
    private String teacherName;

    @Column(name = "teacherAcademy")
    @Excel(name = "学院", orderNum = "3")
    private String teacherAcademy;

    @Column(name = "teacherContact")
    @Excel(name = "联系方式", orderNum = "4")
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
