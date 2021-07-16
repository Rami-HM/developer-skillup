package com.duzon.lulu.sample.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.duzon.common.mapper.LuluAbstractMapper;

/**
 * Sample Mapper
 * @author 신승현
 * @since 2016.10.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  2016.10.12 신승현        최초 생성
 *
 * </pre>
 */
@Repository("sampleMapper")
public class SampleMapper extends LuluAbstractMapper {
	
	public List selectList(HashMap param) {
		return selectList("mapper.SampleMapper.selectList", param);
	}
	
	public int selectMaxId() {
		return selectOne("mapper.SampleMapper.selectMaxId");
	}
	
	public List selectListPaging(HashMap param) {
		return selectList("mapper.SampleMapper.selectListPaging", param);
	}
	
	public int selectListPagingCnt(HashMap param) {
		return selectOne("mapper.SampleMapper.selectListPagingCnt", param);
	}
	public int insertTran(HashMap param) {
		return insert("mapper.SampleMapper.insertTran", param);
	}
}
