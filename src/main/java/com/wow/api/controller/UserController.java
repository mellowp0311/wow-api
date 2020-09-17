package com.wow.api.controller;

import com.wow.api.model.Character;
import com.wow.api.model.User;
import com.wow.api.model.common.ResponseWrap;
import com.wow.api.model.common.Result;
import com.wow.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@Api(description = "유저 API 제공", tags = { "유저 API - UserController" })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "사용자 계정 로그인 처리", notes = "아이디와 패스워드를 파라미터로 받아, 로그인 성공여부를 반환 한다.", response = User.class)
    public ResponseWrap<User> login(@RequestBody User userParam){
        return new ResponseWrap(userService.checkUserAccountInfo(userParam));
    }

    @PostMapping("/add")
    @ApiOperation(value = "사용자 계정 등록", notes = "회원가입 처리", response = Result.class)
    public ResponseWrap<Result> addUser(@RequestBody User user){
        return new ResponseWrap(userService.addUser(user));
    }

    @PutMapping("/modify")
    @ApiOperation(value = "사용자 계정 수정", notes = "회원가입 처리", response = Result.class)
    public ResponseWrap<Result> modifyUser(@RequestBody User user){
        return new ResponseWrap(userService.modifyUser(user));
    }

    @PostMapping("/character/add")
    @ApiOperation(value = "사용자 케릭터 등록", notes = "케릭터 등록", response = Result.class)
    public ResponseWrap<Result> addUserCharacter(@RequestBody Character character){
        return new ResponseWrap(userService.addUserCharacter(character));
    }

    @PutMapping("/character/modify")
    @ApiOperation(value = "사용자 케릭터 수정", notes = "케릭터 수정", response = Result.class)
    public ResponseWrap<Result> modifyUserCharacter(@RequestBody Character character){
        return new ResponseWrap(userService.modifyUserCharacter(character));
    }

    @GetMapping("/character/list")
    @ApiOperation(value = "사용자 케릭터 목록 조회", notes = "사용자가 보유한 케릭터 목록을 조회 한다.", response = Character.class)
    public ResponseWrap<List<Character>> characterList(@RequestParam(value = "userSeq") @ApiParam(value = "계정 시퀀스", example = "1") Long userSeq){
        return new ResponseWrap(userService.searchUserCharacterList(userSeq));
    }


}
