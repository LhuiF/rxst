package com.unionx.base.material.vo1;

import java.util.ArrayList;
import java.util.List;

public class SysCailiaoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCailiaoCriteria() {
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

        public Criteria andClnumIsNull() {
            addCriterion("clNum is null");
            return (Criteria) this;
        }

        public Criteria andClnumIsNotNull() {
            addCriterion("clNum is not null");
            return (Criteria) this;
        }

        public Criteria andClnumEqualTo(Integer value) {
            addCriterion("clNum =", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumNotEqualTo(Integer value) {
            addCriterion("clNum <>", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumGreaterThan(Integer value) {
            addCriterion("clNum >", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("clNum >=", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumLessThan(Integer value) {
            addCriterion("clNum <", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumLessThanOrEqualTo(Integer value) {
            addCriterion("clNum <=", value, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumIn(List<Integer> values) {
            addCriterion("clNum in", values, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumNotIn(List<Integer> values) {
            addCriterion("clNum not in", values, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumBetween(Integer value1, Integer value2) {
            addCriterion("clNum between", value1, value2, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnumNotBetween(Integer value1, Integer value2) {
            addCriterion("clNum not between", value1, value2, "clnum");
            return (Criteria) this;
        }

        public Criteria andClnameIsNull() {
            addCriterion("clName is null");
            return (Criteria) this;
        }

        public Criteria andClnameIsNotNull() {
            addCriterion("clName is not null");
            return (Criteria) this;
        }

        public Criteria andClnameEqualTo(String value) {
            addCriterion("clName =", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotEqualTo(String value) {
            addCriterion("clName <>", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThan(String value) {
            addCriterion("clName >", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThanOrEqualTo(String value) {
            addCriterion("clName >=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThan(String value) {
            addCriterion("clName <", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThanOrEqualTo(String value) {
            addCriterion("clName <=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLike(String value) {
            addCriterion("clName like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotLike(String value) {
            addCriterion("clName not like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameIn(List<String> values) {
            addCriterion("clName in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotIn(List<String> values) {
            addCriterion("clName not in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameBetween(String value1, String value2) {
            addCriterion("clName between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotBetween(String value1, String value2) {
            addCriterion("clName not between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andClrqstIsNull() {
            addCriterion("clRqst is null");
            return (Criteria) this;
        }

        public Criteria andClrqstIsNotNull() {
            addCriterion("clRqst is not null");
            return (Criteria) this;
        }

        public Criteria andClrqstEqualTo(String value) {
            addCriterion("clRqst =", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstNotEqualTo(String value) {
            addCriterion("clRqst <>", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstGreaterThan(String value) {
            addCriterion("clRqst >", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstGreaterThanOrEqualTo(String value) {
            addCriterion("clRqst >=", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstLessThan(String value) {
            addCriterion("clRqst <", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstLessThanOrEqualTo(String value) {
            addCriterion("clRqst <=", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstLike(String value) {
            addCriterion("clRqst like", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstNotLike(String value) {
            addCriterion("clRqst not like", value, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstIn(List<String> values) {
            addCriterion("clRqst in", values, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstNotIn(List<String> values) {
            addCriterion("clRqst not in", values, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstBetween(String value1, String value2) {
            addCriterion("clRqst between", value1, value2, "clrqst");
            return (Criteria) this;
        }

        public Criteria andClrqstNotBetween(String value1, String value2) {
            addCriterion("clRqst not between", value1, value2, "clrqst");
            return (Criteria) this;
        }

        public Criteria andTjUuidIsNull() {
            addCriterion("tj_uuid is null");
            return (Criteria) this;
        }

        public Criteria andTjUuidIsNotNull() {
            addCriterion("tj_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andTjUuidEqualTo(String value) {
            addCriterion("tj_uuid =", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidNotEqualTo(String value) {
            addCriterion("tj_uuid <>", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidGreaterThan(String value) {
            addCriterion("tj_uuid >", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidGreaterThanOrEqualTo(String value) {
            addCriterion("tj_uuid >=", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidLessThan(String value) {
            addCriterion("tj_uuid <", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidLessThanOrEqualTo(String value) {
            addCriterion("tj_uuid <=", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidLike(String value) {
            addCriterion("tj_uuid like", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidNotLike(String value) {
            addCriterion("tj_uuid not like", value, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidIn(List<String> values) {
            addCriterion("tj_uuid in", values, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidNotIn(List<String> values) {
            addCriterion("tj_uuid not in", values, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidBetween(String value1, String value2) {
            addCriterion("tj_uuid between", value1, value2, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andTjUuidNotBetween(String value1, String value2) {
            addCriterion("tj_uuid not between", value1, value2, "tjUuid");
            return (Criteria) this;
        }

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andClnameLikeInsensitive(String value) {
            addCriterion("upper(clName) like", value.toUpperCase(), "clname");
            return (Criteria) this;
        }

        public Criteria andClrqstLikeInsensitive(String value) {
            addCriterion("upper(clRqst) like", value.toUpperCase(), "clrqst");
            return (Criteria) this;
        }

        public Criteria andTjUuidLikeInsensitive(String value) {
            addCriterion("upper(tj_uuid) like", value.toUpperCase(), "tjUuid");
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