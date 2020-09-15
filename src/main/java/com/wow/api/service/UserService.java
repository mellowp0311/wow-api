package com.wow.api.service;

import com.wow.api.model.Character;
import com.wow.api.model.User;
import com.wow.api.repository.UserSlaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public boolean checkUserAccountInfo(User userParam){
        return Objects.nonNull(userSlaveRepository.selectUserAccount(userParam));
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
