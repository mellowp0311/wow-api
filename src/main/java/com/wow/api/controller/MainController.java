package com.wow.api.controller;

import com.wow.api.model.MainDashBoard;
import com.wow.api.model.common.ResponseWrap;
import com.wow.api.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/main")
@Api(description = "메인 API 제공", tags = { "메인(홈) API - MainController" })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {

    private final MainService mainService;


    @GetMapping("/current-week")
    @ApiOperation(value = "금주 대시보드 조회", response = MainDashBoard.class)
    public ResponseWrap mainDashboard(@RequestParam(value = "userSeq") @ApiParam(value = "계정 시퀀스", example = "1") Long userSeq){
        return new ResponseWrap(mainService.searchMainDashboard(userSeq));
    }

    @GetMapping("/current-week/detail")
    @ApiOperation(value = "금주 레이드 달성률 상세 조회", response = MainDashBoard.class)
    public ResponseWrap achievementRate(@RequestParam(value = "userSeq") @ApiParam(value = "계정 시퀀스", example = "1") Long userSeq){
        return new ResponseWrap(mainService.searchAchievementRate(userSeq));
    }

}
