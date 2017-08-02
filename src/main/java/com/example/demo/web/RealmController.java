package com.example.demo.web;

import com.example.demo.domain.Realm;
import com.example.demo.service.RealmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ll on 2017/7/31.
 */
@RestController
@RequestMapping("/api")
public class RealmController {
    private final RealmService realmService;

    public RealmController(RealmService realmService) {
        this.realmService = realmService;
    }

    @GetMapping("/getall")
    public List<Realm>  findAll(){
        return realmService.findAll();
    }


}
