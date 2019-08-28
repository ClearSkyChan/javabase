package com.clearsky.javabase.Infrastructure;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public  class DbQuery {

    public  <T> List<T> Select(String sql, Object... args){
        List<T> results = new ArrayList<T>();
        return results;
    }
}
