package com.xjc.study.algorithm.sort;

import java.util.Arrays;

/**
 * Description: TODO
 * 希尔排序
 * @author 19040838
 * @title: ShellSort
 * Created by 19040838 on 2021.03.03 10:49
 */
public class ShellSort {
    public static void shellSort(int[] data) {
        // 计算出最大的h值
        int h = 1;
        while (h <= data.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < data.length; i += h) {
                if (data[i] < data[i - h]) {
                    int tmp = data[i];
                    int j = i - h;
                    while (j >= 0 && data[j] > tmp) {
                        data[j + h] = data[j];
                        j -= h;
                    }
                    data[j + h] = tmp;
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
    }
}
