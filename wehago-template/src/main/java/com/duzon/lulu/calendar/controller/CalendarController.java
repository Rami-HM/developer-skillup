package com.duzon.lulu.calendar.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duzon.common.controller.LuluBaseController;
import com.duzon.common.model.LuluResult;
import com.duzon.common.util.RequestUtil;
import com.duzon.lulu.auto.model.TCalendar;
import com.duzon.lulu.calendar.service.CalendarService;


@RestController
public class CalendarController extends LuluBaseController {
	
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private HttpServletRequest request;
	
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * get calendar - list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/calendar/list", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public LuluResult getCalendarList(HttpServletRequest request) throws Exception {
		
		LuluResult result = new LuluResult();
		result = calendarService.getCalendarList();
		return result;
	}
	
	/**
	 * get calendar - list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/calendar", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public LuluResult getCalendarList2(HttpServletRequest request) throws Exception {
		
		LuluResult result = new LuluResult();
		result = calendarService.getCalendarList();
		return result;
	}
	
	/**
	 * create calendar 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/calendar", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public LuluResult createCalendar() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = calendarService.createCalendar(param);
		return result;
	}
	
	/**
	 * update calendar 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/calendar", method=RequestMethod.PUT, produces="application/json;charset=utf-8")
	public LuluResult updateCalendar() throws Exception {
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		LuluResult result = new LuluResult();
		result = calendarService.updateCalendar(param);
		return result;
	}
	
	/**
	 * update calendar 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/calendar", method=RequestMethod.DELETE, produces="application/json;charset=utf-8")
	public LuluResult deleteCalendar(@RequestParam(value="calendar_id") int id) throws Exception {
		LuluResult result = new LuluResult();
		result = calendarService.updateCalendarUseYN(id);
		return result;
	}

	
}
