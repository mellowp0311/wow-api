package com.wow.api.repository;

import com.wow.api.config.annotation.MasterConnection;
import com.wow.api.model.RaidPeriod;
import com.wow.api.model.RaidSchedule;
import org.springframework.stereotype.Repository;


@Repository
@MasterConnection
public interface RaidMasterRepository {

    int insertRaidSchedule(RaidSchedule raidSchedule);

    int updateRaidSchedule(RaidSchedule raidSchedule);

    int deleteRaidSchedule(Long raidScheduleSeq);

    int insertCurrentWeekRaidPeriod(RaidPeriod raidPeriod);
}
