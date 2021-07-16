package com.duzon.lulu.sample.service;

import java.util.HashMap;
import java.util.List;

import com.duzon.common.model.LuluResult;
import com.duzon.common.service.LuluService;
import com.duzon.lulu.auto.model.TestUser;

/**
 * Sample Service
 * @author 신승현
 * @since 2016.10.11
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *
 *
 * </pre>
 */
public interface SampleService extends LuluService {
	
	List<TestUser> getSampleList();
	
	TestUser getSample(int id);
	
	int createSample(HashMap<String, Object> param);
	
	int updateSample(HashMap<String, Object> param);
	
	int deleteSample(int id);
	
	LuluResult sampleApi(HashMap<String, Object> param);
	
	LuluResult sampleMulti(HashMap<String, Object> param);
	
	LuluResult samplePaging(HashMap<String, Object> param);
	
	LuluResult sampleTran(HashMap<String, Object> param);
	
	LuluResult sampleInner(HashMap<String, Object> param);
	
	LuluResult sampleMongoSelect(HashMap<String, Object> param);
	
	LuluResult sampleMongoInsert(HashMap<String, Object> param);
}
