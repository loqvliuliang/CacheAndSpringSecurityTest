package com.example.demo;

import com.example.demo.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class Demo1111111ApplicationTests {
	@Autowired
	private  DepartmentService departmentService;

	@Before
	public void before(){

	}

	@Test
	public void contextLoads() {
		System.out.print(11);

	}

}
