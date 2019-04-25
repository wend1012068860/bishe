package com.example.bishe.controller;

import com.example.bishe.service.ArrangeService;
import com.example.bishe.service.RoomService;
import com.example.bishe.utils.ResponseUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class ArrangeController {
    @Resource
    private ArrangeService arrangeService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseUtil getAllRooms(){
        return new ResponseUtil(0,"get all arranges",arrangeService.getAllArrange());
    }

    @RequestMapping(value = "/freeRoom", method = RequestMethod.POST)
    public ResponseUtil getFreeRooms(@RequestParam String time){
        return new ResponseUtil(0,"get free rooms",arrangeService.getFreeRooms(time));
    }
}
