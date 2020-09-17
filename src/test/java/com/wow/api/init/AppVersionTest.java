package com.wow.api.init;

import org.junit.Test;

import java.time.LocalDateTime;

public class AppVersionTest {

    @Test
    public void test_compare_to() {

        LocalDateTime sevenStartDt = LocalDateTime.of(2020, 9, 10, 10, 0,0);
        LocalDateTime maxDate = LocalDateTime.of(2021, 12, 31, 23, 59,59);
        System.out.println(sevenStartDt.isBefore(maxDate));

        int count = 0;
        while (sevenStartDt.isBefore(maxDate)){
            count++;
            sevenStartDt = sevenStartDt.plusDays(7);
            System.out.println(sevenStartDt);
        }
        System.out.println(count);



//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4.2.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4.2"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.2.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.42.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.42.43"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.s.43"));
    }


}
