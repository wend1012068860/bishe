package com.example.bishe.service;

import com.example.bishe.entity.AandP;
import com.example.bishe.entity.LoginUser;
import com.example.bishe.utils.ResponseUtil;

public interface LoginService {
    /**
     * 查找登陆用户
     * @param aandP
     * @return
     */
    ResponseUtil getLoginUser(AandP aandP);
}
