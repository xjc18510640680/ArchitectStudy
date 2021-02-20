package com.xjc.study.exam;

import com.xjc.study.toolutils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Description: TODO
 *
 * @title: Demo
 * Created by 19040838 on 2021.02.18 18:53
 */
public class Demo {
    public static void main(String[] args) {
        List<Intervals> intervals = new ArrayList<>();
        intervals.add(new Intervals(1, 11));
        intervals.add(new Intervals(2, 6));
        intervals.add(new Intervals(8, 10));
        intervals.add(new Intervals(15, 18));
        System.out.print("[");
        for (Intervals intervals1 : sortRepeat(intervals)) {
            System.out.print("[" + intervals1.a + "," + intervals1.b + "],");
        }
        System.out.print("]");

    }

    public static List<Intervals> sortRepeat(List<Intervals> intervals) {
        int n = intervals.size();
        int[] numArr1 = new int[n];
        int[] numArr2 = new int[n];
        for (int i = 0; i < n; i++) {
            numArr1[i] = intervals.get(i).a;
            numArr2[i] = intervals.get(i).b;
        }
        Arrays.sort(numArr1);
        Arrays.sort(numArr2);
        List<Intervals> resultList = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || numArr1[i + 1] > numArr2[i]) {
                resultList.add(new Intervals(numArr1[j], numArr2[i]));
                j = i + 1;
            }
        }
        return resultList;
    }

}

class Intervals {
    int a;
    int b;
    Intervals() {
        a = 0;
        b = 0;
    }

    Intervals(int m, int n) {
        a = m;
        b = n;
    }
}