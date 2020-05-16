package com.minant.mycache.form;

import java.util.Objects;

/**
 * @ClassName DictSearchForm
 * @Description TODO 字典码值查询Form
 * @Author MinAnt
 * @Date 2020/5/15
 * @Version V1.0
 */
public class DictSearchForm {
    private String dictCode;
    // 1：asc 2:desc
    private int orderType;

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DictSearchForm)) return false;
        DictSearchForm that = (DictSearchForm) o;
        return Objects.equals(getDictCode(), that.getDictCode()) &&
                Objects.equals(getOrderType(), that.getOrderType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDictCode(), getOrderType());
    }

    @Override
    public String toString() {
        return "DictSearchForm{" +
                "dictCode='" + dictCode + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
