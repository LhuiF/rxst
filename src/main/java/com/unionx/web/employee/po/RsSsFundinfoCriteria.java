package com.unionx.web.employee.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RsSsFundinfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RsSsFundinfoCriteria() {
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

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLike(String value) {
            addCriterion("employee_id like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("employee_id not like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeIsNull() {
            addCriterion("ss_people_type is null");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeIsNotNull() {
            addCriterion("ss_people_type is not null");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeEqualTo(String value) {
            addCriterion("ss_people_type =", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeNotEqualTo(String value) {
            addCriterion("ss_people_type <>", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeGreaterThan(String value) {
            addCriterion("ss_people_type >", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ss_people_type >=", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeLessThan(String value) {
            addCriterion("ss_people_type <", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeLessThanOrEqualTo(String value) {
            addCriterion("ss_people_type <=", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeLike(String value) {
            addCriterion("ss_people_type like", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeNotLike(String value) {
            addCriterion("ss_people_type not like", value, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeIn(List<String> values) {
            addCriterion("ss_people_type in", values, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeNotIn(List<String> values) {
            addCriterion("ss_people_type not in", values, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeBetween(String value1, String value2) {
            addCriterion("ss_people_type between", value1, value2, "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeNotBetween(String value1, String value2) {
            addCriterion("ss_people_type not between", value1, value2, "ssPeopleType");
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

        public Criteria andMtPeopleTypeIsNull() {
            addCriterion("mt_people_type is null");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeIsNotNull() {
            addCriterion("mt_people_type is not null");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeEqualTo(String value) {
            addCriterion("mt_people_type =", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeNotEqualTo(String value) {
            addCriterion("mt_people_type <>", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeGreaterThan(String value) {
            addCriterion("mt_people_type >", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mt_people_type >=", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeLessThan(String value) {
            addCriterion("mt_people_type <", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeLessThanOrEqualTo(String value) {
            addCriterion("mt_people_type <=", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeLike(String value) {
            addCriterion("mt_people_type like", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeNotLike(String value) {
            addCriterion("mt_people_type not like", value, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeIn(List<String> values) {
            addCriterion("mt_people_type in", values, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeNotIn(List<String> values) {
            addCriterion("mt_people_type not in", values, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeBetween(String value1, String value2) {
            addCriterion("mt_people_type between", value1, value2, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeNotBetween(String value1, String value2) {
            addCriterion("mt_people_type not between", value1, value2, "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayIsNull() {
            addCriterion("obtain_ss_way is null");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayIsNotNull() {
            addCriterion("obtain_ss_way is not null");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayEqualTo(String value) {
            addCriterion("obtain_ss_way =", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayNotEqualTo(String value) {
            addCriterion("obtain_ss_way <>", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayGreaterThan(String value) {
            addCriterion("obtain_ss_way >", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_ss_way >=", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayLessThan(String value) {
            addCriterion("obtain_ss_way <", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayLessThanOrEqualTo(String value) {
            addCriterion("obtain_ss_way <=", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayLike(String value) {
            addCriterion("obtain_ss_way like", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayNotLike(String value) {
            addCriterion("obtain_ss_way not like", value, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayIn(List<String> values) {
            addCriterion("obtain_ss_way in", values, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayNotIn(List<String> values) {
            addCriterion("obtain_ss_way not in", values, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayBetween(String value1, String value2) {
            addCriterion("obtain_ss_way between", value1, value2, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayNotBetween(String value1, String value2) {
            addCriterion("obtain_ss_way not between", value1, value2, "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleIsNull() {
            addCriterion("insured_tele is null");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleIsNotNull() {
            addCriterion("insured_tele is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleEqualTo(String value) {
            addCriterion("insured_tele =", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleNotEqualTo(String value) {
            addCriterion("insured_tele <>", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleGreaterThan(String value) {
            addCriterion("insured_tele >", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleGreaterThanOrEqualTo(String value) {
            addCriterion("insured_tele >=", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleLessThan(String value) {
            addCriterion("insured_tele <", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleLessThanOrEqualTo(String value) {
            addCriterion("insured_tele <=", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleLike(String value) {
            addCriterion("insured_tele like", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleNotLike(String value) {
            addCriterion("insured_tele not like", value, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleIn(List<String> values) {
            addCriterion("insured_tele in", values, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleNotIn(List<String> values) {
            addCriterion("insured_tele not in", values, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleBetween(String value1, String value2) {
            addCriterion("insured_tele between", value1, value2, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleNotBetween(String value1, String value2) {
            addCriterion("insured_tele not between", value1, value2, "insuredTele");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateIsNull() {
            addCriterion("issuance_sscard_date is null");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateIsNotNull() {
            addCriterion("issuance_sscard_date is not null");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_sscard_date =", value, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_sscard_date <>", value, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateGreaterThan(Date value) {
            addCriterionForJDBCDate("issuance_sscard_date >", value, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_sscard_date >=", value, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateLessThan(Date value) {
            addCriterionForJDBCDate("issuance_sscard_date <", value, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_sscard_date <=", value, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateIn(List<Date> values) {
            addCriterionForJDBCDate("issuance_sscard_date in", values, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("issuance_sscard_date not in", values, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issuance_sscard_date between", value1, value2, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceSscardDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issuance_sscard_date not between", value1, value2, "issuanceSscardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateIsNull() {
            addCriterion("issuance_mtcard_date is null");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateIsNotNull() {
            addCriterion("issuance_mtcard_date is not null");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_mtcard_date =", value, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_mtcard_date <>", value, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateGreaterThan(Date value) {
            addCriterionForJDBCDate("issuance_mtcard_date >", value, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_mtcard_date >=", value, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateLessThan(Date value) {
            addCriterionForJDBCDate("issuance_mtcard_date <", value, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issuance_mtcard_date <=", value, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateIn(List<Date> values) {
            addCriterionForJDBCDate("issuance_mtcard_date in", values, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("issuance_mtcard_date not in", values, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issuance_mtcard_date between", value1, value2, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andIssuanceMtcardDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issuance_mtcard_date not between", value1, value2, "issuanceMtcardDate");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("bank_code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("bank_code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("bank_code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("bank_code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("bank_code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("bank_code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("bank_code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("bank_code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("bank_code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("bank_code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("bank_code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("bank_code not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andIsSickIsNull() {
            addCriterion("is_sick is null");
            return (Criteria) this;
        }

        public Criteria andIsSickIsNotNull() {
            addCriterion("is_sick is not null");
            return (Criteria) this;
        }

        public Criteria andIsSickEqualTo(String value) {
            addCriterion("is_sick =", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickNotEqualTo(String value) {
            addCriterion("is_sick <>", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickGreaterThan(String value) {
            addCriterion("is_sick >", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickGreaterThanOrEqualTo(String value) {
            addCriterion("is_sick >=", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickLessThan(String value) {
            addCriterion("is_sick <", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickLessThanOrEqualTo(String value) {
            addCriterion("is_sick <=", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickLike(String value) {
            addCriterion("is_sick like", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickNotLike(String value) {
            addCriterion("is_sick not like", value, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickIn(List<String> values) {
            addCriterion("is_sick in", values, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickNotIn(List<String> values) {
            addCriterion("is_sick not in", values, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickBetween(String value1, String value2) {
            addCriterion("is_sick between", value1, value2, "isSick");
            return (Criteria) this;
        }

        public Criteria andIsSickNotBetween(String value1, String value2) {
            addCriterion("is_sick not between", value1, value2, "isSick");
            return (Criteria) this;
        }

        public Criteria andAverageWageIsNull() {
            addCriterion("average_wage is null");
            return (Criteria) this;
        }

        public Criteria andAverageWageIsNotNull() {
            addCriterion("average_wage is not null");
            return (Criteria) this;
        }

        public Criteria andAverageWageEqualTo(Double value) {
            addCriterion("average_wage =", value, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageNotEqualTo(Double value) {
            addCriterion("average_wage <>", value, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageGreaterThan(Double value) {
            addCriterion("average_wage >", value, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageGreaterThanOrEqualTo(Double value) {
            addCriterion("average_wage >=", value, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageLessThan(Double value) {
            addCriterion("average_wage <", value, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageLessThanOrEqualTo(Double value) {
            addCriterion("average_wage <=", value, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageIn(List<Double> values) {
            addCriterion("average_wage in", values, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageNotIn(List<Double> values) {
            addCriterion("average_wage not in", values, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageBetween(Double value1, Double value2) {
            addCriterion("average_wage between", value1, value2, "averageWage");
            return (Criteria) this;
        }

        public Criteria andAverageWageNotBetween(Double value1, Double value2) {
            addCriterion("average_wage not between", value1, value2, "averageWage");
            return (Criteria) this;
        }

        public Criteria andSsWageIsNull() {
            addCriterion("ss_wage is null");
            return (Criteria) this;
        }

        public Criteria andSsWageIsNotNull() {
            addCriterion("ss_wage is not null");
            return (Criteria) this;
        }

        public Criteria andSsWageEqualTo(Double value) {
            addCriterion("ss_wage =", value, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageNotEqualTo(Double value) {
            addCriterion("ss_wage <>", value, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageGreaterThan(Double value) {
            addCriterion("ss_wage >", value, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageGreaterThanOrEqualTo(Double value) {
            addCriterion("ss_wage >=", value, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageLessThan(Double value) {
            addCriterion("ss_wage <", value, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageLessThanOrEqualTo(Double value) {
            addCriterion("ss_wage <=", value, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageIn(List<Double> values) {
            addCriterion("ss_wage in", values, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageNotIn(List<Double> values) {
            addCriterion("ss_wage not in", values, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageBetween(Double value1, Double value2) {
            addCriterion("ss_wage between", value1, value2, "ssWage");
            return (Criteria) this;
        }

        public Criteria andSsWageNotBetween(Double value1, Double value2) {
            addCriterion("ss_wage not between", value1, value2, "ssWage");
            return (Criteria) this;
        }

        public Criteria andPfWageIsNull() {
            addCriterion("pf_wage is null");
            return (Criteria) this;
        }

        public Criteria andPfWageIsNotNull() {
            addCriterion("pf_wage is not null");
            return (Criteria) this;
        }

        public Criteria andPfWageEqualTo(Double value) {
            addCriterion("pf_wage =", value, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageNotEqualTo(Double value) {
            addCriterion("pf_wage <>", value, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageGreaterThan(Double value) {
            addCriterion("pf_wage >", value, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageGreaterThanOrEqualTo(Double value) {
            addCriterion("pf_wage >=", value, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageLessThan(Double value) {
            addCriterion("pf_wage <", value, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageLessThanOrEqualTo(Double value) {
            addCriterion("pf_wage <=", value, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageIn(List<Double> values) {
            addCriterion("pf_wage in", values, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageNotIn(List<Double> values) {
            addCriterion("pf_wage not in", values, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageBetween(Double value1, Double value2) {
            addCriterion("pf_wage between", value1, value2, "pfWage");
            return (Criteria) this;
        }

        public Criteria andPfWageNotBetween(Double value1, Double value2) {
            addCriterion("pf_wage not between", value1, value2, "pfWage");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateIsNull() {
            addCriterion("ss_declare_date is null");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateIsNotNull() {
            addCriterion("ss_declare_date is not null");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateEqualTo(Date value) {
            addCriterionForJDBCDate("ss_declare_date =", value, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ss_declare_date <>", value, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ss_declare_date >", value, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ss_declare_date >=", value, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateLessThan(Date value) {
            addCriterionForJDBCDate("ss_declare_date <", value, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ss_declare_date <=", value, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateIn(List<Date> values) {
            addCriterionForJDBCDate("ss_declare_date in", values, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ss_declare_date not in", values, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ss_declare_date between", value1, value2, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsDeclareDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ss_declare_date not between", value1, value2, "ssDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateIsNull() {
            addCriterion("pf_declare_date is null");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateIsNotNull() {
            addCriterion("pf_declare_date is not null");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateEqualTo(Date value) {
            addCriterionForJDBCDate("pf_declare_date =", value, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pf_declare_date <>", value, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pf_declare_date >", value, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pf_declare_date >=", value, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateLessThan(Date value) {
            addCriterionForJDBCDate("pf_declare_date <", value, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pf_declare_date <=", value, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateIn(List<Date> values) {
            addCriterionForJDBCDate("pf_declare_date in", values, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pf_declare_date not in", values, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pf_declare_date between", value1, value2, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andPfDeclareDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pf_declare_date not between", value1, value2, "pfDeclareDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateIsNull() {
            addCriterion("ss_start_date is null");
            return (Criteria) this;
        }

        public Criteria andSsStartDateIsNotNull() {
            addCriterion("ss_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andSsStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("ss_start_date =", value, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ss_start_date <>", value, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ss_start_date >", value, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ss_start_date >=", value, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateLessThan(Date value) {
            addCriterionForJDBCDate("ss_start_date <", value, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ss_start_date <=", value, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("ss_start_date in", values, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ss_start_date not in", values, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ss_start_date between", value1, value2, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andSsStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ss_start_date not between", value1, value2, "ssStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateIsNull() {
            addCriterion("pf_start_date is null");
            return (Criteria) this;
        }

        public Criteria andPfStartDateIsNotNull() {
            addCriterion("pf_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andPfStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("pf_start_date =", value, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pf_start_date <>", value, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pf_start_date >", value, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pf_start_date >=", value, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateLessThan(Date value) {
            addCriterionForJDBCDate("pf_start_date <", value, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pf_start_date <=", value, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("pf_start_date in", values, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pf_start_date not in", values, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pf_start_date between", value1, value2, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andPfStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pf_start_date not between", value1, value2, "pfStartDate");
            return (Criteria) this;
        }

        public Criteria andAddReasonIsNull() {
            addCriterion("add_reason is null");
            return (Criteria) this;
        }

        public Criteria andAddReasonIsNotNull() {
            addCriterion("add_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAddReasonEqualTo(String value) {
            addCriterion("add_reason =", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonNotEqualTo(String value) {
            addCriterion("add_reason <>", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonGreaterThan(String value) {
            addCriterion("add_reason >", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonGreaterThanOrEqualTo(String value) {
            addCriterion("add_reason >=", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonLessThan(String value) {
            addCriterion("add_reason <", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonLessThanOrEqualTo(String value) {
            addCriterion("add_reason <=", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonLike(String value) {
            addCriterion("add_reason like", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonNotLike(String value) {
            addCriterion("add_reason not like", value, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonIn(List<String> values) {
            addCriterion("add_reason in", values, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonNotIn(List<String> values) {
            addCriterion("add_reason not in", values, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonBetween(String value1, String value2) {
            addCriterion("add_reason between", value1, value2, "addReason");
            return (Criteria) this;
        }

        public Criteria andAddReasonNotBetween(String value1, String value2) {
            addCriterion("add_reason not between", value1, value2, "addReason");
            return (Criteria) this;
        }

        public Criteria andDesignated1IsNull() {
            addCriterion("designated1 is null");
            return (Criteria) this;
        }

        public Criteria andDesignated1IsNotNull() {
            addCriterion("designated1 is not null");
            return (Criteria) this;
        }

        public Criteria andDesignated1EqualTo(String value) {
            addCriterion("designated1 =", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1NotEqualTo(String value) {
            addCriterion("designated1 <>", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1GreaterThan(String value) {
            addCriterion("designated1 >", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1GreaterThanOrEqualTo(String value) {
            addCriterion("designated1 >=", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1LessThan(String value) {
            addCriterion("designated1 <", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1LessThanOrEqualTo(String value) {
            addCriterion("designated1 <=", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1Like(String value) {
            addCriterion("designated1 like", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1NotLike(String value) {
            addCriterion("designated1 not like", value, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1In(List<String> values) {
            addCriterion("designated1 in", values, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1NotIn(List<String> values) {
            addCriterion("designated1 not in", values, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1Between(String value1, String value2) {
            addCriterion("designated1 between", value1, value2, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated1NotBetween(String value1, String value2) {
            addCriterion("designated1 not between", value1, value2, "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated2IsNull() {
            addCriterion("designated2 is null");
            return (Criteria) this;
        }

        public Criteria andDesignated2IsNotNull() {
            addCriterion("designated2 is not null");
            return (Criteria) this;
        }

        public Criteria andDesignated2EqualTo(String value) {
            addCriterion("designated2 =", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2NotEqualTo(String value) {
            addCriterion("designated2 <>", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2GreaterThan(String value) {
            addCriterion("designated2 >", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2GreaterThanOrEqualTo(String value) {
            addCriterion("designated2 >=", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2LessThan(String value) {
            addCriterion("designated2 <", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2LessThanOrEqualTo(String value) {
            addCriterion("designated2 <=", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2Like(String value) {
            addCriterion("designated2 like", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2NotLike(String value) {
            addCriterion("designated2 not like", value, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2In(List<String> values) {
            addCriterion("designated2 in", values, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2NotIn(List<String> values) {
            addCriterion("designated2 not in", values, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2Between(String value1, String value2) {
            addCriterion("designated2 between", value1, value2, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated2NotBetween(String value1, String value2) {
            addCriterion("designated2 not between", value1, value2, "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated3IsNull() {
            addCriterion("designated3 is null");
            return (Criteria) this;
        }

        public Criteria andDesignated3IsNotNull() {
            addCriterion("designated3 is not null");
            return (Criteria) this;
        }

        public Criteria andDesignated3EqualTo(String value) {
            addCriterion("designated3 =", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3NotEqualTo(String value) {
            addCriterion("designated3 <>", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3GreaterThan(String value) {
            addCriterion("designated3 >", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3GreaterThanOrEqualTo(String value) {
            addCriterion("designated3 >=", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3LessThan(String value) {
            addCriterion("designated3 <", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3LessThanOrEqualTo(String value) {
            addCriterion("designated3 <=", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3Like(String value) {
            addCriterion("designated3 like", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3NotLike(String value) {
            addCriterion("designated3 not like", value, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3In(List<String> values) {
            addCriterion("designated3 in", values, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3NotIn(List<String> values) {
            addCriterion("designated3 not in", values, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3Between(String value1, String value2) {
            addCriterion("designated3 between", value1, value2, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated3NotBetween(String value1, String value2) {
            addCriterion("designated3 not between", value1, value2, "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated4IsNull() {
            addCriterion("designated4 is null");
            return (Criteria) this;
        }

        public Criteria andDesignated4IsNotNull() {
            addCriterion("designated4 is not null");
            return (Criteria) this;
        }

        public Criteria andDesignated4EqualTo(String value) {
            addCriterion("designated4 =", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4NotEqualTo(String value) {
            addCriterion("designated4 <>", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4GreaterThan(String value) {
            addCriterion("designated4 >", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4GreaterThanOrEqualTo(String value) {
            addCriterion("designated4 >=", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4LessThan(String value) {
            addCriterion("designated4 <", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4LessThanOrEqualTo(String value) {
            addCriterion("designated4 <=", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4Like(String value) {
            addCriterion("designated4 like", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4NotLike(String value) {
            addCriterion("designated4 not like", value, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4In(List<String> values) {
            addCriterion("designated4 in", values, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4NotIn(List<String> values) {
            addCriterion("designated4 not in", values, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4Between(String value1, String value2) {
            addCriterion("designated4 between", value1, value2, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated4NotBetween(String value1, String value2) {
            addCriterion("designated4 not between", value1, value2, "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated5IsNull() {
            addCriterion("designated5 is null");
            return (Criteria) this;
        }

        public Criteria andDesignated5IsNotNull() {
            addCriterion("designated5 is not null");
            return (Criteria) this;
        }

        public Criteria andDesignated5EqualTo(String value) {
            addCriterion("designated5 =", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5NotEqualTo(String value) {
            addCriterion("designated5 <>", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5GreaterThan(String value) {
            addCriterion("designated5 >", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5GreaterThanOrEqualTo(String value) {
            addCriterion("designated5 >=", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5LessThan(String value) {
            addCriterion("designated5 <", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5LessThanOrEqualTo(String value) {
            addCriterion("designated5 <=", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5Like(String value) {
            addCriterion("designated5 like", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5NotLike(String value) {
            addCriterion("designated5 not like", value, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5In(List<String> values) {
            addCriterion("designated5 in", values, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5NotIn(List<String> values) {
            addCriterion("designated5 not in", values, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5Between(String value1, String value2) {
            addCriterion("designated5 between", value1, value2, "designated5");
            return (Criteria) this;
        }

        public Criteria andDesignated5NotBetween(String value1, String value2) {
            addCriterion("designated5 not between", value1, value2, "designated5");
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

        public Criteria andEmployeeIdLikeInsensitive(String value) {
            addCriterion("upper(employee_id) like", value.toUpperCase(), "employeeId");
            return (Criteria) this;
        }

        public Criteria andSsPeopleTypeLikeInsensitive(String value) {
            addCriterion("upper(ss_people_type) like", value.toUpperCase(), "ssPeopleType");
            return (Criteria) this;
        }

        public Criteria andCitizenIdCodeLikeInsensitive(String value) {
            addCriterion("upper(citizen_ID_code) like", value.toUpperCase(), "citizenIdCode");
            return (Criteria) this;
        }

        public Criteria andMtPeopleTypeLikeInsensitive(String value) {
            addCriterion("upper(mt_people_type) like", value.toUpperCase(), "mtPeopleType");
            return (Criteria) this;
        }

        public Criteria andObtainSsWayLikeInsensitive(String value) {
            addCriterion("upper(obtain_ss_way) like", value.toUpperCase(), "obtainSsWay");
            return (Criteria) this;
        }

        public Criteria andInsuredTeleLikeInsensitive(String value) {
            addCriterion("upper(insured_tele) like", value.toUpperCase(), "insuredTele");
            return (Criteria) this;
        }

        public Criteria andBankNameLikeInsensitive(String value) {
            addCriterion("upper(bank_name) like", value.toUpperCase(), "bankName");
            return (Criteria) this;
        }

        public Criteria andBankCodeLikeInsensitive(String value) {
            addCriterion("upper(bank_code) like", value.toUpperCase(), "bankCode");
            return (Criteria) this;
        }

        public Criteria andIsSickLikeInsensitive(String value) {
            addCriterion("upper(is_sick) like", value.toUpperCase(), "isSick");
            return (Criteria) this;
        }

        public Criteria andAddReasonLikeInsensitive(String value) {
            addCriterion("upper(add_reason) like", value.toUpperCase(), "addReason");
            return (Criteria) this;
        }

        public Criteria andDesignated1LikeInsensitive(String value) {
            addCriterion("upper(designated1) like", value.toUpperCase(), "designated1");
            return (Criteria) this;
        }

        public Criteria andDesignated2LikeInsensitive(String value) {
            addCriterion("upper(designated2) like", value.toUpperCase(), "designated2");
            return (Criteria) this;
        }

        public Criteria andDesignated3LikeInsensitive(String value) {
            addCriterion("upper(designated3) like", value.toUpperCase(), "designated3");
            return (Criteria) this;
        }

        public Criteria andDesignated4LikeInsensitive(String value) {
            addCriterion("upper(designated4) like", value.toUpperCase(), "designated4");
            return (Criteria) this;
        }

        public Criteria andDesignated5LikeInsensitive(String value) {
            addCriterion("upper(designated5) like", value.toUpperCase(), "designated5");
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