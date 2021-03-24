package com.xjc.study.algorithm.sort;

import com.xjc.study.toolutils.ArrayUtils;

/**
 * Description: TODO
 *
 * @title: InsertSort
 * Created by 19040838 on 2020.11.26 21:31
 */
public class InsertSort {

    /**
     * @Description 插入排序 时间复杂度O(n)
     * @Author 19040838
     * @Date 2020.11.26 21:32
     **/
    public static void intArrayInsertSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
