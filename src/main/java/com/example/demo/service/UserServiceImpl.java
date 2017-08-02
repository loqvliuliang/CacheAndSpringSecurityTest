package com.example.demo.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Department;
import com.example.demo.domain.User;
import com.example.demo.persistence.DepartmentMapper;
import com.example.demo.persistence.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ll on 2017/7/28.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    private final UserMapper userMapper;
    private final DepartmentMapper departmentMapper;

    public UserServiceImpl(UserMapper userMapper, DepartmentMapper departmentMapper) {
        this.userMapper = userMapper;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Department findDepartmentByUserId(Long userId) {
        System.out.println(userId);
        //先在user表里通过userId查询departmentId
        User user = userMapper.selectById(userId);
        //再在department中查询department信息
        Department department = departmentMapper.selectById(user.getDepartmentId());
        return department;
    }

    @Override
    public List<User> findUsersByDepartmentId(Long departmentId) {

        List<User> list = userMapper.selectUsersByDepartmentId(departmentId);
        return list;
    }

    @Override
    public User findByName(String name) {

        return userMapper.selectByName(name);
    }


}
