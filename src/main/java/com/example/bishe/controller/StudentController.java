package com.example.bishe.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.example.bishe.dao.LoginUserRepository;
import com.example.bishe.dao.StudentRepository;
import com.example.bishe.entity.LoginUser;
import com.example.bishe.entity.Student;
import com.example.bishe.service.StudentService;
import com.example.bishe.utils.ExcelUtils;
import com.example.bishe.utils.ResponseUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Resource
    private StudentService studentService;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private LoginUserRepository loginUserRepository;

    @RequestMapping(value = "all",method = RequestMethod.GET)
    public ResponseUtil getAllStudent(){
        return new ResponseUtil(0,"find all student",studentService.findAllStudent());
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.POST)
    public ResponseUtil deleteOneStudent(@RequestParam Integer studentId){
        return new ResponseUtil(0,"delete one student",studentService.deleteOneStudent(studentId));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponseUtil updateStudentInfo(@RequestBody Student student){
        return new ResponseUtil(0,"update success",studentService.updateOneStudent(student));
    }

    @RequestMapping(value = "searchOne", method = RequestMethod.POST)
    public ResponseUtil findOneStudentByNumber(@RequestParam String studentNumber){
        return new ResponseUtil(0,"find a student",studentService.findStudentByNumber(studentNumber));
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
            ExcelImportResult<Student> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Student.class,
                    importParams);

            List<Student> successList = result.getList();
            for (Student demoExcel : successList) {
                System.out.println(demoExcel);
                studentRepository.save(demoExcel);

                LoginUser loginUser = new LoginUser();
                loginUser.setLoginAccount(demoExcel.getStudentNumber());
                loginUser.setLoginPassword(demoExcel.getStudentNumber());
                loginUser.setLoginIdentity("student");
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
        List<Student> personList = studentRepository.findAll();
//         导出操作
        ExcelUtils.exportExcel(personList, "学生信息", "学生信息", Student.class, "测试.xls", response);

    }
}
