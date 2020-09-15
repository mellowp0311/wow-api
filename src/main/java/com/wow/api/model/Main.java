package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;


@Data
@ApiModel(description = "유저 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Main {

    @ApiModelProperty(value = "")
    private Object weekly;



}