package com.wow.api.model.dashboard;

import com.wow.api.model.RaidSchedule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "대시보드 정보")
public class RaidCharacter {

    @ApiModelProperty(value = "사용자 시퀀스")
    private Long userSeq;

    @ApiModelProperty(value = "케릭터 시퀀스")
    private Long characterSeq;

    @ApiModelProperty(value = "케릭터 명")
    private String characterName;

    @ApiModelProperty(value = "안퀴사원")
    private RaidSchedule at;

    @ApiModelProperty(value = "안퀴폐허")
    private RaidSchedule ar;

    @ApiModelProperty(value = "화산심장부")
    private RaidSchedule mc;

    @ApiModelProperty(value = "검은날개둥지")
    private RaidSchedule bl;

    @ApiModelProperty(value = "오닉시아")
    private RaidSchedule ox;

    @ApiModelProperty(value = "줄구룹")
    private RaidSchedule zg;

    @ApiModelProperty(value = "총 수입")
    private int totalProfit;

    @ApiModelProperty(value = "총 지출")
    private int totalExpense;

}
