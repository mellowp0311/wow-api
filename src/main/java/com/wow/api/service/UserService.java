package com.wow.api.service;

import com.wow.api.exception.CustomException;
import com.wow.api.model.Character;
import com.wow.api.model.User;
import com.wow.api.model.common.Result;
import com.wow.api.repository.UserMasterRepository;
import com.wow.api.repository.UserSlaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.wow.api.constants.ErrorEnum.*;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMasterRepository userMasterRepository;
    private final UserSlaveRepository userSlaveRepository;


    /**
     * 사용자 로그인 체크
     *
     * @param userParam
     * @return
     */
    public User checkUserAccountInfo(User userParam){
        User user = userSlaveRepository.selectUserAccount(userParam);
        if(Objects.isNull(user)) throw new CustomException(USER_LOGIN_INVALID, userParam.getUserId());
        return user;
    }


    /**
     * 사용자 회원 가입
     *
     * @param userParam
     * @return
     */
    public Result addUser(User userParam) {

        // 계정 아이디 유효성 체크
        User user = userSlaveRepository.selectUserAccount(userParam);
        if(userParam.getUserId().length() < 6) throw new CustomException(USER_ID_IS_SHORT, userParam.getUserId());
        if(Objects.nonNull(user)) throw new CustomException(ALREADY_REGISTERED_ID, userParam.getUserId());

        // 패스워드 유효성 체크
        if(userParam.getUserPassword().length() < 6) throw new CustomException(USER_PASSWORD_IS_SHORT, userParam.getUserId());

        Result.ResultBuilder builder = Result.builder();
        if(userMasterRepository.insertUser(userParam) > 0){
            builder.code(200).message("회원 가입이 처리 되었습니다.");
        } else {
            builder.code(500).message("회원 가입에 실패 하였습니다.");
            log.error("[ addUser ] fail parameter: {}", userParam);
        }

        return builder.build();
    }

    /**
     * 사용자 수정
     *
     * @param userParam
     * @return
     */
    public Result modifyUser(User userParam) {
        if(userParam.getUserPassword().length() < 6) {
            throw new CustomException(USER_PASSWORD_IS_SHORT, userParam.getUserId());
        }
        Result.ResultBuilder builder = Result.builder();
        if(userMasterRepository.updateUser(userParam) > 0){
            builder.code(200).message("회원 정보가 수정 되었습니다.");
        } else {
            builder.code(500).message("회원 정보 수정에 실패 하였습니다.");
            log.error("[ modifyUser ] fail parameter: {}", userParam);
        }
        return builder.build();
    }



    /**
     * 사용자 케릭터 생성
     *
     * @param character
     * @return
     */
    public Result addUserCharacter(Character character) {
        Result.ResultBuilder builder = Result.builder();
        if(userMasterRepository.insertUserCharacter(character) > 0){
            builder.code(200).message("케릭터가 등록 되었습니다.");
        } else {
            builder.code(500).message("케릭터 등록에 실패 하였습니다.");
            log.error("[ addUserCharacter ] fail parameter: {}", character);
        }
        return builder.build();
    }


    /**
     * 사용자 케릭터 수정
     *
     * @param character
     * @return
     */
    public Result modifyUserCharacter(Character character) {
        Result.ResultBuilder builder = Result.builder();
        if(userMasterRepository.updateUserCharacter(character) > 0){
            builder.code(200).message("케릭터가 수정 되었습니다.");
        } else {
            builder.code(500).message("케릭터 수정에 실패 하였습니다.");
            log.error("[ modifyUserCharacter ] fail parameter: {}", character);
        }
        return builder.build();
    }




    /**
     * 사용자 케릭터 목록 조회
     *
     * @param userSeq
     * @return
     */
    public List<Character> searchUserCharacterList(Long userSeq){
        return userSlaveRepository.selectUserCharacterList(userSeq);
    }



}
