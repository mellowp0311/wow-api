package com.wow.api.constants;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public enum OsEnum {


    ANDROID(1, 1, "android"),
    IOS(2, 1, "iOS"),
    FRONT(3, 2, "front"),
    UNKNOWN(99, 99, "unknown");


    @ApiModelProperty("운영체제 타입(안드로이드/아이폰/웹)코드")
    private int typeCode;

    @ApiModelProperty("운영체제 타입(앱/프론트) 코드")
    private int deviceCode;

    @ApiModelProperty("운영체제 명")
    private String name;

    OsEnum(int typeCode, int deviceCode, String name){
        this.typeCode = typeCode;
        this.deviceCode = deviceCode;
        this.name = name;
    }


}
