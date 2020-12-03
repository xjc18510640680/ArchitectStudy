package com.xjc.study.algorithm;

import com.xjc.study.toolutils.ArrayUtils;
import com.xjc.study.toolutils.SystemUtils;

/**
 *  冒泡排序
 * @title: Algorithm_003_BubbleSort
 * @Author 19040838
 * @Date: 2020.11.26 16:53
 */
public class Algorithm_003_BubbleSort {

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        boolean defaultSize = false;
        for(int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generatorUnOrderRepeatRandomArray(maxSize, 1, maxValue, defaultSize);
            int[] arr1 = ArrayUtils.copyArray(arr);

            ArrayUtils.sort(arr);
            System.out.print("Arrays.sort(arr)排序后的数组arr：");
            SystemUtils.printArray(arr);

            bubbleSort(arr1);
            System.out.print("冒泡排序后的数组arr1：");
            SystemUtils.printArray(arr1);
            if (!ArrayUtils.isEqual(arr, arr1)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.exchangeValue(arr, j, j + 1);
                }
            }
        }
    }
}
