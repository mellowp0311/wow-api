package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
@ApiModel(description = "케릭별 레이드 달성률 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterRate {

    @ApiModelProperty(value = "케릭터 시퀀스")
    private Long characterSeq;

    @ApiModelProperty(value = "사용자 시퀀스")
    private Long userSeq;

    @ApiModelProperty(value = "케릭터 명")
    private String characterName;

    @ApiModelProperty(value = "케릭터 직업 코드")
    private String characterJob;

    @ApiModelProperty(value = "케릭터 직업 코드명")
    private String characterJobName;

    private List<RaidStatus> raidStatusList;



}
