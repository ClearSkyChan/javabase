package com.clearsky.javabase.infrastructure;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.java.OffsetDateTimeJavaDescriptor;
import org.hibernate.type.descriptor.sql.TimeTypeDescriptor;

import java.time.OffsetDateTime;

public class OffsetDateTimeType extends AbstractSingleColumnStandardBasicType<OffsetDateTime> {

    public OffsetDateTimeType() {
        super(TimeTypeDescriptor.INSTANCE, OffsetDateTimeJavaDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "LocalDateString";
    }
}
