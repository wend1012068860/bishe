package com.example.bishe.service.impl;

import com.example.bishe.entity.Course;
import com.example.bishe.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    @Resource
    private CourseService courseService;

    @Test
    public void deleteOne(){
        System.out.println(courseService.stuCourses("s002"));
    }

}