package com.xjc.study.collection.test;

import com.xjc.study.collection.entity.OrderPo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XuJiuCheng
 * @date: Created in 09:18 2021/7/16
 * @description:
 */
public class TestOrderNums {

    private static final List<OrderPo> orderPos = new ArrayList<>();

    static {
        orderPos.add(new OrderPo("XSD1000000000", 2000L));
        orderPos.add(new OrderPo("XSD1000000001", 3000L));
        orderPos.add(new OrderPo("XSD1000000002", 4000L));
        orderPos.add(new OrderPo("XSD1000000003", 5000L));
        orderPos.add(new OrderPo("XSD1000000004", 1000L));
        orderPos.add(new OrderPo("XSD1000000005", 8000L));
    }
    public static void main(String[] args) {
        System.out.println(orderPos.stream().mapToLong(orderPos -> orderPos.getPrice()).sum());
        System.out.println(orderPos.stream().mapToLong(orderPos -> orderPos.getPrice()).max());
        System.out.println(orderPos.stream().mapToLong(orderPos -> orderPos.getPrice()).min());
        System.out.println(orderPos.stream().mapToLong(orderPos -> orderPos.getPrice()).average());
        System.out.println(orderPos.stream().mapToLong(orderPos -> orderPos.getPrice()).count());
    }
}
