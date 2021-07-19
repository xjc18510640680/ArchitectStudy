package com.xjc.study.collection.entity;

/**
 * @author: XuJiuCheng
 * @date: Created in 16:28 2021/7/16
 * @description:
 */
public class OutBoundNoticeDetails {
    private String dispatchNo;
    private Integer exchangeType;
    private Integer guaranteePeriodType;
    private String kzSkuCode;
    private Integer skuId;
    private Long skuOrderId;
    private Integer skuQualityType;
    private Integer skuQuantity;
    private Integer skuType;

    public String getDispatchNo() {
        return dispatchNo;
    }

    public void setDispatchNo(String dispatchNo) {
        this.dispatchNo = dispatchNo;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public Integer getGuaranteePeriodType() {
        return guaranteePeriodType;
    }

    public void setGuaranteePeriodType(Integer guaranteePeriodType) {
        this.guaranteePeriodType = guaranteePeriodType;
    }

    public String getKzSkuCode() {
        return kzSkuCode;
    }

    public void setKzSkuCode(String kzSkuCode) {
        this.kzSkuCode = kzSkuCode;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Long getSkuOrderId() {
        return skuOrderId;
    }

    public void setSkuOrderId(Long skuOrderId) {
        this.skuOrderId = skuOrderId;
    }

    public Integer getSkuQualityType() {
        return skuQualityType;
    }

    public void setSkuQualityType(Integer skuQualityType) {
        this.skuQualityType = skuQualityType;
    }

    public Integer getSkuQuantity() {
        return skuQuantity;
    }

    public void setSkuQuantity(Integer skuQuantity) {
        this.skuQuantity = skuQuantity;
    }

    public Integer getSkuType() {
        return skuType;
    }

    public void setSkuType(Integer skuType) {
        this.skuType = skuType;
    }
}
