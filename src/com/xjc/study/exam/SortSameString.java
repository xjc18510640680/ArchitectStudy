package com.xjc.study.exam;

import java.util.*;

/**
 * Description: TODO
 * 输入两个字符串，找出字符串1在字符串2中的所有字符，去重并排序
 * 例如  输入  comehere    welcometoZhuhai
 *      输出 [c, e, h, m, o]
 * @author 19040838
 * @title: SortSameString
 * Created by 19040838 on 2021.04.08 15:00
 */
public class SortSameString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr1 = sc.nextLine().toLowerCase().toCharArray();
        char[] arr2 = sc.nextLine().toLowerCase().toCharArray();
        List<String> list = new ArrayList<>();
        for (char value : arr1) {
            if (list.contains(String.valueOf(value))) {
                break;
            }
            for (char c : arr2) {
                if (value == c) {
                    list.add(String.valueOf(value));
                    break;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
