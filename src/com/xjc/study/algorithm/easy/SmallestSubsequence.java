/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.easy;

import java.util.*;

/**
 * SortStrAndLeaveOne
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 样例
 * 输入样例 1
 * bcabc
 * 输出样例 1
 * abc
 * 输入样例 2
 * cbacdcbc
 * 输出样例 2
 * acdb
 *
 * @author x30057190
 * @since 2024/1/25
 */
public class SmallestSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(removeDuplicates(input));
        }
    }

    /**
     * removeDuplicates
     *
     * @author x30057190
     * @param input input
     * @return String
     **/
    private static String removeDuplicates(String input) {
        Deque<Character> characterDeque = new LinkedList<>();
        int[] arrays = new int[26];
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            arrays[c - 'a']++;
        }
        for (char c : input.toCharArray()) {
            if (!set.contains(c)) {
                while (!characterDeque.isEmpty() && arrays[characterDeque.peekLast() - 'a'] > 0
                        && c < characterDeque.peekLast()) {
                    set.remove(characterDeque.pollLast());
                }
                characterDeque.add(c);
                set.add(c);
            }
            arrays[c - 'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!characterDeque.isEmpty()) {
            stringBuilder.append(characterDeque.pollFirst());
        }
        return stringBuilder.toString();
    }
}
