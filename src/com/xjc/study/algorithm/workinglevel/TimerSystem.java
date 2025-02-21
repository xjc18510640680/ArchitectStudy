package com.xjc.study.algorithm.workinglevel;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 定时器系统
 模拟一个周期定时器系统：一个定时器启动后，每经过一个周期则产生一次超时，直到被停止
 请实现该系统的如下功能：
 TimerSystem(int[] timers) -- 初始化定时器系统，所创建的定时器记录于timers中
 缺省都未启动；timers[i]的下标i表示定时器编号，值表示周期。注：系统初始时刻为0
 timerStart(int timerId) -- 启动定时器timerId，从启动开始计时
 如果计时器不存在，返回false；如果定时器存在（运行或停止状态），返回true，且重新开始计时
 timerStop(int timerId) -- 停止一个定时器timerId。
 如果该定时器不存在，返回false；如果定时器存在（运行或停止状态）返回true，并停止该定时器
 runTimerSystem(int nowTime) -- 模拟推进系统时间到nowTime（含该时刻），并进行所有定时器的超时处理
 自上次调用时刻到nowTime，一个定时器timerId如果有超时，按格式[time, timerId]输出其超时信息（可能有多次）
 time表示一个超时时刻
 所有超时信息的返回顺序要求：
 优先按time先后顺序；
 同一时刻有多个定时器超时，按timerId升序。
 注：未调用runTimerSystem时系统时刻维持不变；输入保证改函数的nowTime严格递增。
 样例1
 输入
 TimerSystem([3,5])
 timerStart(0)
 timerStart(1)
 runTimerSystem(15)
 timerStop(1)
 runTimerSystem(20)
 timerStop(1)
 timerStop(2)
 输出
 null
 true
 true
 [[3, 0], [5, 1], [6, 0], [9, 0], [10, 1], [12, 0], [15, 0], [15, 1]]
 true
 [[18, 0]]
 true
 false
 样例2
 输入
 TimerSystem([8,4,11])
 runTimerSystem(2)
 timerStart(1)
 timerStart(4)
 runTimerSystem(8)
 timerStart(0)
 timerStart(2)
 timerStart(1)
 runTimerSystem(20)
 timerStop(1)
 runTimerSystem(30)
 输出
 null
 []
 true
 false
 [[6, 1]]
 true
 true
 true
 [[12, 1], [16, 0], [16, 1], [19, 2], [20, 1]]
 true
 [[24, 0], [30, 2]]

 测试用例部分通过
 * @author x30057190
 * @since 2024/5/25
 */
class TimerSystem {
    private static int[] timers;
    private static boolean[] isStart;
    private static int[] lastTime;

    /**
     * 初始化定时器系统，所创建的定时器记录于timers中
     *  缺省都未启动；timers[i]的下标i表示定时器编号，值表示周期。注：系统初始时刻为0
     * @param timers timers
     **/
    public TimerSystem(int[] timers) {
        this.timers = timers;
        isStart = new boolean[timers.length];
        lastTime = new int[timers.length];
        Arrays.fill(isStart, false);
        Arrays.fill(lastTime, -1);
        System.out.println("null");
    }
    /**
     * 启动定时器timerId，从启动开始计时
     *  如果计时器不存在，返回false；如果定时器存在（运行或停止状态），返回true，且重新开始计时
     * @param timerId timerId
     * @return boolean
     **/
    public static boolean timerStart(int timerId) {
        if (timerId < 0 || timerId >= timers.length) {
            return false;
        }
        isStart[timerId] = true;
        lastTime[timerId] = 0;
        return true;
    }
    /**
     * 停止一个定时器timerId。
     *  如果该定时器不存在，返回false；如果定时器存在（运行或停止状态）返回true，并停止该定时器
     * @param timerId timerId
     * @return boolean
     **/
    public static boolean timerStop(int timerId) {
        if (timerId < 0 || timerId >= timers.length) {
            return false;
        }
        isStart[timerId] = false;
        return true;
    }
    /**
     *  模拟推进系统时间到nowTime（含该时刻），并进行所有定时器的超时处理
     *  自上次调用时刻到nowTime，一个定时器timerId如果有超时，按格式[time, timerId]输出其超时信息（可能有多次）
     *  time表示一个超时时刻
     *  所有超时信息的返回顺序要求：
     *  优先按time先后顺序；
     *  同一时刻有多个定时器超时，按timerId升序。
     *  注：未调用runTimerSystem时系统时刻维持不变；输入保证改函数的nowTime严格递增。
     *  返回值（二维数组）的元素格式为 [time, timerId]
     * @param nowTime nowTime
     * @return int[][]
     **/
    public static int[][] runTimerSystem(int nowTime) {
        int[][] res = new int[10][2];
        int idx = 0;
        for (int i = 0; i < timers.length; i++) {
            if (isStart[i]) {
                for (int j = lastTime[i] + timers[i]; j <= nowTime; j += timers[i]) {
                    res[idx][0] = j;
                    res[idx][1] = i;
                    idx++;
                }
                lastTime[i] = nowTime;
            }
        }
        int[][] array = Arrays.copyOf(res, idx);
        Arrays.sort(array, Comparator.comparingInt(a -> a[0]));
        return array;
    }

    public static void main(String[] args) {
        // 测试1
        System.out.println(new TimerSystem(new int[] {3, 5}));
        System.out.println(timerStart(0));
        System.out.println(timerStart(1));
        System.out.println(Arrays.deepToString(runTimerSystem(15)));
        System.out.println(timerStop(1));
        System.out.println(Arrays.deepToString(runTimerSystem(20)));
        System.out.println(timerStop(1));
        System.out.println(timerStop(2));

        // 测试2
//        System.out.println(new TimerSystem(new int[] {8, 4, 11}));
//        System.out.println(Arrays.deepToString(runTimerSystem(2)));
//        System.out.println(timerStart(1));
//        System.out.println(timerStart(4));
//        System.out.println(Arrays.deepToString(runTimerSystem(8)));
//        System.out.println(timerStart(0));
//        System.out.println(timerStart(2));
//        System.out.println(timerStart(1));
//        System.out.println(Arrays.deepToString(runTimerSystem(20)));
//        System.out.println(timerStop(1));
//        System.out.println(Arrays.deepToString(runTimerSystem(30)));
    }
}