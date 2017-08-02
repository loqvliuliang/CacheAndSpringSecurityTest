package com.example.demo.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.example.demo.security.AuthenticationMethod;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by ll on 2017/7/27.
 */

@Data
@TableName("alt_department")
public class Department  implements Serializable{
    private static final long serialVersionUID = -4057268048980805940L;
    @TableId
    private Long id;
    private String name;
    private String code;
    private int status;
//    private Date createDate;
    private ZonedDateTime createDate;
    private AuthenticationMethod authenticationMethod;
}
