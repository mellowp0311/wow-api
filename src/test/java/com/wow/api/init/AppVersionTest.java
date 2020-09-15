package com.wow.api.init;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class AppVersionTest {

    @Test
    public void test_compare_to() {


        LocalDateTime redis = LocalDateTime.of(2019,2,12,13,00,0);
        LocalDateTime now1  = LocalDateTime.of(2019,2,12,13,00,10);
        LocalDateTime now2  = LocalDateTime.of(2019,2,12,13,05,10);
        LocalDateTime now3  = LocalDateTime.of(2019,2,12,13,30,0);

        System.out.println(Duration.between(redis, now1).toMillis());
        System.out.println(Duration.between(redis, now2).toMillis());
        System.out.println(Duration.between(redis, now3).toMillis());



//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4.2.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4.2"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.2.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.42.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.42.43"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.s.43"));
    }


}
