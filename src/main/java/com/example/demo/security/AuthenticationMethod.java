package com.example.demo.security;

import com.example.demo.domain.StatusEnum;
import org.springframework.util.Assert;

/**
 * Created by ll on 2017/7/27.
 */
public enum AuthenticationMethod  implements StatusEnum {
    ENABLED(0),DISABLED(1);
    private int departmentStatus;

    AuthenticationMethod(int departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public static AuthenticationMethod parse(int departmentStatus){
        AuthenticationMethod authenticationMethod = null;
        for (AuthenticationMethod method : AuthenticationMethod.values()) {
            if(departmentStatus == method.getdepartmentStatus()){
                authenticationMethod=method;
            }
        }
        Assert.notNull(authenticationMethod, "AuthenticationMethod[departmentStatus=" + departmentStatus + "] not found");
        return authenticationMethod;

    }

    @Override
    public int getdepartmentStatus() {
        return departmentStatus;
    }
}
