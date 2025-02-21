/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.workinglevel;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 Mini订货系统
 请实现一个Mini订货系统，提供订货、发货、查询功能：
 OrderSystem()--系统初始化
 order(int customerId, String[] goods)--表示客户的一次订货，goods每个元素表示一件商品，值为商品种类
 （同一客户可以多次订货；单次订货，可以对同一件商品定购多件）
 deliver(String[] goods)--表示发货多件商品，goods含义同上：每个元素表示一件商品，值为商品种类
 （依次将每件商品按照定购的先后顺序发给定购该商品的客户）注：用例保证发的商品一定被某用户定购过
 query()--查询并返回系统中为发货件数最大的客户id；若存在并列，返回客户id较小的；若所有客户都完成发货，返回-1
 输入
 每行

 * @author x30057190
 * @since 2024/4/25
 */
public class OrderSystem {

    private static List<Map<Integer, String>> orderList = new ArrayList<>();

    private static List<Map<Integer, String>> unDeliverList = new ArrayList<>();

    public OrderSystem() {
        System.out.println("null");
    }

    static String order(int customerId, List<String> goods) {
        for (String goodId : goods) {
            Map<Integer, String> unDeliverMap = new HashMap<>();
            unDeliverMap.put(customerId, goodId);
            orderList.add(unDeliverMap);
            unDeliverList = orderList;
        }
        return "null";
    }

    static String deliver(List<String> goods) {
        if (orderList.isEmpty()) {
            return "null";
        }
        for (String goodId : goods) {
            for (Map<Integer, String> map : orderList) {
                if (map.containsValue(goodId)) {
                    unDeliverList.remove(map);
                    break;
                }
            }
        }
        orderList = unDeliverList;
        return "null";
    }

    static int query() {
        if (!unDeliverList.isEmpty()) {
            Map<Integer, Long> result = unDeliverList.stream()
                .flatMap(map -> map.keySet().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            List<Map.Entry<Integer, Long>> list = new ArrayList<>(result.entrySet());
            list.sort(
                (a, b) -> Math.toIntExact(
                    a.getValue().equals(b.getValue()) ? a.getKey() - b.getKey() : b.getValue() - a.getValue()));
            for (Map.Entry<Integer, Long> entry : list) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new OrderSystem();
        // 测试1
        System.out.println(order(99, Collections.singletonList("gb1000")));
        System.out.println(order(88, Arrays.asList("gb666", "gb555")));
        System.out.println(order(99, Collections.singletonList("gb666")));
        System.out.println(query());
        System.out.println(deliver(Collections.singletonList("gb666")));
        System.out.println(query());
        // 测试2
//        System.out.println(order(1, Arrays.asList("1", "2", "3")));
//        System.out.println(order(2, Arrays.asList("1", "6", "4", "2", "5", "3", "7")));
//        System.out.println(order(3, Arrays.asList("1", "6", "4", "2", "5")));
//        System.out.println(deliver(Arrays.asList("1", "4")));
//        System.out.println(deliver(Arrays.asList("1", "2", "5")));
//        System.out.println(deliver(Arrays.asList("3", "3")));
//        System.out.println(query());
        // 测试3
//        System.out.println(order(1, Arrays.asList("1", "2", "3")));
//        System.out.println(order(2, Arrays.asList("1", "6", "4", "2", "5", "3", "7")));
//        System.out.println(deliver(Arrays.asList("1", "4")));
//        System.out.println(deliver(Arrays.asList("1", "2", "5")));
//        System.out.println(deliver(Arrays.asList("3", "3")));
//        System.out.println(deliver(Collections.singletonList("6")));
//        System.out.println(deliver(Collections.singletonList("7")));
//        System.out.println(deliver(Collections.singletonList("2")));
//        System.out.println(order(3, Arrays.asList("7", "7", "7", "7", "7", "7", "7", "7", "7", "7")));
//        System.out.println(order(999, Arrays.asList("6", "61", "66", "666", "999")));
//        System.out.println(deliver(Arrays.asList("7", "7", "7", "7", "7", "7")));
//        System.out.println(query());
    }
}
