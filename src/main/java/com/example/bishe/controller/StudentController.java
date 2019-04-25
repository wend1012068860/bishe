package com.example.bishe.controller;

import com.example.bishe.service.StudentService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping(value = "all",method = RequestMethod.GET)
    public ResponseUtil getAllStudent(){
        return new ResponseUtil(0,"find all student",studentService.findAllStudent());
    }
}
