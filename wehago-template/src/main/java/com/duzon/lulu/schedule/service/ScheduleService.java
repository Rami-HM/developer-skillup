package com.duzon.lulu.schedule.service;

import java.util.HashMap;
import java.util.List;

import com.duzon.common.model.LuluResult;
import com.duzon.common.service.LuluService;
import com.duzon.lulu.auto.model.TSchedule;

public interface ScheduleService extends LuluService {
	
	LuluResult getScheduleList();
	
	LuluResult createSchedule(HashMap<String, Object> param);
	
	LuluResult updateSchedule(HashMap<String, Object> param);
	
	LuluResult deleteSchedule(HashMap<String, Object> param);
	
}
