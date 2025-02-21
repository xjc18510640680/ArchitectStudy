/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.hard;

import java.util.Scanner;

/**
 * LMatch
 *
 * @author x30057190
 * @since 2024/3/8
 */
public class LMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            char[][] grid = new char[rows][columns];
            for (int i = 0; i < rows; i++) {
                String rowString = scanner.next();
                for (int j = 0; j < columns; j++) {
                    grid[i][j] = rowString.charAt(j);
                }
            }
            boolean result = canFormL(grid, rows, columns);
            System.out.println(result ? "YES" : "NO");
        }
    }

    private static boolean canFormL(char[][] grid, int rows, int columns) {
        int blackCount = 0;
        int whiteCount = 0;

        // Count the number of black and white cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'B') {
                    blackCount++;
                } else if (grid[i][j] == 'W') {
                    whiteCount++;
                }
            }
        }

        // If the counts are not multiples of 4, it's impossible
        if (blackCount % 4 != 0 || whiteCount % 4 != 0) {
            return false;
        }

        // Check if the black cells can form L shapes
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'B' && !visited[i][j]) {
                    if (!dfs(grid, visited, i, j, rows, columns)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int rows, int columns) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || visited[i][j] || grid[i][j] != 'B') {
            return true;
        }

        visited[i][j] = true;

        return dfs(grid, visited, i - 1, j, rows, columns) &&
        dfs(grid, visited, i + 1, j, rows, columns) &&
        dfs(grid, visited, i, j - 1, rows, columns) &&
        dfs(grid, visited, i, j + 1, rows, columns);
    }
}
