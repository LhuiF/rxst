package com.unionx.sys.enterprise.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RsEnterpriseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RsEnterpriseCriteria() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountIsNull() {
            addCriterion("insurance_account is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountIsNotNull() {
            addCriterion("insurance_account is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountEqualTo(String value) {
            addCriterion("insurance_account =", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountNotEqualTo(String value) {
            addCriterion("insurance_account <>", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountGreaterThan(String value) {
            addCriterion("insurance_account >", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountGreaterThanOrEqualTo(String value) {
            addCriterion("insurance_account >=", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountLessThan(String value) {
            addCriterion("insurance_account <", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountLessThanOrEqualTo(String value) {
            addCriterion("insurance_account <=", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountLike(String value) {
            addCriterion("insurance_account like", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountNotLike(String value) {
            addCriterion("insurance_account not like", value, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountIn(List<String> values) {
            addCriterion("insurance_account in", values, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountNotIn(List<String> values) {
            addCriterion("insurance_account not in", values, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountBetween(String value1, String value2) {
            addCriterion("insurance_account between", value1, value2, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountNotBetween(String value1, String value2) {
            addCriterion("insurance_account not between", value1, value2, "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andWorkAddrIsNull() {
            addCriterion("work_addr is null");
            return (Criteria) this;
        }

        public Criteria andWorkAddrIsNotNull() {
            addCriterion("work_addr is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAddrEqualTo(String value) {
            addCriterion("work_addr =", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrNotEqualTo(String value) {
            addCriterion("work_addr <>", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrGreaterThan(String value) {
            addCriterion("work_addr >", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrGreaterThanOrEqualTo(String value) {
            addCriterion("work_addr >=", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrLessThan(String value) {
            addCriterion("work_addr <", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrLessThanOrEqualTo(String value) {
            addCriterion("work_addr <=", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrLike(String value) {
            addCriterion("work_addr like", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrNotLike(String value) {
            addCriterion("work_addr not like", value, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrIn(List<String> values) {
            addCriterion("work_addr in", values, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrNotIn(List<String> values) {
            addCriterion("work_addr not in", values, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrBetween(String value1, String value2) {
            addCriterion("work_addr between", value1, value2, "workAddr");
            return (Criteria) this;
        }

        public Criteria andWorkAddrNotBetween(String value1, String value2) {
            addCriterion("work_addr not between", value1, value2, "workAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNull() {
            addCriterion("reg_addr is null");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNotNull() {
            addCriterion("reg_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRegAddrEqualTo(String value) {
            addCriterion("reg_addr =", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotEqualTo(String value) {
            addCriterion("reg_addr <>", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThan(String value) {
            addCriterion("reg_addr >", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThanOrEqualTo(String value) {
            addCriterion("reg_addr >=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThan(String value) {
            addCriterion("reg_addr <", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThanOrEqualTo(String value) {
            addCriterion("reg_addr <=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLike(String value) {
            addCriterion("reg_addr like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotLike(String value) {
            addCriterion("reg_addr not like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIn(List<String> values) {
            addCriterion("reg_addr in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotIn(List<String> values) {
            addCriterion("reg_addr not in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrBetween(String value1, String value2) {
            addCriterion("reg_addr between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotBetween(String value1, String value2) {
            addCriterion("reg_addr not between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("legal_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("legal_name =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("legal_name <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("legal_name >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_name >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("legal_name <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("legal_name <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("legal_name like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("legal_name not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("legal_name in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("legal_name not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("legal_name between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("legal_name not between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIsNull() {
            addCriterion("legal_phone is null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIsNotNull() {
            addCriterion("legal_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneEqualTo(String value) {
            addCriterion("legal_phone =", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotEqualTo(String value) {
            addCriterion("legal_phone <>", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneGreaterThan(String value) {
            addCriterion("legal_phone >", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("legal_phone >=", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLessThan(String value) {
            addCriterion("legal_phone <", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLessThanOrEqualTo(String value) {
            addCriterion("legal_phone <=", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLike(String value) {
            addCriterion("legal_phone like", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotLike(String value) {
            addCriterion("legal_phone not like", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIn(List<String> values) {
            addCriterion("legal_phone in", values, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotIn(List<String> values) {
            addCriterion("legal_phone not in", values, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneBetween(String value1, String value2) {
            addCriterion("legal_phone between", value1, value2, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotBetween(String value1, String value2) {
            addCriterion("legal_phone not between", value1, value2, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNull() {
            addCriterion("agent_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNotNull() {
            addCriterion("agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNameEqualTo(String value) {
            addCriterion("agent_name =", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotEqualTo(String value) {
            addCriterion("agent_name <>", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThan(String value) {
            addCriterion("agent_name >", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_name >=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThan(String value) {
            addCriterion("agent_name <", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThanOrEqualTo(String value) {
            addCriterion("agent_name <=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLike(String value) {
            addCriterion("agent_name like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotLike(String value) {
            addCriterion("agent_name not like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameIn(List<String> values) {
            addCriterion("agent_name in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotIn(List<String> values) {
            addCriterion("agent_name not in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameBetween(String value1, String value2) {
            addCriterion("agent_name between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotBetween(String value1, String value2) {
            addCriterion("agent_name not between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneIsNull() {
            addCriterion("agent_phone is null");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneIsNotNull() {
            addCriterion("agent_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneEqualTo(String value) {
            addCriterion("agent_phone =", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotEqualTo(String value) {
            addCriterion("agent_phone <>", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneGreaterThan(String value) {
            addCriterion("agent_phone >", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("agent_phone >=", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneLessThan(String value) {
            addCriterion("agent_phone <", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneLessThanOrEqualTo(String value) {
            addCriterion("agent_phone <=", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneLike(String value) {
            addCriterion("agent_phone like", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotLike(String value) {
            addCriterion("agent_phone not like", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneIn(List<String> values) {
            addCriterion("agent_phone in", values, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotIn(List<String> values) {
            addCriterion("agent_phone not in", values, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneBetween(String value1, String value2) {
            addCriterion("agent_phone between", value1, value2, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotBetween(String value1, String value2) {
            addCriterion("agent_phone not between", value1, value2, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaIsNull() {
            addCriterion("insureance_area is null");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaIsNotNull() {
            addCriterion("insureance_area is not null");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaEqualTo(String value) {
            addCriterion("insureance_area =", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaNotEqualTo(String value) {
            addCriterion("insureance_area <>", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaGreaterThan(String value) {
            addCriterion("insureance_area >", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaGreaterThanOrEqualTo(String value) {
            addCriterion("insureance_area >=", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaLessThan(String value) {
            addCriterion("insureance_area <", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaLessThanOrEqualTo(String value) {
            addCriterion("insureance_area <=", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaLike(String value) {
            addCriterion("insureance_area like", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaNotLike(String value) {
            addCriterion("insureance_area not like", value, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaIn(List<String> values) {
            addCriterion("insureance_area in", values, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaNotIn(List<String> values) {
            addCriterion("insureance_area not in", values, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaBetween(String value1, String value2) {
            addCriterion("insureance_area between", value1, value2, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaNotBetween(String value1, String value2) {
            addCriterion("insureance_area not between", value1, value2, "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaIsNull() {
            addCriterion("accumulation_area is null");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaIsNotNull() {
            addCriterion("accumulation_area is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaEqualTo(String value) {
            addCriterion("accumulation_area =", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaNotEqualTo(String value) {
            addCriterion("accumulation_area <>", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaGreaterThan(String value) {
            addCriterion("accumulation_area >", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaGreaterThanOrEqualTo(String value) {
            addCriterion("accumulation_area >=", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaLessThan(String value) {
            addCriterion("accumulation_area <", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaLessThanOrEqualTo(String value) {
            addCriterion("accumulation_area <=", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaLike(String value) {
            addCriterion("accumulation_area like", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaNotLike(String value) {
            addCriterion("accumulation_area not like", value, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaIn(List<String> values) {
            addCriterion("accumulation_area in", values, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaNotIn(List<String> values) {
            addCriterion("accumulation_area not in", values, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaBetween(String value1, String value2) {
            addCriterion("accumulation_area between", value1, value2, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaNotBetween(String value1, String value2) {
            addCriterion("accumulation_area not between", value1, value2, "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAngencyIsNull() {
            addCriterion("angency is null");
            return (Criteria) this;
        }

        public Criteria andAngencyIsNotNull() {
            addCriterion("angency is not null");
            return (Criteria) this;
        }

        public Criteria andAngencyEqualTo(String value) {
            addCriterion("angency =", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyNotEqualTo(String value) {
            addCriterion("angency <>", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyGreaterThan(String value) {
            addCriterion("angency >", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyGreaterThanOrEqualTo(String value) {
            addCriterion("angency >=", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyLessThan(String value) {
            addCriterion("angency <", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyLessThanOrEqualTo(String value) {
            addCriterion("angency <=", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyLike(String value) {
            addCriterion("angency like", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyNotLike(String value) {
            addCriterion("angency not like", value, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyIn(List<String> values) {
            addCriterion("angency in", values, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyNotIn(List<String> values) {
            addCriterion("angency not in", values, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyBetween(String value1, String value2) {
            addCriterion("angency between", value1, value2, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyNotBetween(String value1, String value2) {
            addCriterion("angency not between", value1, value2, "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyIdIsNull() {
            addCriterion("angency_Id is null");
            return (Criteria) this;
        }

        public Criteria andAngencyIdIsNotNull() {
            addCriterion("angency_Id is not null");
            return (Criteria) this;
        }

        public Criteria andAngencyIdEqualTo(String value) {
            addCriterion("angency_Id =", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdNotEqualTo(String value) {
            addCriterion("angency_Id <>", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdGreaterThan(String value) {
            addCriterion("angency_Id >", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdGreaterThanOrEqualTo(String value) {
            addCriterion("angency_Id >=", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdLessThan(String value) {
            addCriterion("angency_Id <", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdLessThanOrEqualTo(String value) {
            addCriterion("angency_Id <=", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdLike(String value) {
            addCriterion("angency_Id like", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdNotLike(String value) {
            addCriterion("angency_Id not like", value, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdIn(List<String> values) {
            addCriterion("angency_Id in", values, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdNotIn(List<String> values) {
            addCriterion("angency_Id not in", values, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdBetween(String value1, String value2) {
            addCriterion("angency_Id between", value1, value2, "angencyId");
            return (Criteria) this;
        }

        public Criteria andAngencyIdNotBetween(String value1, String value2) {
            addCriterion("angency_Id not between", value1, value2, "angencyId");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceIsNull() {
            addCriterion("isinsurance is null");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceIsNotNull() {
            addCriterion("isinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceEqualTo(String value) {
            addCriterion("isinsurance =", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceNotEqualTo(String value) {
            addCriterion("isinsurance <>", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceGreaterThan(String value) {
            addCriterion("isinsurance >", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("isinsurance >=", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceLessThan(String value) {
            addCriterion("isinsurance <", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceLessThanOrEqualTo(String value) {
            addCriterion("isinsurance <=", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceLike(String value) {
            addCriterion("isinsurance like", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceNotLike(String value) {
            addCriterion("isinsurance not like", value, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceIn(List<String> values) {
            addCriterion("isinsurance in", values, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceNotIn(List<String> values) {
            addCriterion("isinsurance not in", values, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceBetween(String value1, String value2) {
            addCriterion("isinsurance between", value1, value2, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceNotBetween(String value1, String value2) {
            addCriterion("isinsurance not between", value1, value2, "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceIsNull() {
            addCriterion("ishealthinsurance is null");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceIsNotNull() {
            addCriterion("ishealthinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceEqualTo(String value) {
            addCriterion("ishealthinsurance =", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceNotEqualTo(String value) {
            addCriterion("ishealthinsurance <>", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceGreaterThan(String value) {
            addCriterion("ishealthinsurance >", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("ishealthinsurance >=", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceLessThan(String value) {
            addCriterion("ishealthinsurance <", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceLessThanOrEqualTo(String value) {
            addCriterion("ishealthinsurance <=", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceLike(String value) {
            addCriterion("ishealthinsurance like", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceNotLike(String value) {
            addCriterion("ishealthinsurance not like", value, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceIn(List<String> values) {
            addCriterion("ishealthinsurance in", values, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceNotIn(List<String> values) {
            addCriterion("ishealthinsurance not in", values, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceBetween(String value1, String value2) {
            addCriterion("ishealthinsurance between", value1, value2, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceNotBetween(String value1, String value2) {
            addCriterion("ishealthinsurance not between", value1, value2, "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesIsNull() {
            addCriterion("isbankfees is null");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesIsNotNull() {
            addCriterion("isbankfees is not null");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesEqualTo(String value) {
            addCriterion("isbankfees =", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesNotEqualTo(String value) {
            addCriterion("isbankfees <>", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesGreaterThan(String value) {
            addCriterion("isbankfees >", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesGreaterThanOrEqualTo(String value) {
            addCriterion("isbankfees >=", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesLessThan(String value) {
            addCriterion("isbankfees <", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesLessThanOrEqualTo(String value) {
            addCriterion("isbankfees <=", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesLike(String value) {
            addCriterion("isbankfees like", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesNotLike(String value) {
            addCriterion("isbankfees not like", value, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesIn(List<String> values) {
            addCriterion("isbankfees in", values, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesNotIn(List<String> values) {
            addCriterion("isbankfees not in", values, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesBetween(String value1, String value2) {
            addCriterion("isbankfees between", value1, value2, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesNotBetween(String value1, String value2) {
            addCriterion("isbankfees not between", value1, value2, "isbankfees");
            return (Criteria) this;
        }

        public Criteria andOpenBankIsNull() {
            addCriterion("open_bank is null");
            return (Criteria) this;
        }

        public Criteria andOpenBankIsNotNull() {
            addCriterion("open_bank is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBankEqualTo(String value) {
            addCriterion("open_bank =", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotEqualTo(String value) {
            addCriterion("open_bank <>", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankGreaterThan(String value) {
            addCriterion("open_bank >", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankGreaterThanOrEqualTo(String value) {
            addCriterion("open_bank >=", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLessThan(String value) {
            addCriterion("open_bank <", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLessThanOrEqualTo(String value) {
            addCriterion("open_bank <=", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLike(String value) {
            addCriterion("open_bank like", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotLike(String value) {
            addCriterion("open_bank not like", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankIn(List<String> values) {
            addCriterion("open_bank in", values, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotIn(List<String> values) {
            addCriterion("open_bank not in", values, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankBetween(String value1, String value2) {
            addCriterion("open_bank between", value1, value2, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotBetween(String value1, String value2) {
            addCriterion("open_bank not between", value1, value2, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenCodeIsNull() {
            addCriterion("open_code is null");
            return (Criteria) this;
        }

        public Criteria andOpenCodeIsNotNull() {
            addCriterion("open_code is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCodeEqualTo(String value) {
            addCriterion("open_code =", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeNotEqualTo(String value) {
            addCriterion("open_code <>", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeGreaterThan(String value) {
            addCriterion("open_code >", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeGreaterThanOrEqualTo(String value) {
            addCriterion("open_code >=", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeLessThan(String value) {
            addCriterion("open_code <", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeLessThanOrEqualTo(String value) {
            addCriterion("open_code <=", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeLike(String value) {
            addCriterion("open_code like", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeNotLike(String value) {
            addCriterion("open_code not like", value, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeIn(List<String> values) {
            addCriterion("open_code in", values, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeNotIn(List<String> values) {
            addCriterion("open_code not in", values, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeBetween(String value1, String value2) {
            addCriterion("open_code between", value1, value2, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenCodeNotBetween(String value1, String value2) {
            addCriterion("open_code not between", value1, value2, "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenAccountIsNull() {
            addCriterion("open_account is null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountIsNotNull() {
            addCriterion("open_account is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountEqualTo(String value) {
            addCriterion("open_account =", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountNotEqualTo(String value) {
            addCriterion("open_account <>", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountGreaterThan(String value) {
            addCriterion("open_account >", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountGreaterThanOrEqualTo(String value) {
            addCriterion("open_account >=", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountLessThan(String value) {
            addCriterion("open_account <", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountLessThanOrEqualTo(String value) {
            addCriterion("open_account <=", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountLike(String value) {
            addCriterion("open_account like", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountNotLike(String value) {
            addCriterion("open_account not like", value, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountIn(List<String> values) {
            addCriterion("open_account in", values, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountNotIn(List<String> values) {
            addCriterion("open_account not in", values, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountBetween(String value1, String value2) {
            addCriterion("open_account between", value1, value2, "openAccount");
            return (Criteria) this;
        }

        public Criteria andOpenAccountNotBetween(String value1, String value2) {
            addCriterion("open_account not between", value1, value2, "openAccount");
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

        public Criteria andDcDateIsNull() {
            addCriterion("DC_date is null");
            return (Criteria) this;
        }

        public Criteria andDcDateIsNotNull() {
            addCriterion("DC_date is not null");
            return (Criteria) this;
        }

        public Criteria andDcDateEqualTo(Date value) {
            addCriterionForJDBCDate("DC_date =", value, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("DC_date <>", value, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateGreaterThan(Date value) {
            addCriterionForJDBCDate("DC_date >", value, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DC_date >=", value, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateLessThan(Date value) {
            addCriterionForJDBCDate("DC_date <", value, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DC_date <=", value, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateIn(List<Date> values) {
            addCriterionForJDBCDate("DC_date in", values, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("DC_date not in", values, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DC_date between", value1, value2, "dcDate");
            return (Criteria) this;
        }

        public Criteria andDcDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DC_date not between", value1, value2, "dcDate");
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

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andInsuranceAccountLikeInsensitive(String value) {
            addCriterion("upper(insurance_account) like", value.toUpperCase(), "insuranceAccount");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLikeInsensitive(String value) {
            addCriterion("upper(org_code) like", value.toUpperCase(), "orgCode");
            return (Criteria) this;
        }

        public Criteria andWorkAddrLikeInsensitive(String value) {
            addCriterion("upper(work_addr) like", value.toUpperCase(), "workAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLikeInsensitive(String value) {
            addCriterion("upper(reg_addr) like", value.toUpperCase(), "regAddr");
            return (Criteria) this;
        }

        public Criteria andLegalNameLikeInsensitive(String value) {
            addCriterion("upper(legal_name) like", value.toUpperCase(), "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLikeInsensitive(String value) {
            addCriterion("upper(legal_phone) like", value.toUpperCase(), "legalPhone");
            return (Criteria) this;
        }

        public Criteria andAgentNameLikeInsensitive(String value) {
            addCriterion("upper(agent_name) like", value.toUpperCase(), "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneLikeInsensitive(String value) {
            addCriterion("upper(agent_phone) like", value.toUpperCase(), "agentPhone");
            return (Criteria) this;
        }

        public Criteria andInsureanceAreaLikeInsensitive(String value) {
            addCriterion("upper(insureance_area) like", value.toUpperCase(), "insureanceArea");
            return (Criteria) this;
        }

        public Criteria andAccumulationAreaLikeInsensitive(String value) {
            addCriterion("upper(accumulation_area) like", value.toUpperCase(), "accumulationArea");
            return (Criteria) this;
        }

        public Criteria andAngencyLikeInsensitive(String value) {
            addCriterion("upper(angency) like", value.toUpperCase(), "angency");
            return (Criteria) this;
        }

        public Criteria andAngencyIdLikeInsensitive(String value) {
            addCriterion("upper(angency_Id) like", value.toUpperCase(), "angencyId");
            return (Criteria) this;
        }

        public Criteria andIsinsuranceLikeInsensitive(String value) {
            addCriterion("upper(isinsurance) like", value.toUpperCase(), "isinsurance");
            return (Criteria) this;
        }

        public Criteria andIshealthinsuranceLikeInsensitive(String value) {
            addCriterion("upper(ishealthinsurance) like", value.toUpperCase(), "ishealthinsurance");
            return (Criteria) this;
        }

        public Criteria andIsbankfeesLikeInsensitive(String value) {
            addCriterion("upper(isbankfees) like", value.toUpperCase(), "isbankfees");
            return (Criteria) this;
        }

        public Criteria andOpenBankLikeInsensitive(String value) {
            addCriterion("upper(open_bank) like", value.toUpperCase(), "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenCodeLikeInsensitive(String value) {
            addCriterion("upper(open_code) like", value.toUpperCase(), "openCode");
            return (Criteria) this;
        }

        public Criteria andOpenAccountLikeInsensitive(String value) {
            addCriterion("upper(open_account) like", value.toUpperCase(), "openAccount");
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