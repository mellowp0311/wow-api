package com.wow.api.model.dashboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "메모 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {

    @ApiModelProperty(value = "레이드 기간정보")
    private String content;
    private String regDate;
    private boolean isCompleted;

}
