package com.wow.api.service;

import com.wow.api.model.RaidSchedule;
import com.wow.api.repository.RaidMasterRepository;
import com.wow.api.repository.UserSlaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RaidService {

    private final RaidMasterRepository raidMasterRepository;



    public void addRaidSchedule(RaidSchedule raidSchedule) {
        raidMasterRepository.insertRaidSchedule(raidSchedule);
    }


    public void modifyRaidSchedule(RaidSchedule raidSchedule) {
        raidMasterRepository.updateRaidSchedule(raidSchedule);
    }


    public void removeRaidSchedule(Long raidScheduleSeq) {
        raidMasterRepository.deleteRaidSchedule(raidScheduleSeq);
    }


}
