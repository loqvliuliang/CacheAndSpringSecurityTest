package com.example.demo.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Realm;
import com.example.demo.persistence.RealmMapper;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by ll on 2017/7/31.
 */
@Service
public class RealmServiceImpl extends ServiceImpl<RealmMapper,Realm> implements RealmService   {
    private final RealmMapper realmMapper;

    public RealmServiceImpl(RealmMapper realmMapper) {
        this.realmMapper = realmMapper;
    }

    @Override
    public List<Realm> findAll() {
        List<Realm> list = realmMapper.findAll();
        for(Realm realm:list){
            System.out.println(realm.toString());
        }
        return list;
    }
}
