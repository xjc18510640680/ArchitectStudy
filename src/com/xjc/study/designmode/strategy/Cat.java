package com.xjc.study.designmode.strategy;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: Cat
 * Created by 19040838 on 2021.02.22 16:10
 */
public class Cat {

    int height;

    public Cat(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                '}';
    }
}
