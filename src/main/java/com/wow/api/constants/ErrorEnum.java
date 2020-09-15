package com.wow.api.constants;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@Getter
@ApiModel(value = "에러코드 정의")
public enum ErrorEnum {

    /**
     * 1000 ~ 1099: 스펙 관련 에러 정의
     */
    PARAM_INVALID_OS(1000001, "Check the required parameter (osName) information."),
    PARAM_UNKNOWN_OS(1000002, "Check for incorrect parameter (osName) information."),
    PARAM_MALFORMED_APP_VERSION(1000003, "Check for incorrect parameter (appVersion) information.");

    private Integer code;

    private String message;

    ErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
