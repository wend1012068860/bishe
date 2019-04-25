package com.example.bishe.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Arrange {
    @Id
    @GeneratedValue

    private Integer id;
    private String room;
    private String time;

    public Arrange(String room, String time) {
        this.room = room;
        this.time = time;
    }

    public Arrange() {
    }
}
