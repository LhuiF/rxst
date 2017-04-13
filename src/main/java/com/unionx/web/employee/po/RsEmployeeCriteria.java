package com.unionx.web.employee.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RsEmployeeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RsEmployeeCriteria() {
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeIsNull() {
            addCriterion("paper_work_type is null");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeIsNotNull() {
            addCriterion("paper_work_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeEqualTo(String value) {
            addCriterion("paper_work_type =", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeNotEqualTo(String value) {
            addCriterion("paper_work_type <>", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeGreaterThan(String value) {
            addCriterion("paper_work_type >", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("paper_work_type >=", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeLessThan(String value) {
            addCriterion("paper_work_type <", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("paper_work_type <=", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeLike(String value) {
            addCriterion("paper_work_type like", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeNotLike(String value) {
            addCriterion("paper_work_type not like", value, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeIn(List<String> values) {
            addCriterion("paper_work_type in", values, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeNotIn(List<String> values) {
            addCriterion("paper_work_type not in", values, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeBetween(String value1, String value2) {
            addCriterion("paper_work_type between", value1, value2, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeNotBetween(String value1, String value2) {
            addCriterion("paper_work_type not between", value1, value2, "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeIsNull() {
            addCriterion("paper_work_code is null");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeIsNotNull() {
            addCriterion("paper_work_code is not null");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeEqualTo(String value) {
            addCriterion("paper_work_code =", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeNotEqualTo(String value) {
            addCriterion("paper_work_code <>", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeGreaterThan(String value) {
            addCriterion("paper_work_code >", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeGreaterThanOrEqualTo(String value) {
            addCriterion("paper_work_code >=", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeLessThan(String value) {
            addCriterion("paper_work_code <", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeLessThanOrEqualTo(String value) {
            addCriterion("paper_work_code <=", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeLike(String value) {
            addCriterion("paper_work_code like", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeNotLike(String value) {
            addCriterion("paper_work_code not like", value, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeIn(List<String> values) {
            addCriterion("paper_work_code in", values, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeNotIn(List<String> values) {
            addCriterion("paper_work_code not in", values, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeBetween(String value1, String value2) {
            addCriterion("paper_work_code between", value1, value2, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeNotBetween(String value1, String value2) {
            addCriterion("paper_work_code not between", value1, value2, "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterionForJDBCDate("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterionForJDBCDate("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterionForJDBCDate("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelIsNull() {
            addCriterion("educational_level is null");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelIsNotNull() {
            addCriterion("educational_level is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelEqualTo(String value) {
            addCriterion("educational_level =", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelNotEqualTo(String value) {
            addCriterion("educational_level <>", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelGreaterThan(String value) {
            addCriterion("educational_level >", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelGreaterThanOrEqualTo(String value) {
            addCriterion("educational_level >=", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelLessThan(String value) {
            addCriterion("educational_level <", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelLessThanOrEqualTo(String value) {
            addCriterion("educational_level <=", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelLike(String value) {
            addCriterion("educational_level like", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelNotLike(String value) {
            addCriterion("educational_level not like", value, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelIn(List<String> values) {
            addCriterion("educational_level in", values, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelNotIn(List<String> values) {
            addCriterion("educational_level not in", values, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelBetween(String value1, String value2) {
            addCriterion("educational_level between", value1, value2, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelNotBetween(String value1, String value2) {
            addCriterion("educational_level not between", value1, value2, "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andCountryRegionIsNull() {
            addCriterion("country_region is null");
            return (Criteria) this;
        }

        public Criteria andCountryRegionIsNotNull() {
            addCriterion("country_region is not null");
            return (Criteria) this;
        }

        public Criteria andCountryRegionEqualTo(String value) {
            addCriterion("country_region =", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionNotEqualTo(String value) {
            addCriterion("country_region <>", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionGreaterThan(String value) {
            addCriterion("country_region >", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionGreaterThanOrEqualTo(String value) {
            addCriterion("country_region >=", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionLessThan(String value) {
            addCriterion("country_region <", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionLessThanOrEqualTo(String value) {
            addCriterion("country_region <=", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionLike(String value) {
            addCriterion("country_region like", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionNotLike(String value) {
            addCriterion("country_region not like", value, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionIn(List<String> values) {
            addCriterion("country_region in", values, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionNotIn(List<String> values) {
            addCriterion("country_region not in", values, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionBetween(String value1, String value2) {
            addCriterion("country_region between", value1, value2, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andCountryRegionNotBetween(String value1, String value2) {
            addCriterion("country_region not between", value1, value2, "countryRegion");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityIsNull() {
            addCriterion("personal_identity is null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityIsNotNull() {
            addCriterion("personal_identity is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityEqualTo(String value) {
            addCriterion("personal_identity =", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityNotEqualTo(String value) {
            addCriterion("personal_identity <>", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityGreaterThan(String value) {
            addCriterion("personal_identity >", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("personal_identity >=", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityLessThan(String value) {
            addCriterion("personal_identity <", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityLessThanOrEqualTo(String value) {
            addCriterion("personal_identity <=", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityLike(String value) {
            addCriterion("personal_identity like", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityNotLike(String value) {
            addCriterion("personal_identity not like", value, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityIn(List<String> values) {
            addCriterion("personal_identity in", values, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityNotIn(List<String> values) {
            addCriterion("personal_identity not in", values, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityBetween(String value1, String value2) {
            addCriterion("personal_identity between", value1, value2, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityNotBetween(String value1, String value2) {
            addCriterion("personal_identity not between", value1, value2, "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeIsNull() {
            addCriterion("citizen_ID_code is null");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeIsNotNull() {
            addCriterion("citizen_ID_code is not null");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeEqualTo(String value) {
            addCriterion("citizen_ID_code =", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeNotEqualTo(String value) {
            addCriterion("citizen_ID_code <>", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeGreaterThan(String value) {
            addCriterion("citizen_ID_code >", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("citizen_ID_code >=", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeLessThan(String value) {
            addCriterion("citizen_ID_code <", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeLessThanOrEqualTo(String value) {
            addCriterion("citizen_ID_code <=", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeLike(String value) {
            addCriterion("citizen_ID_code like", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeNotLike(String value) {
            addCriterion("citizen_ID_code not like", value, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeIn(List<String> values) {
            addCriterion("citizen_ID_code in", values, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeNotIn(List<String> values) {
            addCriterion("citizen_ID_code not in", values, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeBetween(String value1, String value2) {
            addCriterion("citizen_ID_code between", value1, value2, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeNotBetween(String value1, String value2) {
            addCriterion("citizen_ID_code not between", value1, value2, "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andAccountNatureIsNull() {
            addCriterion("account_nature is null");
            return (Criteria) this;
        }

        public Criteria andAccountNatureIsNotNull() {
            addCriterion("account_nature is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNatureEqualTo(String value) {
            addCriterion("account_nature =", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureNotEqualTo(String value) {
            addCriterion("account_nature <>", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureGreaterThan(String value) {
            addCriterion("account_nature >", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureGreaterThanOrEqualTo(String value) {
            addCriterion("account_nature >=", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureLessThan(String value) {
            addCriterion("account_nature <", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureLessThanOrEqualTo(String value) {
            addCriterion("account_nature <=", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureLike(String value) {
            addCriterion("account_nature like", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureNotLike(String value) {
            addCriterion("account_nature not like", value, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureIn(List<String> values) {
            addCriterion("account_nature in", values, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureNotIn(List<String> values) {
            addCriterion("account_nature not in", values, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureBetween(String value1, String value2) {
            addCriterion("account_nature between", value1, value2, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountNatureNotBetween(String value1, String value2) {
            addCriterion("account_nature not between", value1, value2, "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountAddressIsNull() {
            addCriterion("account_address is null");
            return (Criteria) this;
        }

        public Criteria andAccountAddressIsNotNull() {
            addCriterion("account_address is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAddressEqualTo(String value) {
            addCriterion("account_address =", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressNotEqualTo(String value) {
            addCriterion("account_address <>", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressGreaterThan(String value) {
            addCriterion("account_address >", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressGreaterThanOrEqualTo(String value) {
            addCriterion("account_address >=", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressLessThan(String value) {
            addCriterion("account_address <", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressLessThanOrEqualTo(String value) {
            addCriterion("account_address <=", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressLike(String value) {
            addCriterion("account_address like", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressNotLike(String value) {
            addCriterion("account_address not like", value, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressIn(List<String> values) {
            addCriterion("account_address in", values, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressNotIn(List<String> values) {
            addCriterion("account_address not in", values, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressBetween(String value1, String value2) {
            addCriterion("account_address between", value1, value2, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountAddressNotBetween(String value1, String value2) {
            addCriterion("account_address not between", value1, value2, "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeIsNull() {
            addCriterion("account_zip_code is null");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeIsNotNull() {
            addCriterion("account_zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeEqualTo(String value) {
            addCriterion("account_zip_code =", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeNotEqualTo(String value) {
            addCriterion("account_zip_code <>", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeGreaterThan(String value) {
            addCriterion("account_zip_code >", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("account_zip_code >=", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeLessThan(String value) {
            addCriterion("account_zip_code <", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeLessThanOrEqualTo(String value) {
            addCriterion("account_zip_code <=", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeLike(String value) {
            addCriterion("account_zip_code like", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeNotLike(String value) {
            addCriterion("account_zip_code not like", value, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeIn(List<String> values) {
            addCriterion("account_zip_code in", values, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeNotIn(List<String> values) {
            addCriterion("account_zip_code not in", values, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeBetween(String value1, String value2) {
            addCriterion("account_zip_code between", value1, value2, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeNotBetween(String value1, String value2) {
            addCriterion("account_zip_code not between", value1, value2, "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andLogPhotoIsNull() {
            addCriterion("log_photo is null");
            return (Criteria) this;
        }

        public Criteria andLogPhotoIsNotNull() {
            addCriterion("log_photo is not null");
            return (Criteria) this;
        }

        public Criteria andLogPhotoEqualTo(String value) {
            addCriterion("log_photo =", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoNotEqualTo(String value) {
            addCriterion("log_photo <>", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoGreaterThan(String value) {
            addCriterion("log_photo >", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("log_photo >=", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoLessThan(String value) {
            addCriterion("log_photo <", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoLessThanOrEqualTo(String value) {
            addCriterion("log_photo <=", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoLike(String value) {
            addCriterion("log_photo like", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoNotLike(String value) {
            addCriterion("log_photo not like", value, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoIn(List<String> values) {
            addCriterion("log_photo in", values, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoNotIn(List<String> values) {
            addCriterion("log_photo not in", values, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoBetween(String value1, String value2) {
            addCriterion("log_photo between", value1, value2, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andLogPhotoNotBetween(String value1, String value2) {
            addCriterion("log_photo not between", value1, value2, "logPhoto");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeIsNull() {
            addCriterion("address_zip_code is null");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeIsNotNull() {
            addCriterion("address_zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeEqualTo(String value) {
            addCriterion("address_zip_code =", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeNotEqualTo(String value) {
            addCriterion("address_zip_code <>", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeGreaterThan(String value) {
            addCriterion("address_zip_code >", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("address_zip_code >=", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeLessThan(String value) {
            addCriterion("address_zip_code <", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeLessThanOrEqualTo(String value) {
            addCriterion("address_zip_code <=", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeLike(String value) {
            addCriterion("address_zip_code like", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeNotLike(String value) {
            addCriterion("address_zip_code not like", value, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeIn(List<String> values) {
            addCriterion("address_zip_code in", values, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeNotIn(List<String> values) {
            addCriterion("address_zip_code not in", values, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeBetween(String value1, String value2) {
            addCriterion("address_zip_code between", value1, value2, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeNotBetween(String value1, String value2) {
            addCriterion("address_zip_code not between", value1, value2, "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andTeleIsNull() {
            addCriterion("tele is null");
            return (Criteria) this;
        }

        public Criteria andTeleIsNotNull() {
            addCriterion("tele is not null");
            return (Criteria) this;
        }

        public Criteria andTeleEqualTo(String value) {
            addCriterion("tele =", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotEqualTo(String value) {
            addCriterion("tele <>", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleGreaterThan(String value) {
            addCriterion("tele >", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleGreaterThanOrEqualTo(String value) {
            addCriterion("tele >=", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleLessThan(String value) {
            addCriterion("tele <", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleLessThanOrEqualTo(String value) {
            addCriterion("tele <=", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleLike(String value) {
            addCriterion("tele like", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotLike(String value) {
            addCriterion("tele not like", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleIn(List<String> values) {
            addCriterion("tele in", values, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotIn(List<String> values) {
            addCriterion("tele not in", values, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleBetween(String value1, String value2) {
            addCriterion("tele between", value1, value2, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotBetween(String value1, String value2) {
            addCriterion("tele not between", value1, value2, "tele");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(String value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(String value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(String value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(String value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLike(String value) {
            addCriterion("enterprise_id like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotLike(String value) {
            addCriterion("enterprise_id not like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<String> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<String> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(String value1, String value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNull() {
            addCriterion("job_number is null");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNotNull() {
            addCriterion("job_number is not null");
            return (Criteria) this;
        }

        public Criteria andJobNumberEqualTo(String value) {
            addCriterion("job_number =", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotEqualTo(String value) {
            addCriterion("job_number <>", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThan(String value) {
            addCriterion("job_number >", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThanOrEqualTo(String value) {
            addCriterion("job_number >=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThan(String value) {
            addCriterion("job_number <", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThanOrEqualTo(String value) {
            addCriterion("job_number <=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLike(String value) {
            addCriterion("job_number like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotLike(String value) {
            addCriterion("job_number not like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberIn(List<String> values) {
            addCriterion("job_number in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotIn(List<String> values) {
            addCriterion("job_number not in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberBetween(String value1, String value2) {
            addCriterion("job_number between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotBetween(String value1, String value2) {
            addCriterion("job_number not between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJoinWorkIsNull() {
            addCriterion("join_work is null");
            return (Criteria) this;
        }

        public Criteria andJoinWorkIsNotNull() {
            addCriterion("join_work is not null");
            return (Criteria) this;
        }

        public Criteria andJoinWorkEqualTo(Date value) {
            addCriterionForJDBCDate("join_work =", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkNotEqualTo(Date value) {
            addCriterionForJDBCDate("join_work <>", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkGreaterThan(Date value) {
            addCriterionForJDBCDate("join_work >", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_work >=", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkLessThan(Date value) {
            addCriterionForJDBCDate("join_work <", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_work <=", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkIn(List<Date> values) {
            addCriterionForJDBCDate("join_work in", values, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkNotIn(List<Date> values) {
            addCriterionForJDBCDate("join_work not in", values, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_work between", value1, value2, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_work not between", value1, value2, "joinWork");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeIsNull() {
            addCriterion("ex_passport_code is null");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeIsNotNull() {
            addCriterion("ex_passport_code is not null");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeEqualTo(String value) {
            addCriterion("ex_passport_code =", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeNotEqualTo(String value) {
            addCriterion("ex_passport_code <>", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeGreaterThan(String value) {
            addCriterion("ex_passport_code >", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ex_passport_code >=", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeLessThan(String value) {
            addCriterion("ex_passport_code <", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeLessThanOrEqualTo(String value) {
            addCriterion("ex_passport_code <=", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeLike(String value) {
            addCriterion("ex_passport_code like", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeNotLike(String value) {
            addCriterion("ex_passport_code not like", value, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeIn(List<String> values) {
            addCriterion("ex_passport_code in", values, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeNotIn(List<String> values) {
            addCriterion("ex_passport_code not in", values, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeBetween(String value1, String value2) {
            addCriterion("ex_passport_code between", value1, value2, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeNotBetween(String value1, String value2) {
            addCriterion("ex_passport_code not between", value1, value2, "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeIsNull() {
            addCriterion("ex_permit_code is null");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeIsNotNull() {
            addCriterion("ex_permit_code is not null");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeEqualTo(String value) {
            addCriterion("ex_permit_code =", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeNotEqualTo(String value) {
            addCriterion("ex_permit_code <>", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeGreaterThan(String value) {
            addCriterion("ex_permit_code >", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ex_permit_code >=", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeLessThan(String value) {
            addCriterion("ex_permit_code <", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeLessThanOrEqualTo(String value) {
            addCriterion("ex_permit_code <=", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeLike(String value) {
            addCriterion("ex_permit_code like", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeNotLike(String value) {
            addCriterion("ex_permit_code not like", value, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeIn(List<String> values) {
            addCriterion("ex_permit_code in", values, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeNotIn(List<String> values) {
            addCriterion("ex_permit_code not in", values, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeBetween(String value1, String value2) {
            addCriterion("ex_permit_code between", value1, value2, "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeNotBetween(String value1, String value2) {
            addCriterion("ex_permit_code not between", value1, value2, "exPermitCode");
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

        public Criteria andIsdelEqualTo(String value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(String value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(String value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(String value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(String value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(String value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLike(String value) {
            addCriterion("isdel like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotLike(String value) {
            addCriterion("isdel not like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<String> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<String> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(String value1, String value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(String value1, String value2) {
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
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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
            addCriterionForJDBCDate("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLikeInsensitive(String value) {
            addCriterion("upper(employee_name) like", value.toUpperCase(), "employeeName");
            return (Criteria) this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(sex) like", value.toUpperCase(), "sex");
            return (Criteria) this;
        }

        public Criteria andPaperWorkTypeLikeInsensitive(String value) {
            addCriterion("upper(paper_work_type) like", value.toUpperCase(), "paperWorkType");
            return (Criteria) this;
        }

        public Criteria andPaperWorkCodeLikeInsensitive(String value) {
            addCriterion("upper(paper_work_code) like", value.toUpperCase(), "paperWorkCode");
            return (Criteria) this;
        }

        public Criteria andNationLikeInsensitive(String value) {
            addCriterion("upper(nation) like", value.toUpperCase(), "nation");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLikeInsensitive(String value) {
            addCriterion("upper(native_place) like", value.toUpperCase(), "nativePlace");
            return (Criteria) this;
        }

        public Criteria andEducationalLevelLikeInsensitive(String value) {
            addCriterion("upper(educational_level) like", value.toUpperCase(), "educationalLevel");
            return (Criteria) this;
        }

        public Criteria andCountryRegionLikeInsensitive(String value) {
            addCriterion("upper(country_region) like", value.toUpperCase(), "countryRegion");
            return (Criteria) this;
        }

        public Criteria andPersonalIdentityLikeInsensitive(String value) {
            addCriterion("upper(personal_identity) like", value.toUpperCase(), "personalIdentity");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeLikeInsensitive(String value) {
            addCriterion("upper(citizen_ID_code) like", value.toUpperCase(), "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andAccountNatureLikeInsensitive(String value) {
            addCriterion("upper(account_nature) like", value.toUpperCase(), "accountNature");
            return (Criteria) this;
        }

        public Criteria andAccountAddressLikeInsensitive(String value) {
            addCriterion("upper(account_address) like", value.toUpperCase(), "accountAddress");
            return (Criteria) this;
        }

        public Criteria andAccountZipCodeLikeInsensitive(String value) {
            addCriterion("upper(account_zip_code) like", value.toUpperCase(), "accountZipCode");
            return (Criteria) this;
        }

        public Criteria andLogPhotoLikeInsensitive(String value) {
            addCriterion("upper(log_photo) like", value.toUpperCase(), "logPhoto");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andAddressZipCodeLikeInsensitive(String value) {
            addCriterion("upper(address_zip_code) like", value.toUpperCase(), "addressZipCode");
            return (Criteria) this;
        }

        public Criteria andTeleLikeInsensitive(String value) {
            addCriterion("upper(tele) like", value.toUpperCase(), "tele");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(email) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLikeInsensitive(String value) {
            addCriterion("upper(enterprise_id) like", value.toUpperCase(), "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLikeInsensitive(String value) {
            addCriterion("upper(enterprise_name) like", value.toUpperCase(), "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andJobNumberLikeInsensitive(String value) {
            addCriterion("upper(job_number) like", value.toUpperCase(), "jobNumber");
            return (Criteria) this;
        }

        public Criteria andExPassportCodeLikeInsensitive(String value) {
            addCriterion("upper(ex_passport_code) like", value.toUpperCase(), "exPassportCode");
            return (Criteria) this;
        }

        public Criteria andExPermitCodeLikeInsensitive(String value) {
            addCriterion("upper(ex_permit_code) like", value.toUpperCase(), "exPermitCode");
            return (Criteria) this;
        }

        public Criteria andIsdelLikeInsensitive(String value) {
            addCriterion("upper(isdel) like", value.toUpperCase(), "isdel");
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