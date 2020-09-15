package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;


@Data
@ApiModel(description = "유저 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @ApiModelProperty(value = "계정 시퀀스")
    private Long userSeq;

    @ApiModelProperty(value = "계정 아이디")
    private String userId;

    @ApiModelProperty(value = "계정 패스워드")
    private String userPassword;

    @ApiModelProperty(value = "계정 상태")
    private String userStatus;

    public User(){}

    @Builder
    public User(String userId, String userPassword){
        this.userId = userId;
        this.userPassword = userPassword;
    }

}
