package com.duzon.lulu.schedule.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duzon.common.model.LuluResult;
import com.duzon.common.util.StringUtil;
import com.duzon.common.util.ValidationUtil;
import com.duzon.lulu.auto.model.TSchedule;
import com.duzon.lulu.schedule.mapper.ScheduleMapper;
import com.duzon.lulu.schedule.service.ScheduleService;

@Service("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	protected Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ScheduleMapper scheduleMapper;

	public LuluResult getScheduleList() {

		LuluResult result = new LuluResult();
		List<TSchedule> list = scheduleMapper.selectList();

		result.setResultData(list);

		return result;
	}

	@Override
	public LuluResult createSchedule(HashMap<String, Object> param) {

		LuluResult result = new LuluResult();

		try {
			// Validation Start
			boolean chkValidation = true;
			String[] valiValus = { "schedule_name", "calendar_id" };
			if (!ValidationUtil.checkContainsKeys(valiValus, param)) // empty 도 같이 걸러줌
				chkValidation = false;

			if (!StringUtil.isStringDouble((String) param.get("calendar_id")))
				chkValidation = false;

			if (StringUtil.fixNull(param.get("attend_num")).isEmpty())
				if (!StringUtil.isStringDouble((String) param.get("attend_num")))
					chkValidation = false;

			if (!chkValidation) {
				result.setResultCode(400);
				result.setResultMsg("FAIL");

				return result;
			}
			// Validation End

			// cast value
			param.put("attend_num", Integer.parseInt(StringUtil.fixNull(param.get("attend_num"))));
			param.put("calendar_id", Long.parseLong(StringUtil.fixNull( param.get("calendar_id"))));

			int cnt = scheduleMapper.insertSchedule(param);

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
	public LuluResult updateSchedule(HashMap<String, Object> param) {
		LuluResult result = new LuluResult();

		try {
			// Validation Start
			boolean chkValidation = true;
			String[] valiValus = { "schedule_name", "calendar_id", "schedule_id" };
			if (!ValidationUtil.checkContainsKeys(valiValus, param))
				chkValidation = false;

			if (!StringUtil.isStringDouble((String) param.get("calendar_id")))
				chkValidation = false;

			if (!StringUtil.isStringDouble((String) param.get("schedule_id")))
				chkValidation = false;

			if (StringUtil.fixNull(param.get("attend_num")).isEmpty())
				if (!StringUtil.isStringDouble((String) param.get("attend_num")))
					chkValidation = false;

			if (!chkValidation) {
				result.setResultCode(400);
				result.setResultMsg("FAIL");

				return result;
			}
			// Validation End

			// cast value
			param.put("attend_num", Integer.parseInt(StringUtil.fixNull( param.get("attend_num"))));
			param.put("calendar_id", Long.parseLong(StringUtil.fixNull( param.get("calendar_id"))));
			param.put("schedule_id", Long.parseLong(StringUtil.fixNull( param.get("schedule_id"))));

			int cnt = scheduleMapper.updateSchedule(param);

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
	public LuluResult deleteSchedule(HashMap<String, Object> param) {

		LuluResult result = new LuluResult();
		try {
			// Validation Start
			boolean chkValidation = true;
			String[] valiValus = { "upt_id", "schedule_id" };
			if (!ValidationUtil.checkContainsKeys(valiValus, param))
				chkValidation = false;

			if (!StringUtil.isStringDouble((String) param.get("schedule_id")))
				chkValidation = false;

			if (!chkValidation) {
				result.setResultCode(400);
				result.setResultMsg("FAIL");

				return result;
			}
			// Validation End

			// cast value
			param.put("schedule_id", Integer.parseInt(StringUtil.fixNull(param.get("schedule_id"))));

			int cnt = scheduleMapper.updateUseYNSchedule(param);

			result.setResultCode(201);
			result.setResultMsg("SUCCESS");
			result.setResultData(cnt);
		} catch (Exception e) {
			result.setResultCode(400);
			result.setResultMsg("FAIL");
		}
		return result;

	}

}
