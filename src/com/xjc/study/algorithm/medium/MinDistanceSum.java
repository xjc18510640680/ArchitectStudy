package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 1067. 【软件认证】最小距离和:https://oj.rnd.huawei.com/problems/1067/details
 *
 * @author x30057190
 * @since 2024/5/11
 */
public class MinDistanceSum {
    // 待实现函数，在此函数中填入答题代码
    static int[][] distanceMap;
    private static int nearestWareHouse(int[][] grid) {
        distanceMap = new int[grid.length][grid[0].length]; // 最大为300
        // 初始化 distanceMap
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // 设置为最大可能距离
                distanceMap[row][col] = grid.length + grid[0].length;
            }
        }
        // 从仓库向外寻找商店，并计算距离。
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // 仓库位置
                if (grid[row][col] == 0) {
                    System.out.println("仓库" + "[" + row + ", " + col + "]开始寻找路径");
                    dfs(grid, row, col, 0);
                }
            }
        }
        // 求总路程距离
        int totalDistance = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // 跳过无法达到，和障碍物的地址。
                if (distanceMap[row][col] == grid.length + grid[0].length) {
                    continue;
                }
                totalDistance += distanceMap[row][col];
            }
        }
        return totalDistance;
    }
    static void dfs(int[][] grid, int row, int col, int distance) {
        // 超出边界
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || distance >= (grid.length + grid[0].length)) {
            return;
        }
        // 遇到障碍物，此路不通。
        if (grid[row][col] == -1) {
            return;
        }
        // 已经有最短路径，更长路线不作考虑
        if (distance >= distanceMap[row][col]) {
            return;
        }
        // 记录距离
        distanceMap[row][col] = distance;
        distance++;
        // 继续其他路径
        dfs(grid, row + 1, col, distance); // up
        dfs(grid, row - 1, col, distance); // down
        dfs(grid, row, col - 1, distance); // left
        dfs(grid, row, col + 1, distance); // right
    }
    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int rows = cin.nextInt();
        int cows = cin.nextInt();
        int[][] grid = new int[rows][cows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                grid[i][j] = cin.nextInt();
            }
        }
        System.out.println(nearestWareHouse(grid));

        cin.close();
    }
}
