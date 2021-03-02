package com.xjc.study.algorithm.sort;

import com.xjc.study.toolutils.ArrayUtils;

import java.util.Arrays;

/**
 * Description: TODO
 *
 * @title: SortTest
 * Created by 19040838 on 2021.03.02 16:24
 */
public class SortTest {
    public static void main(String[] args) {
        int testTime = 1;
        int maxSize = 10;
        int maxValue = 10;
        boolean defaultSize = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generatorUnOrderRepeatRandomArray(maxSize, 1, maxValue, defaultSize);
            int[] arr1 = ArrayUtils.copyArray(arr);
            System.out.println("随机生成的数组：" + Arrays.toString(arr));
            ArrayUtils.sort(arr);
            System.out.println("Arrays.sort(arr)排序后的数组arr：" + Arrays.toString(arr));
//            AlgorithmBubbleSort.bubbleSort(arr1);
//            System.out.println("冒泡排序后的数组arr1：" + Arrays.toString(arr1));
//            AlgorithmSelectSort.selectionSort(arr1);
//            System.out.println("选择排序后的数组arr1：" + Arrays.toString(arr1));
//            AlgorithmInsertSort.intArrayInsertSort(arr1);
//            System.out.println("插入排序后的数组arr1：" + Arrays.toString(arr1));
            AlgorithmHeapSort.heapSort(arr1);
            System.out.println("堆排序后的数组arr1：" + Arrays.toString(arr1));
            System.out.println("==============================================================");
        }
    }
}
