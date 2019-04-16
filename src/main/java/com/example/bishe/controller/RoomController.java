package com.example.bishe.controller;

import com.example.bishe.service.RoomService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class RoomController {
    @Resource
    private RoomService roomService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseUtil getAllRooms(){
        return new ResponseUtil(0,"get all rooms",roomService.getAllRooms());
    }
}
