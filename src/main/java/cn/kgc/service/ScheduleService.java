package cn.kgc.service;


import cn.kgc.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    /**
     * 查询所有作息时间
     * @return
     */
    List<Schedule> getAllSchedule();
}
