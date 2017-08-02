package com.example.demo.web;

import com.baomidou.mybatisplus.activerecord.Model;
import com.example.demo.domain.Department;
import com.example.demo.service.DepartmentService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ll on 2017/7/27.
 */
@RestController
@RequestMapping("/api")
public class DepartmnetController {
    private final DepartmentService departmentService;
    public DepartmnetController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //插入部门数据
    @PostMapping("/insertDepartment")
    public int insertDepartment(@RequestBody Department department){
        System.out.println(department);
        int i  = departmentService.insertDepartment(department);
        return i;
    }

    //根据ID得到相应部门信息
    @GetMapping("/selectDepartmentById")
    @PreAuthorize("hasRole('ADMIN')")
    public Department getDepartmentById(@RequestParam Long id) {
        Department department = departmentService.selectById(id);
        return department;
    }


    @GetMapping("/test/Transactional")
    public void test1(){

        departmentService.insertDepartment();
    }


    //分页查询
    @GetMapping("/departments")
    public List<Department> getDepartments(@RequestParam int page,@RequestParam int pageSize){
        List<Department> list = departmentService.seachDepartment(page,pageSize);
        return list;
    }
}
