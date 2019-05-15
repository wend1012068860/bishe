package com.example.bishe.dao;

import com.example.bishe.entity.Choose;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ChooseRepository extends JpaRepository<Choose,Integer> {
    Choose findChooseByCourseIdAndStudentNumber(Integer courseId, String studentNumber);
    List<Choose> findChoosesByStudentNumber(String studentNumber);
    int deleteChooseByCourseIdAndStudentNumber(Integer courseId,String studentNumber);
}
