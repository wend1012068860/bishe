package com.example.bishe.controller;

import com.example.bishe.dao.ChooseRepository;
import com.example.bishe.dao.CourseRepository;
import com.example.bishe.dao.TeacherRepository;
import com.example.bishe.entity.Choose;
import com.example.bishe.entity.Course;
import com.example.bishe.entity.PublicTime;
import com.example.bishe.entity.Teacher;
import com.example.bishe.service.CourseService;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Resource
    private CourseService courseService;
    @Resource
    private ChooseRepository chooseRepository;
    @Resource
    private TeacherRepository teacherRepository;
    @Resource
    private CourseRepository courseRepository;

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

    @RequestMapping(value = "choose",method = RequestMethod.POST)
    public ResponseUtil courseChoose(@RequestParam Integer courseId,String teacherName, String studentNumber){
        String teacherNumber = teacherRepository.findTeacherByTeacherName(teacherName).getTeacherNumber();
        Choose choose = new Choose(courseId,teacherNumber,studentNumber);
        if (chooseRepository.findChooseByCourseIdAndStudentNumber(choose.getCourseId(),choose.getStudentNumber()) != null){
            return new ResponseUtil(0,"add failed","已选择，请勿重复选课！");
        }else {
            chooseRepository.save(choose);
            courseService.addChooseNumber(courseId);
            return new ResponseUtil(0,"add choose","选课成功！");
        }
    }

    @RequestMapping(value = "exitRace",method = RequestMethod.POST)
    public ResponseUtil exitRace(@RequestParam Integer courseId,String studentNumber){
        int result = chooseRepository.deleteChooseByCourseIdAndStudentNumber(courseId,studentNumber);
        if (result == 1){
            courseService.reduceChooseNumber(courseId);
            return new ResponseUtil(0,"exit race success",result);
        }else {
            return new ResponseUtil(0,"exit race failed",result);
        }
    }

    @RequestMapping(value = "chooseCourse", method = RequestMethod.POST)
    public ResponseUtil chooseCourse(@RequestParam String studentNumber){
        return new ResponseUtil(0,"get success",courseService.stuCourses(studentNumber));
    }


    @RequestMapping(value = "time", method = RequestMethod.GET)
    public ResponseUtil getTime(){
        List<String> list = new ArrayList<>();
        list.add(PublicTime.startTime);
        list.add(PublicTime.endTime);
        return new ResponseUtil(0,"start and end time",list);
    }

    @RequestMapping(value = "teacher",method = RequestMethod.POST)
    public ResponseUtil getTeacherCourse(@RequestParam String teacherNumber){
        Teacher teacher = teacherRepository.findTeacherByTeacherNumber(teacherNumber);
        return new ResponseUtil(0,"find teacher's course",courseRepository.findCourseByCourseTeacher(teacher.getTeacherName()));
    }

}
