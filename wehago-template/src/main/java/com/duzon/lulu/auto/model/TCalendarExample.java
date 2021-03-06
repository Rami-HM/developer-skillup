package com.duzon.lulu.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCalendarExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public TCalendarExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andCalendar_idIsNull() {
			addCriterion("calendar_id is null");
			return (Criteria) this;
		}

		public Criteria andCalendar_idIsNotNull() {
			addCriterion("calendar_id is not null");
			return (Criteria) this;
		}

		public Criteria andCalendar_idEqualTo(Long value) {
			addCriterion("calendar_id =", value, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idNotEqualTo(Long value) {
			addCriterion("calendar_id <>", value, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idGreaterThan(Long value) {
			addCriterion("calendar_id >", value, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idGreaterThanOrEqualTo(Long value) {
			addCriterion("calendar_id >=", value, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idLessThan(Long value) {
			addCriterion("calendar_id <", value, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idLessThanOrEqualTo(Long value) {
			addCriterion("calendar_id <=", value, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idIn(List<Long> values) {
			addCriterion("calendar_id in", values, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idNotIn(List<Long> values) {
			addCriterion("calendar_id not in", values, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idBetween(Long value1, Long value2) {
			addCriterion("calendar_id between", value1, value2, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_idNotBetween(Long value1, Long value2) {
			addCriterion("calendar_id not between", value1, value2, "calendar_id");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameIsNull() {
			addCriterion("calendar_name is null");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameIsNotNull() {
			addCriterion("calendar_name is not null");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameEqualTo(String value) {
			addCriterion("calendar_name =", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameNotEqualTo(String value) {
			addCriterion("calendar_name <>", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameGreaterThan(String value) {
			addCriterion("calendar_name >", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameGreaterThanOrEqualTo(String value) {
			addCriterion("calendar_name >=", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameLessThan(String value) {
			addCriterion("calendar_name <", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameLessThanOrEqualTo(String value) {
			addCriterion("calendar_name <=", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameLike(String value) {
			addCriterion("calendar_name like", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameNotLike(String value) {
			addCriterion("calendar_name not like", value, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameIn(List<String> values) {
			addCriterion("calendar_name in", values, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameNotIn(List<String> values) {
			addCriterion("calendar_name not in", values, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameBetween(String value1, String value2) {
			addCriterion("calendar_name between", value1, value2, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andCalendar_nameNotBetween(String value1, String value2) {
			addCriterion("calendar_name not between", value1, value2, "calendar_name");
			return (Criteria) this;
		}

		public Criteria andReg_idIsNull() {
			addCriterion("reg_id is null");
			return (Criteria) this;
		}

		public Criteria andReg_idIsNotNull() {
			addCriterion("reg_id is not null");
			return (Criteria) this;
		}

		public Criteria andReg_idEqualTo(String value) {
			addCriterion("reg_id =", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idNotEqualTo(String value) {
			addCriterion("reg_id <>", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idGreaterThan(String value) {
			addCriterion("reg_id >", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idGreaterThanOrEqualTo(String value) {
			addCriterion("reg_id >=", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idLessThan(String value) {
			addCriterion("reg_id <", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idLessThanOrEqualTo(String value) {
			addCriterion("reg_id <=", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idLike(String value) {
			addCriterion("reg_id like", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idNotLike(String value) {
			addCriterion("reg_id not like", value, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idIn(List<String> values) {
			addCriterion("reg_id in", values, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idNotIn(List<String> values) {
			addCriterion("reg_id not in", values, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idBetween(String value1, String value2) {
			addCriterion("reg_id between", value1, value2, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_idNotBetween(String value1, String value2) {
			addCriterion("reg_id not between", value1, value2, "reg_id");
			return (Criteria) this;
		}

		public Criteria andReg_dateIsNull() {
			addCriterion("reg_date is null");
			return (Criteria) this;
		}

		public Criteria andReg_dateIsNotNull() {
			addCriterion("reg_date is not null");
			return (Criteria) this;
		}

		public Criteria andReg_dateEqualTo(Date value) {
			addCriterionForJDBCDate("reg_date =", value, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("reg_date <>", value, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("reg_date >", value, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("reg_date >=", value, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateLessThan(Date value) {
			addCriterionForJDBCDate("reg_date <", value, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("reg_date <=", value, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateIn(List<Date> values) {
			addCriterionForJDBCDate("reg_date in", values, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("reg_date not in", values, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("reg_date between", value1, value2, "reg_date");
			return (Criteria) this;
		}

		public Criteria andReg_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("reg_date not between", value1, value2, "reg_date");
			return (Criteria) this;
		}

		public Criteria andUpt_idIsNull() {
			addCriterion("upt_id is null");
			return (Criteria) this;
		}

		public Criteria andUpt_idIsNotNull() {
			addCriterion("upt_id is not null");
			return (Criteria) this;
		}

		public Criteria andUpt_idEqualTo(String value) {
			addCriterion("upt_id =", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idNotEqualTo(String value) {
			addCriterion("upt_id <>", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idGreaterThan(String value) {
			addCriterion("upt_id >", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idGreaterThanOrEqualTo(String value) {
			addCriterion("upt_id >=", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idLessThan(String value) {
			addCriterion("upt_id <", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idLessThanOrEqualTo(String value) {
			addCriterion("upt_id <=", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idLike(String value) {
			addCriterion("upt_id like", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idNotLike(String value) {
			addCriterion("upt_id not like", value, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idIn(List<String> values) {
			addCriterion("upt_id in", values, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idNotIn(List<String> values) {
			addCriterion("upt_id not in", values, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idBetween(String value1, String value2) {
			addCriterion("upt_id between", value1, value2, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUpt_idNotBetween(String value1, String value2) {
			addCriterion("upt_id not between", value1, value2, "upt_id");
			return (Criteria) this;
		}

		public Criteria andUseynIsNull() {
			addCriterion("useyn is null");
			return (Criteria) this;
		}

		public Criteria andUseynIsNotNull() {
			addCriterion("useyn is not null");
			return (Criteria) this;
		}

		public Criteria andUseynEqualTo(String value) {
			addCriterion("useyn =", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynNotEqualTo(String value) {
			addCriterion("useyn <>", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynGreaterThan(String value) {
			addCriterion("useyn >", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynGreaterThanOrEqualTo(String value) {
			addCriterion("useyn >=", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynLessThan(String value) {
			addCriterion("useyn <", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynLessThanOrEqualTo(String value) {
			addCriterion("useyn <=", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynLike(String value) {
			addCriterion("useyn like", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynNotLike(String value) {
			addCriterion("useyn not like", value, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynIn(List<String> values) {
			addCriterion("useyn in", values, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynNotIn(List<String> values) {
			addCriterion("useyn not in", values, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynBetween(String value1, String value2) {
			addCriterion("useyn between", value1, value2, "useyn");
			return (Criteria) this;
		}

		public Criteria andUseynNotBetween(String value1, String value2) {
			addCriterion("useyn not between", value1, value2, "useyn");
			return (Criteria) this;
		}

		public Criteria andUpt_dateIsNull() {
			addCriterion("upt_date is null");
			return (Criteria) this;
		}

		public Criteria andUpt_dateIsNotNull() {
			addCriterion("upt_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpt_dateEqualTo(Date value) {
			addCriterionForJDBCDate("upt_date =", value, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("upt_date <>", value, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("upt_date >", value, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("upt_date >=", value, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateLessThan(Date value) {
			addCriterionForJDBCDate("upt_date <", value, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("upt_date <=", value, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateIn(List<Date> values) {
			addCriterionForJDBCDate("upt_date in", values, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("upt_date not in", values, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("upt_date between", value1, value2, "upt_date");
			return (Criteria) this;
		}

		public Criteria andUpt_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("upt_date not between", value1, value2, "upt_date");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_calendar
	 * @mbg.generated  Tue Jul 13 14:39:50 KST 2021
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_calendar
     *
     * @mbg.generated do_not_delete_during_merge Fri Jul 09 15:04:10 KST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}