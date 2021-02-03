package com.xjc.study.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description: TODO
 *a11b2bac3bad3abcd2
 * @title: Main
 * Created by 19040838 on 2021.02.01 21:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            System.out.println(jieya(input));
        }
    }

    private static String jieya(String input) {
        if (input == null || input.trim() == "") {
            return "";
        }
        char[] cArr = input.toCharArray();
        String result = "";
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList =new ArrayList<>();
        String temp = "";
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] > 48 && cArr[i] <= 57) {
                strList.add(temp);
                intList.add(cArr[i] - 48);
                temp = "";
            } else {
                temp += cArr[i];
            }
        }
        sort(intList, strList, 0, intList.size() - 1);
        int count = 0;
        for (int i = 0; i < intList.size() - 1; i++) {
            if (intList.get(i) == intList.get(i + 1)) {
                count++;
            } else {
                if (count > 0) {
                    sorts(strList, i - count, i);
                }
                count = 0;
            }
        }
        for (int i = 0; i < intList.size(); i++) {
            while (intList.get(i) > 0) {
                result += strList.get(i);
                intList.set(i, intList.get(i) - 1);
            }
        }
        return result;
    }

    private static void sorts(ArrayList<String> strList, int be, int en) {
        char[][] cArr = new char[en - be + 1][];
        int temp = 1;
        for (int i = be; i <= en;i++) {
            cArr[++temp] = strList.get(i).toCharArray();
        }
        int[] in = new int[en - be + 1];
        for (int i = be; i <= en; i++) {
            for (int j = 0; j < cArr[i - be].length; j++) {
                in[i - be] = cArr[i - be][j];
            }
        }
        for (int i = be; i <= en; i++) {
            int min = i;
            for (int j = i + 1; j <= en; j++) {
                if (in[j - be] < in[min - be]) {
                    min = j;
                }
                if (min != i) {
                    String temp1 = strList.get(i);
                    strList.set(i, strList.get(min));
                    strList.set(min, temp1);
                }
            }
        }
    }

    private static void sort(ArrayList<Integer> intList, ArrayList<String> strList,
                             int n, int m) {
        for (int i = n; i <= m; i++) {
            int min = i;
            for (int j = i + 1; j < intList.size(); j++) {
                if (intList.get(min) > intList.get(j)) {
                    min = j;
                }
            }
            if (i != min) {
                int temp0 = intList.get(i);
                String temp1 = strList.get(i);
                intList.set(i, intList.get(min));
                strList.set(i, strList.get(min));
                intList.set(min, temp0);
                strList.set(min, temp1);
            }
        }
    }
}
