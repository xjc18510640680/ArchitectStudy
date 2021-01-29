package com.xjc.study.test.demo.demo20201126;

/**
 *
 * @title: demo001
 * @Author 19040838
 * @Date: 2020.11.26 11:38
 */
public class demo001 {
    public static void main(String[] args) {

        System.out.println("D3".matches("D5|D6|D7"));
    }

    /**
     * @Description 一个球从200米高度下落，每次下落反弹原来高度的一半，如此反复，求第n次落地时共经历了多少米？
     * @Author 19040838
     * @Date 2020.12.29 15:35
     **/
    public static int demo(int height, int count) {
        int countHeight = height;
        for (int i = 0; i < count; i++) {
            height = height >> 1;
            countHeight += 1.5 * height;
        }
        return countHeight;
    }
}
