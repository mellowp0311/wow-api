package com.wow.api.service;

import com.wow.api.model.Code;
import com.wow.api.model.RaidPeriod;
import com.wow.api.repository.CoreSlaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CoreService {

    private final RaidService raidService;
    private final CoreSlaveRepository coreSlaveRepository;


    /**
     * 그룹코드 목록 조회
     *
     * @return
     */
    public List<Code> searchGroupCodeList() {
        return coreSlaveRepository.selectGroupCodeList();
    }

    /**
     * 상세코드 목록 조회
     *
     * @param groupCode
     * @return
     */
    public List<Code> searchDetailCodeList(String groupCode) {
        return coreSlaveRepository.selectDetailCodeList(groupCode);
    }

    /**
     * 상세코드 조회
     *
     * @param groupCode
     * @param detailCode
     * @return
     */
    public Code searchDetailCode(String groupCode, String detailCode) {
        return coreSlaveRepository.selectDetailCode(groupCode, detailCode);
    }


    /**
     * 2년치 레이드 날짜 등록
     *
     */
    public void addRaidInitPerDay() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime s7 = LocalDateTime.of(2020, 9, 10, 10, 0,0);
        LocalDateTime e7 = LocalDateTime.of(2020, 9, 17, 4, 0,0);
        LocalDateTime s3 = LocalDateTime.of(2020, 9, 11, 10, 0,0);
        LocalDateTime e3 = LocalDateTime.of(2020, 9, 14, 4, 0,0);
        LocalDateTime s5 = LocalDateTime.of(2020, 9, 11, 10, 0,0);
        LocalDateTime e5 = LocalDateTime.of(2020, 9, 16, 4, 0,0);
        LocalDateTime maxDate = LocalDateTime.of(2021, 12, 31, 23, 59,59);
        int addCount = 0;
        while (s7.isBefore(maxDate)){
            s7 = s7.plusDays(7);
            e7 = e7.plusDays(7);
            raidService.addCurrentWeekRaidPeriod(RaidPeriod.builder().code("AT").start(s7.format(f)).end(e7.format(f)).build());
            raidService.addCurrentWeekRaidPeriod(RaidPeriod.builder().code("BL").start(s7.format(f)).end(e7.format(f)).build());
            raidService.addCurrentWeekRaidPeriod(RaidPeriod.builder().code("MC").start(s7.format(f)).end(e7.format(f)).build());
            addCount++;
        }
        log.info("[ raid_7day ] add count: {}", addCount);

        addCount = 0;
        while (s5.isBefore(maxDate)){
            s5 = s5.plusDays(5);
            e5 = e5.plusDays(5);
            raidService.addCurrentWeekRaidPeriod(RaidPeriod.builder().code("OX").start(s5.format(f)).end(e5.format(f)).build());
            addCount++;
        }
        log.info("[ raid_5day ] add count: {}", addCount);

        addCount = 0;
        while (s3.isBefore(maxDate)){
            s3 = s3.plusDays(3);
            e3 = e3.plusDays(3);
            raidService.addCurrentWeekRaidPeriod(RaidPeriod.builder().code("AR").start(s3.format(f)).end(e3.format(f)).build());
            raidService.addCurrentWeekRaidPeriod(RaidPeriod.builder().code("ZG").start(s3.format(f)).end(e3.format(f)).build());
            addCount++;
        }
        log.info("[ raid_3day ] add count: {}", addCount);
    }



}
