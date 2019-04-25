package com.example.bishe.dao;

import com.example.bishe.entity.Course;
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
public class CourseRepositoryTest {
    @Resource
    private CourseRepository courseRepository;

    @Test
    public void deleteOne(){
        System.out.println(courseRepository.findById(4));
    }

    @Test
    public void saveOne() throws ParseException {

    }

}