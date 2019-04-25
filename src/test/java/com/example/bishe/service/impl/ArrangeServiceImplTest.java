package com.example.bishe.service.impl;

import com.example.bishe.service.ArrangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrangeServiceImplTest {
    @Resource
    private ArrangeService arrangeService;

    @Test
    public void getFreeRooms() {
        System.out.println(arrangeService.getFreeRooms("星期一[1-2节]"));
    }
}