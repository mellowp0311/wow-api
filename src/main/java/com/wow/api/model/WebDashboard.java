package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.api.model.dashboard.RaidCharacter;
import com.wow.api.model.dashboard.RaidType;
import com.wow.api.model.dashboard.Todo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@ApiModel(description = "대시보드 정보")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebDashboard {

    @ApiModelProperty(value = "레이드 기간정보")
    private RaidType raidType;

    @ApiModelProperty(value = "내 케릭터 리스트")
    private List<Character> characterList;

    @ApiModelProperty(value = "케릭터 정보")
    private List<Todo> todoList;

    @ApiModelProperty(value = "내 케릭터 레이드 현황 리스트")
    private List<RaidCharacter> raidParticipateList;

}
