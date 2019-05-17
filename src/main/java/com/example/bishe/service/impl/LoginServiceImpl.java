package com.example.bishe.service.impl;

import com.example.bishe.dao.LoginRepository;
import com.example.bishe.entity.AandP;
import com.example.bishe.entity.LoginUser;
import com.example.bishe.service.LoginService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginRepository loginRepository;

    @Override
    public ResponseUtil getLoginUser(AandP aandP) {
        LoginUser user = loginRepository.findLoginUserByLoginAccount(aandP.getAccount());
        //账号有效
        if (user != null){
            //判断密码是否正确
            if (aandP.getPassword().equals(user.getLoginPassword())){
                return new ResponseUtil(0,"登陆成功！",user);
            }else {
                return new ResponseUtil(0,"密码错误！",null);
            }
        }else {
            return new ResponseUtil(0,"账号错误！",null);
        }
    }

    @Override
    public ResponseUtil changePassword(String loginAccount, String oldPass, String newPass) {
        LoginUser loginUser = loginRepository.findLoginUserByLoginAccount(loginAccount);
        if (loginUser != null){
            if (loginUser.getLoginPassword().equals(oldPass)){
                loginUser.setLoginPassword(newPass);
                loginRepository.save(loginUser);
                return new ResponseUtil(0,"success",1);
            }else {
                return new ResponseUtil(0,"old password wrong",0);
            }
        }else {
            return new ResponseUtil(0,"failed",0);
        }
    }
}
