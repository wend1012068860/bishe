package com.example.bishe.service.impl;

import com.example.bishe.dao.StudentRepository;
import com.example.bishe.entity.Student;
import com.example.bishe.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    @Resource
    private StudentService studentService;
    @Resource
    private StudentRepository studentRepository;

    @Test
    public void findAll(){
        System.out.println();
    }

}