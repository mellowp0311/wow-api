package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;


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
}