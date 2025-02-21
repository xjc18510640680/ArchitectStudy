/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.workinglevel;

import java.util.Arrays;

/**
 基于日志的系统故障预测
 现给定一组原始事件序列events（元素可以重复），以及一个特征序列traits（元素不可以重复）
 请在events中从左到右按匹配规则找到一个匹配特征序列的最短连续子序列，如果存在多个最短的，
 则返回最早匹配到的连续子序列。
 匹配规则：对于events中的某个连续子序列，当从中去除n个（n>=0）元素后，且不破坏余下元素
 的相对位置所形成的的新序列和特征序列traits相同时，则该连续子序列是匹配特征序列的
 注：输入保证至少存在一个匹配的连续子序列
 要求：
 输入 第一个参数是数组 events 代表原始事件序列，1<events.length<=1000
     第二个参数是数组 traits 代表特征序列，1<=traits.length<=20
     0<=events[i], traits[i]<=1000
 输出 一个连续的子序列
 样例
 输入 [4,8,4,3,6,6,8]
     [4,6,8]
 输出 [4,3,6,6,8]

 输入 [2,30,4,4,6,2,2,3,4,6,6,2,4,4,6]
     [2,4,6]
 输出 [2,3,4,6]
 *
 * @author x30057190
 * @since 2024-06-19 18:40
 */
public class MatchLogTrait {

    /**
     * 根据输入的事件数组和特征数组，预测可能的故障点
     *
     * @param events 事件数组，表示一系列的事件
     * @param traits 特征数组，表示一系列的特征
     * @return 返回一个数组，表示预测的故障点
     */
    public static int[] matchLogTrait(int[] events, int[] traits) {
        // 如果特征数组只有一个元素，直接返回该元素
        if (traits.length == 1) {
            return new int[] {traits[0]};
        }
        int r1;
        int r2;
        // 左侧故障点索引
        int leftRel = 0;
        // 右侧故障点索引
        int rightRel = 0;
        int min = Integer.MAX_VALUE;
        // 遍历事件数组
        for (int i = 0; i < events.length; i++) {
            // 如果当前事件不等于特征数组的第一个元素，跳过当前循环
            if (events[i] != traits[0]) {
                continue;
            }
            r1 = i + 1;
            r2 = 1;
            // 循环比较事件数组和特征数组的元素
            while (r1 < events.length && r2 < traits.length) {
                // 如果事件数组的元素不等于特征数组的元素，r1自增
                if (events[r1] != traits[r2]) {
                    r1++;
                } else {
                    // 如果事件数组的元素等于特征数组的元素，r1和r2都自增
                    r1++;
                    r2++;
                }
                // 如果r2等于特征数组的长度，说明已经找到了一个可能的故障点
                if (r2 == traits.length) {
                    // 更新最小距离和相关的索引
                    if (min > (r1 - i)) {
                        leftRel = i;
                        rightRel = r1 - 1;
                        min = (r1 - i);
                    }
                    break;
                }
            }
        }
        // 返回预测的故障点
        return getResults(events, rightRel, leftRel);
    }

    /**
     * 根据输入的事件数组、右侧故障点索引和左侧故障点索引，获取预测的故障点
     *
     * @param events 事件数组
     * @param rightRel 右侧故障点索引
     * @param leftRel 左侧故障点索引
     * @return 返回预测的故障点数组
     */
    private static int[] getResults(int[] events, int rightRel, int leftRel) {
        int len = rightRel - leftRel + 1;
        int[] arr = new int[len];
        // 将预测的故障点添加到数组中
        for (int i = 0; i < len; i++) {
            arr[i] = events[leftRel++];
        }
        return arr;
    }

    public static void main(String[] args) {
        // int[] events = {4,8,4,3,6,6,8};
        // int[] traits = {4,6,8};
        int[] events = {2,30,4,4,6,2,2,3,4,6,6,2,4,4,6};
        int[] traits = {2,4,6};
        System.out.println(Arrays.toString(matchLogTrait(events, traits)));
    }
}
