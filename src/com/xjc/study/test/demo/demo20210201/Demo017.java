package com.xjc.study.test.demo.demo20210201;

import java.util.Scanner;

/**
 * Description: TODO 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 * 输入描述: 输入字符串 输出描述: 输出字符串
 * 示例1
 * 输入 A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出 A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 * @title: Demo017
 * Created by 19040838 on 2021.02.01 10:01
 */
public class Demo017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(Character.isLetter(c)){
                    sb.append(c);
                }
            }
            //冒泡排序
            char[] cs = sb.toString().toCharArray();
           /* for(int i = 0; i < cs.length; i++){
                for(int j = 0; j < cs.length - i - 1; j++){
                    if(Character.toLowerCase(cs[j]) - Character.toLowerCase(cs[j + 1]) > 0){
                        char temp = cs[j];
                        cs[j] = cs[j + 1];
                        cs[j + 1] = temp;
                    }
                }
            }*/
            // 插入排序
            for(int i = 1; i < cs.length; i++) {
                for(int j = i - 1; j >= 0 && Character.toLowerCase(cs[j]) > Character.toLowerCase(cs[j + 1]); j--) {
                    char temp = cs[j];
                    cs[j] = cs[j + 1];
                    cs[j + 1] = temp;
                }
            }
            StringBuilder result = new StringBuilder();
            int index = 0;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(Character.isLetter(c)){
                    result.append(cs[index]);
                    index++;
                }else{
                    result.append(c);
                }
            }
            System.out.println(result.toString());
        }
        sc.close();
    }
}
