package edu.poly.boatbooking.mapper;

import edu.poly.boatbooking.dto.ScheduleDto;
import edu.poly.boatbooking.entity.Schedule;

public class ScheduleMapper {
    public static ScheduleDto mapToScheduleDto (Schedule schedule) {
        return new ScheduleDto(
                schedule.getId(),
                schedule.getBoat_name(),
                schedule.getPort_name(),
                schedule.getFromLocation(),
                schedule.getToLocation(),
                schedule.getDepartureDay(),
                schedule.getDepartureTime(),
                schedule.getArrivalTime(),
                schedule.getPrice()
        );
    }
    public static Schedule mapToSchedule(ScheduleDto scheduleDto) {
        return new Schedule(
                scheduleDto.getId(),
                scheduleDto.getBoat_name(),
                scheduleDto.getPort_name(),
                scheduleDto.getFromLocation(),
                scheduleDto.getToLocation(),
                scheduleDto.getDepartureDay(),
                scheduleDto.getDepartureTime(),
                scheduleDto.getArrivalTime(),
                scheduleDto.getPrice()
        );
    }
}
