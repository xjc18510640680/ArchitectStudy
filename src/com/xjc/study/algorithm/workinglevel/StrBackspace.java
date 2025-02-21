package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 退格键
 用$来表示退格键，遇到$就删除上一位字符（如果有）
 在键盘上从左到右一次输入一串字符串，请输出最终字符的个数。注：退格键不会出现在最终的剩余字符中
 输入
 一个字符串，仅由小写字母、字符$组成，长度范围[0,100]
 输出
 一个整数，表示处理后的字符串的长度
 样例 1
 输入 "$c$df"  输出 2
 样例 2
 输入 "ab$q$$yv$$$$" 输出 0

 * @author x30057190
 * @since 2024/5/23
 */
public class StrBackspace {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            String inputStr = cin.nextLine();
            System.out.println(strBackspace(inputStr));
        }
    }
    static int strBackspace(String inputStr) {
        char[] charArray = inputStr.toCharArray();
        int len = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '$') {
                charArray[len++] = charArray[i];
            } else {
                if (len > 0) {
                    len--;
                }
            }
        }
        return len;
    }

    public static int strBackspace1(String inputStr) {
        if (inputStr.isEmpty()) {
            return 0;
        }
        char[] arr = inputStr.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                inputStr = inputStr.substring(1);
                return strBackspace(inputStr);
            }
            if (arr[i] == '$') {
                if (i - 1 >= 0) {
                    inputStr = inputStr.substring(0, i - 1) + inputStr.substring(i + 1);
                    return strBackspace(inputStr);
                }
            }
        }
        return inputStr.length();
    }
}
