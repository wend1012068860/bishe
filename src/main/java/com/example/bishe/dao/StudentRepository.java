package com.example.bishe.dao;

import com.example.bishe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentByStudentId(Integer studentId);

    Student findStudentByStudentNumber(String studentNumber);
}
