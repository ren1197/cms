package com.gx.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BAdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BAdExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNull() {
            addCriterion("creatdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNotNull() {
            addCriterion("creatdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatdateEqualTo(Date value) {
            addCriterion("creatdate =", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotEqualTo(Date value) {
            addCriterion("creatdate <>", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThan(Date value) {
            addCriterion("creatdate >", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThanOrEqualTo(Date value) {
            addCriterion("creatdate >=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThan(Date value) {
            addCriterion("creatdate <", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThanOrEqualTo(Date value) {
            addCriterion("creatdate <=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateIn(List<Date> values) {
            addCriterion("creatdate in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotIn(List<Date> values) {
            addCriterion("creatdate not in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateBetween(Date value1, Date value2) {
            addCriterion("creatdate between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotBetween(Date value1, Date value2) {
            addCriterion("creatdate not between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNull() {
            addCriterion("modifydate is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("modifydate is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(Date value) {
            addCriterion("modifydate =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(Date value) {
            addCriterion("modifydate <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(Date value) {
            addCriterion("modifydate >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(Date value) {
            addCriterion("modifydate >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(Date value) {
            addCriterion("modifydate <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(Date value) {
            addCriterion("modifydate <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<Date> values) {
            addCriterion("modifydate in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<Date> values) {
            addCriterion("modifydate not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(Date value1, Date value2) {
            addCriterion("modifydate between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(Date value1, Date value2) {
            addCriterion("modifydate not between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNull() {
            addCriterion("begindate is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("begindate is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(Date value) {
            addCriterion("begindate =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(Date value) {
            addCriterion("begindate <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(Date value) {
            addCriterion("begindate >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("begindate >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(Date value) {
            addCriterion("begindate <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(Date value) {
            addCriterion("begindate <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<Date> values) {
            addCriterion("begindate in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<Date> values) {
            addCriterion("begindate not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(Date value1, Date value2) {
            addCriterion("begindate between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(Date value1, Date value2) {
            addCriterion("begindate not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andAdpositionidIsNull() {
            addCriterion("adpositionid is null");
            return (Criteria) this;
        }

        public Criteria andAdpositionidIsNotNull() {
            addCriterion("adpositionid is not null");
            return (Criteria) this;
        }

        public Criteria andAdpositionidEqualTo(Integer value) {
            addCriterion("adpositionid =", value, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidNotEqualTo(Integer value) {
            addCriterion("adpositionid <>", value, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidGreaterThan(Integer value) {
            addCriterion("adpositionid >", value, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adpositionid >=", value, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidLessThan(Integer value) {
            addCriterion("adpositionid <", value, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidLessThanOrEqualTo(Integer value) {
            addCriterion("adpositionid <=", value, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidIn(List<Integer> values) {
            addCriterion("adpositionid in", values, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidNotIn(List<Integer> values) {
            addCriterion("adpositionid not in", values, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidBetween(Integer value1, Integer value2) {
            addCriterion("adpositionid between", value1, value2, "adpositionid");
            return (Criteria) this;
        }

        public Criteria andAdpositionidNotBetween(Integer value1, Integer value2) {
            addCriterion("adpositionid not between", value1, value2, "adpositionid");
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

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("isdel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPath2IsNull() {
            addCriterion("path2 is null");
            return (Criteria) this;
        }

        public Criteria andPath2IsNotNull() {
            addCriterion("path2 is not null");
            return (Criteria) this;
        }

        public Criteria andPath2EqualTo(String value) {
            addCriterion("path2 =", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotEqualTo(String value) {
            addCriterion("path2 <>", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2GreaterThan(String value) {
            addCriterion("path2 >", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2GreaterThanOrEqualTo(String value) {
            addCriterion("path2 >=", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2LessThan(String value) {
            addCriterion("path2 <", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2LessThanOrEqualTo(String value) {
            addCriterion("path2 <=", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2Like(String value) {
            addCriterion("path2 like", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotLike(String value) {
            addCriterion("path2 not like", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2In(List<String> values) {
            addCriterion("path2 in", values, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotIn(List<String> values) {
            addCriterion("path2 not in", values, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2Between(String value1, String value2) {
            addCriterion("path2 between", value1, value2, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotBetween(String value1, String value2) {
            addCriterion("path2 not between", value1, value2, "path2");
            return (Criteria) this;
        }

        public Criteria andPath3IsNull() {
            addCriterion("path3 is null");
            return (Criteria) this;
        }

        public Criteria andPath3IsNotNull() {
            addCriterion("path3 is not null");
            return (Criteria) this;
        }

        public Criteria andPath3EqualTo(String value) {
            addCriterion("path3 =", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotEqualTo(String value) {
            addCriterion("path3 <>", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3GreaterThan(String value) {
            addCriterion("path3 >", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3GreaterThanOrEqualTo(String value) {
            addCriterion("path3 >=", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3LessThan(String value) {
            addCriterion("path3 <", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3LessThanOrEqualTo(String value) {
            addCriterion("path3 <=", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3Like(String value) {
            addCriterion("path3 like", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotLike(String value) {
            addCriterion("path3 not like", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3In(List<String> values) {
            addCriterion("path3 in", values, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotIn(List<String> values) {
            addCriterion("path3 not in", values, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3Between(String value1, String value2) {
            addCriterion("path3 between", value1, value2, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotBetween(String value1, String value2) {
            addCriterion("path3 not between", value1, value2, "path3");
            return (Criteria) this;
        }

        public Criteria andPath5IsNull() {
            addCriterion("path5 is null");
            return (Criteria) this;
        }

        public Criteria andPath5IsNotNull() {
            addCriterion("path5 is not null");
            return (Criteria) this;
        }

        public Criteria andPath5EqualTo(String value) {
            addCriterion("path5 =", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotEqualTo(String value) {
            addCriterion("path5 <>", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5GreaterThan(String value) {
            addCriterion("path5 >", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5GreaterThanOrEqualTo(String value) {
            addCriterion("path5 >=", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5LessThan(String value) {
            addCriterion("path5 <", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5LessThanOrEqualTo(String value) {
            addCriterion("path5 <=", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5Like(String value) {
            addCriterion("path5 like", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotLike(String value) {
            addCriterion("path5 not like", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5In(List<String> values) {
            addCriterion("path5 in", values, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotIn(List<String> values) {
            addCriterion("path5 not in", values, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5Between(String value1, String value2) {
            addCriterion("path5 between", value1, value2, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotBetween(String value1, String value2) {
            addCriterion("path5 not between", value1, value2, "path5");
            return (Criteria) this;
        }

        public Criteria andPath4IsNull() {
            addCriterion("path4 is null");
            return (Criteria) this;
        }

        public Criteria andPath4IsNotNull() {
            addCriterion("path4 is not null");
            return (Criteria) this;
        }

        public Criteria andPath4EqualTo(String value) {
            addCriterion("path4 =", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotEqualTo(String value) {
            addCriterion("path4 <>", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4GreaterThan(String value) {
            addCriterion("path4 >", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4GreaterThanOrEqualTo(String value) {
            addCriterion("path4 >=", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4LessThan(String value) {
            addCriterion("path4 <", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4LessThanOrEqualTo(String value) {
            addCriterion("path4 <=", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4Like(String value) {
            addCriterion("path4 like", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotLike(String value) {
            addCriterion("path4 not like", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4In(List<String> values) {
            addCriterion("path4 in", values, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotIn(List<String> values) {
            addCriterion("path4 not in", values, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4Between(String value1, String value2) {
            addCriterion("path4 between", value1, value2, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotBetween(String value1, String value2) {
            addCriterion("path4 not between", value1, value2, "path4");
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