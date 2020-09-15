package com.wow.api.service;

import com.wow.api.model.Character;
import com.wow.api.model.MainDashBoard;
import com.wow.api.model.RaidPeriod;
import com.wow.api.model.RaidStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainService {


    private final UserService userService;
    private final RaidService raidService;

    /**
     * 금주 대시보드 조회
     * - 앱 메인화면에 노출되는 데이터 정보
     *
     * @param userSeq
     * @return
     */
    @Transactional
    public MainDashBoard searchMainDashboard(Long userSeq) {
        // 01. 레이드 기간정보 조회
        List<RaidPeriod> raidPeriods = raidService.selectCurrentWeekRaidPeriod();
        for( RaidPeriod period : raidPeriods){
            if(Objects.nonNull(period.getRaidStartDate())) continue;
            // 레이드가 초기화 되었을 경우, 갱신 처리 (배치처리 X)
            RaidPeriod raidPeriod = raidService.selectAddWeekRaidPeriod(period);
            raidService.addCurrentWeekRaidPeriod(raidPeriod);
            period.refreshCurrentWeekRaidData(raidPeriod);
        }
        // 02. 레이드 달성률 계산
        List<Character> characters = userService.searchUserCharacterList(userSeq);
        double canParticipate = raidPeriods.size() * characters.size();
        double participate = raidService.searchCurrentWeekRaidCount(userSeq, raidPeriods);
        int rate = (int) Math.round(participate / canParticipate * 100);
        return MainDashBoard.builder().achievementRate(rate).raidPeriods(raidPeriods).build();
    }


    /**
     * 금주 레이드 달성률 상세 조회
     * - 레이드별 케릭터 참여 여부를 보여준다.
     * - 메인 > 달성률 클릭
     *
     * @param userSeq
     * @return
     */
    public Map<String, List<RaidStatus>> searchAchievementRate(Long userSeq) {
        List<RaidStatus> characterList = raidService.searchUserCurrentWeekRaidParticipateList(userSeq);
        return characterList.stream().collect(Collectors.groupingBy(RaidStatus::getRaidCode));
    }



}
