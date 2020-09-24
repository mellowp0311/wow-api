package com.wow.api.model.dashboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.api.model.RaidPeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "대시보드 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RaidType {

    @ApiModelProperty(value = "안퀴라즈사원")
    private RaidPeriod at;

    @ApiModelProperty(value = "안퀴라즈폐허")
    private RaidPeriod ar;

    @ApiModelProperty(value = "오닉시아")
    private RaidPeriod ox;

    
}
