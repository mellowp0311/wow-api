package com.wow.api.controller;

import com.wow.api.model.Character;
import com.wow.api.model.User;
import com.wow.api.model.common.ResponseWrap;
import com.wow.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
@Api(description = "유저 API 제공", tags = { "유저 API - UserController" })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping("/account/login")
    @ApiOperation(value = "사용자 계정 로그인 처리", notes = "아이디와 패스워드를 파라미터로 받아, 로그인 성공여부를 반환 한다.", response = User.class)
    public ResponseWrap<User> login(@RequestParam(value = "userId") @ApiParam(value = "로그인 아이디", example = "mellow_p@naver.com") String userId,
                                    @RequestParam(value = "userPassword") @ApiParam(value = "로그인 패스워드", example = "1234") String userPassword){
        return new ResponseWrap(userService.checkUserAccountInfo(User.builder().userId(userId).userPassword(userPassword).build()));
    }

    @GetMapping("/character/list")
    @ApiOperation(value = "사용자 케릭터 목록 조회", notes = "사용자가 보유한 케릭터 목록을 조회 한다.", response = Character.class)
    public ResponseWrap<List<Character>> characterList(@RequestParam(value = "userSeq") @ApiParam(value = "계정 시퀀스", example = "1") Long userSeq){
        return new ResponseWrap(userService.searchUserCharacterList(userSeq));
    }


}
