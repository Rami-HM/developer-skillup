package com.duzon.lulu.auto.mapper;

import com.duzon.lulu.auto.model.TSchedule;
import com.duzon.lulu.auto.model.TScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScheduleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    long countByExample(TScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int deleteByExample(TScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int deleteByPrimaryKey(Long schedule_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int insert(TSchedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int insertSelective(TSchedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    List<TSchedule> selectByExample(TScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    TSchedule selectByPrimaryKey(Long schedule_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int updateByExampleSelective(@Param("record") TSchedule record, @Param("example") TScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int updateByExample(@Param("record") TSchedule record, @Param("example") TScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int updateByPrimaryKeySelective(TSchedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbg.generated Tue Jul 13 14:39:50 KST 2021
     */
    int updateByPrimaryKey(TSchedule record);
}