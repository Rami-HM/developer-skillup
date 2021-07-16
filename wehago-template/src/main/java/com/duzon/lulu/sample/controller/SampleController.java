package com.duzon.lulu.sample.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.duzon.common.controller.LuluBaseController;
import com.duzon.common.model.LuluResult;
import com.duzon.common.util.RequestUtil;
import com.duzon.lulu.auto.model.TestUser;
import com.duzon.lulu.sample.service.SampleService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class SampleController extends LuluBaseController {
	
	@Autowired
	private SampleService sampleService;
	@Autowired
	private HttpServletRequest request;
	
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * get sample - list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sample", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public ResponseEntity<?> getSampleList(HttpServletRequest request) throws Exception {
		List<TestUser> list = sampleService.getSampleList();
		return new ResponseEntity<List<TestUser>>(list, HttpStatus.OK);
	}
	
	/**
	 * get sample - single
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sample/{id}", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public ResponseEntity<?> getSampleSingle(@PathVariable("id") int id) throws Exception {
		TestUser testUser = sampleService.getSample(id);
		return new ResponseEntity<TestUser>(testUser, HttpStatus.OK);
	}
	
	/**
	 * create sample 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sample", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public ResponseEntity<?> createSample() throws Exception {
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		int cnt = sampleService.createSample(param);
		return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
	}
	
	/**
	 * update sample 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sample", method=RequestMethod.PUT, produces="application/json;charset=utf-8")
	public ResponseEntity<?> updateSample() throws Exception {
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		int cnt = sampleService.updateSample(param);
		return new ResponseEntity<Integer>(cnt, HttpStatus.OK);
	}
	
	/**
	 * delete sample
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sample/{id}", method=RequestMethod.DELETE, produces="application/json;charset=utf-8")
	public ResponseEntity<?> deleteSample(@PathVariable("id") int id) throws Exception{
		int cnt = sampleService.deleteSample(id);
		return new ResponseEntity<Integer>(cnt, HttpStatus.OK);
	}
	
	/**
	 * Sample API
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sample/api", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleApi() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = sampleService.sampleApi(param);
		return LuluResponse(result);
	}
	
	/**
	 * sampleRequestParam 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sample/requestParam", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleRequestParam(@RequestParam(value="id",required=true) String id
												, @RequestParam(value="pw",required=true) String pw
												, @RequestParam(value="name",required=false, defaultValue="김더존") String name
												, @RequestParam(value="company_code",required=false, defaultValue="0001") String company_code) throws Exception {
		LuluResult result = new LuluResult();
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("pw", pw);
		param.put("name", name);
		param.put("company_code", company_code);
		result.setResultData(param);
		
		return LuluResponse(result);
	}
	
	/**
	 * Multi
	 * @param request
	 * @param response
	 * @return
	 * 
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sample/multi", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleMulti() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = sampleService.sampleMulti(param);
		return LuluResponse(result);
	}
	
	/**
	 * Paging
	 * @param request
	 * @param response
	 * @return
	 * 
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sample/paging", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public ResponseEntity<?> samplePaging() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = sampleService.samplePaging(param);
		return LuluResponse(result);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sample/tran", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleTran() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = sampleService.sampleTran(param);
		return LuluResponse(result);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sample/inner", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleInner() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = sampleService.sampleInner(param);
		return LuluResponse(result);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sample/fileupload", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		HashMap<String, Object> resultData = new HashMap<String, Object>();
		
		// 저장 경로 - 실제 구현할때는 properties파일에 경로를 주어서 서버마다 원하는 위치로 파일을 저장합니다.
		String upLoadPath = "/Users/ssh/Documents/workspace/wehago-template/src/main/webapp/upload";
		// 폴더 없을경우 폴더 생성
		makeDir(upLoadPath);
		// 파일명 - 원하는 파일명으로 변경 
		String fileName = file.getOriginalFilename().trim();
		// 풀경로 (경로+파일명)
		String fullName = upLoadPath + File.separator + fileName;
		// 필요시 용량 체크
     	long fileSize = file.getSize();
     	// 파일 생성
     	file.transferTo(new File(fullName));
     	
     	// 리턴값
     	resultData.put("originalFilename", fileName);	// 원본파일이름
     	resultData.put("fileName", fileName);			// 변경된파일이름
     	resultData.put("fileSize", fileSize);			// 파일사이즈
    	result.setResultData(resultData);
     	
		return LuluResponse(result);
	}
	
	public void makeDir(String path){
		File uploadDir = new File(path);
    	if(!uploadDir.exists())
			uploadDir.mkdir();
	}
	
	/**
	 * mongo db select
	 * @param request
	 * @param response
	 * @return ResponseEntity
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sample/mongo", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleMongoSelect() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = sampleService.sampleMongoSelect(param);
		return LuluResponse(result);
	}
	
	/**
	 * mongo db insert
	 * @param request
	 * @param response
	 * @return ResponseEntity
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sample/mongo", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public ResponseEntity<?> sampleMongoInsert() throws Exception {
		LuluResult result = new LuluResult();
		HashMap<String, Object> param = RequestUtil.paramToHashMap(request);
		result = sampleService.sampleMongoInsert(param);
		return LuluResponse(result);
	}
	
}
