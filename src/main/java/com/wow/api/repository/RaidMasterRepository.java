package com.wow.api.repository;

import com.wow.api.config.annotation.MasterConnection;
import com.wow.api.config.annotation.SlaveConnection;
import com.wow.api.model.Character;
import com.wow.api.model.RaidSchedule;
import com.wow.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@MasterConnection
public interface RaidMasterRepository {

    void insertRaidSchedule(RaidSchedule raidSchedule);

    void updateRaidSchedule(RaidSchedule raidSchedule);

    void deleteRaidSchedule(Long raidScheduleSeq);
}
