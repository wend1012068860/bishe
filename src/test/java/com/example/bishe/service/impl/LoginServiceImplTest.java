package com.example.bishe.service.impl;

import com.example.bishe.dao.LoginRepository;
import com.example.bishe.entity.AandP;
import com.example.bishe.entity.LoginUser;
import com.example.bishe.service.LoginService;
import com.example.bishe.utils.ResponseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceImplTest {
    @Resource
    private LoginService loginService;

    @Test
    public void getLoginUser() {
        AandP aandP = new AandP("1111","1111");
        ResponseUtil responseUtil = loginService.getLoginUser(aandP);
        System.out.println(responseUtil);
    }
}