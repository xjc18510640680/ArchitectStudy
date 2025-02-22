package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 Page Number
 对于一个网站，很多记录，所以我们不可能一次性将所有记录显示出来，而是需要将记录一页一页的显示，
 这样我们只需要点击页面下方的页码，就只显示某一页的记录了。但是当页码很多的时候，将在表格下方显示很多页码，
 就不好看了吗，所以我们制定了页码显示规则：
 对于总页码N<7，则显示所有页码，反之则最多只显示7个页码（首页页码、尾页页码、当前页K以及当前页前后两页的页码）；未
 显示的连续页码用省略号“…”代替。
 如：N=94，K=5，则显示页码1 ... 3 4 5 6 7 ... 94；N=94，K=93，则显示页码1 ... 91 92 93 94。
 解答要求
 时间限制: C/C++ 1000ms, 其他语言：2000ms
 内存限制: C/C++ 100MB, 其他语言：200MB
 输入
 输入包含两个空格分开的整数N ,K (1≤ K ≤ N ≤ 100)，分别表示总页数和当前页。
 输出
 输出所显示的页码，用空格分开，未显示的连续页码用省略号”…”统一代替。
 样例1
 复制输入：
 3 1
 复制输出：
 1 2 3
 样例2
 复制输入：
 7 1
 复制输出：
 1 2 3 ... 7
 样例3
 复制输入：
 7 5
 复制输出：
 1 ... 3 4 5 6 7
 */
public class PageNumber {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int k = cin.nextInt();
            List<String> pageNumbers = new ArrayList<>();

            if (n < 7) {
                // 如果总页数小于7，则显示所有页码
                for (int i = 1; i <= n; i++) {
                    pageNumbers.add(String.valueOf(i));
                }
            } else {
                // 如果总页数大于等于7，则按规则显示页码

                // 始终显示第一页
                pageNumbers.add("1");

                // 判断是否需要显示省略号
                if (k > 4) {
                    pageNumbers.add("...");
                }

                // 显示当前页及其前后两页
                for (int i = Math.max(2, k - 2); i <= Math.min(n - 1, k + 2); i++) {
                    pageNumbers.add(String.valueOf(i));
                }

                // 判断是否需要显示省略号
                if (k < n - 3) {
                    pageNumbers.add("...");
                }

                // 始终显示最后一页
                pageNumbers.add(String.valueOf(n));
            }

            // 输出结果
            System.out.println(String.join(" ", pageNumbers));
        }
    }
}
