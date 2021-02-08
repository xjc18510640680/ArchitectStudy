package com.xjc.study.designmode.factory.impl;

import com.xjc.study.designmode.factory.CreateOrderService;

/**
 * Description: TODO
 *
 * @title: CreateAOrderServiceImlp
 * Created by 19040838 on 2021.02.07 11:09
 */
public class CreateBOrderServiceImlp implements CreateOrderService {
    @Override
    public void createOrder() {
        System.out.println("BOrder is create");
    }
}
