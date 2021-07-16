package com.duzon.lulu.schedule.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.duzon.common.mapper.LuluAbstractMapper;

@Repository("scheduleMapper")
public class ScheduleMapper extends LuluAbstractMapper {
	
	public List selectList() {
		return selectList("mapper.ScheduleMapper.selectList");
	}
	
	public int insertSchedule(HashMap param) {
		return insert("mapper.ScheduleMapper.insertSchedule",param);
	}
	
	public int updateSchedule(HashMap param) {
		return update("mapper.ScheduleMapper.updateSchedule",param);
	}
	
	public int updateUseYNSchedule(HashMap param) {
		return update("mapper.ScheduleMapper.updateUseYNSchedule",param);
	}
}
