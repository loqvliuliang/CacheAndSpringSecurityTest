package com.example.demo.service;

import com.example.demo.domain.Department;
import com.example.demo.domain.User;

import java.util.List;

/**
 * Created by ll on 2017/7/28.
 */
public interface UserService {
    //根据UserId查询部门信息
    public Department findDepartmentByUserId(Long userId);
    List<User> findUsersByDepartmentId(Long departmentId);
    User findByName(String name);
}
