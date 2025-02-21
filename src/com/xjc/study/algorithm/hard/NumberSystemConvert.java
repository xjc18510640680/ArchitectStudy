/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.hard;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * NumberSystemConvert
 * 编写程序实现将任意10进制正小数m转换成n进制的正小数，小数点后保留10位小数。
 * 输入包含两个数m,n，用空格隔开。输入包含多组测试，当m,n都为0时输入结束。
 * 0.0000009<m<1
 * 1<n<10
 * 输入
 * 0.795 3
 * 0 0
 * 输出
 * 0.2101101122
 *
 * @author x30057190
 * @since 2024/1/22
 */
public class NumberSystemConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // 把所有的answer都存入字符串缓冲池，一次性输出。
        while (sc.hasNext()) {
            // 接收的m是小数
            double m = sc.nextDouble();
            // 要转化为n进制，是整数
            int n = sc.nextInt();
            // 若都为0时，输出字符串缓冲池的全部内容
            if ((BigDecimal.valueOf(m).compareTo(new BigDecimal(0)) == 0) && (n == 0)) {
                System.out.print(sb);
                // 输入0 0则返回
                break;
            }
            sb.append("0.");
            for (int i : getConvertNum(m, n)) {
                // 将int型转换为String类型。
                sb.append(String.valueOf(i));
            }
            sb.append(System.lineSeparator());
        }
        sc.close();
    }

    private static int[] getConvertNum(Double m, int p) {
        // 将in型强制转换为double类型，为下面的乘法作准备
        Double n = (double) p;
        // 因为小数点后要保留十位小数
        int[] result = new int[10];
        Double temp = m;
        for (int index = 0; index < 10; index++) {
            // 不能让int*double，会转成int
            temp = n * temp;
            // double类型强制转换成int类型的写法。不能强制转换。
            int i = temp.intValue();
            result[index] = i;
            if (temp >= 1.0) {
                temp = temp - (double) i;
            }
        }
        // 返回的是一个int数组
        return result;
    }
}
