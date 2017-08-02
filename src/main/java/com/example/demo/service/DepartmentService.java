package com.example.demo.service;

import com.example.demo.domain.Department;
import com.example.demo.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by ll on 2017/7/27.
 */
@CacheConfig(cacheNames = "departments")
public interface DepartmentService  {
    @CachePut(key = "#p0.name")
    int insertDepartment(Department department);
    @Cacheable(key = "#p0")
    Department selectById(Long id);
    List<Department> seachDepartment(int page,int pageSize);
    void insertDepartment();
}
