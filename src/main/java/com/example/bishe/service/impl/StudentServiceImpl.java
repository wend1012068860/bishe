package com.example.bishe.service.impl;

import com.example.bishe.dao.StudentRepository;
import com.example.bishe.service.StudentService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentRepository studentRepository;

    @Override
    public ResponseUtil findAllStudent() {
        return new ResponseUtil(0,"find success",studentRepository.findAll());
    }
}
