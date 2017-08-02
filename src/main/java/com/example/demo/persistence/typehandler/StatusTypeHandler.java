/*
 * Copyright (c) 2017. Shanghai Zhenhui Information Technology Co,. ltd.
 * All rights are reserved.
 */

package com.example.demo.persistence.typehandler;


import com.example.demo.security.AuthenticationMethod;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(AuthenticationMethod.class)
public class StatusTypeHandler extends BaseTypeHandler<AuthenticationMethod>{
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, AuthenticationMethod authenticationMethod, JdbcType jdbcType) throws SQLException {
        if (authenticationMethod != null) {
            preparedStatement.setInt(i,authenticationMethod.getdepartmentStatus());
        }
        else{
            preparedStatement.setString(i, null);
        }
    }

    @Override
    public AuthenticationMethod getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return AuthenticationMethod.parse(resultSet.getInt(s));
    }

    @Override
    public AuthenticationMethod getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return AuthenticationMethod.parse(resultSet.getInt(i));
    }

    @Override
    public AuthenticationMethod getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return AuthenticationMethod.parse(callableStatement.getInt(i));
    }
}
