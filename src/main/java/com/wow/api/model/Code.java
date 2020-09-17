package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description = "공통코드 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Code {

    @ApiModelProperty(value = "그룹코드")
    private String groupCode;

    @ApiModelProperty(value = "그룹코드명")
    private String groupName;

    @ApiModelProperty(value = "상세코드")
    private String detailCode;

    @ApiModelProperty(value = "상세코드명")
    private String detailName;

    @ApiModelProperty(value = "설명")
    private String detailDesc;

    @ApiModelProperty(value = "비고1")
    private String refA;

    @ApiModelProperty(value = "비고2")
    private String refB;

    @ApiModelProperty(value = "비고3")
    private String refC;

    @ApiModelProperty(value = "노출순서")
    private int priority;

    @ApiModelProperty(value = "사용여부")
    private String useYn;


}
