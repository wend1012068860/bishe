package com.example.bishe.service.impl;

import com.example.bishe.dao.RoomRepository;
import com.example.bishe.entity.Room;
import com.example.bishe.service.RoomService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomRepository roomRepository;
    @Override
    public ResponseUtil getAllRooms() {
        return new ResponseUtil(0,"success",roomRepository.findAll());
    }

}
