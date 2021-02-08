package com.xjc.study.designmode.factory.test;

import com.xjc.study.designmode.factory.CreateOrderFactoryService;
import com.xjc.study.designmode.factory.factory.CreateAOrderFactoryImpl;
import com.xjc.study.designmode.factory.factory.CreateOrderFactory;
import com.xjc.study.designmode.factory.CreateOrderService;

/**
 * Description: TODO
 *
 * @title: MyTest
 * Created by 19040838 on 2021.02.07 11:13
 */
public class MyTest {
    public static void main(String[] args) {
//        CreateOrderFactory createOrderFactory = new CreateOrderFactory();
//        CreateOrderService createOrderService = createOrderFactory.create("A");
//        CreateOrderService createOrderService = createOrderFactory.CreateAOrder();
        CreateOrderFactoryService createOrderFactoryService = new CreateAOrderFactoryImpl();
        CreateOrderService createOrderService = createOrderFactoryService.createOrder();
        createOrderService.createOrder();
    }
}
