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
}
