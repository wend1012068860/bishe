package com.example.bishe.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoginUser {
    @Id
    @GeneratedValue

    private Integer loginId;
    @Column(nullable = false)
    private String loginAccount;
    @Column(nullable = false)
    private String loginPassword;
    private String loginIdentity;

    public LoginUser(String loginAccount, String loginPassword, String loginIdentity) {
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
        this.loginIdentity = loginIdentity;
    }

    public LoginUser() {
    }
}
