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
    private String room;
    private Integer personNum;

    public Room(String room, Integer personNum) {
        this.room = room;
        this.personNum = personNum;
    }

    public Room() {
    }
}
