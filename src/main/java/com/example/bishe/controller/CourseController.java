package com.example.bishe.controller;

import com.example.bishe.entity.Course;
import com.example.bishe.entity.PublicTime;
import com.example.bishe.service.CourseService;
import com.example.bishe.utils.ResponseUtil;
import org.apache.catalina.util.RequestUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseUtil getAllCourse(){
        return new ResponseUtil(0,"get all courses",courseService.findALLCourse());
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.POST)
    public ResponseUtil deleteOneCourse(@RequestParam Integer courseId){
        return new ResponseUtil(0,"delete one course",courseService.deleteOneCourse(courseId));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseUtil saveOneCourse(@RequestBody Course course){
        System.out.println("接收完成");
        return new ResponseUtil(0,"save one course",courseService.saveOneCourse(course));
    }

    @RequestMapping(value = "/setime",method = RequestMethod.POST)
    public ResponseUtil getSETime(@RequestParam String setime){
        PublicTime.startAndEndTime = setime;
        System.out.println(PublicTime.startAndEndTime);
        return new ResponseUtil(0,"get start and end time",PublicTime.startAndEndTime);
    }

    @RequestMapping(value = "studentCourse",method = RequestMethod.GET)
    public ResponseUtil studentGetCourse(){
        if (PublicTime.startTime != null && PublicTime.endTime != null) {
            if (PublicTime.ssTime.equals("选课开始") && !PublicTime.eeTime.equals("选课结束")) {
                return new ResponseUtil(0, "student get all courses", courseService.findALLCourse());
            } else {
                return new ResponseUtil(0, "time out", null);
            }
        }else {
            return new ResponseUtil(0,"wrong",null);
        }


    }

}
