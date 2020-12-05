package com.xjc.study.leetcode;

import com.xjc.study.toolutils.ArrayUtils;

/**
 * Description: TODO
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例: 给定 nums = [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @title: LeetCode_0001_SumTwoNum
 * Created by 19040838 on 2020.12.02 11:00
 */
public class LeetCode_0001_SumTwoNum {

    public static void main(String[] args) {
        int testTime = 1;
        int maxSize = 5;
        int maxValue = 10;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generatorUnOrderRepeatRandomArray(maxSize, 1, maxValue, true);
            int target = ArrayUtils.generatorInt(1, maxValue);
            System.out.println("target = " + target);
            twoSum(arr, target);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    System.out.println("nums[" + i + "] + nums[" + j + "] = " + nums[i] + " + " + nums[j] + " = " + target);
                    System.out.println("result [" + i + ", " + j + "]");
                    System.out.println("===============================================================");
                } else {
                    System.out.println("nums[" + i + "] + nums[" + j + "] = " + nums[i] + " + " + nums[j] + " != " + target);
                    System.out.println("===============================================================");
                }
            }
        }
        return result;
    }
}
