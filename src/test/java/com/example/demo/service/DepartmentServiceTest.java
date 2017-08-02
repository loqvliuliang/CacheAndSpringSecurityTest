package com.example.demo.service;

import com.example.demo.domain.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ll on 2017/8/2.
 */

public class DepartmentServiceTest {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectById() throws Exception {
        System.out.print(11);
        Department department =  departmentService.selectById(890494222443569154L);
        System.out.println(department.toString());

    }

}