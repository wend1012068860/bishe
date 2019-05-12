package com.example.bishe.controller;

import com.example.bishe.entity.Teacher;
import com.example.bishe.service.TeacherService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "deleteOne", method = RequestMethod.POST)
    public ResponseUtil deleteOneTeacher(@RequestParam Integer teacherId){
        return new ResponseUtil(0,"delete one success",teacherService.deleteTeacher(teacherId));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponseUtil updateTeacherInfo(@RequestBody Teacher teacher){
        return new ResponseUtil(0,"update success",teacherService.updateTeacher(teacher));
    }
}
