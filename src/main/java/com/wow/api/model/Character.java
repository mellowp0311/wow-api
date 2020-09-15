package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description = "케릭터 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Character {

    @ApiModelProperty(value = "케릭터 시퀀스")
    private Long characterSeq;

    @ApiModelProperty(value = "사용자 시퀀스")
    private Long userSeq;

    @ApiModelProperty(value = "서버 코드")
    private String serverCode;

    @ApiModelProperty(value = "서버 코드명")
    private String serverCodeName;

    @ApiModelProperty(value = "종족 코드")
    private String tribeCode;

    @ApiModelProperty(value = "종족 코드명")
    private String tribeCodeName;

    @ApiModelProperty(value = "케릭터 명")
    private String characterName;

    @ApiModelProperty(value = "케릭터 직업 코드")
    private String characterJob;

    @ApiModelProperty(value = "케릭터 직업 코드명")
    private String characterJobName;

    @ApiModelProperty(value = "케릭터 포지션")
    private String characterPosition;

    @ApiModelProperty(value = "케릭터 포지션명")
    private String characterPositionName;

    @ApiModelProperty(value = "길드 시퀀스")
    private Long guildSeq;

    @ApiModelProperty(value = "길드 명")
    private String guildName;

    @ApiModelProperty(value = "첫번째 전문기술")
    private String firstExpertise;

    @ApiModelProperty(value = "두번째 전문기술")
    private String secondExpertise;

}
