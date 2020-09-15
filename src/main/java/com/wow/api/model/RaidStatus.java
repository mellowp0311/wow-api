package com.wow.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel(description = "금주 레이드 기간")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RaidStatus {

    private String raidCode;
    private String raidName;
    private Long characterSeq;
    private String characterName;
    private String characterJobName;
    private String raidCompleteYn;
    private String raidStartDate;
    private String raidTitle;
    private String raidStatus;

}