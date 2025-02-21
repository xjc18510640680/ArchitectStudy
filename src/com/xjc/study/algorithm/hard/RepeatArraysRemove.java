/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * RepeatArraysRemove
 * 给定一个有序数组 nums ，请删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 样例
 * 输入样例 1
 * 1,1,1,2,2,3
 * 输出样例 1
 * 5
 * 输入样例 2
 * 0,0,1,1,1,1,2,3,3
 * 输出样例 2
 * 7
 *
 * @author x30057190
 * @since 2024/1/24
 */
public class RepeatArraysRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strArrays = scanner.nextLine().split(",");
            System.out.println(getLength(strArrays));
        }
    }

    /**
     * getLength
     *
     * @author x30057190
     * @param arrays arrays
     * @return int
     **/
    public static int getLength(String[] arrays) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : arrays) {
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
        }
        int length = 0;
        for (Integer i : map.values()) {
            length = i > 2 ? length + 2 : length + i;
        }
        return length;
    }
}
