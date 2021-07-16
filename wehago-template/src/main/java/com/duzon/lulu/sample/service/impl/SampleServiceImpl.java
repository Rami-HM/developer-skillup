package com.duzon.lulu.sample.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duzon.lulu.sample.mapper.SampleMapper;
import com.duzon.lulu.sample.service.SampleService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.duzon.common.model.LogModel;
import com.duzon.common.model.LuluResult;
import com.duzon.common.util.DateTimeUtil;
import com.duzon.common.util.JsonUtil;
import com.duzon.common.util.LuluPaging;
import com.duzon.lulu.auto.mapper.TestCompanyMapper;
import com.duzon.lulu.auto.mapper.TestUserMapper;
import com.duzon.lulu.auto.model.TestCompany;
import com.duzon.lulu.auto.model.TestCompanyExample;
import com.duzon.lulu.auto.model.TestUser;
import com.duzon.lulu.auto.model.TestUserExample;
import com.duzon.lulu.common.constants.ActionCode;
import com.duzon.lulu.common.constants.LogCase;
import com.duzon.lulu.common.constants.MenuCode;
import com.duzon.lulu.common.service.HttpConnectionService;
import com.duzon.lulu.common.service.WehagoLogService;

/**
 * SampleService
 * @author 신승현
 * @since 2016.10.11
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  
 *
 * </pre>
 */
@Service("sample1Service")
public class SampleServiceImpl implements SampleService {
	
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	//@Autowired
	//private TestUserMapper testUserMapper;
	
	@Resource(name = "testUserMapper")
	private TestUserMapper testUserMapper;
	
	@Autowired
	private TestCompanyMapper testCompanyMapper;
	@Autowired
	private HttpConnectionService httpConnectionService;
	@Autowired
	private SampleMapper sampleMapper;
	
	
	@Autowired
	private WehagoLogService wehagoLogService;
	
	
	
	public List<TestUser> getSampleList(){
		TestUserExample example = new TestUserExample();
		example.setOrderByClause("id");
		List<TestUser> list = testUserMapper.selectByExample(example);
		
		LogModel logModel = new LogModel();
		logModel.setMenuCode(MenuCode.CONNECT);
		logModel.setActionCode(ActionCode.LOGIN_SUCCESS);
		logModel.setLogCase(LogCase.NONE);
		 
		HashMap logData = new HashMap();
		logData.put("portal_id", "test111");
		logData.put("login_ip", "127.0.0.1");
		logModel.setData(logData);
		wehagoLogService.insertLog(logModel);
		
		return list;
	}
	
	public TestUser getSample(int id){
		TestUser testUser = testUserMapper.selectByPrimaryKey(id);
		return testUser;
	}
	
	public int createSample(HashMap<String, Object> param){
		TestUser testUser = new TestUser();
		testUser.setId(Integer.parseInt(param.get("id").toString()));
		testUser.setPw(param.get("pw").toString());
		testUser.setName(param.get("name").toString());
		testUser.setCompany_code(param.get("company_code").toString());
		
		int cnt = testUserMapper.insertSelective(testUser);
		return cnt;
	}
	
	public int updateSample(HashMap<String, Object> param){
		TestUser testUser = new TestUser();
		testUser.setId(Integer.parseInt(param.get("id").toString()));
		testUser.setPw(param.get("pw").toString());
		testUser.setName(param.get("name").toString());
		testUser.setCompany_code(param.get("company_code").toString());
		
		int cnt = testUserMapper.updateByPrimaryKeySelective(testUser);
		return cnt;
	}
	
	public int deleteSample(int id){
		int cnt = testUserMapper.deleteByPrimaryKey(id);
		return cnt;
	}
	
	public LuluResult sampleApi(HashMap<String, Object> param){
		LuluResult result = new LuluResult();
		HashMap<String, Object> resultData = new HashMap<String, Object>();
		
		// 1. 회사 리스트 조회
		TestCompanyExample example = new TestCompanyExample();
		example.createCriteria().andBusiness_typeEqualTo("1").andCompany_typeNotEqualTo("9");
		List<TestCompany> companyList = testCompanyMapper.selectByExample(example);
		resultData.put("companyList", companyList);
		
		// 2. 회원 조회
		TestUser testUser = this.getSample(1);
		resultData.put("testUser", testUser);
		
		// 3. 회원의 정보 조회 - query
		param.put("company_code", "0001");
		List<HashMap> list = sampleMapper.selectList(param);
		resultData.put("list", list);
		
		// 4. 신규회원 insert
		TestUser insertUser = new TestUser();
		int id = sampleMapper.selectMaxId();
		
		insertUser.setId(id);
		insertUser.setPw("1234");
		insertUser.setName("사용자" + Integer.toString(id));
		insertUser.setCompany_code("0001");
		int insertCnt = testUserMapper.insertSelective(insertUser);
		resultData.put("insertCnt", insertCnt);
		
		// 5. 회원정보 update
		TestUser updateUser = new TestUser();
		updateUser.setId(1);
		updateUser.setCompany_code("0001");
		int updateCnt = testUserMapper.updateByPrimaryKeySelective(updateUser);
		resultData.put("updateCnt", updateCnt);
		
		result.setResultData(resultData);
		return result;
	}
	
