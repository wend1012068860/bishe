package com.example.bishe.dao;

import com.example.bishe.entity.Arrange;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ArrangeRepository extends JpaRepository<Arrange,Integer> {
    /**
     * 查找该时间有课的教室
     * @param time
     * @return
     */
    List<Arrange> findArrangesByTime(String time);

    int deleteArrangeByRoomAndAndTime(String room,String time);
}
