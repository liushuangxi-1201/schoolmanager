package cn.kgc.service;

import cn.kgc.entity.Schedule;
import cn.kgc.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleMapper.getAllSchedule();
    }
}
