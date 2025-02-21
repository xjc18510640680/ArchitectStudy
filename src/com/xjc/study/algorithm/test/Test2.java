/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.test;

import java.util.*;

/**
解析资源名称
 某业务中，需要按请求的[资源前缀]和[资源范围]，并遵照一定规则生成资源名称
 资源前缀：由小写英文字母组成，如：ecs
 资源范围：为如下两种格式之一
    仅一个数字字符串（如："10"）,表示申请一个资源
    区间值，格式 first-last （如："1-5"），表示希望申请的资源是从 first 到 last（含）的连续多个资源
 现给定资源前缀 prefix 和资源范围列表 ranges ，请依次解析 ranges，按如下规则生成资源名称并返回
    每个资源名称的格式为 资源前缀-数字后缀，如："ecs-0099"，"bms-1001"
        资源前缀固定为输入的 prefix；
        数字后缀由 ranges[i]生成，固定是4位数字，取值范围是[0001,9999],注：不足4位补足前导0
    一个 ranges[i] 可能申请一个或多个资源，依次生成每个资源的数字后缀：
        如果该数字后缀未被使用，则使用该数字后缀；
        否则数字后缀顺延，直到找到首个空闲数字。注：可能出现环绕，即：9999顺延到0001
 用例保证：9999个数字资源够用
 输入
 "ecs"
 ["1", "10", "9-11", "9999", "9999"]
 输出
 ["ecs-0001", "ecs-0010", "ecs-0009", "ecs-0011", "ecs-0012", "ecs-9999", "ecs-0002"]
 输入
 "ecs"
 ["7", "6-8", "9999", "9999"]
 输出
 ["ecs-0007", "ecs-0006", "ecs-0008", "ecs-0009", "ecs-9999", "ecs-0001"]
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> ranges = Arrays.asList("7", "6-8", "9999", "9999");
        List<String> result = generateResNames("ecs", ranges);
        System.out.println(result);
    }
    static List<String> generateResNames(String prefix, List<String> ranges) {
        Set<String> res = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String range : ranges) {
            if (range.contains("-")) {
                int first = Integer.parseInt(range.split("-")[0]);
                int last = Integer.parseInt(range.split("-")[1]);
                for (int i = first; i <= last; i++) {
                    buildResult(res, prefix, String.valueOf(i), result);
                }
            } else {
                if (range.equals("9999") && res.contains(String.format("%s-%04d", prefix, Integer.parseInt(range))) ) {
                    range = "1";
                    buildResult(res, prefix, range, result);
                } else {
                    buildResult(res, prefix, range, result);
                }
            }
        }
        return result;
    }
    static void buildResult(Set<String> res, String prefix, String range, List<String> result) {
        final String format = String.format("%s-%04d", prefix, Integer.parseInt(range));
        if (!res.contains(format)) {
            res.add(format);
            result.add(format);
        } else {
            for (int i = 1; i <= 9999; i++) {
                String newFormat = String.format("%s-%04d", prefix, (Integer.parseInt(range) + i) % 10000);
                if (!res.contains(newFormat)) {
                    res.add(newFormat);
                    result.add(newFormat);
                    break;
                }
            }
        }
    }

}
