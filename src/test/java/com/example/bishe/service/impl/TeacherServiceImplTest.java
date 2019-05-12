package com.example.bishe.service.impl;

import com.example.bishe.dao.StudentRepository;
import com.example.bishe.dao.TeacherRepository;
import com.example.bishe.entity.Teacher;
import com.example.bishe.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {
    @Resource
    private TeacherService teacherService;
    @Resource
    private TeacherRepository teacherRepository;

    @Test
    public void findAll(){
        Teacher teacher = teacherRepository.findTeacherByTeacherId(6);
        //teacher.setTeacherNumber("a005");
        //teacher.setTeacherName("测试教师");
        teacher.setTeacherAcademy("计算机与软件学院");
        //teacher.setTeacherContact("123123123");
        System.out.println(teacherService.updateTeacher(teacher));
    }

}