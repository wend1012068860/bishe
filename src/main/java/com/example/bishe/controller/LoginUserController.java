package com.example.bishe.controller;

import com.example.bishe.entity.AandP;
import com.example.bishe.service.LoginService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginUserController {
    @Resource
    private LoginService loginService;

    @RequestMapping(value = "sign_in", method = RequestMethod.POST)
    public ResponseUtil signIn(@RequestBody AandP aandP){
        System.out.println(aandP);
        return loginService.getLoginUser(aandP);
    }

    @RequestMapping(value = "change", method = RequestMethod.POST)
    public ResponseUtil change(@RequestParam String loginAccount,String oldPass, String newPass){
        return new ResponseUtil(0,"change success",loginService.changePassword(loginAccount,oldPass,newPass));
    }
}
