package com.unionx.base.material.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMaterialCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMaterialCriteria() {
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

        public Criteria andQuIsNull() {
            addCriterion("qu is null");
            return (Criteria) this;
        }

        public Criteria andQuIsNotNull() {
            addCriterion("qu is not null");
            return (Criteria) this;
        }

        public Criteria andQuEqualTo(String value) {
            addCriterion("qu =", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotEqualTo(String value) {
            addCriterion("qu <>", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuGreaterThan(String value) {
            addCriterion("qu >", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuGreaterThanOrEqualTo(String value) {
            addCriterion("qu >=", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuLessThan(String value) {
            addCriterion("qu <", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuLessThanOrEqualTo(String value) {
            addCriterion("qu <=", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuLike(String value) {
            addCriterion("qu like", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotLike(String value) {
            addCriterion("qu not like", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuIn(List<String> values) {
            addCriterion("qu in", values, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotIn(List<String> values) {
            addCriterion("qu not in", values, "qu");
            return (Criteria) this;
        }

        public Criteria andQuBetween(String value1, String value2) {
            addCriterion("qu between", value1, value2, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotBetween(String value1, String value2) {
            addCriterion("qu not between", value1, value2, "qu");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andIsMaterialIsNull() {
            addCriterion("is_material is null");
            return (Criteria) this;
        }

        public Criteria andIsMaterialIsNotNull() {
            addCriterion("is_material is not null");
            return (Criteria) this;
        }

        public Criteria andIsMaterialEqualTo(Integer value) {
            addCriterion("is_material =", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialNotEqualTo(Integer value) {
            addCriterion("is_material <>", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialGreaterThan(Integer value) {
            addCriterion("is_material >", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_material >=", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialLessThan(Integer value) {
            addCriterion("is_material <", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialLessThanOrEqualTo(Integer value) {
            addCriterion("is_material <=", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialIn(List<Integer> values) {
            addCriterion("is_material in", values, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialNotIn(List<Integer> values) {
            addCriterion("is_material not in", values, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialBetween(Integer value1, Integer value2) {
            addCriterion("is_material between", value1, value2, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialNotBetween(Integer value1, Integer value2) {
            addCriterion("is_material not between", value1, value2, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsApplyIsNull() {
            addCriterion("is_apply is null");
            return (Criteria) this;
        }

        public Criteria andIsApplyIsNotNull() {
            addCriterion("is_apply is not null");
            return (Criteria) this;
        }

        public Criteria andIsApplyEqualTo(Integer value) {
            addCriterion("is_apply =", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotEqualTo(Integer value) {
            addCriterion("is_apply <>", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyGreaterThan(Integer value) {
            addCriterion("is_apply >", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_apply >=", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLessThan(Integer value) {
            addCriterion("is_apply <", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLessThanOrEqualTo(Integer value) {
            addCriterion("is_apply <=", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyIn(List<Integer> values) {
            addCriterion("is_apply in", values, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotIn(List<Integer> values) {
            addCriterion("is_apply not in", values, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyBetween(Integer value1, Integer value2) {
            addCriterion("is_apply between", value1, value2, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_apply not between", value1, value2, "isApply");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCondition01IsNull() {
            addCriterion("condition_01 is null");
            return (Criteria) this;
        }

        public Criteria andCondition01IsNotNull() {
            addCriterion("condition_01 is not null");
            return (Criteria) this;
        }

        public Criteria andCondition01EqualTo(String value) {
            addCriterion("condition_01 =", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01NotEqualTo(String value) {
            addCriterion("condition_01 <>", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01GreaterThan(String value) {
            addCriterion("condition_01 >", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01GreaterThanOrEqualTo(String value) {
            addCriterion("condition_01 >=", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01LessThan(String value) {
            addCriterion("condition_01 <", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01LessThanOrEqualTo(String value) {
            addCriterion("condition_01 <=", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01Like(String value) {
            addCriterion("condition_01 like", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01NotLike(String value) {
            addCriterion("condition_01 not like", value, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01In(List<String> values) {
            addCriterion("condition_01 in", values, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01NotIn(List<String> values) {
            addCriterion("condition_01 not in", values, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01Between(String value1, String value2) {
            addCriterion("condition_01 between", value1, value2, "condition01");
            return (Criteria) this;
        }

        public Criteria andCondition01NotBetween(String value1, String value2) {
            addCriterion("condition_01 not between", value1, value2, "condition01");
            return (Criteria) this;
        }

        public Criteria andConditon01IsNull() {
            addCriterion("conditon_01 is null");
            return (Criteria) this;
        }

        public Criteria andConditon01IsNotNull() {
            addCriterion("conditon_01 is not null");
            return (Criteria) this;
        }

        public Criteria andConditon01EqualTo(String value) {
            addCriterion("conditon_01 =", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01NotEqualTo(String value) {
            addCriterion("conditon_01 <>", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01GreaterThan(String value) {
            addCriterion("conditon_01 >", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01GreaterThanOrEqualTo(String value) {
            addCriterion("conditon_01 >=", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01LessThan(String value) {
            addCriterion("conditon_01 <", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01LessThanOrEqualTo(String value) {
            addCriterion("conditon_01 <=", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01Like(String value) {
            addCriterion("conditon_01 like", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01NotLike(String value) {
            addCriterion("conditon_01 not like", value, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01In(List<String> values) {
            addCriterion("conditon_01 in", values, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01NotIn(List<String> values) {
            addCriterion("conditon_01 not in", values, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01Between(String value1, String value2) {
            addCriterion("conditon_01 between", value1, value2, "conditon01");
            return (Criteria) this;
        }

        public Criteria andConditon01NotBetween(String value1, String value2) {
            addCriterion("conditon_01 not between", value1, value2, "conditon01");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestIsNull() {
            addCriterion("marerial_request is null");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestIsNotNull() {
            addCriterion("marerial_request is not null");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestEqualTo(String value) {
            addCriterion("marerial_request =", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestNotEqualTo(String value) {
            addCriterion("marerial_request <>", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestGreaterThan(String value) {
            addCriterion("marerial_request >", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestGreaterThanOrEqualTo(String value) {
            addCriterion("marerial_request >=", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestLessThan(String value) {
            addCriterion("marerial_request <", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestLessThanOrEqualTo(String value) {
            addCriterion("marerial_request <=", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestLike(String value) {
            addCriterion("marerial_request like", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestNotLike(String value) {
            addCriterion("marerial_request not like", value, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestIn(List<String> values) {
            addCriterion("marerial_request in", values, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestNotIn(List<String> values) {
            addCriterion("marerial_request not in", values, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestBetween(String value1, String value2) {
            addCriterion("marerial_request between", value1, value2, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestNotBetween(String value1, String value2) {
            addCriterion("marerial_request not between", value1, value2, "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andFenshuIsNull() {
            addCriterion("fenshu is null");
            return (Criteria) this;
        }

        public Criteria andFenshuIsNotNull() {
            addCriterion("fenshu is not null");
            return (Criteria) this;
        }

        public Criteria andFenshuEqualTo(String value) {
            addCriterion("fenshu =", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuNotEqualTo(String value) {
            addCriterion("fenshu <>", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuGreaterThan(String value) {
            addCriterion("fenshu >", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuGreaterThanOrEqualTo(String value) {
            addCriterion("fenshu >=", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuLessThan(String value) {
            addCriterion("fenshu <", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuLessThanOrEqualTo(String value) {
            addCriterion("fenshu <=", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuLike(String value) {
            addCriterion("fenshu like", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuNotLike(String value) {
            addCriterion("fenshu not like", value, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuIn(List<String> values) {
            addCriterion("fenshu in", values, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuNotIn(List<String> values) {
            addCriterion("fenshu not in", values, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuBetween(String value1, String value2) {
            addCriterion("fenshu between", value1, value2, "fenshu");
            return (Criteria) this;
        }

        public Criteria andFenshuNotBetween(String value1, String value2) {
            addCriterion("fenshu not between", value1, value2, "fenshu");
            return (Criteria) this;
        }

        public Criteria andStr03IsNull() {
            addCriterion("str03 is null");
            return (Criteria) this;
        }

        public Criteria andStr03IsNotNull() {
            addCriterion("str03 is not null");
            return (Criteria) this;
        }

        public Criteria andStr03EqualTo(String value) {
            addCriterion("str03 =", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03NotEqualTo(String value) {
            addCriterion("str03 <>", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03GreaterThan(String value) {
            addCriterion("str03 >", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03GreaterThanOrEqualTo(String value) {
            addCriterion("str03 >=", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03LessThan(String value) {
            addCriterion("str03 <", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03LessThanOrEqualTo(String value) {
            addCriterion("str03 <=", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03Like(String value) {
            addCriterion("str03 like", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03NotLike(String value) {
            addCriterion("str03 not like", value, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03In(List<String> values) {
            addCriterion("str03 in", values, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03NotIn(List<String> values) {
            addCriterion("str03 not in", values, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03Between(String value1, String value2) {
            addCriterion("str03 between", value1, value2, "str03");
            return (Criteria) this;
        }

        public Criteria andStr03NotBetween(String value1, String value2) {
            addCriterion("str03 not between", value1, value2, "str03");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andQuLikeInsensitive(String value) {
            addCriterion("upper(qu) like", value.toUpperCase(), "qu");
            return (Criteria) this;
        }

        public Criteria andTypeIdLikeInsensitive(String value) {
            addCriterion("upper(type_id) like", value.toUpperCase(), "typeId");
            return (Criteria) this;
        }

        public Criteria andProductNameLikeInsensitive(String value) {
            addCriterion("upper(product_name) like", value.toUpperCase(), "productName");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLikeInsensitive(String value) {
            addCriterion("upper(create_user_id) like", value.toUpperCase(), "createUserId");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andCondition01LikeInsensitive(String value) {
            addCriterion("upper(condition_01) like", value.toUpperCase(), "condition01");
            return (Criteria) this;
        }

        public Criteria andConditon01LikeInsensitive(String value) {
            addCriterion("upper(conditon_01) like", value.toUpperCase(), "conditon01");
            return (Criteria) this;
        }

        public Criteria andMarerialRequestLikeInsensitive(String value) {
            addCriterion("upper(marerial_request) like", value.toUpperCase(), "marerialRequest");
            return (Criteria) this;
        }

        public Criteria andFenshuLikeInsensitive(String value) {
            addCriterion("upper(fenshu) like", value.toUpperCase(), "fenshu");
            return (Criteria) this;
        }

        public Criteria andStr03LikeInsensitive(String value) {
            addCriterion("upper(str03) like", value.toUpperCase(), "str03");
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