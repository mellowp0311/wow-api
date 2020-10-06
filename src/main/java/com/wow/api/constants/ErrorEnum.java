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
    USER_INSERT_FAIL (
            1000,
            true,
            "아이디 및 패스워드를 확인하여 주십시오.",
            "Please check your ID and password. userId: {}"
    ),
    ALREADY_REGISTERED_ID (
            1000,
            true,
            "이미 회원가입된 사용자 아이디 입니다.",
            "This is a user ID that has already been registered. userId: {}"
    ),
    USER_ID_IS_SHORT (
            1000,
            true,
            "계정 아이디는 6글자 이상으로 설정해 주세요.",
            "Please set the account ID to at least 6 characters. userId: {}"
    ),
    USER_PASSWORD_IS_SHORT(
            1000,
            true,
            "계정 패스워드는 6글자 이상으로 설정해 주세요.",
            "Please set the account password to at least 6 characters. userId: {}"
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
