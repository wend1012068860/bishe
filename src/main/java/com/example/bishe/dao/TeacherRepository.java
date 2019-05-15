package com.example.bishe.dao;

import com.example.bishe.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherByTeacherId(Integer teacherId);

    Teacher findTeacherByTeacherName(String teacherName);

    Teacher findTeacherByTeacherNumber(String teacherNumber);
}
