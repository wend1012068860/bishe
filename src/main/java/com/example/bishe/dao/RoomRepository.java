package com.example.bishe.dao;

import com.example.bishe.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    /**
     * 查找可容纳人数比限选人数多的教室
     * @param limitNum
     * @return
     */
    List<Room> findRoomsByPersonNumGreaterThanEqual(Integer limitNum);
}
