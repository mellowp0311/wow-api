package com.wow.api.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(description = "공통 응답 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private int code;
    private String message;

}
