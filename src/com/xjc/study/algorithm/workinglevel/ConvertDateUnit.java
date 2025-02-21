package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 时长单位转换
 某创新公司在做某些星球的一个太空项目，其中涉及到的时长的不同单位之间的转换和表示
 给定某单位表示的时长，请向尽量大的一个或多个单位转换
 确保转换后的每个单位的数值为整数
 如果转换后某单位的数值为0，则跳过该单位不输出
 假设该星球时长的单位及单位换算关系如下：
 1 year = 22 month，1 month = 31 day，1 day = 24 hour， 1 hour = 60 minute，1 minute = 60 second
 输入
 某单位表示的时长的字符串，格式为；数值 单位，
 用例保证数值为大于0的整数，而且转换前后时长小于10year
 输出
 转换后的时长表示，各单位和数值之间以单空格分隔
 样例1
 输入 489607 minute
 输出 10 month 30 day 7 minute
 样例2
 输入 530323200 second
 输出 9 year
 样例3
 输入 21 month
 输出 21 month
 *
 * @author x30057190
 * @since 2024/5/31
 */
public class ConvertDateUnit {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            System.out.println(unitTransform(cin.nextLine()));
        }
    }

    /**
     * 1 year = 22 month，1 month = 31 day，1 day = 24 hour， 1 hour = 60 minute，1 minute = 60 second
     **/
    public static String unitTransform(String inputStr) {
        String[] parts = inputStr.split(" ");
        long value = Long.parseLong(parts[0]);
        String unit = parts[1];

        long years = 0, months = 0, days = 0, hours = 0, minutes = 0, seconds = 0;
        StringBuilder sr = new StringBuilder();
        switch (unit) {
            case "year":
                years = value;
                break;
            case "month":
                years = value / 22;
                months = value % 22;
                break;
            case "day":
                years = value / (22 * 31);
                months = (value % (22 * 31)) / 31;
                days = value % 31;
                break;
            case "hour":
                years = value / (22 * 31 * 24);
                months = (value % (22 * 31 * 24)) / (31 * 24);
                days = (value % (31 * 24)) / 24;
                hours = value % 24;
                break;
            case "minute":
                years = value / (22 * 31 * 24 * 60);
                months = (value % (22 * 31 * 24 * 60)) / (31 * 24 * 60);
                days = (value % (31 * 24 * 60)) / (24 * 60);
                hours = (value % (24 * 60)) / 60;
                minutes = value % 60;
                break;
            case "second":
                years = value / (22 * 31 * 24 * 60 * 60);
                months = (value % (22 * 31 * 24 * 60 * 60)) / (31 * 24 * 60 * 60);
                days = (value % (31 * 24 * 60 * 60)) / (24 * 60 * 60);
                hours = (value % (24 * 60 * 60)) / (60 * 60);
                minutes = (value % (60 * 60)) / 60;
                seconds = value % 60;
                break;
            default:
                return "";
        }

        if (years > 0) {
            sr.append(years).append(" year ");
        }
        if (months > 0) {
            sr.append(months).append(" month ");
        }
        if (days > 0) {
            sr.append(days).append(" day ");
        }
        if (hours > 0) {
            sr.append(hours).append(" hour ");
        }
        if (minutes > 0) {
            sr.append(minutes).append(" minute ");
        }
        if (seconds > 0) {
            sr.append(seconds).append(" second ");
        }
        return sr.substring(0, sr.toString().length() - 1);
    }
}
