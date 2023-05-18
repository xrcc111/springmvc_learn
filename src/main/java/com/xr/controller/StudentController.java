package com.xr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xr.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xurui
 * @create 2023-05-17 0:12
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addStudent(Student student) {
        System.out.println(student.toString());
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",student.getName());
        mv.addObject("age",student.getAge());
        mv.addObject("email", student.getEmail());
        mv.addObject("male",student.getMale());
        mv.setViewName("show");
        return mv;
    }

    /*返回String只作为页面跳转视图(注意：不能传入完整路径)*/
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String student() {
        return "student";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void toLogin(HttpServletResponse response, String email, Integer age) throws IOException {
        System.out.println("EMAIL"+email+"----------------AGE"+age);
        Student student = new Student();
        student.setEmail(email);
        student.setAge(age);
        String json = "";
        if(student != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(student);
            System.out.println("student抓换的json" + json);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw =  response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public Student findStudentInfo(String name, String male) {
        Student student = new Student();
        student.setMale("男");
        student.setName("小何");
        return student;
    }

    @RequestMapping(value = "/allStudent",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> findAllStudents(Integer pageNum, Integer pageSize){
        System.out.println(pageNum+"========"+pageSize);
        List<Student> list = new ArrayList<>();
        Student student = new Student("张三",18,"18755603174@163.com","男");
        Student s = new Student("李四",20,"lisi@gmail.com","女");
        list.add(student);
        list.add(s);
        return list;
    }

    /*当返回的是String
     * 1.包含注解@ResponseBody时作为数据
     * 2.不包含时作为视图
     * */
}
