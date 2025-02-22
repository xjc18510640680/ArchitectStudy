package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 周长计算
 给定一个二维数组grid[x][y]，其中元素为0或者1，将此二维数组视为一个网格图，网格的单位为1，
 试计算由网格内元素为1的部分组成的图形的周长（保证有唯一且封闭的图形，且x、y皆为范围在[1,200]之间的整数）
 解答要求
 时间限制: C/C++ 1000ms, 其他语言：2000ms
 内存限制: C/C++ 256MB, 其他语言：512MB
 输入
 第一行输入grid[x][y]中x的值
 第二行输入grid[x][y]中y的值
 其后的输入x行由逗号分隔的字符串，例如：0,1,1,0
 输出
 输出图形周长，如16
 样例1
 复制输入：
 4
 4
 0,1,0,0
 1,1,1,0
 0,1,0,0
 1,1,0,0
 复制输出：
 16

 样例2
 复制输入：
 1
 1
 1
 复制输出：
 4

 样例3
 复制输入：
 1
 2
 1,0
 复制输出：
 4
 */
public class CircumferenceCalculation {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String xLine = cin.nextLine();
        String yLine = cin.nextLine();
        int x = Integer.parseInt(xLine);
        int y = Integer.parseInt(yLine);

        int[][] grid = new int[x][y];
        for (int i = 0; i < x; i++) {
            String numsLine = cin.nextLine();
            String[] numsStr = numsLine.split(",");
            for (int j = 0; j < numsStr.length; j++) {
                grid[i][j] = Integer.parseInt(numsStr[j]);
            }
        }
        System.out.println(getResult(grid));
    }
    // 待实现函数，在此函数中填入答题代码
    private static int getResult(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    perimeter -= getSharedEdges(grid, i, j);
                }
            }
        }

        return perimeter;
    }

    private static int getSharedEdges(int[][] grid, int i, int j) {
        int sharedEdges = 0;
        // Check above
        if (i > 0 && grid[i - 1][j] == 1) sharedEdges += 2;
        // Check left
        if (j > 0 && grid[i][j - 1] == 1) sharedEdges += 2;
        return sharedEdges;
    }
}
