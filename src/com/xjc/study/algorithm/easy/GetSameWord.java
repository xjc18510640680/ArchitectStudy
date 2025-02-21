/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.easy;

import java.util.Scanner;

/**
 * GetSameWord
 * 小明在纸上写了一个单词，然后小红写了好多好多的纸条（每个纸条里都是些字母），小刚想知道小红写的这些纸条里，
 * 有哪些包含了小明写的那个单词内容。 当然啦，这里面不区分大小写（大写字母和小写字母认作相同），
 * 比如小红写了个纸条内容是HelloWorld!!,小明给的单词是HELLO，这也算是包含了小明的单词。
 * 样例
 * 输入样例 1:
 * HeLLO
 * 5
 * JIGHELLOdsf
 * UHHelOLO
 * helloworld
 * ghurnrhjbHEllo
 * HeLlOEqualToHeLLO
 * 输出样例 1:
 * JIGHELLOdsf
 * helloworld
 * ghurnrhjbHEllo
 * HeLlOEqualToHeLLO
 * @author x30057190
 * @since 2024/3/1
 */
public class GetSameWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String inputWords = scanner.nextLine();
            if (inputWords.toUpperCase().contains(inputWord.toUpperCase())) {
                System.out.println(inputWords);
            }
        }
        scanner.close();
    }
}