	public LuluResult sampleMulti(HashMap<String, Object> param){
	    LuluResult result = new LuluResult();
	    HashMap<String, Object> resultData = new HashMap<String, Object>();
	    
	    /* gson int가 double로 바뀌는 현상으로 인해 사용안함 
	    Gson gson = new Gson();
	    List<HashMap> list = gson.fromJson(param.get("jsonstr").toString(), List.class);
	    for (HashMap item: list){
	        logger.debug(item);
	    }
	    */
	    
	    List<HashMap> list2 = JsonUtil.toList(param.get("jsonstr").toString());
	    for (HashMap item2: list2){
	        logger.debug(item2);
	    }
	    
	    result.setResultData(list2);
	    return result;
	}
	
	public LuluResult samplePaging(HashMap<String, Object> param){
	    LuluResult result = new LuluResult();
	    HashMap<String, Object> resultData = new HashMap<String, Object>();
	    
	    int page = param.get("page") == null?1:Integer.parseInt(param.get("page").toString());
	    int pages = param.get("pages") == null?10:Integer.parseInt(param.get("pages").toString());
	    int record = param.get("record") == null?10:Integer.parseInt(param.get("record").toString());
	    
	    LuluPaging luluPaging = new LuluPaging();
	    luluPaging.setCurrentPageNo(page);	// 현재 페이지 
	    luluPaging.setPageSize(pages);		// 페이지 갯수
	    luluPaging.setRecordCountPerPage(record);	// 한페이지에 보여줄 레코드 갯수
	    
	    int cnt = sampleMapper.selectListPagingCnt(param);
	    luluPaging.setTotalRecordCount(cnt);	// 총 레코드 갯수
	    param.put("limit", luluPaging.getLimit());
	    param.put("offset", luluPaging.getOffset());
	    
	    List<HashMap> list = sampleMapper.selectListPaging(param);
	    
	    resultData.put("list", list);
	    resultData.put("luluPaging", luluPaging);
	    
	    result.setResultData(resultData);
	    return result;
	}
	
	public LuluResult sampleTran(HashMap<String, Object> param){
	    LuluResult result = new LuluResult();
	    HashMap<String, Object> resultData = new HashMap<String, Object>();
	    
	    TestUser insertUser = new TestUser();
 		int id = sampleMapper.selectMaxId();
 		
 		insertUser.setId(id);
 		insertUser.setPw("1234");
 		insertUser.setName("사용자" + Integer.toString(id));
 		insertUser.setCompany_code("0001");
 		int insertCnt = testUserMapper.insertSelective(insertUser);
	    
 		int insertCnt2 = testUserMapper.insertSelective(insertUser);
 		
	    result.setResultData(resultData);
	    return result;
	}
	
	public LuluResult sampleInner(HashMap<String, Object> param){
	    LuluResult result = new LuluResult();
	    HashMap<String, Object> resultData = new HashMap<String, Object>();
	    
	    // get 
	    LuluResult getResult = httpConnectionService.sendGet("http://172.16.114.180/bcb-j/sample");
	    resultData.put("get", JsonUtil.toList(getResult.getResultData().toString()));
	    
	    // post 
	    param.put("id", sampleMapper.selectMaxId());
	    param.put("pw", "1234");
	    param.put("name", "김삿갓");
	    param.put("company_code", "0002");
	    
	    LuluResult postResult = httpConnectionService.sendPost("http://localhost:8080/wehago-template/sample", param);
	    resultData.put("post", postResult.getResultData());
	    
	    result.setResultData(resultData);
	    return result;
	}
	
	public LuluResult sampleMongoSelect(HashMap<String, Object> param){
		LuluResult result = new LuluResult();
	    HashMap<String, Object> resultData = new HashMap<String, Object>();
	    
	    MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017));
        MongoDatabase db = mongoClient.getDatabase("test");

        MongoCollection<Document> coll = db.getCollection("test");
        
        FindIterable<Document> results = coll.find();
        
        com.mongodb.util.JSON json = new com.mongodb.util.JSON();
        String str = json.serialize(results);
        System.out.println(str);
        resultData.put("list", str);
        
        /*
        MongoCursor<Document> cursor = coll.find().iterator();
        System.out.println(cursor.toString());
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            System.out.println(doc.toJson());
        }
        */
        
        /*
        MongoCollection coll = db.getCollection("test");
        
        MongoCursor<Document> cursor = coll.find().iterator();
        
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            
            List list = new ArrayList(doc.values());
            System.out.print(list.get(1));
            System.out.print(": ");
            System.out.println(list.get(2));
        }
        */
        
//        MongoCollection<Document> collection =  database.getCollection("COLLECTION_NAME");
//        DBObject dbObject  = new BasicDBObject("_id", username);
//        resultObject   = collection.find(dbObject).next();
//        String result =  resultObject.get(YOUR_COLOUM_NAME);
        
	    result.setResultData(resultData);
	    return result;
	}
	
	public LuluResult sampleMongoInsert(HashMap<String, Object> param){
		LuluResult result = new LuluResult();
	    HashMap<String, Object> resultData = new HashMap<String, Object>();

        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017));
        MongoDatabase db = mongoClient.getDatabase("test");

        MongoCollection coll = db.getCollection("test");
        Document doc = new Document();
        doc.put("id", "1");
        doc.put("aaa", "111");
        doc.put("bbb", "222");
        doc.put("ccc", DateTimeUtil.getDateTime("yyyyMMddHHmmss"));
        
        coll.insertOne(doc);
        
        mongoClient.close();
        
        /*
        BasicDBObject doc = new BasicDBObject();
        doc.put("id", "1");
        doc.put("aaa", "111");
        doc.put("bbb", "222");
        doc.put("ccc", "333");
        coll.insertOne(doc);
        */
        
        result.setResultData(resultData);
	    return result;
	}
	
}
