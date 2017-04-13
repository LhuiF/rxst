package com.unionx.web.proxy.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProxyInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProxyInfoCriteria() {
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

        public Criteria andProxyNameIsNull() {
            addCriterion("proxy_name is null");
            return (Criteria) this;
        }

        public Criteria andProxyNameIsNotNull() {
            addCriterion("proxy_name is not null");
            return (Criteria) this;
        }

        public Criteria andProxyNameEqualTo(String value) {
            addCriterion("proxy_name =", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotEqualTo(String value) {
            addCriterion("proxy_name <>", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameGreaterThan(String value) {
            addCriterion("proxy_name >", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_name >=", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameLessThan(String value) {
            addCriterion("proxy_name <", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameLessThanOrEqualTo(String value) {
            addCriterion("proxy_name <=", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameLike(String value) {
            addCriterion("proxy_name like", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotLike(String value) {
            addCriterion("proxy_name not like", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameIn(List<String> values) {
            addCriterion("proxy_name in", values, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotIn(List<String> values) {
            addCriterion("proxy_name not in", values, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameBetween(String value1, String value2) {
            addCriterion("proxy_name between", value1, value2, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotBetween(String value1, String value2) {
            addCriterion("proxy_name not between", value1, value2, "proxyName");
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

        public Criteria andOpenBankAccountIsNull() {
            addCriterion("open_bank_account is null");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountIsNotNull() {
            addCriterion("open_bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountEqualTo(String value) {
            addCriterion("open_bank_account =", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountNotEqualTo(String value) {
            addCriterion("open_bank_account <>", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountGreaterThan(String value) {
            addCriterion("open_bank_account >", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("open_bank_account >=", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountLessThan(String value) {
            addCriterion("open_bank_account <", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountLessThanOrEqualTo(String value) {
            addCriterion("open_bank_account <=", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountLike(String value) {
            addCriterion("open_bank_account like", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountNotLike(String value) {
            addCriterion("open_bank_account not like", value, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountIn(List<String> values) {
            addCriterion("open_bank_account in", values, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountNotIn(List<String> values) {
            addCriterion("open_bank_account not in", values, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountBetween(String value1, String value2) {
            addCriterion("open_bank_account between", value1, value2, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountNotBetween(String value1, String value2) {
            addCriterion("open_bank_account not between", value1, value2, "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameIsNull() {
            addCriterion("open_bank_username is null");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameIsNotNull() {
            addCriterion("open_bank_username is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameEqualTo(String value) {
            addCriterion("open_bank_username =", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameNotEqualTo(String value) {
            addCriterion("open_bank_username <>", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameGreaterThan(String value) {
            addCriterion("open_bank_username >", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("open_bank_username >=", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameLessThan(String value) {
            addCriterion("open_bank_username <", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameLessThanOrEqualTo(String value) {
            addCriterion("open_bank_username <=", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameLike(String value) {
            addCriterion("open_bank_username like", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameNotLike(String value) {
            addCriterion("open_bank_username not like", value, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameIn(List<String> values) {
            addCriterion("open_bank_username in", values, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameNotIn(List<String> values) {
            addCriterion("open_bank_username not in", values, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameBetween(String value1, String value2) {
            addCriterion("open_bank_username between", value1, value2, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameNotBetween(String value1, String value2) {
            addCriterion("open_bank_username not between", value1, value2, "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateIsNull() {
            addCriterion("appointment_payment_date is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateIsNotNull() {
            addCriterion("appointment_payment_date is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_payment_date =", value, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_payment_date <>", value, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateGreaterThan(Date value) {
            addCriterionForJDBCDate("appointment_payment_date >", value, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_payment_date >=", value, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateLessThan(Date value) {
            addCriterionForJDBCDate("appointment_payment_date <", value, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appointment_payment_date <=", value, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateIn(List<Date> values) {
            addCriterionForJDBCDate("appointment_payment_date in", values, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("appointment_payment_date not in", values, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appointment_payment_date between", value1, value2, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentPaymentDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appointment_payment_date not between", value1, value2, "appointmentPaymentDate");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNull() {
            addCriterion("registered_address is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNotNull() {
            addCriterion("registered_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressEqualTo(String value) {
            addCriterion("registered_address =", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotEqualTo(String value) {
            addCriterion("registered_address <>", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThan(String value) {
            addCriterion("registered_address >", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThanOrEqualTo(String value) {
            addCriterion("registered_address >=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThan(String value) {
            addCriterion("registered_address <", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThanOrEqualTo(String value) {
            addCriterion("registered_address <=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLike(String value) {
            addCriterion("registered_address like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotLike(String value) {
            addCriterion("registered_address not like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIn(List<String> values) {
            addCriterion("registered_address in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotIn(List<String> values) {
            addCriterion("registered_address not in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressBetween(String value1, String value2) {
            addCriterion("registered_address between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotBetween(String value1, String value2) {
            addCriterion("registered_address not between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNull() {
            addCriterion("office_address is null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNotNull() {
            addCriterion("office_address is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressEqualTo(String value) {
            addCriterion("office_address =", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotEqualTo(String value) {
            addCriterion("office_address <>", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThan(String value) {
            addCriterion("office_address >", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("office_address >=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThan(String value) {
            addCriterion("office_address <", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThanOrEqualTo(String value) {
            addCriterion("office_address <=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLike(String value) {
            addCriterion("office_address like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotLike(String value) {
            addCriterion("office_address not like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIn(List<String> values) {
            addCriterion("office_address in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotIn(List<String> values) {
            addCriterion("office_address not in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressBetween(String value1, String value2) {
            addCriterion("office_address between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotBetween(String value1, String value2) {
            addCriterion("office_address not between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostIsNull() {
            addCriterion("Change_the_cost is null");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostIsNotNull() {
            addCriterion("Change_the_cost is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostEqualTo(Byte value) {
            addCriterion("Change_the_cost =", value, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostNotEqualTo(Byte value) {
            addCriterion("Change_the_cost <>", value, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostGreaterThan(Byte value) {
            addCriterion("Change_the_cost >", value, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostGreaterThanOrEqualTo(Byte value) {
            addCriterion("Change_the_cost >=", value, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostLessThan(Byte value) {
            addCriterion("Change_the_cost <", value, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostLessThanOrEqualTo(Byte value) {
            addCriterion("Change_the_cost <=", value, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostIn(List<Byte> values) {
            addCriterion("Change_the_cost in", values, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostNotIn(List<Byte> values) {
            addCriterion("Change_the_cost not in", values, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostBetween(Byte value1, Byte value2) {
            addCriterion("Change_the_cost between", value1, value2, "changeTheCost");
            return (Criteria) this;
        }

        public Criteria andChangeTheCostNotBetween(Byte value1, Byte value2) {
            addCriterion("Change_the_cost not between", value1, value2, "changeTheCost");
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

        public Criteria andCreateNameEqualTo(Date value) {
            addCriterionForJDBCDate("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(Date value) {
            addCriterionForJDBCDate("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(Date value) {
            addCriterionForJDBCDate("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<Date> values) {
            addCriterionForJDBCDate("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_name not between", value1, value2, "createName");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andProxyNameLikeInsensitive(String value) {
            addCriterion("upper(proxy_name) like", value.toUpperCase(), "proxyName");
            return (Criteria) this;
        }

        public Criteria andOpenBankLikeInsensitive(String value) {
            addCriterion("upper(open_bank) like", value.toUpperCase(), "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankAccountLikeInsensitive(String value) {
            addCriterion("upper(open_bank_account) like", value.toUpperCase(), "openBankAccount");
            return (Criteria) this;
        }

        public Criteria andOpenBankUsernameLikeInsensitive(String value) {
            addCriterion("upper(open_bank_username) like", value.toUpperCase(), "openBankUsername");
            return (Criteria) this;
        }

        public Criteria andClientNameLikeInsensitive(String value) {
            addCriterion("upper(client_name) like", value.toUpperCase(), "clientName");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLikeInsensitive(String value) {
            addCriterion("upper(registered_address) like", value.toUpperCase(), "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLikeInsensitive(String value) {
            addCriterion("upper(office_address) like", value.toUpperCase(), "officeAddress");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLikeInsensitive(String value) {
            addCriterion("upper(update_name) like", value.toUpperCase(), "updateName");
            return (Criteria) this;
        }

        public Criteria andIsdelLikeInsensitive(String value) {
            addCriterion("upper(isdel) like", value.toUpperCase(), "isdel");
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