package com.wow.api.controller;

import com.wow.api.model.Code;
import com.wow.api.model.common.ResponseWrap;
import com.wow.api.service.CoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/core")
@Api(description = "코어 API 제공", tags = { "코어 API - CoreController" })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CoreController {

    private final String authKey = "eowkdrnsxkdnfps12#";

    private final CoreService coreService;


    @GetMapping("/code")
    @ApiOperation(value = "그룹코드 목록 조회")
    public ResponseWrap<List<Code>> addRaidInitPerDay(){
        return new ResponseWrap(coreService.searchGroupCodeList());
    }

    @GetMapping("/code/{groupCode}")
    @ApiOperation(value = "상세코드 목록 조회")
    public ResponseWrap<List<Code>> detailCodeList(@PathVariable(value = "groupCode") String groupCode){
        return new ResponseWrap(coreService.searchDetailCodeList(groupCode));
    }

    @GetMapping("/code/{groupCode}/{detailCode}")
    @ApiOperation(value = "상세코드 조회")
    public ResponseWrap<Code> addRaidInitPerDay(@PathVariable(value = "groupCode") String groupCode,
                                                @PathVariable(value = "detailCode") String detailCode){
        return new ResponseWrap(coreService.searchDetailCode(groupCode, detailCode));
    }


}
