package com.duzon.lulu.scheduling;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.duzon.common.model.LuluResult;
import com.duzon.lulu.calendar.service.CalendarService;
import com.duzon.lulu.schedule.service.ScheduleService;

public class CalendarTask extends QuartzJobBean{

	private CalendarService calendarService;
	
	/* jobDataAsMap 에서 선언한 서비스를 사용하기 위해 설정 */
	public void setCalendarService(CalendarService calendarService) {
	  this.calendarService = calendarService;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("--- Scheduler start ---> ");
		calendarService.schedularDeleteCalendar();
	}

}
