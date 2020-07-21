package Test;

import domain.Event;
import domain.RecurringSchedule;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {

        IntStream.of(1,15,20,3,9)
                .filter(x -> x > 10)
                .distinct()
                .count();


        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.THURSDAY,
                LocalTime.of(17, 30), Duration.ofMinutes(60));

        Event meeting = new Event("회의",
                LocalDateTime.of(2020, 7, 24, 17, 30),
                Duration.ofMinutes(60));

        assert meeting.isSatisfied(schedule) == false;
        assert meeting.isSatisfied(schedule) == true;

        if (!meeting.isSatisfied(schedule)) {
            meeting.reschedule(schedule);
        }

    }


}
