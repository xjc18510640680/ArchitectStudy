/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.easy;

import java.util.Scanner;

/**
 * MInSubArray
 * Java实现 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, …, numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 样例
 * 输入样例 1
 * 7
 * 6
 * 2
 * 3
 * 1
 * 2
 * 4
 * 3
 * 输出 2
 * 输入样例 2
 * 4
 * 3
 * 1
 * 4
 * 4
 * 输出 1
 *
 * @author x30057190
 * @since 2024/1/26
 */
public class MinSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int target = scanner.nextInt();
            int length = scanner.nextInt();
            int[] nums = new int[target];
            for (int i = 0; i < length; i++) {
                int input = scanner.nextInt();
                nums[i] = input;
            }
            System.out.println(getMinSubArrayLength(target, nums));
        }
        scanner.close();
    }

    /**
     * getMinSubArrayLength
     *
     * @author x30057190
     * @param target target
     * @param nums nums
     * @return int
     **/
    private static int getMinSubArrayLength(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            right++;
            while (sum >= target) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
