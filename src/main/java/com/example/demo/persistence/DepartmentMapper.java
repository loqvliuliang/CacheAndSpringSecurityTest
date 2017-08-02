package com.example.demo.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by ll on 2017/7/27.
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department>{

}
