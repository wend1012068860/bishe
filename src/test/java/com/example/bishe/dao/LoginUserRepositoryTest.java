package com.example.bishe.dao;

import com.example.bishe.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginUserRepositoryTest {
    @Resource
    private LoginUserRepository loginUserRepository;
    @Resource
    private StudentRepository studentRepository;

    @Test
    public void deleteOne(){
        System.out.println(loginUserRepository.findLoginUserByLoginAccount("s003"));
    }

}