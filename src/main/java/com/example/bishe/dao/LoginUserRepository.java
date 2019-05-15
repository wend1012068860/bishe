package com.example.bishe.dao;

import com.example.bishe.entity.LoginUser;
import com.example.bishe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LoginUserRepository extends JpaRepository<LoginUser,Integer> {
    int deleteLoginUserByLoginAccount(String studentNumber);

    LoginUser findLoginUserByLoginAccount(String loginAccount);
}
