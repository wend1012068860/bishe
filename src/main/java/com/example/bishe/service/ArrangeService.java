package com.example.bishe.service;

import com.example.bishe.entity.Arrange;
import com.example.bishe.utils.ResponseUtil;


public interface ArrangeService {
    /**
     * 所有排课教室
     * @return
     */
    ResponseUtil getAllArrange();

    ResponseUtil getFreeRooms(String time,Integer limitNum);
}
