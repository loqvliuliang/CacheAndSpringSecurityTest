package com.example.demo.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

/**
 * Created by ll on 2017/7/31.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("alt_realm")
public class Realm {
    @TableId
    protected Long id;
    @TableField(value = "is_enabled", strategy =  FieldStrategy.NOT_NULL)
    protected Boolean isEnabled;
    @TableField(value = "is_deleted",  strategy  = FieldStrategy.NOT_NULL)
    protected Boolean isDeleted;
    protected ZonedDateTime createdDate;
    protected Long createdBy;
    protected ZonedDateTime lastUpdatedDate;
    protected Long lastUpdatedBy;
    private String name;
    private String domainName;

}
