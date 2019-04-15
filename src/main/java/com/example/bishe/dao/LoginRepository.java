package com.example.bishe.dao;

import com.example.bishe.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginUser,Integer> {

    /**
     * 根据登陆账号查找用户
     * @param loginAccount
     * @return
     */
    LoginUser findLoginUserByLoginAccount(String loginAccount);
}
