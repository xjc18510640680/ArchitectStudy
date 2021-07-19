package com.xjc.study.collection.entity;

import java.util.List;

/**
 * @author: XuJiuCheng
 * @date: Created in 16:28 2021/7/16
 * @description:
 */
public class OutBoundNotice {
    private String address;
    private String area;
    private Integer areaId;
    private Integer billFirstChannel;
    private Integer billSecondChannel;
    private Integer billThirdChannel;
    private String buyerNote;
    private Integer canSplit;
    private String checkoutTime;
    private String city;
    private Integer cityId;
    private String customerContact;
    private Integer customerId;
    private String customerName;
    private Long orderId;
    private String orderNo;
    private String originOrderNo;
    private String paymentTime;
    private String province;
    private Integer provinceId;
    private String receiver;
    private String recevierContact;
    private String saleWarehouseCode;
    private String shopCode;
    private Integer shopInstall;
    private Integer strictLogistics;
    private Integer urgent;
    private String warehouseCode;
    private Integer warehouseId;
    private List<OutBoundNoticeDetails> details;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getBillFirstChannel() {
        return billFirstChannel;
    }

    public void setBillFirstChannel(Integer billFirstChannel) {
        this.billFirstChannel = billFirstChannel;
    }

    public Integer getBillSecondChannel() {
        return billSecondChannel;
    }

    public void setBillSecondChannel(Integer billSecondChannel) {
        this.billSecondChannel = billSecondChannel;
    }

    public Integer getBillThirdChannel() {
        return billThirdChannel;
    }

    public void setBillThirdChannel(Integer billThirdChannel) {
        this.billThirdChannel = billThirdChannel;
    }

    public String getBuyerNote() {
        return buyerNote;
    }

    public void setBuyerNote(String buyerNote) {
        this.buyerNote = buyerNote;
    }

    public Integer getCanSplit() {
        return canSplit;
    }

    public void setCanSplit(Integer canSplit) {
        this.canSplit = canSplit;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOriginOrderNo() {
        return originOrderNo;
    }

    public void setOriginOrderNo(String originOrderNo) {
        this.originOrderNo = originOrderNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRecevierContact() {
        return recevierContact;
    }

    public void setRecevierContact(String recevierContact) {
        this.recevierContact = recevierContact;
    }

    public String getSaleWarehouseCode() {
        return saleWarehouseCode;
    }

    public void setSaleWarehouseCode(String saleWarehouseCode) {
        this.saleWarehouseCode = saleWarehouseCode;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public Integer getShopInstall() {
        return shopInstall;
    }

    public void setShopInstall(Integer shopInstall) {
        this.shopInstall = shopInstall;
    }

    public Integer getStrictLogistics() {
        return strictLogistics;
    }

    public void setStrictLogistics(Integer strictLogistics) {
        this.strictLogistics = strictLogistics;
    }

    public Integer getUrgent() {
        return urgent;
    }

    public void setUrgent(Integer urgent) {
        this.urgent = urgent;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public List<OutBoundNoticeDetails> getDetails() {
        return details;
    }

    public void setDetails(List<OutBoundNoticeDetails> details) {
        this.details = details;
    }
}
