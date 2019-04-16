package com.example.bishe.service.impl;

import com.example.bishe.dao.CourseRepository;
import com.example.bishe.entity.Course;
import com.example.bishe.service.CourseService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseRepository courseRepository;

    @Override
    public ResponseUtil findALLCourse() {
        return new ResponseUtil(0,"get all courses",courseRepository.findAll());
    }

    @Override
    public ResponseUtil deleteOneCourse(Integer courseId) {
        if (courseRepository.findById(courseId) != null){
            courseRepository.deleteById(courseId);
            return new ResponseUtil(0,"delete success",1);
        }else {
            return new ResponseUtil(0,"delete failed",2);
        }

    }
}
