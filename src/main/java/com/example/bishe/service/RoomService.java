package com.example.bishe.service;

import com.example.bishe.entity.Room;
import com.example.bishe.utils.ResponseUtil;

public interface RoomService {
    /**
     * 查询所有教室
     * @return
     */
    ResponseUtil getAllRooms();
}
