/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * MaximumProfit
 * 玩一个游戏，进入和退出各一次，进入和退出的时机由你来决定。如果在S时刻进入，E时刻退出，消耗为(E-S)×K。
 * 游戏中有N个道具（编号为1～N），编号为i的道具价值为Vi，只有你在[Xi, Yi]这个区间都处于游戏中（即S ≤ Xi ≤ Yi ≤
 * E），才能获得这个道具。你的收益为获得的所有道具价值之和减去消耗。
 * 进入和退出各一次，计算可以获取的最大收益
 * 输入
 * 第一行包含两个整数N和K。
 * 接下来N行，每行三个整数，表示一个道具的Xi, Yi, Vi
 * 数据范围：
 * 1 ≤ N ≤ 104
 * 1 ≤ Vi, K ≤ 109
 * -109≤ Xi, Yi ≤ 109
 * Xi ≤ Yi
 * 输出
 * 一个整数，表示最大收益
 * 样例
 * 输入样例 1 复制
 * 3 2
 * 1 3 3
 * 1 2 5
 * 4 7 1
 * 输出
 * 4
 *
 * @author x30057190
 * @since 2024/1/23
 */
public class MaximumProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            int[][] props = new int[n][];
            for (int i = 0; i < n; i++) {
                props[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            System.out.println(playGame(props, k));
        }
        scanner.close();
    }

    /**
     * 进游戏肯定是某道具的左节点，出游戏肯定是某道具的右节点。
     * 遍历所有左节点和右节点的组合，遍历时候不应该重复计算，只计算增量
     *
     * @param props 道具信息
     * @param k 游戏成本
     * @return 最大收益
     */
    private static long playGame(int[][] props, int k) {
        long result = 0L;
        List<Integer> leftList = new ArrayList<>();
        List<Prop> rightList = new ArrayList<>();
        for (int[] prop : props) {
            leftList.add(prop[0]);
            rightList.add(new Prop(prop[0], prop[1], prop[2]));
        }
        List<Integer> leftSort = leftList.stream().distinct().sorted().collect(Collectors.toList());
        rightList.sort(Comparator.comparingInt(o -> o.right));
        // 遍历左节点
        for (int left : leftSort) {
            long tmpResult = 0L;
            int lastLeft = left;
            // 遍历右节点
            for (Prop propRight : rightList) {
                if (propRight.left < left) {
                    continue;
                }
                tmpResult += propRight.value;
                tmpResult -= (long) (propRight.right - lastLeft) * k;
                lastLeft = propRight.right;
                result = Math.max(result, tmpResult);
            }
        }
        return result;
    }

    static class Prop {
        int left;
        int right;
        int value;

        public Prop(int left, int right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
