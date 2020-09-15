package com.wow.api.constants;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "공통 Header 정보")
public class JnHeaderKey {

    public static final String JN_CLIENT_IP = "jn-clientIp";
    public static final String JN_USER_SEQ = "jn-userSeq";
    public static final String JN_STORE_SEQ = "jn-storeSeq";
    public static final String JN_TOKEN = "jn-token";
    public static final String JN_CHANGE_DT = "jn-lastPasswordResetDate";
    public static final String JN_OS_NAME = "jn-osName";
    public static final String JN_APP_VERSION = "jn-appVersion";
    public static final String JN_OS_VERSION = "jn-osVersion";
    public static final String JN_APP_NAME = "jn-appName";


}
