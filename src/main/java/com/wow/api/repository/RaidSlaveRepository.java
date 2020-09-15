package com.wow.api.repository;

import com.wow.api.config.annotation.SlaveConnection;
import com.wow.api.model.RaidPeriod;
import com.wow.api.model.RaidStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@SlaveConnection
public interface RaidSlaveRepository {


    List<RaidPeriod> selectCurrentWeekRaidPeriod();

    RaidPeriod selectAddWeekRaidPeriod(RaidPeriod raidPeriod);

    int selectCurrentWeekRaidCount(@Param("userSeq") Long userSeq, @Param("raidPeriods") List<RaidPeriod> raidPeriods);


    List<RaidStatus> selectUserCurrentWeekRaidParticipateList(Long userSeq);

    RaidStatus selectCharacterCurrentWeekRaidParticipate(@Param("raidCode") String raidCode, @Param("characterSeq") Long characterSeq);
}
