package com.xjc.study.designmode.factory.factory;

import com.xjc.study.designmode.factory.CreateOrderService;
import com.xjc.study.designmode.factory.impl.CreateAOrderServiceImlp;
import com.xjc.study.designmode.factory.impl.CreateBOrderServiceImlp;

/**
 * Description: TODO
 *
 * @title: CreateOrderFactory
 * Created by 19040838 on 2021.02.07 11:14
 */
public class CreateOrderFactory {
    /*public CreateOrderService create(String createOrderType) {
        CreateOrderService createOrderService = null;
        if ("A".equals(createOrderType)) {
            createOrderService = new CreateAOrderServiceImlp();
        } else if ("B".equals(createOrderType)) {
            createOrderService = new CreateBOrderServiceImlp();
        } else {
            System.out.println("请传入正确的创单类型");
        }
        return createOrderService;
    }*/
    public static CreateOrderService CreateAOrder() {
        return new CreateAOrderServiceImlp();
    }
    public static CreateOrderService CreateBOrder() {
        return new CreateBOrderServiceImlp();
    }
}
