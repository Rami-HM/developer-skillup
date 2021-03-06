package com.duzon.lulu.auto.mapper;

import com.duzon.lulu.auto.model.TestUser;
import com.duzon.lulu.auto.model.TestUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestUserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	long countByExample(TestUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int deleteByExample(TestUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int insert(TestUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int insertSelective(TestUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	List<TestUser> selectByExample(TestUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	TestUser selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int updateByExampleSelective(@Param("record") TestUser record, @Param("example") TestUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int updateByExample(@Param("record") TestUser record, @Param("example") TestUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int updateByPrimaryKeySelective(TestUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_user
	 * @mbg.generated  Thu Oct 13 16:52:32 KST 2016
	 */
	int updateByPrimaryKey(TestUser record);
}