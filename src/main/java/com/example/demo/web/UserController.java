package com.example.demo.web;

import com.example.demo.domain.Department;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ll on 2017/7/28.
 */
@Controller
//@RequestMapping("/api")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //根据userId得到部门信息
    @GetMapping("/findDepartmnetByUserId/{userId}")
    public Department findDepartmentByUserId(@PathVariable Long userId){
        Department department = userService.findDepartmentByUserId(userId);
        return department;
    }

    //根据部门ID得到此部门下的所有员工
    @GetMapping("/findUsersByDepartmentId/{departmentId}")
    public List<User> findUsersByDepartmentId(@PathVariable Long departmentId){
        List<User> list = userService.findUsersByDepartmentId(departmentId);
        return list;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @GetMapping("/findByName/{name}")
    public User findByName(@PathVariable String name){
        return userService.findByName(name);
    }
}
