package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 最大口罩产量
 已知莫工厂未来一段时间，每天口罩的生产产能一次记录于数组productions，
 每天的生产计划依次记录于数组plans，plans[i]值为1表示生产，值为0表示休息
 由于疫情影响，口罩需求增加，即：在这window天中原计划休息的，开工生产
 在这window天之外的，生产计划不变
 请制定合适的港公方案，使得这段时间的总产量最大，并返回该最大值
 输入
 第一个参数为整数序列productions，800<=productions<=1000
 第二个参数为行为整数序列plans，值仅为0或1
 第三个参数为window
 注：5<=productions.length==plans.length<=100000
 1<=window<=productions.length
 输出
 一个整数，表示最大口罩生产量
 样例1
 输入
 803,804,805,802,803,804,805,804
 1,0,1,0,1,0,1,0
 3
 输出 4824
 样例2
 输入
 980,910,1000,940,973
 1,1,1,1,1
 5
 输出 4803
 * @author x30057190
 * @since 2024/5/28
 */
public class MaxProduceGauze {

    public static int getMaxQuantity(int[] productions, int[] plans, int window) {
        // 最大产量
        int maxQuantity = 0;
        // 轮训window开始位置
        int start;
        for (int i = 0; i < productions.length; i++) {
            start = i;
            // 每次轮训产量和
            int sum = 0;
            // 初始化轮训窗口window索引
            int index = 0;
            for (int j = 0; j < productions.length; j++) {
                if (j < start && (plans[j] == 1)) {
                    sum += productions[j];
                }
                if (j >= start) {
                    if (index < window) {
                        sum += productions[j];
                        index++;
                    } else {
                        if (plans[j] == 1) {
                            sum += productions[j];
                        }
                    }
                }
            }
            maxQuantity = Math.max(maxQuantity, sum);
        }
        return maxQuantity;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            String[] productionsStr = cin.nextLine().trim().split(",");
            String[] planStr = cin.nextLine().trim().split(",");
            int[] productions = new int[productionsStr.length];
            int[] plans = new int[planStr.length];
            int window = cin.nextInt();
            for (int i = 0; i < productionsStr.length; i++) {
                productions[i] = Integer.parseInt(productionsStr[i]);
            }
            for (int i = 0; i < planStr.length; i++) {
                plans[i] = Integer.parseInt(planStr[i]);
            }
            System.out.println(getMaxQuantity(productions, plans, window));
        }
    }
}
