/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 题目描述
 著名的快速排序算法里有一个经典的划分过程：通常采用某种方法取一个元素作为主元，通过交换，把比主元小的元素放到它的左边，比主元大的元素放到它的右边。
 给定一个划分后的正整数序列，请问有多少个元素可能是划分过程中选取的主元？ 并按升序输出这些主元。
 答要求
 时间限制：1000ms, 内存限制：256MB
 输入
 第 1 行一个正整数 N，表示正整数序列的长度，取值范围 [1, 10^5]
 第 2 行 N 个互不不同的正整数，每个数的取值范围[1, 10^9]
 输出
 按升序排列的可能主元的列表，以单个空格分隔；或者空列表。
 样例
 输入样例 1
 5
 1 3 2 4 5
 输出样例 1
 [1 4 5]
 提示样例 1
 1 的左边没有元素，右边的元素都比它大，所以它可能是主元。
 尽管 3 的左边元素都比它小，但其右边的 2 比它小，所以它不能是主元； 尽管 2 的右边元素都比它大，但其左边的 3 比它大，所以它不能是主元。
 同理，4 和 5 都可能是主元。
 因此，1、4、5 是可能的主元，按升序输出为 [1 4 5] 。
 * @author x30057190
 * @since 2024/4/30
 */
public class QuickSort {

    // 待实现函数，在此函数中填入答题代码
    private static int[] quickSort(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        int[] newNumbers = numbers.clone();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == newNumbers[i] && isAccurate(newNumbers, i)) {
                list.add(numbers[i]);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    private static boolean isAccurate(int[] newNumbers, int index) {
        for (int i = 0; i < index; i++) {
            if (newNumbers[i] > newNumbers[index]) {
                return false;
            }
        }
        return true;
    }

    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int row = cin.nextInt();
        int[] numbers = new int[row];
        for (int i = 0; i < row; i++) {
            numbers[i] = cin.nextInt();
        }
        cin.close();

        int[] results = quickSort(numbers);
        String[] strResult = Arrays.stream(results).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.print("[" + String.join(" ", strResult) + "]");
    }
}
