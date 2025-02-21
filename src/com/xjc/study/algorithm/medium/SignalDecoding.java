package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 1180. 【软件认证】信号解码:https://oj.rnd.huawei.com/problems/1180/details
 * x@y = 2*x+y+3
 * x$y = 3*x+2*y+1
 *
 * @author x30057190
 * @since 2024/5/16
 */
public class SignalDecoding {
    // 分解递归
    private static int getMatchResult(String information) {
        if (information.contains("$")) {
            String[] group$ = information.split("\\$");
            int value = getMatchResult(group$[0]);
            for (int i = 1; i < group$.length; i++) {
                value = value * 3 + getMatchResult(group$[i]) * 2 + 1;
            }
            return value;
        } else if (information.contains("@")) {
            int value = getMatchResult(information.substring(0, information.lastIndexOf("@")));
            value = 2 * value + Integer.parseInt(information.substring(information.lastIndexOf("@") + 1)) + 3;
            return value;
        } else {
            return Integer.parseInt(information.trim());
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String information = cin.nextLine().trim();
        cin.close();
        int result = getMatchResult(information);
        System.out.println(result);
    }
}
