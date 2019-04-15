package com.example.bishe.dao;

import com.example.bishe.entity.LoginUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginRepositoryTest {
    @Resource
    private LoginRepository loginRepository;

    @Test
    public void userLogin(){
        LoginUser loginUser = loginRepository.findLoginUserByLoginAccount("1111");
        if (loginUser != null){
            System.out.println(loginUser);
        }
    }

}