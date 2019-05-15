package com.example.bishe.controller;

import com.example.bishe.entity.PublicTime;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TestQuartz extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if (PublicTime.startAndEndTime != null){
            String seTime = PublicTime.startAndEndTime;
            PublicTime.startTime = seTime.substring(0,19);
            PublicTime.endTime = seTime.substring(20,39);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDate = df.format(date);
            //System.out.println(nowDate + "  " + PublicTime.startTime + "  "+ PublicTime.endTime);
            if (PublicTime.startTime.equals(nowDate)){
                PublicTime.ssTime = "选课开始";
            }else if (PublicTime.endTime.equals(nowDate)){
                PublicTime.eeTime = "选课结束";
            }
        }

    }
}
