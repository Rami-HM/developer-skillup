package com.duzon.lulu.schedule.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duzon.common.controller.LuluBaseController;
import com.duzon.common.model.LuluResult;
import com.duzon.common.util.RequestUtil;
import com.duzon.lulu.auto.model.TSchedule;
import com.duzon.lulu.schedule.service.ScheduleService;


@RestController
public class ScheduleController extends LuluBaseController {
	
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private HttpServletRequest request;
	
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * get schedule - list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/schedule", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public LuluResult getScheduleList(HttpServletRequest request) throws Exception {
		
		LuluResult result = new LuluResult();
		
		result = scheduleService.getScheduleList();
		
		return result;
	}
	
	/**
	 * create schedule 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/schedule", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public LuluResult createSchedule() throws Exception {
		
		LuluResult result = new LuluResult();
		
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = scheduleService.createSchedule(param);
		
		return result;
	}
	
	/**
	 * update schedule 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/schedule", method=RequestMethod.PUT, produces="application/json;charset=utf-8")
	public LuluResult updateSchedule() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = scheduleService.updateSchedule(param);
		return result;
	}
	
	/**
	 * update schedule 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/schedule", method=RequestMethod.DELETE, produces="application/json;charset=utf-8")
	public LuluResult deleteSchedule(@RequestBody TSchedule test) throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		try {
			result = scheduleService.deleteSchedule(param);
		} catch (Exception e) {
			result.setResultCode(400);
			result.setResultMsg("FAIL");
		}
		
		return result;
	}
}
