package com.xjc.study.exam;

import java.util.*;

/**
 * Description: TODO
 * 100个人围成一个圈从1开始报数，输入数m，报到m的人退出，继续从1开始报，
 * 报到m继续退出依次下去直到剩余的人小于m不再报数，输出剩下人的位置。
 * 例如 输入3   输出[58, 91]
 * @author 19040838
 * @title: CircleNum
 * Created by 19040838 on 2021.04.08 15:19
 */
public class CircleNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        int person = 100;
        for (int i = 1; i <= person; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() >= m) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        System.out.println(list);
    }
}
