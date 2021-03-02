package com.xjc.study.designmode.strategy;

import com.xjc.study.toolutils.ArrayUtils;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: Sort
 * Created by 19040838 on 2021.02.22 15:43
 */
public class Sort<T> {

    /**
     *  选择排序
     **/
    public <T> void sort(final T[] arr, Comparator<T> comparator) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                minIndex = comparator.compareTo(arr[j], arr[minIndex]) == -1 ? j : minIndex;
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
