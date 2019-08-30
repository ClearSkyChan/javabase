package com.clearsky.javabase.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public  class DbQuery {

    @Autowired
    private JdbcTemplate _jdbcTemplate;

    public  <T> T SelectObject(Class<T> mappedClass,String sql,Object... args){
        T result = _jdbcTemplate.queryForObject(sql,args,new NewBeanPropertyRowMapper<T>(mappedClass));
        return result;
    }

    public  <T> List<T> SelectList(Class<T> mappedClass,String sql, Object... args){
        List<T> results =  _jdbcTemplate.query(sql, args,new NewBeanPropertyRowMapper<T>(mappedClass));
        return results;
    }

    public <T> T SelectValue(Class<T> mappedClass,String sql,Object... args){
        T result = _jdbcTemplate.queryForObject(sql,args,mappedClass);
        return result;
    }
}
