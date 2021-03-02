package com.xjc.study.designmode.strategy;

import java.util.Arrays;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: Test
 * Created by 19040838 on 2021.02.22 15:49
 */
public class Test {
    public static void main(String[] args) {
        Cat[] catArr = {new Cat(3), new Cat(5), new Cat(1)};
        Sort<Cat> sort = new Sort<>();
        sort.sort(catArr, new CatComparator());
        System.out.println(Arrays.toString(catArr));

        String[] arr = {"3", "5" ,"1"};
        Sort<String> sort1 = new Sort<>();
        sort1.sort(arr, new StringComparator());
        System.out.println(Arrays.toString(arr));
    }
}
