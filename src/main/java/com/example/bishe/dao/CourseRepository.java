package com.example.bishe.dao;

import com.example.bishe.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Modifying
    @Transactional
    @Query("update Course e set e.courseName = ?1 where e.courseId = ?2")
    int updateCourseNameById(String courseName, Integer courseId);
}
