package com.duzon.lulu.calendar.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duzon.common.model.LuluResult;
import com.duzon.common.util.ValidationUtil;
import com.duzon.lulu.auto.mapper.TCalendarMapper;
import com.duzon.lulu.auto.model.TCalendar;
import com.duzon.lulu.calendar.mapper.CalendarMapper;
import com.duzon.lulu.calendar.service.CalendarService;

@Service("CalendarService")
public class CalendarServiceImpl implements CalendarService {
	
	protected Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private CalendarMapper calendarMapper;
	@Autowired
	private TCalendarMapper tCalendarMapper;
	
	public LuluResult getCalendarList() {

		LuluResult result = new LuluResult();
		try {
			List<TCalendar> list = calendarMapper.selectList();

			result.setResultCode(200);
			result.setResultMsg("SUCCESS");
			result.setResultData(list);
			
		} catch (Exception e) {
			result.setResultCode(400);
			result.setResultMsg("FAIL");
		}
		return result;
	}

	@Override
	public LuluResult createCalendar(HashMap<String, Object> param) {

		LuluResult result = new LuluResult();
		try {
			String[] valiValus = {"calendar_name"};
			if(!ValidationUtil.checkContainsKeys(valiValus, param)) {
				result.setResultCode(400);
				result.setResultMsg("FAIL");
			}
			
			int cnt = calendarMapper.insertCalendar(param);
			
			result.setResultCode(201);
			result.setResultMsg("SUCCESS");
			result.setResultData(cnt);
			
		} catch (Exception e) {
			result.setResultCode(400);
			result.setResultMsg("FAIL");
		}
		return result;
		
	}

	@Override
	public LuluResult updateCalendar(HashMap<String, Object> param) {
		
		LuluResult result = new LuluResult();
		try {
			String[] valiValus = {"calendar_name","calendar_id"};
			if(!ValidationUtil.checkContainsKeys(valiValus, param)) {
				result.setResultCode(400);
				result.setResultMsg("FAIL");
			}
			int cnt = calendarMapper.updateCalendar(param);
			
			result.setResultCode(201);
			result.setResultMsg("SUCCESS");
			result.setResultData(cnt);
			
		} catch (Exception e) {
			result.setResultCode(400);
			result.setResultMsg("FAIL");
		}
		return result;
	}

	@Override
	public LuluResult updateCalendarUseYN(int id) {
		
		LuluResult result = new LuluResult();
		try {
			int cnt = calendarMapper.updateUseYNCalendar(id);
			
			result.setResultCode(201);
			result.setResultMsg("SUCCESS");
			result.setResultData(cnt);
			
		} catch (Exception e) {
			result.setResultCode(400);
			result.setResultMsg("FAIL");
		}
		return result;
		
	}
	
	@Override
	public int schedularDeleteCalendar() {
		int cnt = calendarMapper.schedularDeleteCalendar();
		return cnt;
	}



}
