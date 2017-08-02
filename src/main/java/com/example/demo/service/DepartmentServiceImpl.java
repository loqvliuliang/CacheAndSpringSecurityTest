package com.example.demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Department;
import com.example.demo.persistence.DepartmentMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ll on 2017/7/27.
 */
@Service
@CacheConfig(cacheNames = "departments")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department> implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public int insertDepartment(Department department){
        return departmentMapper.insert(department);
    }

    @Override
    @CacheEvict(allEntries = true)
    public Department selectById(Long id) {
        Department department = departmentMapper.selectById(id);
        return department;
    }


    @Override
//    @Cacheable(keyGenerator = "baseCacheKeyGenerator")
    @Cacheable
    public List<Department> seachDepartment(int page, int pageSize) {
        List<Department> list = departmentMapper.selectPage(new Page<Department>(page,pageSize),new EntityWrapper<>());
        return list;
    }


    public void test(){
        Department department = new Department();
        departmentMapper.update(department, new Wrapper<Department>() {
            @Override
            public String getSqlSegment() {
                return null;
            }
        });
    }

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public void insertDepartment(){
        Department department = new Department();
        department.setName("123");
        try{
            departmentMapper.insert(department);
        }catch (Exception e){
            throw new IllegalArgumentException(department.getName()+"已经存在！存入的数据回滚！");
        }
    }
}
