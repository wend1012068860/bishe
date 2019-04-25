package com.example.bishe.service.impl;

import com.example.bishe.dao.TeacherRepository;
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
}
