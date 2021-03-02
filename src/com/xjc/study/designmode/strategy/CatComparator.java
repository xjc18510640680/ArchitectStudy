package com.xjc.study.designmode.strategy;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: StringComparator
 * Created by 19040838 on 2021.02.22 15:55
 */
public class CatComparator implements Comparator<Cat> {

    @Override
    public int compareTo(Cat o1, Cat o2) {
        return Integer.compare(o1.height, o2.height);
    }
}
