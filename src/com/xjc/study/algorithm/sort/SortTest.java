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
        int[] arr = ArrayUtils.generatorUnOrderUnRepeatRandomArray(10, 1, 20, true);
        int[] arrCopy = ArrayUtils.copyArray(arr);
        System.out.println("随机生成的数组：" + Arrays.toString(arr));
        MergeSort.mergeSort(arrCopy, 0, arrCopy.length - 1);
        System.out.println("排序后的新数组：" + Arrays.toString(arrCopy));
        System.out.println("==============================================================");
    }
}
