package com.minant.mycache.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName DictValueInfo
 * @Description TODO 码值信息Modle
 * @Author MinAnt
 * @Date 2020/5/15
 * @Version V1.0
 */
public class DictValueInfo implements Serializable {
    private String dictCode;
    private String realValue;
    private String showValue;
    private Integer dictOrder;


    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getRealValue() {
        return realValue;
    }

    public void setRealValue(String realValue) {
        this.realValue = realValue;
    }

    public String getShowValue() {
        return showValue;
    }

    public void setShowValue(String showValue) {
        this.showValue = showValue;
    }

    public Integer getDictOrder() {
        return dictOrder;
    }

    public void setDictOrder(Integer dictOrder) {
        this.dictOrder = dictOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DictValueInfo)) return false;
        DictValueInfo that = (DictValueInfo) o;
        return Objects.equals(getDictCode(), that.getDictCode()) &&
                Objects.equals(getRealValue(), that.getRealValue()) &&
                Objects.equals(getShowValue(), that.getShowValue()) &&
                Objects.equals(getDictOrder(), that.getDictOrder());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDictCode(), getRealValue(), getShowValue(), getDictOrder());
    }

    @Override
    public String toString() {
        return "DictValueInfo{" +
                "dictCode='" + dictCode + '\'' +
                ", realValue='" + realValue + '\'' +
                ", showValue='" + showValue + '\'' +
                ", dictOrder=" + dictOrder +
                '}';
    }
}
