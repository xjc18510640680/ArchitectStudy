/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.easy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * CalculateDate
 * 现在已知2000年1月1日为星期六，给定一个正整数n，求出2000年1月1日之后n天的日期。
 * 样例
 * 输入样例 1
 * 2000
 * 输出样例 1
 * 2005/6/23 Thursday
 * @author x30057190
 * @since 2024/2/1
 */
public class CalculateDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String result = calculateDate(n);
            System.out.println(result);
        }
    }

    /**
     * calculateDate
     *
     * @author x30057190
     * @param n n
     * @return String
     **/
    private static String calculateDate(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/M/d");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        calendar.add(Calendar.DAY_OF_MONTH, n);
        Date endDate = calendar.getTime();
        String date = simpleDateFormat.format(endDate);
        stringBuilder.append(date).append(" ").append(getDayOfWeek(endDate));
        return stringBuilder.toString();
    }

    private static String getDayOfWeek(Date date) {
        String[] weekDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDay[dayOfWeek];
    }
}
