/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.test;

import java.util.HashMap;
import java.util.Map;

/**
求连续值遍历步数
 将从1开始的连续整数随机打乱，存放到数组numbers中
 请从元素1开始递增访问完所有元素，总共需要移动的步数
 输入 [4,3,6,1,5,2]
 输出 13
 解释：从元素1（下标3）移动到元素2（下标5），移动2步即1-->5-->2
      从元素2到3，移动4步，即2-->5-->1-->6-->3
      从元素3到4，移动1步
      从元素4到5，移动4步
      从元素5到6，移动2步
      共移动2+4+1+4+2=13步

 4, 3, 6, 1, 5, 2
 1, 2, 3, 10, 9, 8, 7, 6, 4, 5
 */
public class Test1 {

    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        String str = "1, 2, 3, 10, 9, 8, 7, 6, 4, 5";
        String[] split = str.split(",");
        int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i].trim());
        }
        Test1 test1 = new Test1();
        int moveSteps = test1.getMoveSteps(numbers);
        System.out.println(moveSteps);
    }

    int getMoveSteps(int[] numbers) {
        int moveSteps = 0;
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 1; i <= numbers.length; i++) {
            if (i + 1 <= numbers.length) {
                moveSteps += Math.abs(map.get(i) - map.get(i + 1));
            }
        }
        return moveSteps;
    }
}
