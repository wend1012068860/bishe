package com.example.bishe.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue

    private Integer roomId;
    private String building;
    private String room;
    private Integer personNum;
    private String roomTime;
}
