package com.wow.api.exception;

import com.wow.api.constants.ErrorEnum;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CustomException extends RuntimeException {

    private List arguments = new ArrayList();

    public ErrorEnum errorEnum;

    public CustomException(ErrorEnum errorEnum, Object... message){
        this.errorEnum = errorEnum;
        this.arguments.add(message);
    }

}
