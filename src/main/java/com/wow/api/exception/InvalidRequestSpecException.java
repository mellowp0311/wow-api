package com.wow.api.exception;

import lombok.Getter;

/**
 * 정해진 스펙에 맞지 않을 경우에 발생하는 예외.
 */
public class InvalidRequestSpecException extends RuntimeException {

    @Getter
    private final String message;

    @Getter
    private final String logMessage;

    public InvalidRequestSpecException(String message, String logMessage) {
        this.message = message;
        this.logMessage = logMessage;
    }
}
