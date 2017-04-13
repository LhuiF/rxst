package com.unionx.web.insurance.vo;

import java.util.ArrayList;
import java.util.List;

public class RsInsuranceBaseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RsInsuranceBaseCriteria() {
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

        public Criteria andInsuranceUuidIsNull() {
            addCriterion("insurance_uuid is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidIsNotNull() {
            addCriterion("insurance_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidEqualTo(String value) {
            addCriterion("insurance_uuid =", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidNotEqualTo(String value) {
            addCriterion("insurance_uuid <>", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidGreaterThan(String value) {
            addCriterion("insurance_uuid >", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidGreaterThanOrEqualTo(String value) {
            addCriterion("insurance_uuid >=", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidLessThan(String value) {
            addCriterion("insurance_uuid <", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidLessThanOrEqualTo(String value) {
            addCriterion("insurance_uuid <=", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidLike(String value) {
            addCriterion("insurance_uuid like", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidNotLike(String value) {
            addCriterion("insurance_uuid not like", value, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidIn(List<String> values) {
            addCriterion("insurance_uuid in", values, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidNotIn(List<String> values) {
            addCriterion("insurance_uuid not in", values, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidBetween(String value1, String value2) {
            addCriterion("insurance_uuid between", value1, value2, "insuranceUuid");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidNotBetween(String value1, String value2) {
            addCriterion("insurance_uuid not between", value1, value2, "insuranceUuid");
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

        public Criteria andCeilingIsNull() {
            addCriterion("ceiling is null");
            return (Criteria) this;
        }

        public Criteria andCeilingIsNotNull() {
            addCriterion("ceiling is not null");
            return (Criteria) this;
        }

        public Criteria andCeilingEqualTo(Double value) {
            addCriterion("ceiling =", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingNotEqualTo(Double value) {
            addCriterion("ceiling <>", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingGreaterThan(Double value) {
            addCriterion("ceiling >", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingGreaterThanOrEqualTo(Double value) {
            addCriterion("ceiling >=", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingLessThan(Double value) {
            addCriterion("ceiling <", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingLessThanOrEqualTo(Double value) {
            addCriterion("ceiling <=", value, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingIn(List<Double> values) {
            addCriterion("ceiling in", values, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingNotIn(List<Double> values) {
            addCriterion("ceiling not in", values, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingBetween(Double value1, Double value2) {
            addCriterion("ceiling between", value1, value2, "ceiling");
            return (Criteria) this;
        }

        public Criteria andCeilingNotBetween(Double value1, Double value2) {
            addCriterion("ceiling not between", value1, value2, "ceiling");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Double value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Double value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Double value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Double value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Double value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Double value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Double> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Double> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Double value1, Double value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Double value1, Double value2) {
            addCriterion("floor not between", value1, value2, "floor");
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

        public Criteria andCeilingBaseEqualTo(Double value) {
            addCriterion("ceiling_base =", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseNotEqualTo(Double value) {
            addCriterion("ceiling_base <>", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseGreaterThan(Double value) {
            addCriterion("ceiling_base >", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseGreaterThanOrEqualTo(Double value) {
            addCriterion("ceiling_base >=", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseLessThan(Double value) {
            addCriterion("ceiling_base <", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseLessThanOrEqualTo(Double value) {
            addCriterion("ceiling_base <=", value, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseIn(List<Double> values) {
            addCriterion("ceiling_base in", values, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseNotIn(List<Double> values) {
            addCriterion("ceiling_base not in", values, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseBetween(Double value1, Double value2) {
            addCriterion("ceiling_base between", value1, value2, "ceilingBase");
            return (Criteria) this;
        }

        public Criteria andCeilingBaseNotBetween(Double value1, Double value2) {
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

        public Criteria andFloorBaseEqualTo(Double value) {
            addCriterion("floor_base =", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseNotEqualTo(Double value) {
            addCriterion("floor_base <>", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseGreaterThan(Double value) {
            addCriterion("floor_base >", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseGreaterThanOrEqualTo(Double value) {
            addCriterion("floor_base >=", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseLessThan(Double value) {
            addCriterion("floor_base <", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseLessThanOrEqualTo(Double value) {
            addCriterion("floor_base <=", value, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseIn(List<Double> values) {
            addCriterion("floor_base in", values, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseNotIn(List<Double> values) {
            addCriterion("floor_base not in", values, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseBetween(Double value1, Double value2) {
            addCriterion("floor_base between", value1, value2, "floorBase");
            return (Criteria) this;
        }

        public Criteria andFloorBaseNotBetween(Double value1, Double value2) {
            addCriterion("floor_base not between", value1, value2, "floorBase");
            return (Criteria) this;
        }

        public Criteria andInsuranceUuidLikeInsensitive(String value) {
            addCriterion("upper(insurance_uuid) like", value.toUpperCase(), "insuranceUuid");
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