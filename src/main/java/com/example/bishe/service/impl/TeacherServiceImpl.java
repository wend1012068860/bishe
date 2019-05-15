package com.example.bishe.service.impl;

import com.example.bishe.dao.TeacherRepository;
import com.example.bishe.entity.Teacher;
import com.example.bishe.service.TeacherService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherRepository teacherRepository;

    @Override
    public ResponseUtil findAllTeacher() {
        return new ResponseUtil(0,"find success",teacherRepository.findAll());
    }

    @Override
    public ResponseUtil deleteTeacher(Integer teacherId) {
        if (teacherRepository.findById(teacherId) != null){
            teacherRepository.deleteById(teacherId);
            return new ResponseUtil(0,"delete one teacher",1);
        }else {
            return new ResponseUtil(0,"delete failed",2);
        }
    }

    @Override
    public ResponseUtil updateTeacher(Teacher teacher) {
        Teacher updateTeacher = teacherRepository.findTeacherByTeacherId(teacher.getTeacherId());
        if (updateTeacher != null){
            updateTeacher.setTeacherNumber(teacher.getTeacherNumber());
            updateTeacher.setTeacherName(teacher.getTeacherName());
            updateTeacher.setTeacherAcademy(teacher.getTeacherAcademy());
            updateTeacher.setTeacherContact(teacher.getTeacherContact());
            teacherRepository.save(updateTeacher);
            return new ResponseUtil(0,"update success",1);
        }else {
            return new ResponseUtil(0,"update failed",2);
        }

    }

    @Override
    public ResponseUtil findTeacherByNumber(String teacherNumber) {
        return new ResponseUtil(0,"find teacher by number",teacherRepository.findTeacherByTeacherNumber(teacherNumber));
    }
}
