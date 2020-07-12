package domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 클래스의 응집도를 높이기 위해,
 * 1) 초기화 되는 속성의 그룹을 기준으로
 * 2) 클래스의 변경 이유가 하나로 제한되도록
 * 할인 조건에 대한 분리를 진행
 */
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }

}
