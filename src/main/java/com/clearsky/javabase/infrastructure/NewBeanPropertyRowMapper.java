package com.clearsky.javabase.infrastructure;

import com.alibaba.druid.util.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class NewBeanPropertyRowMapper<T> extends BeanPropertyRowMapper<T> {

    //Contains valid true values
    public static final Set<String> TRUE_SET = new HashSet<String>(Arrays.asList("y", "yes", "true"));
    private final Class<?> clazz;

    public NewBeanPropertyRowMapper(Class<T> mappedClass) {
        super(mappedClass);
        clazz = mappedClass;
    }

    protected Object getColumnValue(ResultSet rs, int index,
                                    PropertyDescriptor pd) throws SQLException {
        Class<?> requiredType = pd.getPropertyType();


        //将Y/N等映射到boolean
        if (boolean.class.equals(requiredType) || Boolean.class.equals(requiredType)) {
            String stringValue = rs.getString(index);
            if(!StringUtils.isEmpty(stringValue) && TRUE_SET.contains(stringValue.toLowerCase())){
                return true;
            }
            else return false;
        }
        //将Date映射到OffsetDateTime
        if(OffsetDateTime.class.equals(requiredType)){
            Timestamp timestamp = rs.getTimestamp(index);
            if(timestamp==null){
                return null;
            }
            String zonId="+08:00";
            Field[] fields =  clazz.getDeclaredFields();
            for(Field field : fields){
                String n1 = pd.getName();
                String n2 = field.getName();
                if(n1.equals(n2)){
                    Annotation[] anos = field.getAnnotations();
                    Zone zone = field.getAnnotation(Zone.class);
                    zonId =  zone.id();
                }
            }
            ZoneId zoneID = ZoneId.of(zonId);
            OffsetDateTime offsetDatetime = OffsetDateTime.ofInstant(timestamp.toInstant(), zoneID);
            return offsetDatetime;
        }
        return super.getColumnValue(rs, index, pd);
    }
}
