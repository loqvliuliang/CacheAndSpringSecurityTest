package com.example.demo.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.Realm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ll on 2017/7/31.
 */
@Mapper
public interface RealmMapper extends BaseMapper<Realm>{
    List<Realm> findAll();
}
