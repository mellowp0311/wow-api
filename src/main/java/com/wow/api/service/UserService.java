package com.wow.api.service;

import com.wow.api.exception.CustomException;
import com.wow.api.model.Character;
import com.wow.api.model.User;
import com.wow.api.repository.UserSlaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.wow.api.constants.ErrorEnum.USER_LOGIN_INVALID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserSlaveRepository userSlaveRepository;


    /**
     * 사용자 로그인 체크
     *
     * @param userParam
     * @return
     */
    public User checkUserAccountInfo(User userParam){
        User user = userSlaveRepository.selectUserAccount(userParam);
        if(Objects.isNull(user)){
            throw new CustomException(USER_LOGIN_INVALID, userParam.getUserId());
        }
        return user;
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
