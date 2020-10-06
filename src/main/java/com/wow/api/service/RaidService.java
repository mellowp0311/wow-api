package com.wow.api.service;

import com.wow.api.exception.CustomException;
import com.wow.api.model.RaidPeriod;
import com.wow.api.model.RaidSchedule;
import com.wow.api.model.RaidStatus;
import com.wow.api.model.common.Result;
import com.wow.api.model.dashboard.RaidCharacter;
import com.wow.api.repository.RaidMasterRepository;
import com.wow.api.repository.RaidSlaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static com.wow.api.constants.ErrorEnum.RAID_ALREADY_PARTICIPATE;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RaidService {

    private final RaidMasterRepository raidMasterRepository;
    private final RaidSlaveRepository raidSlaveRepository;


    /**
     * 레이드 일정 조회
     *
     * @param userSeq
     * @param characterSeq
     * @param raidCode
     * @return
     */
    public List<RaidSchedule> searchRaidSchedule(Long userSeq, Long characterSeq, String raidCode, String searchDate) {
        if(StringUtils.isEmpty(searchDate)){
            searchDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        return raidSlaveRepository.selectRaidSchedule(userSeq, characterSeq, raidCode, searchDate);
    }



    /**
     * 레이드 일정 등록
     *
     * @param raidSchedule
     */
    public Result addRaidSchedule(RaidSchedule raidSchedule) {
        // 레이드 이력 조회 (금주)
        RaidStatus raidStatus = this.searchCharacterCurrentWeekRaidParticipate(raidSchedule.getRaidCode(), raidSchedule.getCharacterSeq());
        if("Y".equals(raidStatus.getRaidCompleteYn())){
            throw new CustomException(RAID_ALREADY_PARTICIPATE, raidSchedule.getRaidCode(), raidSchedule.getCharacterSeq());
        }
        raidMasterRepository.insertRaidSchedule(raidSchedule);
        return Result.builder().code(200).message("레이드 일정이 등록되었습니다.").build();
    }

    /**
     * 레이드 일정 수정
     *
     * @param raidSchedule
     */
    public Result modifyRaidSchedule(RaidSchedule raidSchedule) {
        raidMasterRepository.updateRaidSchedule(raidSchedule);
        return Result.builder().code(200).message("레이드 일정이 수정되었습니다.").build();
    }

    /**
     * 레이드 일정 삭제
     *
     * @param raidScheduleSeq
     */
    public Result removeRaidSchedule(Long raidScheduleSeq) {
        raidMasterRepository.deleteRaidSchedule(raidScheduleSeq);
        return Result.builder().code(200).message("레이드 일정이 취소되었습니다.").build();
    }


    /**
     * [메인] 금주 레이드 기간정보 조회
     *
     * @return
     */
    public List<RaidPeriod> selectCurrentWeekRaidPeriod() {
        return raidSlaveRepository.selectCurrentWeekRaidPeriod();
    }

    /**
     * [메인] 갱신된 레이드 기건정보 조회
     *
     * @param raidPeriod
     * @return
     */
    public RaidPeriod selectAddWeekRaidPeriod(RaidPeriod raidPeriod) {
        return raidSlaveRepository.selectAddWeekRaidPeriod(raidPeriod);
    }

    /**
     * [메인] 금주 레이드 일정등록
     *
     * @param raidPeriod
     */
    public void addCurrentWeekRaidPeriod(RaidPeriod raidPeriod) {
        raidMasterRepository.insertCurrentWeekRaidPeriod(raidPeriod);
    }

    /**
     * [메인] 금주 레이드 참여 횟수 조회
     *
     * @param userSeq
     * @param raidPeriods
     * @return
     */
    public int searchCurrentWeekRaidCount(Long userSeq, List<RaidPeriod> raidPeriods) {
        return raidSlaveRepository.selectCurrentWeekRaidCount(userSeq, raidPeriods);
    }


    /**
     * [메인] 레이드별 케릭터 참여 정보 조회
     *
     * @param userSeq
     * @return
     */
    public List<RaidStatus> searchUserCurrentWeekRaidParticipateList(Long userSeq) {
        return raidSlaveRepository.selectUserCurrentWeekRaidParticipateList(userSeq);
    }

    /**
     * [메인] 케릭터 금주 레이드 이력 조회
     *
     * @param raidCode
     * @param characterSeq
     * @return
     */
    public RaidStatus searchCharacterCurrentWeekRaidParticipate(String raidCode, Long characterSeq) {
        return raidSlaveRepository.selectCharacterCurrentWeekRaidParticipate(raidCode, characterSeq);
    }

    /**
     * [웹] 케릭별 레이드 참가현황 조회
     *
     * @param userSeq
     */
    public List<RaidCharacter> searchRaidParticipateByCharacter(Long userSeq) {
        return raidSlaveRepository.selectRaidParticipateByCharacter(userSeq);
    }


    /**
     * 케릭별 레이드 참여현황 리스트 조회
     *
     * @param userSeq
     * @return
     */
    public List<RaidCharacter> searchRaidParticipateByCharacterList(Long userSeq){
        List<RaidCharacter> raidCharacterList = searchRaidParticipateByCharacter(userSeq);
        for(RaidCharacter raidCharacter : raidCharacterList){
            int profit = 0;
            profit += Objects.nonNull(raidCharacter.getAt()) ? raidCharacter.getAt().getProfit() : 0;
            profit += Objects.nonNull(raidCharacter.getAr()) ? raidCharacter.getAr().getProfit() : 0;
            profit += Objects.nonNull(raidCharacter.getMc()) ? raidCharacter.getMc().getProfit() : 0;
            profit += Objects.nonNull(raidCharacter.getBl()) ? raidCharacter.getBl().getProfit() : 0;
            profit += Objects.nonNull(raidCharacter.getOx()) ? raidCharacter.getOx().getProfit() : 0;
            profit += Objects.nonNull(raidCharacter.getZg()) ? raidCharacter.getZg().getProfit() : 0;
            raidCharacter.setTotalProfit(profit);
            int expense = 0;
            expense += Objects.nonNull(raidCharacter.getAt()) ? raidCharacter.getAt().getExpense() : 0;
            expense += Objects.nonNull(raidCharacter.getAr()) ? raidCharacter.getAr().getExpense() : 0;
            expense += Objects.nonNull(raidCharacter.getMc()) ? raidCharacter.getMc().getExpense() : 0;
            expense += Objects.nonNull(raidCharacter.getBl()) ? raidCharacter.getBl().getExpense() : 0;
            expense += Objects.nonNull(raidCharacter.getOx()) ? raidCharacter.getOx().getExpense() : 0;
            expense += Objects.nonNull(raidCharacter.getZg()) ? raidCharacter.getZg().getExpense() : 0;
            raidCharacter.setTotalExpense(expense);
        }
        return raidCharacterList;
    }


}
