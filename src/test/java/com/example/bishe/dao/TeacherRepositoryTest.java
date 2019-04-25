package com.example.bishe.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {
    @Resource
    private TeacherRepository teacherRepository;

    @Test
    public void findAll(){
        System.out.println(teacherRepository.findAll());
    }

}