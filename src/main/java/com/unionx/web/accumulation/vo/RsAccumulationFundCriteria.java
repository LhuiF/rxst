package com.unionx.web.accumulation.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RsAccumulationFundCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RsAccumulationFundCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNull() {
            addCriterion("dict_code is null");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNotNull() {
            addCriterion("dict_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictCodeEqualTo(String value) {
            addCriterion("dict_code =", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotEqualTo(String value) {
            addCriterion("dict_code <>", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThan(String value) {
            addCriterion("dict_code >", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dict_code >=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThan(String value) {
            addCriterion("dict_code <", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThanOrEqualTo(String value) {
            addCriterion("dict_code <=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLike(String value) {
            addCriterion("dict_code like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotLike(String value) {
            addCriterion("dict_code not like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeIn(List<String> values) {
            addCriterion("dict_code in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotIn(List<String> values) {
            addCriterion("dict_code not in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeBetween(String value1, String value2) {
            addCriterion("dict_code between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotBetween(String value1, String value2) {
            addCriterion("dict_code not between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNull() {
            addCriterion("dict_name is null");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNotNull() {
            addCriterion("dict_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictNameEqualTo(String value) {
            addCriterion("dict_name =", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotEqualTo(String value) {
            addCriterion("dict_name <>", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThan(String value) {
            addCriterion("dict_name >", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThanOrEqualTo(String value) {
            addCriterion("dict_name >=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThan(String value) {
            addCriterion("dict_name <", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThanOrEqualTo(String value) {
            addCriterion("dict_name <=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLike(String value) {
            addCriterion("dict_name like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotLike(String value) {
            addCriterion("dict_name not like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameIn(List<String> values) {
            addCriterion("dict_name in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotIn(List<String> values) {
            addCriterion("dict_name not in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameBetween(String value1, String value2) {
            addCriterion("dict_name between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotBetween(String value1, String value2) {
            addCriterion("dict_name not between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andFundYearIsNull() {
            addCriterion("fund_year is null");
            return (Criteria) this;
        }

        public Criteria andFundYearIsNotNull() {
            addCriterion("fund_year is not null");
            return (Criteria) this;
        }

        public Criteria andFundYearEqualTo(String value) {
            addCriterion("fund_year =", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearNotEqualTo(String value) {
            addCriterion("fund_year <>", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearGreaterThan(String value) {
            addCriterion("fund_year >", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearGreaterThanOrEqualTo(String value) {
            addCriterion("fund_year >=", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearLessThan(String value) {
            addCriterion("fund_year <", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearLessThanOrEqualTo(String value) {
            addCriterion("fund_year <=", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearLike(String value) {
            addCriterion("fund_year like", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearNotLike(String value) {
            addCriterion("fund_year not like", value, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearIn(List<String> values) {
            addCriterion("fund_year in", values, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearNotIn(List<String> values) {
            addCriterion("fund_year not in", values, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearBetween(String value1, String value2) {
            addCriterion("fund_year between", value1, value2, "fundYear");
            return (Criteria) this;
        }

        public Criteria andFundYearNotBetween(String value1, String value2) {
            addCriterion("fund_year not between", value1, value2, "fundYear");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andClearMonthIsNull() {
            addCriterion("clear_month is null");
            return (Criteria) this;
        }

        public Criteria andClearMonthIsNotNull() {
            addCriterion("clear_month is not null");
            return (Criteria) this;
        }

        public Criteria andClearMonthEqualTo(String value) {
            addCriterion("clear_month =", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthNotEqualTo(String value) {
            addCriterion("clear_month <>", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthGreaterThan(String value) {
            addCriterion("clear_month >", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthGreaterThanOrEqualTo(String value) {
            addCriterion("clear_month >=", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthLessThan(String value) {
            addCriterion("clear_month <", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthLessThanOrEqualTo(String value) {
            addCriterion("clear_month <=", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthLike(String value) {
            addCriterion("clear_month like", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthNotLike(String value) {
            addCriterion("clear_month not like", value, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthIn(List<String> values) {
            addCriterion("clear_month in", values, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthNotIn(List<String> values) {
            addCriterion("clear_month not in", values, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthBetween(String value1, String value2) {
            addCriterion("clear_month between", value1, value2, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andClearMonthNotBetween(String value1, String value2) {
            addCriterion("clear_month not between", value1, value2, "clearMonth");
            return (Criteria) this;
        }

        public Criteria andAveragePayIsNull() {
            addCriterion("average_pay is null");
            return (Criteria) this;
        }

        public Criteria andAveragePayIsNotNull() {
            addCriterion("average_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAveragePayEqualTo(Long value) {
            addCriterion("average_pay =", value, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayNotEqualTo(Long value) {
            addCriterion("average_pay <>", value, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayGreaterThan(Long value) {
            addCriterion("average_pay >", value, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayGreaterThanOrEqualTo(Long value) {
            addCriterion("average_pay >=", value, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayLessThan(Long value) {
            addCriterion("average_pay <", value, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayLessThanOrEqualTo(Long value) {
            addCriterion("average_pay <=", value, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayIn(List<Long> values) {
            addCriterion("average_pay in", values, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayNotIn(List<Long> values) {
            addCriterion("average_pay not in", values, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayBetween(Long value1, Long value2) {
            addCriterion("average_pay between", value1, value2, "averagePay");
            return (Criteria) this;
        }

        public Criteria andAveragePayNotBetween(Long value1, Long value2) {
            addCriterion("average_pay not between", value1, value2, "averagePay");
            return (Criteria) this;
        }

        public Criteria andCeilingIsNull() {
            addCriterion("ceiling is null");
            return (Criteria) this;
        }

        public Criteria andCeilingIsNotNull() {
            addCriterion("ceiling is not null");
            return (Criteria) this;
        }

        public Criteria andCeilingEqualTo(String value) {
            addCriterion("ceiling =", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingNotEqualTo(String value) {
            addCriterion("ceiling <>", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingGreaterThan(String value) {
            addCriterion("ceiling >", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingGreaterThanOrEqualTo(String value) {
            addCriterion("ceiling >=", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingLessThan(String value) {
            addCriterion("ceiling <", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingLessThanOrEqualTo(String value) {
            addCriterion("ceiling <=", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingLike(String value) {
            addCriterion("ceiling like", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingNotLike(String value) {
            addCriterion("ceiling not like", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingIn(List<String> values) {
            addCriterion("ceiling in", values, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingNotIn(List<String> values) {
            addCriterion("ceiling not in", values, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingBetween(String value1, String value2) {
            addCriterion("ceiling between", value1, value2, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingNotBetween(String value1, String value2) {
            addCriterion("ceiling not between", value1, value2, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseIsNull() {
            addCriterion("ceiling_base is null");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseIsNotNull() {
            addCriterion("ceiling_base is not null");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseEqualTo(String value) {
            addCriterion("ceiling_base =", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseNotEqualTo(String value) {
            addCriterion("ceiling_base <>", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseGreaterThan(String value) {
            addCriterion("ceiling_base >", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseGreaterThanOrEqualTo(String value) {
            addCriterion("ceiling_base >=", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseLessThan(String value) {
            addCriterion("ceiling_base <", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseLessThanOrEqualTo(String value) {
            addCriterion("ceiling_base <=", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseLike(String value) {
            addCriterion("ceiling_base like", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseNotLike(String value) {
            addCriterion("ceiling_base not like", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseIn(List<String> values) {
            addCriterion("ceiling_base in", values, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseNotIn(List<String> values) {
            addCriterion("ceiling_base not in", values, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseBetween(String value1, String value2) {
            addCriterion("ceiling_base between", value1, value2, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseNotBetween(String value1, String value2) {
            addCriterion("ceiling_base not between", value1, value2, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseIsNull() {
            addCriterion("floor_base is null");
            return (Criteria) this;
        }

        public Criteria andFloorBaseIsNotNull() {
            addCriterion("floor_base is not null");
            return (Criteria) this;
        }

        public Criteria andFloorBaseEqualTo(String value) {
            addCriterion("floor_base =", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseNotEqualTo(String value) {
            addCriterion("floor_base <>", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseGreaterThan(String value) {
            addCriterion("floor_base >", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseGreaterThanOrEqualTo(String value) {
            addCriterion("floor_base >=", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseLessThan(String value) {
            addCriterion("floor_base <", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseLessThanOrEqualTo(String value) {
            addCriterion("floor_base <=", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseLike(String value) {
            addCriterion("floor_base like", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseNotLike(String value) {
            addCriterion("floor_base not like", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseIn(List<String> values) {
            addCriterion("floor_base in", values, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseNotIn(List<String> values) {
            addCriterion("floor_base not in", values, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseBetween(String value1, String value2) {
            addCriterion("floor_base between", value1, value2, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseNotBetween(String value1, String value2) {
            addCriterion("floor_base not between", value1, value2, "floorBase");
            return (Criteria) this;
        }

        public Criteria andYearCityIsNull() {
            addCriterion("year_city is null");
            return (Criteria) this;
        }

        public Criteria andYearCityIsNotNull() {
            addCriterion("year_city is not null");
            return (Criteria) this;
        }

        public Criteria andYearCityEqualTo(String value) {
            addCriterion("year_city =", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityNotEqualTo(String value) {
            addCriterion("year_city <>", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityGreaterThan(String value) {
            addCriterion("year_city >", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityGreaterThanOrEqualTo(String value) {
            addCriterion("year_city >=", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityLessThan(String value) {
            addCriterion("year_city <", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityLessThanOrEqualTo(String value) {
            addCriterion("year_city <=", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityLike(String value) {
            addCriterion("year_city like", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityNotLike(String value) {
            addCriterion("year_city not like", value, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityIn(List<String> values) {
            addCriterion("year_city in", values, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityNotIn(List<String> values) {
            addCriterion("year_city not in", values, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityBetween(String value1, String value2) {
            addCriterion("year_city between", value1, value2, "yearCity");
            return (Criteria) this;
        }

        public Criteria andYearCityNotBetween(String value1, String value2) {
            addCriterion("year_city not between", value1, value2, "yearCity");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("isdel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isdel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Boolean value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Boolean value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Boolean value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Boolean value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Boolean value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Boolean> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Boolean> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Boolean value1, Boolean value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNull() {
            addCriterion("update_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNotNull() {
            addCriterion("update_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameEqualTo(String value) {
            addCriterion("update_name =", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotEqualTo(String value) {
            addCriterion("update_name <>", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThan(String value) {
            addCriterion("update_name >", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_name >=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThan(String value) {
            addCriterion("update_name <", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("update_name <=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLike(String value) {
            addCriterion("update_name like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotLike(String value) {
            addCriterion("update_name not like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIn(List<String> values) {
            addCriterion("update_name in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotIn(List<String> values) {
            addCriterion("update_name not in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameBetween(String value1, String value2) {
            addCriterion("update_name between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotBetween(String value1, String value2) {
            addCriterion("update_name not between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andDictCodeLikeInsensitive(String value) {
            addCriterion("upper(dict_code) like", value.toUpperCase(), "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictNameLikeInsensitive(String value) {
            addCriterion("upper(dict_name) like", value.toUpperCase(), "dictName");
            return (Criteria) this;
        }

        public Criteria andFundYearLikeInsensitive(String value) {
            addCriterion("upper(fund_year) like", value.toUpperCase(), "fundYear");
            return (Criteria) this;
        }

        public Criteria andClearMonthLikeInsensitive(String value) {
            addCriterion("upper(clear_month) like", value.toUpperCase(), "clearMonth");
            return (Criteria) this;
        }

        public Criteria andCeilingLikeInsensitive(String value) {
            addCriterion("upper(ceiling) like", value.toUpperCase(), "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseLikeInsensitive(String value) {
            addCriterion("upper(ceiling_base) like", value.toUpperCase(), "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseLikeInsensitive(String value) {
            addCriterion("upper(floor_base) like", value.toUpperCase(), "floorBase");
            return (Criteria) this;
        }

        public Criteria andYearCityLikeInsensitive(String value) {
            addCriterion("upper(year_city) like", value.toUpperCase(), "yearCity");
            return (Criteria) this;
        }

        public Criteria andCommentLikeInsensitive(String value) {
            addCriterion("upper(comment) like", value.toUpperCase(), "comment");
            return (Criteria) this;
        }

        public Criteria andCreateNameLikeInsensitive(String value) {
            addCriterion("upper(create_name) like", value.toUpperCase(), "createName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLikeInsensitive(String value) {
            addCriterion("upper(update_name) like", value.toUpperCase(), "updateName");
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