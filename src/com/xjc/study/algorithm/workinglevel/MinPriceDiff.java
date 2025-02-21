package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 最小产品价格差值
 * 输入
 * [1,3,7,5,12]
 * 输出
 * 3
 * 输入
 * [90,98,90,90,1,1]
 * 输出
 * 4
 *
 * @author x30057190
 * @since 2024/5/25
 */
public class MinPriceDiff {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            String[] inputStr = cin.nextLine().split(",");
            int[] prices = new int[inputStr.length];
            for (int i = 0; i < inputStr.length; i++) {
                prices[i] = Integer.parseInt(inputStr[i]);
            }
            System.out.println(getMinPriceDiff(prices));
        }
    }

    /**
     给定某产品多少天的价格，记录于prices中，请找出任意两天之间的
     最小价格差（即abs(prices[i] - prices[j])）的最小值，i!=j）并计算最小介个差组合的个数
     * @param prices prices
     * @return int
     **/
    static int getMinPriceDiff(int[] prices) {
        int n = prices.length;
        // 最小差值
        int minDiff = Integer.MAX_VALUE;
        // 最小差值组数
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 差值
                int diff = Math.abs(prices[i] - prices[j]);
                // 若果差值小于最小差值计数初始化为1
                if (diff < minDiff) {
                    minDiff = diff;
                    count = 1;
                } else if (diff == minDiff) {// 如果差值等于最小差值则计数+1
                    count++;
                }
            }
        }
        return count;
    }
}
