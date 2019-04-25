package com.example.bishe.controller;

import com.example.bishe.service.TeacherService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseUtil getAllTeacher(){
        return new ResponseUtil(0,"find all teacher",teacherService.findAllTeacher());
    }
}
