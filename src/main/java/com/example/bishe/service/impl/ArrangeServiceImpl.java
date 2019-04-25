package com.example.bishe.service.impl;

import com.example.bishe.dao.ArrangeRepository;
import com.example.bishe.dao.RoomRepository;
import com.example.bishe.entity.Arrange;
import com.example.bishe.entity.Room;
import com.example.bishe.service.ArrangeService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArrangeServiceImpl implements ArrangeService {
    @Resource
    private ArrangeRepository arrangeRepository;
    @Resource
    private RoomRepository roomRepository;

    @Override
    public ResponseUtil getAllArrange() {
        return new ResponseUtil(0,"get all arranges",arrangeRepository.findAll());
    }

    @Override
    public ResponseUtil getFreeRooms(String time) {
        List<Arrange> onRooms = arrangeRepository.findArrangesByTime(time);
        List<Room> allRooms = roomRepository.findAll();
        for (int i=0; i<onRooms.size(); i++){
            for (int j=0; j<allRooms.size(); j++){
                if (onRooms.get(i).getRoom().equals(allRooms.get(j).getRoom())){
                    allRooms.remove(j);
                }
            }
        }
        return new ResponseUtil(0,"get all free rooms",allRooms);
    }
}
