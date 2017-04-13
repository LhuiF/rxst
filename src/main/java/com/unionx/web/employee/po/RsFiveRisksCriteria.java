package com.unionx.web.employee.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RsFiveRisksCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RsFiveRisksCriteria() {
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

        public Criteria andPensionIsNull() {
            addCriterion("pension is null");
            return (Criteria) this;
        }

        public Criteria andPensionIsNotNull() {
            addCriterion("pension is not null");
            return (Criteria) this;
        }

        public Criteria andPensionEqualTo(String value) {
            addCriterion("pension =", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionNotEqualTo(String value) {
            addCriterion("pension <>", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionGreaterThan(String value) {
            addCriterion("pension >", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionGreaterThanOrEqualTo(String value) {
            addCriterion("pension >=", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionLessThan(String value) {
            addCriterion("pension <", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionLessThanOrEqualTo(String value) {
            addCriterion("pension <=", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionLike(String value) {
            addCriterion("pension like", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionNotLike(String value) {
            addCriterion("pension not like", value, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionIn(List<String> values) {
            addCriterion("pension in", values, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionNotIn(List<String> values) {
            addCriterion("pension not in", values, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionBetween(String value1, String value2) {
            addCriterion("pension between", value1, value2, "pension");
            return (Criteria) this;
        }

        public Criteria andPensionNotBetween(String value1, String value2) {
            addCriterion("pension not between", value1, value2, "pension");
            return (Criteria) this;
        }

        public Criteria andUnemploymentIsNull() {
            addCriterion("unemployment is null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentIsNotNull() {
            addCriterion("unemployment is not null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentEqualTo(String value) {
            addCriterion("unemployment =", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentNotEqualTo(String value) {
            addCriterion("unemployment <>", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentGreaterThan(String value) {
            addCriterion("unemployment >", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentGreaterThanOrEqualTo(String value) {
            addCriterion("unemployment >=", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentLessThan(String value) {
            addCriterion("unemployment <", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentLessThanOrEqualTo(String value) {
            addCriterion("unemployment <=", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentLike(String value) {
            addCriterion("unemployment like", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentNotLike(String value) {
            addCriterion("unemployment not like", value, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentIn(List<String> values) {
            addCriterion("unemployment in", values, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentNotIn(List<String> values) {
            addCriterion("unemployment not in", values, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentBetween(String value1, String value2) {
            addCriterion("unemployment between", value1, value2, "unemployment");
            return (Criteria) this;
        }

        public Criteria andUnemploymentNotBetween(String value1, String value2) {
            addCriterion("unemployment not between", value1, value2, "unemployment");
            return (Criteria) this;
        }

        public Criteria andFertilityIsNull() {
            addCriterion("fertility is null");
            return (Criteria) this;
        }

        public Criteria andFertilityIsNotNull() {
            addCriterion("fertility is not null");
            return (Criteria) this;
        }

        public Criteria andFertilityEqualTo(String value) {
            addCriterion("fertility =", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityNotEqualTo(String value) {
            addCriterion("fertility <>", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityGreaterThan(String value) {
            addCriterion("fertility >", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityGreaterThanOrEqualTo(String value) {
            addCriterion("fertility >=", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityLessThan(String value) {
            addCriterion("fertility <", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityLessThanOrEqualTo(String value) {
            addCriterion("fertility <=", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityLike(String value) {
            addCriterion("fertility like", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityNotLike(String value) {
            addCriterion("fertility not like", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityIn(List<String> values) {
            addCriterion("fertility in", values, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityNotIn(List<String> values) {
            addCriterion("fertility not in", values, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityBetween(String value1, String value2) {
            addCriterion("fertility between", value1, value2, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityNotBetween(String value1, String value2) {
            addCriterion("fertility not between", value1, value2, "fertility");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryIsNull() {
            addCriterion("work_injury is null");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryIsNotNull() {
            addCriterion("work_injury is not null");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryEqualTo(String value) {
            addCriterion("work_injury =", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryNotEqualTo(String value) {
            addCriterion("work_injury <>", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryGreaterThan(String value) {
            addCriterion("work_injury >", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryGreaterThanOrEqualTo(String value) {
            addCriterion("work_injury >=", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryLessThan(String value) {
            addCriterion("work_injury <", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryLessThanOrEqualTo(String value) {
            addCriterion("work_injury <=", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryLike(String value) {
            addCriterion("work_injury like", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryNotLike(String value) {
            addCriterion("work_injury not like", value, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryIn(List<String> values) {
            addCriterion("work_injury in", values, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryNotIn(List<String> values) {
            addCriterion("work_injury not in", values, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryBetween(String value1, String value2) {
            addCriterion("work_injury between", value1, value2, "workInjury");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryNotBetween(String value1, String value2) {
            addCriterion("work_injury not between", value1, value2, "workInjury");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentIsNull() {
            addCriterion("medical_treatment is null");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentIsNotNull() {
            addCriterion("medical_treatment is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentEqualTo(String value) {
            addCriterion("medical_treatment =", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentNotEqualTo(String value) {
            addCriterion("medical_treatment <>", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentGreaterThan(String value) {
            addCriterion("medical_treatment >", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentGreaterThanOrEqualTo(String value) {
            addCriterion("medical_treatment >=", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentLessThan(String value) {
            addCriterion("medical_treatment <", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentLessThanOrEqualTo(String value) {
            addCriterion("medical_treatment <=", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentLike(String value) {
            addCriterion("medical_treatment like", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentNotLike(String value) {
            addCriterion("medical_treatment not like", value, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentIn(List<String> values) {
            addCriterion("medical_treatment in", values, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentNotIn(List<String> values) {
            addCriterion("medical_treatment not in", values, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentBetween(String value1, String value2) {
            addCriterion("medical_treatment between", value1, value2, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentNotBetween(String value1, String value2) {
            addCriterion("medical_treatment not between", value1, value2, "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIsNull() {
            addCriterion("provident_fund is null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIsNotNull() {
            addCriterion("provident_fund is not null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundEqualTo(String value) {
            addCriterion("provident_fund =", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundNotEqualTo(String value) {
            addCriterion("provident_fund <>", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundGreaterThan(String value) {
            addCriterion("provident_fund >", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundGreaterThanOrEqualTo(String value) {
            addCriterion("provident_fund >=", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundLessThan(String value) {
            addCriterion("provident_fund <", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundLessThanOrEqualTo(String value) {
            addCriterion("provident_fund <=", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundLike(String value) {
            addCriterion("provident_fund like", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundNotLike(String value) {
            addCriterion("provident_fund not like", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIn(List<String> values) {
            addCriterion("provident_fund in", values, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundNotIn(List<String> values) {
            addCriterion("provident_fund not in", values, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundBetween(String value1, String value2) {
            addCriterion("provident_fund between", value1, value2, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundNotBetween(String value1, String value2) {
            addCriterion("provident_fund not between", value1, value2, "providentFund");
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

        public Criteria andPensionLikeInsensitive(String value) {
            addCriterion("upper(pension) like", value.toUpperCase(), "pension");
            return (Criteria) this;
        }

        public Criteria andUnemploymentLikeInsensitive(String value) {
            addCriterion("upper(unemployment) like", value.toUpperCase(), "unemployment");
            return (Criteria) this;
        }

        public Criteria andFertilityLikeInsensitive(String value) {
            addCriterion("upper(fertility) like", value.toUpperCase(), "fertility");
            return (Criteria) this;
        }

        public Criteria andWorkInjuryLikeInsensitive(String value) {
            addCriterion("upper(work_injury) like", value.toUpperCase(), "workInjury");
            return (Criteria) this;
        }

        public Criteria andMedicalTreatmentLikeInsensitive(String value) {
            addCriterion("upper(medical_treatment) like", value.toUpperCase(), "medicalTreatment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundLikeInsensitive(String value) {
            addCriterion("upper(provident_fund) like", value.toUpperCase(), "providentFund");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLikeInsensitive(String value) {
            addCriterion("upper(employee_id) like", value.toUpperCase(), "employeeId");
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