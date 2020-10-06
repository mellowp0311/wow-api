package com.wow.api.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(description = "공통 응답 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrap<T> {

    private Map<String, Object> meta = new HashMap<>();
    private T data;
    private Map<String, Object> error;

    /**
     * Default constructor
     */
    public ResponseWrap() {
        this.meta = new HashMap<>();
    }
    public ResponseWrap(T data) {
        if(data instanceof Result){
            Result result = (Result) data;
            meta.put("code", result.getCode());
            meta.put("message", result.getMessage());
        } else {
            this.data = data;
            meta.put("code", 200);
            meta.put("message", "success");
        }
    }


    /**
     * 에러 스펙
     */
    public ResponseWrap(int code, String message, int status, String title, String detail, String uri) {
        // 기존 meta 에 추가된 에러 스펙 유지.
        meta.put("code"    , code);
        meta.put("message" , message);

        // 신규 스펙으로 정의 한 errors 에 에러 정보 추가.
        this.error = new HashMap<>();
        error.put("status" , status);
        error.put("title"  , title);
        error.put("detail" , detail);
        error.put("path"   , uri);
    }
    public ResponseWrap(HttpStatus httpStatus, String title, String detail, String uri){
        meta.put("code"    , 500);
        meta.put("message" , httpStatus.name());
        this.error = new HashMap<>();
        error.put("status" , httpStatus.value());
        error.put("title"  , title);
        error.put("detail" , detail);
        error.put("path"   , uri);
    }

}
