package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 题目描述：三子连线
 在围棋棋盘上，假设每个点都可以用坐标[x,y]表示，棋盘左下角坐标为[0,0]，右上角坐标为[18,18]
 现给定棋盘上两个点p1,p2,请在棋盘范围内找出第三个点使得三点连城直线并且相邻
 如果存在多个符合条件的点，请找出坐标最小的点[x,y],坐标最小是指，优先x最小，如果x相等则取y最小，如果找不到，输出[-1,-1]
 输入
 第一行表示参数p1
 第一行表示参数p2
 每个数的取值范围：[0,18]
 输出
 如果找到符合要求的点，输出[x,y],否则输出[-1,-1]
 样例1
 输入
 [1, 0]
 [2, 0]
 输出
 [0, 0]
 样例2
 输入
 [0, 0]
 [3, 3]
 输出
 [-1, -1]
 *
 * @author x30057190
 * @since 2024/7/22
 */
public class ThreeSubConnection {
    // 注：point1 = [x1, y1]，point2 = [x2, y2]
    public static int[] threeSubConn(int[] point1, int[] point2) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        if (x1 == x2) {
            if (y1 > y2) {

            }
            if (y1 > 0 && y2 > 0) {
                return new int[] {x1, y1 - 1};
            } else if (y1 < 18 && y2 < 18) {
                return new int[] {x1, y1 > y2 ? y1 + 1 : (y2 - y1 == 2 ? y1 + 1 : y2 + 1)};
            }
        } else if (y1 == y2) {
            if (x1 > 0 && x2 > 0) {
                return new int[] {x1 > x2 ? x1 - 1 : (x2 - x1 == 2 ? x1 + 1 : x2 - 1), y1};
            } else if (x1 < 18 && x2 < 18) {
                return new int[] {x1 > x2 ? x1 + 1 : (x2 - x1 == 2 ? x1 + 1 : x2 + 1), y1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            String[] inputStr1 = cin.nextLine().split(",");
            int[] point1 = new int[inputStr1.length];
            for (int i = 0; i < inputStr1.length; i++) {
                point1[i] = Integer.parseInt(inputStr1[i]);
            }
            String[] inputStr2 = cin.nextLine().split(",");
            int[] point2 = new int[inputStr2.length];
            for (int i = 0; i < inputStr2.length; i++) {
                point2[i] = Integer.parseInt(inputStr2[i]);
            }
            System.out.println(Arrays.toString(threeSubConn(point1, point2)));
        }
    }
}
