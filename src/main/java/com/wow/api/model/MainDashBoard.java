package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@ApiModel(description = "대시보드 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MainDashBoard {

    @ApiModelProperty(value = "달성률")
    private int achievementRate;

    @ApiModelProperty(value = "금주 레이드 기간")
    private List<RaidPeriod> raidPeriods;


}