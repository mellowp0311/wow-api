package com.wow.api.constants;

import java.time.format.DateTimeFormatter;

public class DateConstant {
    public static DateTimeFormatter FORMAT_YMDHMS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter FORMAT_YMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter FORMAT_MD = DateTimeFormatter.ofPattern("MM.dd");
}
