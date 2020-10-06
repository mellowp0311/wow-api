package com.wow.api.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wow.api.constants.ErrorEnum;
import com.wow.api.exception.CustomException;
import com.wow.api.model.common.ResponseWrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    private final String commonLogFormatter = "<{} : {}> {} , uri: {}?{}";
    private final HttpStatus unprocessable = HttpStatus.UNPROCESSABLE_ENTITY;


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handlerCustomException(CustomException ex, HttpServletRequest req) {
        return new ResponseEntity<>(
                makeResponseWrap(ex.getErrorEnum(), ex.getClass().getName(), ex.getArguments(), req.getRequestURI(), req.getQueryString()),
                getDefaultHttpHeaders(), unprocessable
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerException(Exception ex, HttpServletRequest req) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        log.error(commonLogFormatter, 500, ex.getClass().getName(), ex.getLocalizedMessage(), req.getRequestURI(), req.getQueryString());
        return new ResponseEntity<>(
                new ResponseWrap<>(httpStatus, ex.getClass().getName(), ex.getLocalizedMessage(), req.getRequestURI()),
                getDefaultHttpHeaders(), httpStatus
        );
    }

    private ResponseWrap makeResponseWrap(ErrorEnum errorEnum, String exception, List arguments, String uri, String query){
        int code = errorEnum.getCode();
        String kor = errorEnum.getKorMessage();
        String eng = makeLogEngMessage(errorEnum.getIsMessageParam(), errorEnum.getEngMessage(), arguments);
        String uriStr = Objects.isNull(uri) ? "" : uri;
        log.error(commonLogFormatter, code, kor, eng, uriStr, query);
        return new ResponseWrap(code, kor, unprocessable.value(), exception, eng, uri);
    }


    public HttpHeaders getDefaultHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8, StandardCharsets.UTF_8);
        httpHeaders.setContentType(mediaType);
        return httpHeaders;
    }



    /**
     * 에러로그 데이터 반환
     *
     * @param arguments
     * @return
     */
    private String makeLogEngMessage(boolean isMessageParam, String engMsg, List arguments){
        ObjectMapper mapper = new ObjectMapper();
        if(isMessageParam  && arguments.size() < 1) return engMsg;
        String content = engMsg;
        Matcher matcher = Pattern.compile("\\{+}").matcher(engMsg);
        for( Object argument : arguments ){
            if( matcher.find() ) {
                try {
                    content = content.replace(matcher.group(), mapper.writeValueAsString(argument));
                } catch (JsonProcessingException e) {
                    content = content.replace(matcher.group(), "?");
                }
            }
        }
        return content;
    }


}
