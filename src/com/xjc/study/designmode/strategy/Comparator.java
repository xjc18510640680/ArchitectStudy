package com.xjc.study.designmode.strategy;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: Comparator
 * Created by 19040838 on 2021.02.22 15:43
 */
public interface Comparator<T> {
    /**
     * 比较策略
     **/
    int compareTo(T o1, T o2);
}
