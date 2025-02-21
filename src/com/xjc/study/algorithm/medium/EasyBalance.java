package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 1019. 【软件认证】简单负载均衡: https://oj.rnd.huawei.com/problems/1019/details
 *
 * @author x30057190
 * @since 2024/5/7
 */
public class EasyBalance {
    // 待实现函数，在此函数中填入答题代码
    static int[] findHighestLoadServers(int serverNum, Message[] messages) {
        boolean[] isBusy = new boolean[serverNum]; // 下标为server编号-1，值为是否忙碌
        int[] serverLoad = new int[serverNum]; // 下标为server编号-1，值为总Load
        Message[] processingMsg = new Message[serverNum]; // 下标为server编号-1，值为目前仍在处理的 message信息
        // 首先将消息按时间排序
        Arrays.sort(messages, Comparator.comparingInt(o -> o.time));
        int lastProcessIdx = -1; // 上次分配执行的服务器，从-1开始
        // 依次处理 messages
        for (Message message : messages) {
            // 首先更新时间
            updateTime(message.time, isBusy, processingMsg, serverNum);
            // 从 lastProcessIdx 下一个位置开始，循环找到第一个空闲的server
            // 按顺序循环分配服务器：i最大值可为 2 * serverNum，使用 i % serverNum 得到对应循环的下标
            for (int i = lastProcessIdx + 1; i < 2 * serverNum; i++) {
                // 不忙，说明找到空闲的Server
                if (!isBusy[i % serverNum]) {
                    processingMsg[i % serverNum] = message; // message添加到processingMsg
                    serverLoad[i % serverNum] += message.load; // 计算该server的总负载值
                    isBusy[i % serverNum] = true; // 标记该server为忙碌
                    lastProcessIdx = i % serverNum; // 记录下 lastProcessIdx 以下次循环使用
                    break;
                }
            }
        }
        // 统计结果
        List<int[]> idLoadArrList = new ArrayList<>(); // [serverId, serverLoad]
        for (int i = 0; i < serverNum; i++) {
            idLoadArrList.add(new int[] {i + 1, serverLoad[i]});
        }
        idLoadArrList.sort((o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o1[0] - o2[0]); // 按serverLoad降序，serverId升序
        // 生成答案
        List<Integer> ansList = new ArrayList<>();
        ansList.add(idLoadArrList.get(0)[0]);
        int maxLoad = idLoadArrList.get(0)[1];
        int i = 1;
        // 将与最大值相等的serverId加入结果集
        while (i < idLoadArrList.size() && idLoadArrList.get(i)[1] == maxLoad) {
            ansList.add(idLoadArrList.get(i)[0]);
            i++;
        }
        return ansList.stream().mapToInt(Integer::valueOf).toArray();
    }
    private static void updateTime(int time, boolean[] isBusy, Message[] processingMsg, int serverNum) {
        for (int i = 0; i < serverNum; i++) {
            // 空闲的不处理
            if (!isBusy[i]) {
                continue;
            }
            // 忙碌的检查是否处理完了
            Message message = processingMsg[i];
            if (message.time + message.load <= time) {
                isBusy[i] = false;
                processingMsg[i] = null;
            }
        }
    }
    static class Message {
        int time;
        int load;
    }
    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int serverNum = cin.nextInt();
        int messageNum = cin.nextInt();
        Message[] messages = new Message[messageNum];
        for (int i = 0; i < messages.length; i++) {
            Message message = new Message();
            message.time = cin.nextInt();
            message.load = cin.nextInt();
            messages[i] = message;
        }

        cin.close();

        int[] highestLoadServers = findHighestLoadServers(serverNum, messages);
        String[] strResult = Arrays.stream(highestLoadServers).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", strResult));
    }
}
