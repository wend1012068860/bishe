package com.example.bishe.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.example.bishe.dao.LoginUserRepository;
import com.example.bishe.dao.TeacherRepository;
import com.example.bishe.entity.LoginUser;
import com.example.bishe.entity.Student;
import com.example.bishe.entity.Teacher;
import com.example.bishe.service.TeacherService;
import com.example.bishe.utils.ExcelUtils;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private TeacherRepository teacherRepository;
    @Resource
    private LoginUserRepository loginUserRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseUtil getAllTeacher(){
        return new ResponseUtil(0,"find all teacher",teacherService.findAllTeacher());
    }

    @RequestMapping(value = "deleteOne", method = RequestMethod.POST)
    public ResponseUtil deleteOneTeacher(@RequestParam Integer teacherId){
        return new ResponseUtil(0,"delete one success",teacherService.deleteTeacher(teacherId));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponseUtil updateTeacherInfo(@RequestBody Teacher teacher){
        return new ResponseUtil(0,"update success",teacherService.updateTeacher(teacher));
    }

    @RequestMapping(value = "searchOne",method = RequestMethod.POST)
    public ResponseUtil searchOneTeacher(@RequestParam String teacherNumber){
        return new ResponseUtil(0,"search one teacher info",teacherService.findTeacherByNumber(teacherNumber));
    }

    @PostMapping("/importExcel")
    public void importExcel2(@RequestParam("file") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);

        // 需要验证
        importParams.setNeedVerfiy(true);

        try {
            ExcelImportResult<Teacher> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Teacher.class,
                    importParams);

            List<Teacher> successList = result.getList();
            for (Teacher demoExcel : successList) {
                System.out.println(demoExcel);
                teacherRepository.save(demoExcel);

                LoginUser loginUser = new LoginUser();
                loginUser.setLoginAccount(demoExcel.getTeacherNumber());
                loginUser.setLoginPassword(demoExcel.getTeacherNumber());
                loginUser.setLoginIdentity("teacher");
                loginUserRepository.save(loginUser);
            }
        } catch (IOException e) {
        } catch (Exception e) {
        }
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        System.out.println(1);
//        模拟从数据库获取需要导出的数据
        List<Teacher> personList = teacherRepository.findAll();
//         导出操作
        ExcelUtils.exportExcel(personList, "教师信息", "教师信息", Teacher.class, "教师信息.xls", response);

    }
}
