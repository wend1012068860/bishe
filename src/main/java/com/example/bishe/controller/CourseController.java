package com.example.bishe.controller;

import com.example.bishe.service.CourseService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/deleteOne", method = RequestMethod.POST)
    public ResponseUtil deleteOneCourse(@RequestParam Integer courseId){
        return new ResponseUtil(0,"delete one course",courseService.deleteOneCourse(courseId));
    }
}
