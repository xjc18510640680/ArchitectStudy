package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

/**
 * IP报文头解析
 一个IP报文头及所包含的个信息的关系，共20字节
 版本（4） 首部长度（4）  服务类型（8）  总长度（字节数）（16）
 标识（16）标志（3） 片偏移（13）
 生存时间（8） 协议（8） 首部检验和（16）
 源IP地址（32）
 目的IP地址（32）
 从上到下，从左到右一次标识个信息在IP报文头中的顺序
 标识（16）标识占16bit即2个字节长度
 现在给定一个十六进制格式的IP报文头数据，请解析输出其中的总长度、标志、目的IP地址
 总长度、标志位十进制整数
 目的IP地址位点分十进制格式，如192.168.20.184
 样例
 输入
 45 00 10 3c 7c 48 20 03 80 06 00 00 c0 a8 01 02 c0 a8 14 b8
 输出
 4156,1,192.168.20.184
 * @author x30057190
 * @since 2024/5/23
 */
public class IPPacketHeaderParsing {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            String headerInfo = cin.nextLine();
            System.out.println(parseIpv4Data(headerInfo));
        }
    }

    static String parseIpv4Data(String headerInfo) {
        headerInfo = headerInfo.replaceAll("\\s", "");
        String totalLen = headerInfo.substring(4, 8);
        String flag = headerInfo.substring(12, 13);
        String ip = headerInfo.substring(32);
        return String.format(Locale.ROOT, "%d,%d,%d.%d.%d.%d",
            Integer.parseInt(totalLen, 16),
            Integer.parseInt(flag, 16) / 2,
            Integer.parseInt(ip.substring(0, 2), 16),
            Integer.parseInt(ip.substring(2, 4), 16),
            Integer.parseInt(ip.substring(4, 6), 16),
            Integer.parseInt(ip.substring(6), 16)
        );
    }

    public static int hex2ten(String hex) {
        int hexLength = hex.length();
        int result = 0;
        for (int i = 0; i < hexLength; ++i) {
            char c = hex.charAt(i);
            if (c >= '0' && c <= '9') {
                result += (int) ((c - '0') * Math.pow(16, hexLength - 1 - i));
            } else {
                result += (int) ((c - 'a' + 10) * Math.pow(16, hexLength - 1 - i));
            }
        }
        return result;
    }
}
