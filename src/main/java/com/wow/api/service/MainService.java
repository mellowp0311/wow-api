package com.wow.api.service;

import com.wow.api.model.Character;
import com.wow.api.model.*;
import com.wow.api.model.dashboard.RaidCharacter;
import com.wow.api.model.dashboard.RaidType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
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
        List<RaidPeriod> raidPeriods = this.searchCurrentWeekRaidPeriod();
        // 02. 레이드 달성률 계산
        List<Character> characters = userService.searchUserCharacterList(userSeq);
        double canParticipate = raidPeriods.size() * characters.size();
        double participate = raidService.searchCurrentWeekRaidCount(userSeq, raidPeriods);
        int rate = (int) Math.round(participate / canParticipate * 100);
        return MainDashBoard.builder().achievementRate(rate).raidPeriods(raidPeriods).build();
    }

    /**
     * 레이드 기간 정보 조회
     *
     * @return
     */
    private List<RaidPeriod> searchCurrentWeekRaidPeriod(){
        List<RaidPeriod> raidPeriods = raidService.selectCurrentWeekRaidPeriod();
        for( RaidPeriod period : raidPeriods){
            if(StringUtils.isEmpty(period.getRaidStartDate())){
                // 레이드가 초기화 되었을 경우, 갱신 처리 (배치처리 X)
                RaidPeriod raidPeriod = raidService.selectAddWeekRaidPeriod(period);
                raidService.addCurrentWeekRaidPeriod(raidPeriod);
                period.refreshCurrentWeekRaidData(raidPeriod);
            }
            period.makeBetweenDayList();
        }
        return raidPeriods;
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


    /**
     * [웹] 대시보드 현황 정보 조회
     *
     * @param userSeq
     * @return
     */
    public WebDashboard searchWebMainDashboard(Long userSeq) {
        // 금주 레이드 일정
        RaidType raidType = new RaidType();
        List<RaidPeriod> raidPeriods = this.searchCurrentWeekRaidPeriod();
        for( RaidPeriod raidPeriod: raidPeriods){
            if(raidPeriod.getRaidCode().equals("AR")) raidType.setAr(raidPeriod);
            if(raidPeriod.getRaidCode().equals("AT")) raidType.setAt(raidPeriod);
            if(raidPeriod.getRaidCode().equals("OX")) raidType.setOx(raidPeriod);
        }
        // 사용자 케릭터 목록
        List<Character> characterList = userService.searchUserCharacterList(userSeq);
        // 사용자 케릭터 레이드 참가 현황
        List<RaidCharacter> raidCharacterList = raidService.searchRaidParticipateByCharacterList(userSeq);
        return WebDashboard.builder().raidType(raidType).characterList(characterList).raidParticipateList(raidCharacterList).build();
    }





}
