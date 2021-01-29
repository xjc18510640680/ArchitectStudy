package com.xjc.study.leetcode;

import com.xjc.study.toolutils.ArrayUtils;

import java.util.Arrays;

/**
 * Description: TODO 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1:  输入: [1,2,3]  输出: 6
 * 示例 2:  输入: [1,2,3,4]  输出: 24
 * 注意: 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 *       输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * @title: LeetCode_0628_MaxValueOfThreeNumMultiply
 * Created by 19040838 on 2021.01.20 10:17
 */
public class LeetCode_0628_MaxValueOfThreeNumMultiply {

    public static int maximumProduct(int[] nums) {
        if (nums.length < 3 && nums.length > Math.pow(10, 4)) {
            return 0;
        }
        // 找出数组中最大的三个数
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3], nums[0] * nums[1] * nums[nums.length-1]);
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtils.generatorUnOrderUnRepeatRandomArray((int) Math.pow(10, 4), -1000, 1000, false);
        int[] nums1 = {-100,-1,2,3,4};
        System.out.println(maximumProduct(nums));
    }

}
