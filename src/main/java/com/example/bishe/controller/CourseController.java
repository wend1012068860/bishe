package com.example.bishe.controller;

import com.example.bishe.service.CourseService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseUtil getAllCourse(){
        return new ResponseUtil(0,"get all courses",courseService.findALLCourse());
    }
}
