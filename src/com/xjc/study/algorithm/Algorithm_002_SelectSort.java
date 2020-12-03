package com.xjc.study.algorithm;

import com.xjc.study.toolutils.ArrayUtils;
import com.xjc.study.toolutils.SystemUtils;

/**
 *选择排序
 * @title: Algorithm_002_SelectSort
 * @Author 19040838
 * @Date: 2020.11.26 14:08
 */
public class Algorithm_002_SelectSort {

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

            selectionSort(arr1);
            System.out.print("选择排序后的数组arr1：");
            SystemUtils.printArray(arr1);
            if (!ArrayUtils.isEqual(arr, arr1)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            ArrayUtils.exchangeValue(arr, i, minIndex);
        }
    }
}
