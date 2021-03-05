package com.xjc.study.algorithm.sort;

/**
 *  冒泡排序
 * @title: BubbleSort
 * @Author 19040838
 * @Date: 2020.11.26 16:53
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
