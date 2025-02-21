//package com.xjc.study.algorithm.workinglevel;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Scanner;
//
///**
//   IP报文头解析
//     一个IP报文头及所包含的各信息的关系如图所示：
//     版本（4） 首部长度（4）  服务类型（8）  总长度（字节数）（16）
//     标识（16）                         标志（3） 片偏移（13）
//             生存时间（8）      协议（8） 首部检验和（16）
//     源IP地址（32）
//     目的IP地址（32）
//     图中从上到下、从左到右依次表示各信息在IP报文头中的顺序:
//     各信息括号内的数字表示所占位数，如：标识(16)，表示标识部分占16个bit位即2个字节长度。
//     现给定一个十六进制格式的IP报文头数据，请解析输出其中的标识、标志：
//     标识、标志为十进制整数
//     输入
//     十六进制字符串[0-9A-F]，表示合法的IP报文头数据，每两位字符表示一个字节，字符串长度固定为 40
//     注：报文数据为网络字节序(即大端序)，大端序的高位字节在低地址，小端序的高位字节在高地址，如：数字 65538，其4字节表示的大端序内容为 00010002，小端序内容为 02000100
//     输出
//     一个字符串，表示解析结果: 标识,标志，以,间隔
//     样例1
//     复制输入：
//     "4500103C3721A00380060000C0A85566C0A8212C"
//     复制输出：
//     "14113,5"
//     解释：
//     对照图示的各信息所在位置：
//     标识 ：0x3721，十进制值为 14113
//     标志 ：0xA0的二进制为 10100000，其中的高 3 位为标志，二进制为 101，10进制值为 5
//     样例2
//     复制输入：
//     "450000FF0234900380060000000A01028090A0B0"
//     复制输出：
//     "564,4"
// */
//
//public class ParseIpv4Data {
//
//    /**
//     * 解析IPv4数据，将输入的字符串转换为IPv4地址格式
//     *
//     * @param headerInfo 输入的字符串，预期是一个八进制数
//     * @return 返回一个字符串，表示IPv4地址，格式为"a.b.c.d"，其中a,b,c,d都是整数
//     */
//    public String parseIpv4Data(String headerInfo) {
//        // 将输入的字符串转换为十进制数，然后转换为IPv4地址格式
//        // 第一部分的计算方法是：将输入的字符串从第8位开始，到第12位结束，转换为十进制数
//        // 第二部分的计算方法是：将输入的字符串从第12位开始，到第13位结束，转换为十进制数，然后除以2
//        // 最后，将两部分用逗号连接起来，形成IPv4地址格式
//        return Integer.parseInt(headerInfo, 8, 12, 16) + "," + Integer.parseInt(headerInfo, 12, 13, 16) / 2;
//    }
//
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
//        while (cin.hasNext()) {
//            String headerInfo = cin.nextLine();
//            ParseIpv4Data parseIpv4Data = new ParseIpv4Data();
//            System.out.println(parseIpv4Data.parseIpv4Data(headerInfo));
//        }
//    }
//}
