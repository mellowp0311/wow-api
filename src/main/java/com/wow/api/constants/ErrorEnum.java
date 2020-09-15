package com.wow.api.constants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.Optional;

@Getter
@ApiModel(value = "에러코드 정의")
public enum ErrorEnum {

    USER_LOGIN_INVALID (
            1000,
            true,
            "아이디 및 패스워드를 확인하여 주십시오.",
            "Please check your ID and password. userId: {}"
    ),
    RAID_ALREADY_PARTICIPATE (
            3001,
            true,
            "해당 레이드는 이미 참여했습니다.",
            "The raid has already participated. raidCode: {}, characterSeq: {}"
    )

    ;

    @ApiModelProperty(value = "에러코드")
    private int code;

    @ApiModelProperty(value = "프로트/앱 반환용 에러 메시지")
    private String korMessage;

    @ApiModelProperty(value = "에러로그 파라미터 정보 존재 여부")
    private Boolean isMessageParam;

    @ApiModelProperty(value = "키바나 에러로그 메시지")
    private String engMessage;

    ErrorEnum(int code, Boolean isParam, String korMessage, String engMessage) {
        this.code = code;
        this.isMessageParam = Optional.ofNullable(isParam).orElse(false);
        this.korMessage = korMessage;
        this.engMessage = engMessage;
    }


}
