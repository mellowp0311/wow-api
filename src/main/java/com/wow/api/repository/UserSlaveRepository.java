package com.wow.api.repository;

import com.wow.api.config.annotation.SlaveConnection;
import com.wow.api.model.Character;
import com.wow.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@SlaveConnection
public interface UserSlaveRepository {

    User selectUserAccount(User userParam);

    List<Character> selectUserCharacterList(Long userSeq);
}
