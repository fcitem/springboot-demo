package com.boot.mybatis.bean;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class UserExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
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

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("USER_ID like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("USER_ID not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(Object value) {
			addCriterion("USER_NAME =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(Object value) {
			addCriterion("USER_NAME <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(Object value) {
			addCriterion("USER_NAME >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(Object value) {
			addCriterion("USER_NAME >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(Object value) {
			addCriterion("USER_NAME <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(Object value) {
			addCriterion("USER_NAME <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<Object> values) {
			addCriterion("USER_NAME in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<Object> values) {
			addCriterion("USER_NAME not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(Object value1, Object value2) {
			addCriterion("USER_NAME between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(Object value1, Object value2) {
			addCriterion("USER_NAME not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andLoginIdIsNull() {
			addCriterion("LOGIN_ID is null");
			return (Criteria) this;
		}

		public Criteria andLoginIdIsNotNull() {
			addCriterion("LOGIN_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLoginIdEqualTo(String value) {
			addCriterion("LOGIN_ID =", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotEqualTo(String value) {
			addCriterion("LOGIN_ID <>", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdGreaterThan(String value) {
			addCriterion("LOGIN_ID >", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdGreaterThanOrEqualTo(String value) {
			addCriterion("LOGIN_ID >=", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdLessThan(String value) {
			addCriterion("LOGIN_ID <", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdLessThanOrEqualTo(String value) {
			addCriterion("LOGIN_ID <=", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdLike(String value) {
			addCriterion("LOGIN_ID like", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotLike(String value) {
			addCriterion("LOGIN_ID not like", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdIn(List<String> values) {
			addCriterion("LOGIN_ID in", values, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotIn(List<String> values) {
			addCriterion("LOGIN_ID not in", values, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdBetween(String value1, String value2) {
			addCriterion("LOGIN_ID between", value1, value2, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotBetween(String value1, String value2) {
			addCriterion("LOGIN_ID not between", value1, value2, "loginId");
			return (Criteria) this;
		}

		public Criteria andUserPwdIsNull() {
			addCriterion("USER_PWD is null");
			return (Criteria) this;
		}

		public Criteria andUserPwdIsNotNull() {
			addCriterion("USER_PWD is not null");
			return (Criteria) this;
		}

		public Criteria andUserPwdEqualTo(Object value) {
			addCriterion("USER_PWD =", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotEqualTo(Object value) {
			addCriterion("USER_PWD <>", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdGreaterThan(Object value) {
			addCriterion("USER_PWD >", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdGreaterThanOrEqualTo(Object value) {
			addCriterion("USER_PWD >=", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLessThan(Object value) {
			addCriterion("USER_PWD <", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLessThanOrEqualTo(Object value) {
			addCriterion("USER_PWD <=", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdIn(List<Object> values) {
			addCriterion("USER_PWD in", values, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotIn(List<Object> values) {
			addCriterion("USER_PWD not in", values, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdBetween(Object value1, Object value2) {
			addCriterion("USER_PWD between", value1, value2, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotBetween(Object value1, Object value2) {
			addCriterion("USER_PWD not between", value1, value2, "userPwd");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("STATUS is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(BigDecimal value) {
			addCriterion("STATUS =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(BigDecimal value) {
			addCriterion("STATUS <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(BigDecimal value) {
			addCriterion("STATUS >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("STATUS >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(BigDecimal value) {
			addCriterion("STATUS <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(BigDecimal value) {
			addCriterion("STATUS <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<BigDecimal> values) {
			addCriterion("STATUS in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<BigDecimal> values) {
			addCriterion("STATUS not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("STATUS between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("STATUS not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(Object value) {
			addCriterion("EMAIL =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(Object value) {
			addCriterion("EMAIL <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(Object value) {
			addCriterion("EMAIL >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(Object value) {
			addCriterion("EMAIL >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(Object value) {
			addCriterion("EMAIL <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(Object value) {
			addCriterion("EMAIL <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<Object> values) {
			addCriterion("EMAIL in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<Object> values) {
			addCriterion("EMAIL not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(Object value1, Object value2) {
			addCriterion("EMAIL between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(Object value1, Object value2) {
			addCriterion("EMAIL not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNull() {
			addCriterion("TELEPHONE is null");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNotNull() {
			addCriterion("TELEPHONE is not null");
			return (Criteria) this;
		}

		public Criteria andTelephoneEqualTo(Object value) {
			addCriterion("TELEPHONE =", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotEqualTo(Object value) {
			addCriterion("TELEPHONE <>", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThan(Object value) {
			addCriterion("TELEPHONE >", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThanOrEqualTo(Object value) {
			addCriterion("TELEPHONE >=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThan(Object value) {
			addCriterion("TELEPHONE <", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThanOrEqualTo(Object value) {
			addCriterion("TELEPHONE <=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneIn(List<Object> values) {
			addCriterion("TELEPHONE in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotIn(List<Object> values) {
			addCriterion("TELEPHONE not in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneBetween(Object value1, Object value2) {
			addCriterion("TELEPHONE between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotBetween(Object value1, Object value2) {
			addCriterion("TELEPHONE not between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andUserDescIsNull() {
			addCriterion("USER_DESC is null");
			return (Criteria) this;
		}

		public Criteria andUserDescIsNotNull() {
			addCriterion("USER_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andUserDescEqualTo(Object value) {
			addCriterion("USER_DESC =", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescNotEqualTo(Object value) {
			addCriterion("USER_DESC <>", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescGreaterThan(Object value) {
			addCriterion("USER_DESC >", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescGreaterThanOrEqualTo(Object value) {
			addCriterion("USER_DESC >=", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescLessThan(Object value) {
			addCriterion("USER_DESC <", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescLessThanOrEqualTo(Object value) {
			addCriterion("USER_DESC <=", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescIn(List<Object> values) {
			addCriterion("USER_DESC in", values, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescNotIn(List<Object> values) {
			addCriterion("USER_DESC not in", values, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescBetween(Object value1, Object value2) {
			addCriterion("USER_DESC between", value1, value2, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescNotBetween(Object value1, Object value2) {
			addCriterion("USER_DESC not between", value1, value2, "userDesc");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}

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
}