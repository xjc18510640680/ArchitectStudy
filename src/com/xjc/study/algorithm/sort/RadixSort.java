package com.xjc.study.algorithm.sort;

import java.util.ArrayList;

/**
 * Description: TODO
 *  基数排序
 * @author 19040838
 * @title: RadixSort
 * Created by 19040838 on 2021.03.03 11:25
 */
public class RadixSort {
    /**
     *  基数排序函数
     *   a表示要排序的数组
     *   d表示每一位数字的范围（这里是10进制数，有0~9一共10种情况）
     **/
    public static void radixSort(int[] a, int d){
        //n用来表示当前排序的是第几位
        int n = 1;
        //hasNum用来表示数组中是否有至少一个数字存在第n位
        boolean hasNum = false;
        //二维数组temp用来保存当前排序的数字
        //第一维d表示一共有d个桶
        //第二维a.length表示每个桶最多可能存放a.length个数字
        int[][] temp = new int[d][a.length];
        int[] order = new int[d];
        while(true){
            //判断是否所有元素均无比更高位，因为第一遍一定要先排序一次，所以有n!=1的判断
            if(n != 1 && !hasNum){
                break;
            }
            hasNum = false;
            //遍历要排序的数组，将其存入temp数组中（按照第n位上的数字将数字放入桶中）
            for(int i = 0;i < a.length;i++){
                int x = a[i]/(n*10);
                if(x != 0){
                    hasNum = true;
                }
                int lsd = (x%10);
                temp[lsd][order[lsd]] = a[i];
                order[lsd]++;
            }
            //k用来将排序好的temp数组存入data数组（将桶中的数字倒出）
            int k = 0;
            for(int i = 0;i < d;i++){
                if(order[i] != 0){
                    for(int j = 0;j < order[i];j++){
                        a[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n++;
        }
    }

    /**
     * 基数排序
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
