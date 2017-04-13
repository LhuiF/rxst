package com.unionx.web.company.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyShebaoBiliCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyShebaoBiliCriteria() {
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

        public Criteria andCompanyEndowmentIsNull() {
            addCriterion("company_endowment is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentIsNotNull() {
            addCriterion("company_endowment is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentEqualTo(Double value) {
            addCriterion("company_endowment =", value, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentNotEqualTo(Double value) {
            addCriterion("company_endowment <>", value, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentGreaterThan(Double value) {
            addCriterion("company_endowment >", value, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentGreaterThanOrEqualTo(Double value) {
            addCriterion("company_endowment >=", value, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentLessThan(Double value) {
            addCriterion("company_endowment <", value, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentLessThanOrEqualTo(Double value) {
            addCriterion("company_endowment <=", value, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentIn(List<Double> values) {
            addCriterion("company_endowment in", values, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentNotIn(List<Double> values) {
            addCriterion("company_endowment not in", values, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentBetween(Double value1, Double value2) {
            addCriterion("company_endowment between", value1, value2, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyEndowmentNotBetween(Double value1, Double value2) {
            addCriterion("company_endowment not between", value1, value2, "companyEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentIsNull() {
            addCriterion("person_endowment is null");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentIsNotNull() {
            addCriterion("person_endowment is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentEqualTo(Double value) {
            addCriterion("person_endowment =", value, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentNotEqualTo(Double value) {
            addCriterion("person_endowment <>", value, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentGreaterThan(Double value) {
            addCriterion("person_endowment >", value, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentGreaterThanOrEqualTo(Double value) {
            addCriterion("person_endowment >=", value, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentLessThan(Double value) {
            addCriterion("person_endowment <", value, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentLessThanOrEqualTo(Double value) {
            addCriterion("person_endowment <=", value, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentIn(List<Double> values) {
            addCriterion("person_endowment in", values, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentNotIn(List<Double> values) {
            addCriterion("person_endowment not in", values, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentBetween(Double value1, Double value2) {
            addCriterion("person_endowment between", value1, value2, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andPersonEndowmentNotBetween(Double value1, Double value2) {
            addCriterion("person_endowment not between", value1, value2, "personEndowment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentIsNull() {
            addCriterion("company_unemployment is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentIsNotNull() {
            addCriterion("company_unemployment is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentEqualTo(Double value) {
            addCriterion("company_unemployment =", value, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentNotEqualTo(Double value) {
            addCriterion("company_unemployment <>", value, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentGreaterThan(Double value) {
            addCriterion("company_unemployment >", value, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentGreaterThanOrEqualTo(Double value) {
            addCriterion("company_unemployment >=", value, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentLessThan(Double value) {
            addCriterion("company_unemployment <", value, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentLessThanOrEqualTo(Double value) {
            addCriterion("company_unemployment <=", value, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentIn(List<Double> values) {
            addCriterion("company_unemployment in", values, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentNotIn(List<Double> values) {
            addCriterion("company_unemployment not in", values, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentBetween(Double value1, Double value2) {
            addCriterion("company_unemployment between", value1, value2, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyUnemploymentNotBetween(Double value1, Double value2) {
            addCriterion("company_unemployment not between", value1, value2, "companyUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentIsNull() {
            addCriterion("person_unemployment is null");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentIsNotNull() {
            addCriterion("person_unemployment is not null");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentEqualTo(Double value) {
            addCriterion("person_unemployment =", value, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentNotEqualTo(Double value) {
            addCriterion("person_unemployment <>", value, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentGreaterThan(Double value) {
            addCriterion("person_unemployment >", value, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentGreaterThanOrEqualTo(Double value) {
            addCriterion("person_unemployment >=", value, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentLessThan(Double value) {
            addCriterion("person_unemployment <", value, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentLessThanOrEqualTo(Double value) {
            addCriterion("person_unemployment <=", value, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentIn(List<Double> values) {
            addCriterion("person_unemployment in", values, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentNotIn(List<Double> values) {
            addCriterion("person_unemployment not in", values, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentBetween(Double value1, Double value2) {
            addCriterion("person_unemployment between", value1, value2, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andPersonUnemploymentNotBetween(Double value1, Double value2) {
            addCriterion("person_unemployment not between", value1, value2, "personUnemployment");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryIsNull() {
            addCriterion("company_injury is null");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryIsNotNull() {
            addCriterion("company_injury is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryEqualTo(Double value) {
            addCriterion("company_injury =", value, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryNotEqualTo(Double value) {
            addCriterion("company_injury <>", value, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryGreaterThan(Double value) {
            addCriterion("company_injury >", value, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryGreaterThanOrEqualTo(Double value) {
            addCriterion("company_injury >=", value, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryLessThan(Double value) {
            addCriterion("company_injury <", value, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryLessThanOrEqualTo(Double value) {
            addCriterion("company_injury <=", value, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryIn(List<Double> values) {
            addCriterion("company_injury in", values, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryNotIn(List<Double> values) {
            addCriterion("company_injury not in", values, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryBetween(Double value1, Double value2) {
            addCriterion("company_injury between", value1, value2, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyInjuryNotBetween(Double value1, Double value2) {
            addCriterion("company_injury not between", value1, value2, "companyInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryIsNull() {
            addCriterion("person_injury is null");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryIsNotNull() {
            addCriterion("person_injury is not null");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryEqualTo(Double value) {
            addCriterion("person_injury =", value, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryNotEqualTo(Double value) {
            addCriterion("person_injury <>", value, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryGreaterThan(Double value) {
            addCriterion("person_injury >", value, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryGreaterThanOrEqualTo(Double value) {
            addCriterion("person_injury >=", value, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryLessThan(Double value) {
            addCriterion("person_injury <", value, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryLessThanOrEqualTo(Double value) {
            addCriterion("person_injury <=", value, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryIn(List<Double> values) {
            addCriterion("person_injury in", values, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryNotIn(List<Double> values) {
            addCriterion("person_injury not in", values, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryBetween(Double value1, Double value2) {
            addCriterion("person_injury between", value1, value2, "personInjury");
            return (Criteria) this;
        }

        public Criteria andPersonInjuryNotBetween(Double value1, Double value2) {
            addCriterion("person_injury not between", value1, value2, "personInjury");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalIsNull() {
            addCriterion("company_medical is null");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalIsNotNull() {
            addCriterion("company_medical is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalEqualTo(Double value) {
            addCriterion("company_medical =", value, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalNotEqualTo(Double value) {
            addCriterion("company_medical <>", value, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalGreaterThan(Double value) {
            addCriterion("company_medical >", value, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalGreaterThanOrEqualTo(Double value) {
            addCriterion("company_medical >=", value, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalLessThan(Double value) {
            addCriterion("company_medical <", value, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalLessThanOrEqualTo(Double value) {
            addCriterion("company_medical <=", value, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalIn(List<Double> values) {
            addCriterion("company_medical in", values, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalNotIn(List<Double> values) {
            addCriterion("company_medical not in", values, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalBetween(Double value1, Double value2) {
            addCriterion("company_medical between", value1, value2, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andCompanyMedicalNotBetween(Double value1, Double value2) {
            addCriterion("company_medical not between", value1, value2, "companyMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalIsNull() {
            addCriterion("person_medical is null");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalIsNotNull() {
            addCriterion("person_medical is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalEqualTo(Double value) {
            addCriterion("person_medical =", value, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalNotEqualTo(Double value) {
            addCriterion("person_medical <>", value, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalGreaterThan(Double value) {
            addCriterion("person_medical >", value, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalGreaterThanOrEqualTo(Double value) {
            addCriterion("person_medical >=", value, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalLessThan(Double value) {
            addCriterion("person_medical <", value, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalLessThanOrEqualTo(Double value) {
            addCriterion("person_medical <=", value, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalIn(List<Double> values) {
            addCriterion("person_medical in", values, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalNotIn(List<Double> values) {
            addCriterion("person_medical not in", values, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalBetween(Double value1, Double value2) {
            addCriterion("person_medical between", value1, value2, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalNotBetween(Double value1, Double value2) {
            addCriterion("person_medical not between", value1, value2, "personMedical");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbIsNull() {
            addCriterion("person_medical_db is null");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbIsNotNull() {
            addCriterion("person_medical_db is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbEqualTo(Double value) {
            addCriterion("person_medical_db =", value, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbNotEqualTo(Double value) {
            addCriterion("person_medical_db <>", value, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbGreaterThan(Double value) {
            addCriterion("person_medical_db >", value, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbGreaterThanOrEqualTo(Double value) {
            addCriterion("person_medical_db >=", value, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbLessThan(Double value) {
            addCriterion("person_medical_db <", value, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbLessThanOrEqualTo(Double value) {
            addCriterion("person_medical_db <=", value, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbIn(List<Double> values) {
            addCriterion("person_medical_db in", values, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbNotIn(List<Double> values) {
            addCriterion("person_medical_db not in", values, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbBetween(Double value1, Double value2) {
            addCriterion("person_medical_db between", value1, value2, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andPersonMedicalDbNotBetween(Double value1, Double value2) {
            addCriterion("person_medical_db not between", value1, value2, "personMedicalDb");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityIsNull() {
            addCriterion("company_maternity is null");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityIsNotNull() {
            addCriterion("company_maternity is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityEqualTo(Double value) {
            addCriterion("company_maternity =", value, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityNotEqualTo(Double value) {
            addCriterion("company_maternity <>", value, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityGreaterThan(Double value) {
            addCriterion("company_maternity >", value, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityGreaterThanOrEqualTo(Double value) {
            addCriterion("company_maternity >=", value, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityLessThan(Double value) {
            addCriterion("company_maternity <", value, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityLessThanOrEqualTo(Double value) {
            addCriterion("company_maternity <=", value, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityIn(List<Double> values) {
            addCriterion("company_maternity in", values, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityNotIn(List<Double> values) {
            addCriterion("company_maternity not in", values, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityBetween(Double value1, Double value2) {
            addCriterion("company_maternity between", value1, value2, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andCompanyMaternityNotBetween(Double value1, Double value2) {
            addCriterion("company_maternity not between", value1, value2, "companyMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityIsNull() {
            addCriterion("person_maternity is null");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityIsNotNull() {
            addCriterion("person_maternity is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityEqualTo(Double value) {
            addCriterion("person_maternity =", value, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityNotEqualTo(Double value) {
            addCriterion("person_maternity <>", value, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityGreaterThan(Double value) {
            addCriterion("person_maternity >", value, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityGreaterThanOrEqualTo(Double value) {
            addCriterion("person_maternity >=", value, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityLessThan(Double value) {
            addCriterion("person_maternity <", value, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityLessThanOrEqualTo(Double value) {
            addCriterion("person_maternity <=", value, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityIn(List<Double> values) {
            addCriterion("person_maternity in", values, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityNotIn(List<Double> values) {
            addCriterion("person_maternity not in", values, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityBetween(Double value1, Double value2) {
            addCriterion("person_maternity between", value1, value2, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPersonMaternityNotBetween(Double value1, Double value2) {
            addCriterion("person_maternity not between", value1, value2, "personMaternity");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeIsNull() {
            addCriterion("pay_person_type is null");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeIsNotNull() {
            addCriterion("pay_person_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeEqualTo(String value) {
            addCriterion("pay_person_type =", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeNotEqualTo(String value) {
            addCriterion("pay_person_type <>", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeGreaterThan(String value) {
            addCriterion("pay_person_type >", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_person_type >=", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeLessThan(String value) {
            addCriterion("pay_person_type <", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_person_type <=", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeLike(String value) {
            addCriterion("pay_person_type like", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeNotLike(String value) {
            addCriterion("pay_person_type not like", value, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeIn(List<String> values) {
            addCriterion("pay_person_type in", values, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeNotIn(List<String> values) {
            addCriterion("pay_person_type not in", values, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeBetween(String value1, String value2) {
            addCriterion("pay_person_type between", value1, value2, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonTypeNotBetween(String value1, String value2) {
            addCriterion("pay_person_type not between", value1, value2, "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameIsNull() {
            addCriterion("pay_person_name is null");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameIsNotNull() {
            addCriterion("pay_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameEqualTo(String value) {
            addCriterion("pay_person_name =", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameNotEqualTo(String value) {
            addCriterion("pay_person_name <>", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameGreaterThan(String value) {
            addCriterion("pay_person_name >", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("pay_person_name >=", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameLessThan(String value) {
            addCriterion("pay_person_name <", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameLessThanOrEqualTo(String value) {
            addCriterion("pay_person_name <=", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameLike(String value) {
            addCriterion("pay_person_name like", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameNotLike(String value) {
            addCriterion("pay_person_name not like", value, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameIn(List<String> values) {
            addCriterion("pay_person_name in", values, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameNotIn(List<String> values) {
            addCriterion("pay_person_name not in", values, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameBetween(String value1, String value2) {
            addCriterion("pay_person_name between", value1, value2, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameNotBetween(String value1, String value2) {
            addCriterion("pay_person_name not between", value1, value2, "payPersonName");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidIsNull() {
            addCriterion("company_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidIsNotNull() {
            addCriterion("company_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidEqualTo(String value) {
            addCriterion("company_uuid =", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidNotEqualTo(String value) {
            addCriterion("company_uuid <>", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidGreaterThan(String value) {
            addCriterion("company_uuid >", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidGreaterThanOrEqualTo(String value) {
            addCriterion("company_uuid >=", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidLessThan(String value) {
            addCriterion("company_uuid <", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidLessThanOrEqualTo(String value) {
            addCriterion("company_uuid <=", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidLike(String value) {
            addCriterion("company_uuid like", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidNotLike(String value) {
            addCriterion("company_uuid not like", value, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidIn(List<String> values) {
            addCriterion("company_uuid in", values, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidNotIn(List<String> values) {
            addCriterion("company_uuid not in", values, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidBetween(String value1, String value2) {
            addCriterion("company_uuid between", value1, value2, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidNotBetween(String value1, String value2) {
            addCriterion("company_uuid not between", value1, value2, "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidIsNull() {
            addCriterion("shebao_canshu_uuid is null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidIsNotNull() {
            addCriterion("shebao_canshu_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidEqualTo(String value) {
            addCriterion("shebao_canshu_uuid =", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidNotEqualTo(String value) {
            addCriterion("shebao_canshu_uuid <>", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidGreaterThan(String value) {
            addCriterion("shebao_canshu_uuid >", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidGreaterThanOrEqualTo(String value) {
            addCriterion("shebao_canshu_uuid >=", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidLessThan(String value) {
            addCriterion("shebao_canshu_uuid <", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidLessThanOrEqualTo(String value) {
            addCriterion("shebao_canshu_uuid <=", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidLike(String value) {
            addCriterion("shebao_canshu_uuid like", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidNotLike(String value) {
            addCriterion("shebao_canshu_uuid not like", value, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidIn(List<String> values) {
            addCriterion("shebao_canshu_uuid in", values, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidNotIn(List<String> values) {
            addCriterion("shebao_canshu_uuid not in", values, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidBetween(String value1, String value2) {
            addCriterion("shebao_canshu_uuid between", value1, value2, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidNotBetween(String value1, String value2) {
            addCriterion("shebao_canshu_uuid not between", value1, value2, "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityIsNull() {
            addCriterion("shebao_canshu_yearCity is null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityIsNotNull() {
            addCriterion("shebao_canshu_yearCity is not null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityEqualTo(String value) {
            addCriterion("shebao_canshu_yearCity =", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityNotEqualTo(String value) {
            addCriterion("shebao_canshu_yearCity <>", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityGreaterThan(String value) {
            addCriterion("shebao_canshu_yearCity >", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityGreaterThanOrEqualTo(String value) {
            addCriterion("shebao_canshu_yearCity >=", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityLessThan(String value) {
            addCriterion("shebao_canshu_yearCity <", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityLessThanOrEqualTo(String value) {
            addCriterion("shebao_canshu_yearCity <=", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityLike(String value) {
            addCriterion("shebao_canshu_yearCity like", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityNotLike(String value) {
            addCriterion("shebao_canshu_yearCity not like", value, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityIn(List<String> values) {
            addCriterion("shebao_canshu_yearCity in", values, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityNotIn(List<String> values) {
            addCriterion("shebao_canshu_yearCity not in", values, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityBetween(String value1, String value2) {
            addCriterion("shebao_canshu_yearCity between", value1, value2, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityNotBetween(String value1, String value2) {
            addCriterion("shebao_canshu_yearCity not between", value1, value2, "shebaoCanshuYearcity");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeIsNull() {
            addCriterion("shebao_canshu_startTime is null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeIsNotNull() {
            addCriterion("shebao_canshu_startTime is not null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeEqualTo(Date value) {
            addCriterion("shebao_canshu_startTime =", value, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeNotEqualTo(Date value) {
            addCriterion("shebao_canshu_startTime <>", value, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeGreaterThan(Date value) {
            addCriterion("shebao_canshu_startTime >", value, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shebao_canshu_startTime >=", value, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeLessThan(Date value) {
            addCriterion("shebao_canshu_startTime <", value, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("shebao_canshu_startTime <=", value, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeIn(List<Date> values) {
            addCriterion("shebao_canshu_startTime in", values, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeNotIn(List<Date> values) {
            addCriterion("shebao_canshu_startTime not in", values, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeBetween(Date value1, Date value2) {
            addCriterion("shebao_canshu_startTime between", value1, value2, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("shebao_canshu_startTime not between", value1, value2, "shebaoCanshuStarttime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeIsNull() {
            addCriterion("shebao_canshu_endTime is null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeIsNotNull() {
            addCriterion("shebao_canshu_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeEqualTo(Date value) {
            addCriterion("shebao_canshu_endTime =", value, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeNotEqualTo(Date value) {
            addCriterion("shebao_canshu_endTime <>", value, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeGreaterThan(Date value) {
            addCriterion("shebao_canshu_endTime >", value, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shebao_canshu_endTime >=", value, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeLessThan(Date value) {
            addCriterion("shebao_canshu_endTime <", value, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("shebao_canshu_endTime <=", value, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeIn(List<Date> values) {
            addCriterion("shebao_canshu_endTime in", values, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeNotIn(List<Date> values) {
            addCriterion("shebao_canshu_endTime not in", values, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeBetween(Date value1, Date value2) {
            addCriterion("shebao_canshu_endTime between", value1, value2, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("shebao_canshu_endTime not between", value1, value2, "shebaoCanshuEndtime");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingIsNull() {
            addCriterion("shebao_canshu_celling is null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingIsNotNull() {
            addCriterion("shebao_canshu_celling is not null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingEqualTo(Double value) {
            addCriterion("shebao_canshu_celling =", value, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingNotEqualTo(Double value) {
            addCriterion("shebao_canshu_celling <>", value, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingGreaterThan(Double value) {
            addCriterion("shebao_canshu_celling >", value, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingGreaterThanOrEqualTo(Double value) {
            addCriterion("shebao_canshu_celling >=", value, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingLessThan(Double value) {
            addCriterion("shebao_canshu_celling <", value, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingLessThanOrEqualTo(Double value) {
            addCriterion("shebao_canshu_celling <=", value, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingIn(List<Double> values) {
            addCriterion("shebao_canshu_celling in", values, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingNotIn(List<Double> values) {
            addCriterion("shebao_canshu_celling not in", values, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingBetween(Double value1, Double value2) {
            addCriterion("shebao_canshu_celling between", value1, value2, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuCellingNotBetween(Double value1, Double value2) {
            addCriterion("shebao_canshu_celling not between", value1, value2, "shebaoCanshuCelling");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorIsNull() {
            addCriterion("shebao_canshu_floor is null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorIsNotNull() {
            addCriterion("shebao_canshu_floor is not null");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorEqualTo(Double value) {
            addCriterion("shebao_canshu_floor =", value, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorNotEqualTo(Double value) {
            addCriterion("shebao_canshu_floor <>", value, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorGreaterThan(Double value) {
            addCriterion("shebao_canshu_floor >", value, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorGreaterThanOrEqualTo(Double value) {
            addCriterion("shebao_canshu_floor >=", value, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorLessThan(Double value) {
            addCriterion("shebao_canshu_floor <", value, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorLessThanOrEqualTo(Double value) {
            addCriterion("shebao_canshu_floor <=", value, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorIn(List<Double> values) {
            addCriterion("shebao_canshu_floor in", values, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorNotIn(List<Double> values) {
            addCriterion("shebao_canshu_floor not in", values, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorBetween(Double value1, Double value2) {
            addCriterion("shebao_canshu_floor between", value1, value2, "shebaoCanshuFloor");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuFloorNotBetween(Double value1, Double value2) {
            addCriterion("shebao_canshu_floor not between", value1, value2, "shebaoCanshuFloor");
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

        public Criteria andPayPersonTypeLikeInsensitive(String value) {
            addCriterion("upper(pay_person_type) like", value.toUpperCase(), "payPersonType");
            return (Criteria) this;
        }

        public Criteria andPayPersonNameLikeInsensitive(String value) {
            addCriterion("upper(pay_person_name) like", value.toUpperCase(), "payPersonName");
            return (Criteria) this;
        }

        public Criteria andCompanyUuidLikeInsensitive(String value) {
            addCriterion("upper(company_uuid) like", value.toUpperCase(), "companyUuid");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLikeInsensitive(String value) {
            addCriterion("upper(company_name) like", value.toUpperCase(), "companyName");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuUuidLikeInsensitive(String value) {
            addCriterion("upper(shebao_canshu_uuid) like", value.toUpperCase(), "shebaoCanshuUuid");
            return (Criteria) this;
        }

        public Criteria andShebaoCanshuYearcityLikeInsensitive(String value) {
            addCriterion("upper(shebao_canshu_yearCity) like", value.toUpperCase(), "shebaoCanshuYearcity");
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