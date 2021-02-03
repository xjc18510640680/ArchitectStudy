package com.xjc.study.exam;

import java.util.Scanner;

/**
 * @Description
 * 题目描述
 * 将一段压缩后的字符串解压缩，并且排序输出。
 * 解压规则：每个字符串后边跟一个数字，表示这个字符串的重复数字将每个字符串的字符重复次数升序排序，并输出结果。
 * 例如：a3b2,输出结果为bbaaa
 * a11b2bac3bad3abcd2
 * 思路：
 * 将每个字符串和数字分别取出存到两个数组
 * 对这两个数组进行排序
 * 最后进行重复的拼接工作。
 * @Author 19040838
 * @Date 2021.02.02 15:26
 **/
public class ExtractZip {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            System.out.println(extractZip(input));
        }
    }

    private static String extractZip(String input) {
        if (input == null || "".equals(input.trim())) {
            return "";
        }
        char[] chars = input.toCharArray();
        StringBuilder temp = new StringBuilder();
        String[] strArr = new String[input.length() / 2];
        int[] numArr = new int[input.length() / 2];
        int k=0;
        int count = 0;
        for(int i = 0, n = chars.length; i < n; i++) {
            if((chars[i] + "").matches("[a-z]")){
                temp.append(chars[i]);
                continue;
            } else{
                strArr[k] = temp.toString();
            }
            if((chars[i] + "").matches("[0-9]")) {
                count = count * 10 + Integer.parseInt(chars[i] + "");
                if(i != chars.length - 1 && (chars[i + 1] + "").matches("[0-9]")) {
                    continue;
                } else{
                    numArr[k] = count;
                }
            }
            k += 1;
            count = 0;
            temp = new StringBuilder();
        }
        for(int i = 0;i < numArr.length - 1;i++){
            for(int j = 0;j < numArr.length - 1 - i;j++){
                if(numArr[j] > numArr[j + 1]){
                    int temp1 = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp1;
                    String tempStr = strArr[j];
                    strArr[j] = strArr[j + 1];
                    strArr[j + 1] = tempStr;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < strArr.length; j++) {
            for(int i = 0;i < numArr[j];i++) {
                result.append(strArr[j]);
            }
        }
        return result.toString();
    }
}