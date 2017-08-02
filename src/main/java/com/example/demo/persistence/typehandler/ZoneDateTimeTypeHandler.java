package com.example.demo.persistence.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by ll on 2017/7/27.
 */
@MappedTypes(ZonedDateTime.class)//描述哪些类可以被拦截
public class ZoneDateTimeTypeHandler extends BaseTypeHandler<ZonedDateTime> {

    //重新定义往数据库里面写数据的类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, ZonedDateTime zonedDateTime, JdbcType jdbcType) throws SQLException {
        preparedStatement.setTimestamp(
                i,
                Timestamp.from(zonedDateTime.toInstant()),
                GregorianCalendar.from(zonedDateTime)
        );
    }


    //下面三个方法定义读出来数据类型转换
    @Override
    public ZonedDateTime getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Timestamp ts = resultSet.getTimestamp(s, Calendar.getInstance());
        if (ts != null) {
            return ZonedDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }

    @Override
    public ZonedDateTime getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Timestamp ts = resultSet.getTimestamp(i, Calendar.getInstance());
        if (ts != null) {
            return ZonedDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }

    @Override
    public ZonedDateTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Timestamp ts = callableStatement.getTimestamp(i, Calendar.getInstance());
        if (ts != null) {
            return ZonedDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }
}
