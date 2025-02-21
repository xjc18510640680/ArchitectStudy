/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.test;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
高频res接口
 某系统开放了多个rest接口供第三方系统调用，偶同事记录了这些接口的调用信息，存放于日志
 invokes 中，invokes[i]=[time,interfaceId],表示在时刻 time ，接口 interfaceId 被调用了依次
 给定时间窗口长度 timeSegment。对于某接口，若存在一个时间窗口[t, t + timeSegment)，其被调用的次数不少于
 minLimits 次，则称该接口为高频接口，并按升序返回；若没有，则为空列表[]
 输入
 [[0, 1], [0, 10], [9, 1], [10, 10], [20, 3], [25, 3], [100, 3], [100, 3]]
 10
 2
 输出
 [1, 3]

 输入
 [[1, 1], [2, 1], [3, 1], [4, 1], [5, 1], [6, 1], [7, 1], [8, 1], [9, 1], [10, 1]]
 10
 10
 输出
 [1]
 输入
 [[1, 1], [2, 1], [3, 1], [4, 1], [5, 1], [6, 1], [7, 1], [8, 1], [9, 1], [10, 1]]
 10
 10
 输出
 [1]
 */
public class Test3 {
    public static void main(String[] args) {
        List<InvokeInfo> invokes = List.of(
                new InvokeInfo() {{
                    time = 1;
                    interfaceId = 1;
                }},
                new InvokeInfo() {{
                    time = 2;
                    interfaceId = 1;
                }},
                new InvokeInfo() {{
                    time = 3;
                    interfaceId = 1;
                }},
                new InvokeInfo() {{
                    time = 4;
                    interfaceId = 1;
                }},
                new InvokeInfo() {{
                    time = 5;
                    interfaceId = 1;
                }},
                new InvokeInfo() {{
                    time = 6;
                    interfaceId = 1;
                }},
                new InvokeInfo() {
                    {
                        time = 7;
                        interfaceId = 1;
                    }
                },
                new InvokeInfo() {
                    {
                        time = 8;
                        interfaceId = 1;
                    }
                },
                new InvokeInfo() {
                    {
                        time = 9;
                        interfaceId = 1;
                    }
                },
                new InvokeInfo() {
                    {
                        time = 10;
                        interfaceId = 1;
                    }
                });
        int timeSegment = 10;
        int minLimits = 10;
        Test3 test = new Test3();
        int[] result = test.getInterfaces(invokes, timeSegment, minLimits);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    int[] getInterfaces(List<InvokeInfo> invokes, int timeSegment, int minLimits) {
        Set<Integer> interfaces = new HashSet<>();
        // 按接口id分组，统计每个接口在每个时间窗口内的调用次数
        invokes.stream().collect(Collectors.groupingBy(InvokeInfo::getInterfaceId, Collectors.groupingBy(
                        invokeInfo -> invokeInfo.time / timeSegment, Collectors.counting())))
                .forEach((interfaceId, time2Count) -> {
                    // 若某个接口在某个时间窗口内的调用次数大于等于minLimits，则认为该接口为高频接口
                    time2Count.forEach((time, count) -> {
                        if (count >= minLimits) {
                            // 记录为高频接口
                            interfaces.add(interfaceId);
                        }
                    });
                });
        for (InvokeInfo invokeInfo :invokes){
            for (int i = invokeInfo.time; i < invokeInfo.time + timeSegment; i++) {
                if (invokeInfo.time >= i || invokeInfo.time + timeSegment <= i || invokeInfo.interfaceId == 1) {
                    System.out.println(invokeInfo.time / timeSegment);
                }
            }
        }
        return interfaces.stream().mapToInt(Integer::intValue).toArray();
    }

}
class InvokeInfo {
    int time;
    int interfaceId;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(int interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String toString() {
        return String.format(Locale.ROOT, "[%d, %d]", time, interfaceId);
    }
}
