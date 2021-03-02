package com.xjc.study.designmode.strategy;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: StringComparator
 * Created by 19040838 on 2021.02.22 15:55
 */
public class StringComparator implements Comparator<String> {

    @Override
    public int compareTo(String o1, String o2) {
        int a = Integer.parseInt(o1);
        int b = Integer.parseInt(o2);
        return Integer.compare(a, b);
    }
}
