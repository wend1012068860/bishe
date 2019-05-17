package com.example.bishe.dao;

import com.example.bishe.entity.Choose;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChooseRepositoryTest {
    @Resource
    private ChooseRepository chooseRepository;

    @Test
    public void test(){
        System.out.println(chooseRepository.findChoosesByCourseId(2));
    }

}