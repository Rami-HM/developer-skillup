package com.duzon.lulu.calendar.service;

import java.util.HashMap;
import java.util.List;

import com.duzon.common.model.LuluResult;
import com.duzon.common.service.LuluService;
import com.duzon.lulu.auto.model.TCalendar;

public interface CalendarService extends LuluService {
	
	LuluResult getCalendarList();
	
	LuluResult createCalendar(HashMap<String, Object> param);
	
	LuluResult updateCalendar(HashMap<String, Object> param);
	
	LuluResult updateCalendarUseYN(int id);
	
	int schedularDeleteCalendar();
	
	
	
}
