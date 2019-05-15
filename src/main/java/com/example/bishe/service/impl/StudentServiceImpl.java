package com.example.bishe.service.impl;

import com.example.bishe.dao.LoginUserRepository;
import com.example.bishe.dao.StudentRepository;
import com.example.bishe.entity.Student;
import com.example.bishe.service.StudentService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private LoginUserRepository loginUserRepository;

    @Override
    public ResponseUtil findAllStudent() {
        return new ResponseUtil(0,"find success",studentRepository.findAll());
    }

    @Override
    public ResponseUtil deleteOneStudent(Integer studentId) {
        Student student = studentRepository.findStudentByStudentId(studentId);
        if (student != null){
            studentRepository.deleteById(studentId);
            loginUserRepository.deleteLoginUserByLoginAccount(student.getStudentNumber());
            return new ResponseUtil(0,"delete one student",1);
        }else {
            return new ResponseUtil(0,"delete failed",2);
        }
    }

    @Override
    public ResponseUtil updateOneStudent(Student student) {
        Student updateStudent = studentRepository.findStudentByStudentId(student.getStudentId());
        if (updateStudent != null){
            updateStudent.setStudentName(student.getStudentName());
            updateStudent.setStudentClass(student.getStudentClass());
            updateStudent.setStudentProfession(student.getStudentProfession());
            updateStudent.setStudentAcademy(student.getStudentAcademy());
            updateStudent.setStudentInTime(student.getStudentInTime());
            updateStudent.setStudentContact(student.getStudentContact());
            studentRepository.save(updateStudent);
            return new ResponseUtil(0,"update success",1);
        }else {
            return new ResponseUtil(0,"update failed",2);
        }
    }

    @Override
    public ResponseUtil findStudentByNumber(String studentNumber) {
        return new ResponseUtil(0,"find success",studentRepository.findStudentByStudentNumber(studentNumber));
    }
}
