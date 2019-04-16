package com.example.bishe.service.impl;

import com.example.bishe.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceImplTest {
    @Resource
    private RoomService roomService;

    @Test
    public void getAllRooms() {
        System.out.println(roomService.getAllRooms());
    }
}