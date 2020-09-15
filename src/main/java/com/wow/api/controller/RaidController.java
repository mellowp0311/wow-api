package com.wow.api.controller;

import com.wow.api.model.RaidSchedule;
import com.wow.api.service.RaidService;
import com.wow.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/raid")
@Api(description = "공격대 API 제공", tags = { "공격대 API - RaidController" })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RaidController {

    private final RaidService raidService;


    @PostMapping("/schedule")
    @ApiOperation(value = "레이드 일정 등록", response = Boolean.class)
    public void addRaidSchedule(@RequestBody RaidSchedule raidSchedule){
        raidService.addRaidSchedule(raidSchedule);
    }

    @PutMapping("/schedule")
    @ApiOperation(value = "레이드 일정 수정", response = Boolean.class)
    public void modifyRaidSchedule(@RequestBody RaidSchedule raidSchedule){
        raidService.modifyRaidSchedule(raidSchedule);
    }

    @DeleteMapping("/schedule/{raidScheduleSeq}")
    @ApiOperation(value = "레이드 일정 삭제", response = Boolean.class)
    public void removeRaidSchedule(@PathVariable("raidScheduleSeq") Long raidScheduleSeq){
        raidService.removeRaidSchedule(raidScheduleSeq);
    }

}
