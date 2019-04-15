package com.example.bishe.entity;

import lombok.Builder;
import lombok.Data;

@Data
public class AandP {
    private String account;
    private String password;

    public AandP(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public AandP() {
    }
}
