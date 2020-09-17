package com.wow.api.controller;

import com.wow.api.model.RaidSchedule;
import com.wow.api.model.common.ResponseWrap;
import com.wow.api.model.common.Result;
import com.wow.api.service.RaidService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/raid")
@Api(description = "레이드 API 제공", tags = { "레이드 API - RaidController" })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RaidController {

    private final RaidService raidService;


    @GetMapping("/schedule")
    @ApiOperation(value = "레이드 일정 조회", response = Result.class)
    public ResponseWrap<Result> addRaidSchedule(@RequestParam(value = "userSeq") @ApiParam(value = "계정 시퀀스", example = "1") Long userSeq,
                                                @RequestParam(value = "characterSeq") @ApiParam(value = "케릭터 시퀀스", example = "3") Long characterSeq,
                                                @RequestParam(value = "raidCode") @ApiParam(value = "레이드 코드", example = "BL") String raidCode,
                                                @RequestParam(value = "searchDate") @ApiParam(value = "조회 날짜", example = "2020-09-15 12:00:00") String searchDate){
        return new ResponseWrap(raidService.searchRaidSchedule(userSeq, characterSeq, raidCode, searchDate));
    }


    @PostMapping("/schedule/add")
    @ApiOperation(value = "레이드 일정 등록", response = Result.class)
    public ResponseWrap<Result> addRaidSchedule(@RequestBody RaidSchedule raidSchedule){
        return new ResponseWrap(raidService.addRaidSchedule(raidSchedule));
    }

    @PutMapping("/schedule/modify")
    @ApiOperation(value = "레이드 일정 수정", response = Result.class)
    public ResponseWrap<Result> modifyRaidSchedule(@RequestBody RaidSchedule raidSchedule){
        return new ResponseWrap(raidService.modifyRaidSchedule(raidSchedule));
    }

    @DeleteMapping("/schedule/remove/{raidScheduleSeq}")
    @ApiOperation(value = "레이드 일정 삭제", response = Result.class)
    public ResponseWrap<Result> removeRaidSchedule(@PathVariable("raidScheduleSeq") Long raidScheduleSeq){
        return new ResponseWrap(raidService.removeRaidSchedule(raidScheduleSeq));
    }

}
