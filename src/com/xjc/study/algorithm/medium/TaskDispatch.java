package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 1020. 【软件认证】任务调度算法:https://oj.rnd.huawei.com/problems/1020/details
 *
 * @author x30057190
 * @since 2024/5/8
 */
public class TaskDispatch {
    // 待实现函数，在此函数中填入答题代码
    private static int getMinTime(int taskNum, int[][] relations) {
        // 动态规划
        int[] dp = new int[taskNum + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < taskNum; i++) {
            for (int[] relation : relations) {
                dp[relation[0]] = Math.max(dp[relation[0]], dp[relation[1]] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int taskNum = cin.nextInt();
        int relationNum = cin.nextInt();
        int[][] relations = new int[relationNum][];
        if (relationNum > 0) {
            cin.nextLine();
            for (int i = 0; i < relationNum; i++) {
                String[] str = cin.nextLine().split(">");
                relations[i] = new int[2];
                relations[i][0] = Integer.parseInt(str[0]);
                relations[i][1] = Integer.parseInt(str[1]);
            }
        }
        cin.close();

        System.out.println(getMinTime(taskNum, relations));
    }
}
