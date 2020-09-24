package com.wow.api.init;

import com.google.common.collect.ImmutableMap;
import com.wow.api.constants.DateConstant;
import com.wow.api.model.RaidPeriod;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppVersionTest {

    @Test
    public void test_compare_to() {
        RaidPeriod raidPeriod = new RaidPeriod();
        raidPeriod.setRaidStartDate("2020-09-21");
        raidPeriod.setRaidPeriod(3);
        aaaa(raidPeriod);
    }

    private void aaaa(RaidPeriod raidPeriod){
        String day = "";
        String now = LocalDateTime.now().format(DateConstant.FORMAT_MD);
        List<Map<String, Object>> dayList = new ArrayList<>();
        for(int i = 0; i < raidPeriod.getRaidPeriod(); i++){
            LocalDate date = LocalDate.parse(raidPeriod.getRaidStartDate(), DateConstant.FORMAT_YMD).plusDays(i);
            boolean isNow = now.equals(date.format(DateConstant.FORMAT_MD));
            System.out.println(ImmutableMap.builder().put("day", date.format(DateConstant.FORMAT_MD)).put("isNow", isNow).build());
            ;
        }

    }


}
