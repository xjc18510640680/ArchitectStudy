package com.xjc.study.toolutils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @title: ArrayUtils
 * @Author 19040838
 * @Date: 2020.11.26 15:10
 */
public class ArrayUtils {

    /**
     * @Description 随机生成无序可重复Int数组
     * @Author 19040838
     * @Date 2020.11.26 15:14
     * @Version  1.0
     */
    public static int[] generatorUnOrderRepeatRandomArray(int maxArraySize, int minValue, int maxValue, boolean defaultSize) {
        int arraySize = defaultSize ? maxArraySize : generatorInt(minValue, maxValue);
        int[] arr = new int[arraySize];
        if(maxValue < minValue) {
            return arr;
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = generatorInt(minValue, maxValue);
        }
        System.out.print("随机生成无序可重复Int数组：");
        printArray(arr);
        return arr;
    }

    /**
     * @Description 随机生成无序不可重复Int数组
     * @Author 19040838
     * @Date 2020.11.26 15:14
     * @Version  1.0
     */
    public static int[] generatorUnOrderUnRepeatRandomArray(int maxArraySize, int minValue, int maxValue, boolean defaultSize) {
        int arraySize = defaultSize ? maxArraySize : generatorInt(1, maxArraySize);
        int[] arr = new int[arraySize];
        if(maxValue < minValue) {
            return arr;
        }
        int count = 0;
        while(count < arraySize) {
            int num = generatorInt(minValue, maxValue);
            boolean flag = true;
            for (int j = 0; j < arraySize; j++) {
                if(num == arr[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                arr[count] = num;
                count++;
            }
        }
        System.out.print("随机生成无序不可重复Int数组：");
        printArray(arr);
        return arr;
    }

    /**
     * @Description 随机生成有序可重复Int数组
     * @Author 19040838
     * @Date 2020.11.26 15:14
     * @Version  1.0
     */
    public static int[] generatorOrderRepeatRandomArray(int maxArraySize, int minValue, int maxValue, boolean defaultSize) {
        int arraySize = defaultSize ? maxArraySize : generatorInt(minValue, maxValue);
        int[] arr = new int[arraySize];
        if(maxValue < minValue) {
            return arr;
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = generatorInt(minValue, maxValue);
        }
        sort(arr);
        System.out.print("随机生成有序可重复Int数组：");
        printArray(arr);
        return arr;
    }

    /**
     * @Description 随机生成有序不可重复Int数组
     * @Author 19040838
     * @Date 2020.11.26 15:14
     * @Version  1.0
     */
    public static int[] generatorOrderUnRepeatRandomArray(int maxArraySize, int minValue, int maxValue, boolean defaultSize) {
        int arraySize = defaultSize ? maxArraySize : generatorInt(minValue, maxValue);
        int[] arr = new int[arraySize];
        if(maxValue < minValue) {
            return arr;
        }
        int count = 0;
        while(count < arraySize) {
            int num = generatorInt(minValue, maxValue);
            boolean flag = true;
            for (int j = 0; j < arraySize; j++) {
                if(num == arr[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                arr[count] = num;
                count++;
            }
        }
        sort(arr);
        System.out.print("随机生成有序不可重复Int数组：");
        printArray(arr);
        return arr;
    }

    /**
     * @Description  随机生成minValue~maxValue之间的数
     * Math.random()   [0,1)
     * Math.random() * N  [0,N)
     * (int)(Math.random() * N)  [0, N-1]
     * @Author 19040838
     * @Date 2020.12.02 17:44
     **/
    public static int generatorInt(int minValue, int maxValue) {
        return (int)(Math.random() + minValue) + (int)((maxValue - minValue + 1) * Math.random());
    }

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
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i + 1 == arr.length) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * @Description 复制数组
     * @Author 19040838
     * @Date 2020.11.26 15:36
     * @Version  1.0
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * @Description 校验两个数组是否一样
     * @Author 19040838
     * @Date 2020.11.26 15:36
     * @Version  1.0
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description 数组排序
     * @Author 19040838
     * @Date 2020.11.26 15:37
     * @Version  1.0
     */
    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * @Description int数组选择排序
     * @Author 19040838
     * @Date 2020.11.26 16:48
     * @Version  1.0
     */
    public static void intArraySelectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            exchangeValue(arr, i, minIndex);
        }
    }

    /**
     * @Description 冒泡排序
     * @Author 19040838
     * @Date 2020.11.26 17:04
     * @Version  1.0
     */
    public static void intArrayBubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    arr[i] = arr[i] ^ arr[j];
//                    arr[j] = arr[i] ^ arr[j];
//                    arr[i] = arr[i] ^ arr[j];
                    exchangeValue(arr, j, j + 1);
                }
            }
        }
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

    /**
     * @Description 交换值
     * @Author 19040838
     * @Date 2020.11.26 17:06
     * @Version  1.0
     */
    public static void exchangeValue(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
