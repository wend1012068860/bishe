package com.example.bishe.service.impl;

import com.example.bishe.dao.ArrangeRepository;
import com.example.bishe.dao.ChooseRepository;
import com.example.bishe.dao.CourseRepository;
import com.example.bishe.entity.Arrange;
import com.example.bishe.entity.Choose;
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
    @Resource
    private ArrangeRepository arrangeRepository;
    @Resource
    private ChooseRepository chooseRepository;

    @Override
    public ResponseUtil findALLCourse() {
        return new ResponseUtil(0,"get all courses",courseRepository.findAll());
    }

    @Override
    public ResponseUtil deleteOneCourse(Integer courseId) {
        Course course = courseRepository.findCourseByCourseId(courseId);
        System.out.println(course);
        if (course != null){
            courseRepository.deleteById(courseId);
            String tp = course.getCourseTp();
            String time = tp.substring(0,tp.indexOf("/"));
            String place = tp.substring(tp.indexOf("/")+1);
            Arrange arrange = new Arrange(place,time);
            arrangeRepository.deleteArrangeByRoomAndAndTime(place,time);
            return new ResponseUtil(0,"delete success",1);
        }else {
            return new ResponseUtil(0,"delete failed",2);
        }

    }

    @Override
    public ResponseUtil saveOneCourse(Course course) {
        String tp = course.getCourseTp();
        String time = tp.substring(0,tp.indexOf("/"));
        System.out.println(time);
        String place = tp.substring(tp.indexOf("/")+1);
        System.out.println(place);
        Arrange arrange = new Arrange(place,time);
        arrangeRepository.save(arrange);
        return new ResponseUtil(0, "save success", courseRepository.save(course));
    }

    @Override
    public ResponseUtil addChooseNumber(Integer courseId) {
        Course course = courseRepository.findCourseByCourseId(courseId);
        if (course.getCourseChooseNum() < course.getCourseLimitNum()){
            course.setCourseChooseNum(course.getCourseChooseNum()+1);
            courseRepository.save(course);
            return new ResponseUtil(0,"已选人数+1",1);
        }else {
            return new ResponseUtil(0,"该课人数已满！",0);
        }
    }

    @Override
    public ResponseUtil reduceChooseNumber(Integer courseId) {
        Course course = courseRepository.findCourseByCourseId(courseId);
        if (course.getCourseChooseNum() > 0 ){
            course.setCourseChooseNum(course.getCourseChooseNum()-1);
            courseRepository.save(course);
            return new ResponseUtil(0,"已选人数-1",1);
        }else {
            return new ResponseUtil(0,"人数已为0，无法再减少",0);
        }

    }

    @Override
    public ResponseUtil stuCourses(String studentNumber) {
        List<Choose> chooseList = chooseRepository.findChoosesByStudentNumber(studentNumber);
        List<Course> courseList = new ArrayList<>();
        for (Choose choose : chooseList) {
            Course course = courseRepository.findCourseByCourseId(choose.getCourseId());
            courseList.add(course);
        }
        return new ResponseUtil(0,"get student choose courses",courseList);
    }
}
