package com.example.bishe.dao;

import com.example.bishe.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class studentRepositoryTest {
    @Resource
    private StudentRepository studentRepository;

    @Test
    public void findAll(){
        System.out.println(studentRepository.findStudentByStudentNumber("s002"));
    }

}