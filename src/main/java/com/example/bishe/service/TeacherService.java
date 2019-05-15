package com.example.bishe.service;

import com.example.bishe.entity.Teacher;
import com.example.bishe.utils.ResponseUtil;

public interface TeacherService {
    /**
     * 查找所有老师
     * @return
     */
    ResponseUtil findAllTeacher();

    /**
     * 删除一名老师信息
     * @param teacherId
     * @return
     */
    ResponseUtil deleteTeacher(Integer teacherId);

    /**
     * 更新一名老师信息
     * @param teacher
     * @return
     */
    ResponseUtil updateTeacher(Teacher teacher);

    ResponseUtil findTeacherByNumber(String teacherNumber);
}
