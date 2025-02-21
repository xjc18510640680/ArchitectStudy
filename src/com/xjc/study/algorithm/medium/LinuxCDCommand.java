/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 题目描述
 某简易的linux目录系统 cd 命令（change directory）功能如下：

 cd ：进入home目录/home/user；
 cd -：进入上一次停留的目录（连续两个以上 cd - 会在两个目录之间来回跳转，而不是回到更早之前的目录）；
 cd <绝对路径>：以 / 开头的为绝对路径；
 cd <相对路径>：不以/开头的为相对路径；
 现给定一批 cd 命令，命令格式及相关假设如下：

 单独的/表示根目录，且为系统默认的初始目录；
 ////a表示目录/a，即这种格式中的多个 / 等价于一个 / ；
 特殊目录. ，表示当前层次目录，例如/a/. 表示目录/a；
 特殊目录..，表示当前层次目录的父目录（根目录的父目录仍为根），例如/a/..表示目录/；
 假设不会出现第一个命令为cd -的情况；
 请计算所有命令执行结束后的最终目录，并格式化输出其绝对路径：

 必须以/开头，不以/结尾（除根目录外）；
 不允许特殊目录.、..，不允许连续的/，需转化为所表示的目录；
 解答要求
 时间限制：1000ms, 内存限制：128MB
 输入
 首行一个整数 n，表示 cd 命令的个数，取值范围：[1,100]
 接下来 n 行，每行一条 cd 命令，长度范围 [1, 100]，其中目录名仅由小写英文字母 [a-z] 组成

 假设：

 设目录总长度 < 10000
 命令中的目录都是存在的
 命令格式都符合规则
 输出
 一个字符串，表示最终目录的绝对路径。

 样例
 输入样例 1 复制

 3
 cd /aa/bb/cc/dd/
 cd ./ee/ff
 cd gg/../hh
 输出样例 1

 /aa/bb/cc/dd/ee/ff/hh
 提示样例 1
 默认目录在 / ，各条命令执行情况如下：

 第一条：路径名以 / 开头表示绝对路径，执行后当前目录为 /aa/bb/cc/dd/
 第二条：路径名不以 / 开头表示相对路径，进入当前目录的下层目录，执行后当前目录为 /aa/bb/cc/dd/ee/ff
 第三条：路径名不以 / 开头表示相对路径，gg/../hh 表示先进入下层目录 gg，接着返回 gg 的上层目录即当前目录，然后进入下层目录 hh， 因此最终目录为 /aa/bb/cc/dd/ee/ff/hh
 * @author x30057190
 * @since 2024/4/26
 */
public class LinuxCDCommand {
    private static String currentDirectory = "/";
    private static String home = "/home/user";
    private static String LAST_PATH = "";
    private static String prePath = "";
    // 待实现函数，在此函数中填入答题代码
    private static String getCurrentDirectory(String[] cmds) {
        String result = "";
        for (String cmd : cmds) {
            String[] parts = cmd.split(" ");
            if (parts.length < 2) {
                result = home;
                LAST_PATH = result;
                continue;
            }
            String path = parts[1];
            String[] pathParts = path.split("/");
            for (String pathPart : pathParts) {
                if (pathPart != null && !pathPart.isEmpty()) {
                    if ("..".equals(pathPart) && pathParts.length == 1) {
                        prePath = "".equals(LAST_PATH) ? home : LAST_PATH;
                        result = "".equals(LAST_PATH) ?
                            home.substring(0, home.lastIndexOf("/")) :
                            LAST_PATH.substring(0, LAST_PATH.lastIndexOf("/"));
                        LAST_PATH = result;
                        continue;
                    }
                    if ("-".equals(pathPart)) {
                        result = "".equals(prePath) ? home : prePath;
                        LAST_PATH = result;
                        continue;
                    }
                    if (".".equals(pathPart)) {
                        prePath = result;
                        LAST_PATH = result;
                        continue;
                    }
                    if ("..".equals(pathPart)) {
                        prePath = result;
                        result = "".equals(LAST_PATH) ? "" : LAST_PATH.substring(0, LAST_PATH.lastIndexOf("/"));
                        LAST_PATH = result;
                        continue;
                    }
                    prePath = result;
                    result = result + currentDirectory + pathPart;
                    LAST_PATH = result;
                }
            }
        }
        return result;
    }

    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int row = cin.nextInt();
        cin.nextLine();
        String[] cmds = new String[row];
        for (int i = 0; i < row; i++) {
            cmds[i] = cin.nextLine();
        }
        cin.close();
        String result = getCurrentDirectory(cmds);
        System.out.println(result);
    }
}
