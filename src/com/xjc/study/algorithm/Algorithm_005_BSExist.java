package com.xjc.study.algorithm;

import com.xjc.study.toolutils.ArrayUtils;

import java.util.Arrays;

/**
 * Description: TODO
 *
 * @title: Algorithm_005_BSExist
 * Created by 19040838 on 2020.11.30 11:47
 */
public class Algorithm_005_BSExist {

    public static void main(String[] args) {
        int testTime = 5;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generatorUnOrderRepeatRandomArray(maxSize, 1, maxValue, false);
            Arrays.sort(arr);
            ArrayUtils.printArray(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            System.out.println("查找的数：" + value);
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * @Description
     * @Author 19040838
     * @Date 2020.11.30 11:47
     **/
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        // L..R// L..R 至少两个数的时候
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                System.out.println("sortedArr["+mid+"]" + sortedArr[mid]);
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println("sortedArr["+L+"]" + sortedArr[L]);
        return sortedArr[L] == num;
    }

    public static boolean test(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if(cur == num) {
                System.out.println("contain:" + num);
                return true;
            }
        }
        System.out.println("unContain:" + num);
        return false;
    }
}
