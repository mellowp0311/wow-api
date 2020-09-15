package com.wow.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.nio.charset.StandardCharsets;


@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    public HttpHeaders getDefaultHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8, StandardCharsets.UTF_8);
        httpHeaders.setContentType(mediaType);
        return httpHeaders;
    }

}
