package org.jaboumal.hoenggermeisterschaft.util;

import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public static String now() {
        return DATE_TIME_FORMATTER.format(java.time.LocalDateTime.now());
    }
}
