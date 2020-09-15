package com.wow.api.controller;

import com.wow.api.model.RaidSchedule;
import com.wow.api.model.common.ResponseWrap;
import com.wow.api.model.common.Result;
import com.wow.api.service.RaidService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/raid")
@Api(description = "공격대 API 제공", tags = { "공격대 API - RaidController" })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RaidController {

    private final RaidService raidService;


    @PostMapping("/schedule")
    @ApiOperation(value = "레이드 일정 등록", response = Result.class)
    public ResponseWrap<Result> addRaidSchedule(@RequestBody RaidSchedule raidSchedule){
        return new ResponseWrap(raidService.addRaidSchedule(raidSchedule));
    }

    @PutMapping("/schedule")
    @ApiOperation(value = "레이드 일정 수정", response = Result.class)
    public ResponseWrap<Result> modifyRaidSchedule(@RequestBody RaidSchedule raidSchedule){
        return new ResponseWrap(raidService.modifyRaidSchedule(raidSchedule));
    }

    @DeleteMapping("/schedule/{raidScheduleSeq}")
    @ApiOperation(value = "레이드 일정 삭제", response = Result.class)
    public ResponseWrap<Result> removeRaidSchedule(@PathVariable("raidScheduleSeq") Long raidScheduleSeq){
        return new ResponseWrap(raidService.removeRaidSchedule(raidScheduleSeq));
    }

}
