package com.wow.api.exception;

import com.wow.api.constants.ErrorEnum;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class CustomException extends RuntimeException {

    /**
     * 로그 파라미터 리스트
     *
     */
    private List arguments = new ArrayList();

    /**
     * 에러 정의 정보
     *
     */
    public ErrorEnum errorEnum;

    /**
     * 생성자
     *
     * @param errorEnum
     * @param message
     */
    public CustomException(ErrorEnum errorEnum, Object... message){
        this.errorEnum = errorEnum;
        this.arguments.add(message);
    }

}
