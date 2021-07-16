package com.duzon.lulu.calendar.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.duzon.common.mapper.LuluAbstractMapper;
import com.duzon.lulu.auto.model.TCalendar;

@Repository("calendarMapper")
public class CalendarMapper extends LuluAbstractMapper {
	
	public List selectList() {
		return selectList("mapper.CalendarMapper.selectList");
	}
	
	public Long selectMaxCalendarId() {
		return selectOne("mapper.CalendarMapper.selectMaxCalendarId");
	}
	
	public int insertCalendar(HashMap param) {
		return insert("mapper.CalendarMapper.insertCalendar",param);
	}
	
	public int updateCalendar(HashMap param) {
		return update("mapper.CalendarMapper.updateCalendar",param);
	}
	
	public int updateUseYNCalendar(int id) {
		return update("mapper.CalendarMapper.updateUseYNCalendar",id);
	}
	
	public int schedularDeleteCalendar() {
		return delete("mapper.CalendarMapper.schedularDeleteCalendar");		
	}
}
