package com.xjc.study.test;

import com.xjc.study.toolutils.ArrayUtils;

import java.util.Arrays;

/**
 * Description: TODO
 *
 * @title: Demo
 * Created by 19040838 on 2021.02.20 9:41
 */
public class Demo {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Arrays.toString(
//                    ArrayUtils.generatorUnOrderUnRepeatRandomArray(7, 1, 35, true)
//            ));
//        }
        int[] arr = ArrayUtils.generatorUnOrderUnRepeatRandomArray(7, 1, 35, true);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
    }

    // 冒泡
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 选择排序

}