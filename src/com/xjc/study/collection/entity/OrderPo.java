package com.xjc.study.collection.entity;

import java.util.Objects;

/**
 * @author: XuJiuCheng
 * @date: Created in 09:10 2021/7/16
 * @description:
 */
public class OrderPo {
    private String orderNo;
    private Long price;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public OrderPo(String orderNo, Long price) {
        this.orderNo = orderNo;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderPo)) {
            return false;
        }
        OrderPo orderPo = (OrderPo) o;
        return getOrderNo().equals(orderPo.getOrderNo()) && getPrice().equals(orderPo.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNo(), getPrice());
    }

    @Override
    public String toString() {
        return "OrderPo{" +
                "orderNo='" + orderNo + '\'' +
                ", price=" + price +
                '}';
    }

    public OrderPo() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
