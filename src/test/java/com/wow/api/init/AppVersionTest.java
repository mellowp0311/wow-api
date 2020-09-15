package com.wow.api.init;

import org.junit.Test;

public class AppVersionTest {

    @Test
    public void test_compare_to() {

        int total = 24;
        int character_count = 22;
        int character = 4;
//        System.out.println(Math.round((count) * character) / character);
        System.out.println( (total / character_count) * 100 );
        System.out.println( (double) character_count / (double) total * 100 );
        System.out.println( Math.round((double) character_count / (double) total * 100));



//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4.2.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4.2"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("4"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.2.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.42.3"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.42.43"));
//        System.out.println(AppVersionUtil.isBadNumberAppVersion("44.s.43"));
    }


}
