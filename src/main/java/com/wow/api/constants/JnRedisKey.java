package com.wow.api.constants;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "공통 Header 정보")
public class JnRedisKey {

    public static final String REDIS_HASH_KEY = "init";
    public static final String TOGGLE = "toggle";
    public static final String POPUP  = "popup";
    public static final String APP_VERSION = "appVersion";

}
