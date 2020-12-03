package com.xjc.study.toolutils;

/**
 *
 * @title: SystemUtils
 * @Author 19040838
 * @Date: 2020.11.26 15:11
 */
public class SystemUtils {

    /**
     * @Description 打印int数组
     * @Author 19040838
     * @Date 2020.11.26 15:14
     * @Version  1.0
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
