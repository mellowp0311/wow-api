package com.wow.api.repository;

import com.wow.api.config.annotation.MasterConnection;
import com.wow.api.model.Character;
import com.wow.api.model.User;
import org.springframework.stereotype.Repository;


@Repository
@MasterConnection
public interface UserMasterRepository {

    int insertUser(User userParam);

    int updateUser(User user);

    int insertUserCharacter(Character character);

    int updateUserCharacter(Character character);


}
