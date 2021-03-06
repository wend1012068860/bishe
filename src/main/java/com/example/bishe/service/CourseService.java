package com.example.bishe.service;

import com.example.bishe.entity.Course;
import com.example.bishe.utils.ResponseUtil;

import java.util.List;

public interface CourseService {
    /**
     * 查找所有课程信息
     * @return
     */
    ResponseUtil findALLCourse();

    ResponseUtil deleteOneCourse(Integer courseId);

    ResponseUtil saveOneCourse(Course course);

    ResponseUtil addChooseNumber(Integer courseId);

    ResponseUtil reduceChooseNumber(Integer courseId);

    ResponseUtil stuCourses(String studentNumber);
}
