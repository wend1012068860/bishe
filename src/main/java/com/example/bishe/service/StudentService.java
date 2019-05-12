package com.example.bishe.service;

import com.example.bishe.entity.Student;
import com.example.bishe.utils.ResponseUtil;

import java.util.List;

public interface StudentService {
    /**
     * 查找所有学生
     * @return
     */
    ResponseUtil findAllStudent();

    /**
     * 删除一个学生
     * @param studentId
     * @return
     */
    ResponseUtil deleteOneStudent(Integer studentId);

    /**
     * 更新一个学生信息
     * @param student
     * @return
     */
    ResponseUtil updateOneStudent(Student student);
}
