package com.wow.api.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(description = "공통 응답 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrap<T> {

    private Map<String, Object> meta;
    private T data;
    private Map<String, Object> error;

    /**
     * Default constructor
     */
    public ResponseWrap() {

    }

    public ResponseWrap(T data) {
        this.data = data;
    }


    /**
     * 에러 스펙
     *
     * @param code
     * @param message
     * @param status
     * @param title
     * @param detail
     * @param uri
     */
    public ResponseWrap(int code, String message, int status, String title, String detail, String uri) {
        // 기존 meta 에 추가된 에러 스펙 유지.
        this.meta = new HashMap<>();
        meta.put("code"    , code);
        meta.put("message" , message);

        // 신규 스펙으로 정의 한 errors 에 에러 정보 추가.
        this.error = new HashMap<>();
        error.put("status" , status);
        error.put("title"  , title);
        error.put("detail" , detail);
        error.put("path"   , uri);
    }


    private Map<String, Object> getDefaultMeta(){
        return new ImmutableMap.Builder<String, Object>().put("code", 200).put("message", "success").build();
    }


}
