package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description = "공격대 일정 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RaidSchedule {

    @ApiModelProperty(value = "공격대 일정 시퀀스")
    private Long raidScheduleSeq;

    @ApiModelProperty(value = "공격대 참여 케릭터 시퀀스")
    private Long characterSeq;

    @ApiModelProperty(value = "던전 코드")
    private String dungeonCode;

    @ApiModelProperty(value = "공격대 타이틀")
    private String raidTitle;

    @ApiModelProperty(value = "공격대장 케릭터 명")
    private String raidCaptainCharacter;

    @ApiModelProperty(value = "공격대 초대 케릭터 명")
    private String raidInviteCharacter;

    @ApiModelProperty(value = "공격대 초대 일시")
    private String raidInviteDate;

    @ApiModelProperty(value = "공격대 진입 일시")
    private String raidStartDate;

    @ApiModelProperty(value = "공격대 종료 일시")
    private String raidClearDate;

    @ApiModelProperty(value = "메모")
    private String memo;

    @ApiModelProperty(value = "수익금")
    private int proceeds;

    @ApiModelProperty(value = "수정 일시")
    private String updDate;

    @ApiModelProperty(value = "등록 일시")
    private String regDate;


}
