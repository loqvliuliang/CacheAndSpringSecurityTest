package com.example.demo.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ll on 2017/7/27.
 */
@Mapper
public interface UserMapper  extends BaseMapper<User>{

    List<User> selectUsersByDepartmentId(Long departmentId);

    User selectByName(String name);


}
