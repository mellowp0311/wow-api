package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.ImmutableMap;
import com.wow.api.constants.DateConstant;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.*;


@Data
@ApiModel(description = "레이드 기간 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RaidPeriod {

    private String raidCode;
    private String raidName;
    private String raidStartDate;
    private String raidStartDay;
    private String raidStartTime;
    private String raidEndDate;
    private String raidEndDay;
    private String raidEndTime;
    private int raidMaxCnt;
    private int raidPeriod;
    private List<Map> betweenDayList;

    public RaidPeriod(){}

    @Builder
    public RaidPeriod(String code, String start, String end){
        this.raidCode = code;
        this.raidStartDate = start;
        this.raidEndDate = end;
    }

    public void refreshCurrentWeekRaidData(RaidPeriod raidPeriod) {
        this.raidStartDate = raidPeriod.getRaidStartDate();
        this.raidStartDay = raidPeriod.getRaidStartDay();
        this.raidStartTime = raidPeriod.getRaidStartTime();
        this.raidEndDate = raidPeriod.getRaidEndDate();
        this.raidEndDay = raidPeriod.getRaidEndDay();
        this.raidEndTime = raidPeriod.getRaidEndTime();
        this.raidMaxCnt = raidPeriod.getRaidMaxCnt();
        this.raidPeriod = raidPeriod.getRaidPeriod();
    }


    public void makeBetweenDayList(){
        if(Objects.isNull(getBetweenDayList())) setBetweenDayList(new ArrayList<>());
        String now = LocalDateTime.now().format(DateConstant.FORMAT_MD);
        for(int i = 0; i < getRaidPeriod(); i++){
            LocalDate date = LocalDate.parse(getRaidStartDate(), DateConstant.FORMAT_YMD).plusDays(i);
            betweenDayList.add(
                    ImmutableMap.builder()
                            .put("day", date.format(DateConstant.FORMAT_MD))
                            .put("isNow", now.equals(date.format(DateConstant.FORMAT_MD)))
                            .put("dayOfWeek", date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN))
                            .build()
            );
        }
    }
}