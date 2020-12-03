package com.xjc.study.leetcode;

import com.xjc.study.toolutils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从
 * list = {1,2,3..., n} 中依序读取一个数字。
 * 请使用下述操作来构建目标数组 target ：
 *     Push：从 list 中读取一个新元素， 并将其推入数组中。
 *     Pop：删除数组中的最后一个元素。
 *     如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * 请返回构建目标数组所用的操作序列。
 * 题目数据保证答案是唯一的。
 * 示例 1：
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 *
 * 示例 2：
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 *
 * 示例 3：
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 *
 * 示例 4：
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 * 提示：
 *
 *     1 <= target.length <= 100
 *     1 <= target[i] <= 100
 *     1 <= n <= 100
 *     target 是严格递增的
 * @title: LeetCode_1441_BuildArrayByStack
 * Created by 19040838 on 2020.12.02 16:48
 */
public class LeetCode_1441_BuildArrayByStack {

    public static List<String> buildArray(int[] target, int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i > target[target.length-1]) {
                break;
            }
            if(target.length > n) {
                resultList.add("Push");
            }
            if (contains(target, i)) {
                resultList.add("Push");
            } else {
                resultList.add("Push");
                resultList.add("Pop");
            }
        }
        return resultList;
    }

    public static boolean contains(int[] arr, Integer targetValue) {
        for(int s: arr){
            if(s == targetValue) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       /* int testTime = 50;
        int maxValue = 100;
        int minValue = 1;
        int maxArraySize = 100;
        for (int i = 0; i < testTime; i++) {
            // 随机生成数组
            int[] target = ArrayUtils.generatorOrderUnRepeatRandomArray(maxArraySize, minValue, maxValue, false);
            // 随机生成正整数
            int n = ArrayUtils.generatorInt(minValue, maxValue);
            System.out.print("输入: n = " + n + ",target = ");
            ArrayUtils.printArray(target);
            System.out.print("输出：");
            System.out.println(buildArray(target, n));
        }*/

        int[] arr = {1, 3};
        System.out.print("输入: n = " + 3 + ",target = ");
        ArrayUtils.printArray(arr);
        System.out.println("预期：" + "[Push, Push, Pop, Push]");
        System.out.print("输出：");
        System.out.println(buildArray(arr, 3));

        int[] arr1 = {1, 2, 3};
        System.out.print("输入: n = " + 3 + ",target = ");
        ArrayUtils.printArray(arr1);
        System.out.println("预期：" + "[Push, Push, Push]");
        System.out.print("输出：");
        System.out.println(buildArray(arr1, 3));

        int[] arr2 = {1, 2};
        System.out.print("输入: n = " + 1 + ",target = ");
        ArrayUtils.printArray(arr2);
        System.out.println("预期：" + "[Push, Push]");
        System.out.print("输出：");
        System.out.println(buildArray(arr2, 1));

        int[] arr3 = {2, 3, 4};
        System.out.print("输入: n = " + 4 + ",target = ");
        ArrayUtils.printArray(arr3);
        System.out.println("预期：" + "[Push, Pop, Push, Push, Push]");
        System.out.print("输出：");
        System.out.println(buildArray(arr3, 4));
    }
}
