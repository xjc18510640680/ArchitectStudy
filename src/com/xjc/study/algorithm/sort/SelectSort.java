package com.xjc.study.algorithm.sort;

/**
 * 选择排序
 * @title: SelectSort
 * @Author 19040838
 * @Date: 2020.11.26 14:08
 */
public class SelectSort {

    /**
     * 选择排序
     **/
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
