package com.xjc.study.algorithm;

import com.xjc.study.toolutils.ArrayUtils;

/**
 * Description: TODO
 *
 * @title: Algorithm_004_InsertSort
 * Created by 19040838 on 2020.11.26 21:31
 */
public class Algorithm_004_InsertSort {

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean defaultSize = false;
        boolean seccess = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generatorUnOrderRepeatRandomArray(maxSize, 1, maxValue, defaultSize);
            int[] arr1 = ArrayUtils.copyArray(arr);

            intArrayInsertSort(arr);
            System.out.print("插入排序后的数组arr：");
            ArrayUtils.printArray(arr);

            ArrayUtils.sort(arr1);
            System.out.print("sort排序后的数组arr1：");
            ArrayUtils.printArray(arr1);
            if(!ArrayUtils.isEqual(arr, arr1)) {
                seccess = false;
                break;
            }
        }
        System.out.println(seccess ? "NICE!" : "FUCKING FUCKED!");
    }

    /**
     * @Description 插入排序
     * @Author 19040838
     * @Date 2020.11.26 21:32
     **/
    public static void intArrayInsertSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                ArrayUtils.exchangeValue(arr, j, j+1);
            }
        }
    }
}
