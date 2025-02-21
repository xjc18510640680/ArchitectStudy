package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 【软件认证】设备编号
 给定一个设备编号区间[start, end]，包含4或18的编号都不能使用，如：418、148、718不能使用，108可用。
 请问有多少可用设备编号。
 输入
 两个整数start end(单空格间隔)，用于标识设备编号区间，0 < start < end <= 100000
 输出
 一个整数，代表可用设备编号的数量
 样例1
 复制输入：
 3 20
 复制输出：
 15
 解释：
 不能使用的设备编号为4、14、18
 样例2
 复制输入：
 1 1000
 复制输出：
 711
 */
public class GetNormalDeviceNum {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int start = cin.nextInt();
        int end = cin.nextInt();
        cin.close();

        System.out.println(getNormalDeviceNum(start, end));
    }

    private static int getNormalDeviceNum(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (!String.valueOf(i).contains("4") && !String.valueOf(i).contains("14") && !String.valueOf(i)
                .contains("18")) {
                count++;
            }
        }
        return count;
    }
}
