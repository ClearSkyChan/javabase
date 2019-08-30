package com.clearsky.javabase.infrastructure;

import java.time.*;
import java.util.Date;

public class DateUtil {

    public static Date ToDate(LocalDate localDate){
        ZoneId zoneID = ZoneId.of("+08:00");
        ZonedDateTime zdt = localDate.atStartOfDay(zoneID);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    public static OffsetDateTime toOffsetDateTime(Date date) {
        ZoneId zoneID = ZoneId.of("+08:00");
        Instant instant = date.toInstant() ;
        OffsetDateTime offsetDatetime = OffsetDateTime.ofInstant(instant, zoneID);
        return offsetDatetime;
    }

}
