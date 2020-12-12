package cn.kgc.mapper;

import cn.kgc.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScheduleMapper {
    /**
     * 查询所有作息时间
     * @return
     */
    List<Schedule> getAllSchedule();
}
