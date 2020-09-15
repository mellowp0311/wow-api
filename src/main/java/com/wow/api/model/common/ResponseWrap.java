package com.wow.api.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiModel;
import lombok.Data;

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

    private Map<String, Object> getDefaultMeta(){
        return new ImmutableMap.Builder<String, Object>().put("code", 200).put("message", "success").build();
    }


}
