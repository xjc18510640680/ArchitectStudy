package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * [模拟计算器]
 * 某模拟计算器有20个栈，分别用小写字母a~t命名，每个栈的容量为32，
 * 初始状态下所有栈都为空，栈支持如下功能：压栈，出栈，读取栈顶值，替换栈顶值
 * 现对模拟计算器下发一系列计算指令 instructions，instructions[i]格式如下：
 *   PSH 栈名 整数：将给定的整数压栈至制定的栈，若栈中已经有32个元素，则压栈失败且不做任何处理
 *   POP 栈名：将指定栈的栈顶元素出栈
 *   ADD 栈1 栈2：把两个栈的栈顶值相加，用结果替换栈1的栈顶值
 *   MUL 栈1 栈2：把两个栈的栈顶值相乘，用结果替换栈1的栈顶值
 *   DIV 栈1 栈2：栈1的栈顶值除以栈2的栈顶值，将商（向下取整）替换栈1的栈顶值，余数替换栈2的栈顶值
 *   输入保证：POP/ADD/MUL/DIV操作的栈不为空，DIV操作不会出现除以零的情况
 * 请依次执行这些指令，最后依次返回模拟计算器中这20个栈的栈顶值：
 *   若某条指令的计算结果出现数值 val >= 1024，则结果以 1024 为底取余（即 val % 1024）
 *   若返回时栈为空，则以-1表示
 * 输入
 * 一系列指令 instructions，1 <= instructions.length <= 1000
 *    输入保证指令合法，且ADD/MUL/DIV不会输入两个相同的栈
 *    输入的整数为十进制表示，值范围[0,2^10-1]
 * 输出
 * 20个整数，依次表示20个栈的栈顶值；如果栈为空，则以-1表示
 * 样例 1
 * 输入 ["PSH a 8", "PSH d 3", "PSH c 3", "ADD a c", "DIV a c", "MUL d c", "POP c"]
 * 输出 [3, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
 * 样例 2
 * 输入 ["PSH a 9", "PSH t 400", "MUL t a", "DIV t a", "PSH a 30", "MUL a t"]
 * 输出 [716, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58]
 *
 * @author x30057190
 * @since 2024/12/17
 */

public class StackCalculator {

    private static final Map<Character, Stack<Integer>> stacks = new HashMap<>();

    static  {
        for (char c = 'a'; c <= 't'; c++) {
            stacks.put(c, new Stack<>());
        }
    }

    public static int[] stackCalculator(List<String> instructions) {
        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            char stackName = parts[1].charAt(0);
            switch (parts[0]) {
                case "PSH":
                    if (stacks.get(stackName).size() < 32) {
                        stacks.get(stackName).push(Integer.parseInt(parts[2]));
                    }
                    break;
                case "POP":
                    if (!stacks.get(stackName).isEmpty()) {
                        stacks.get(stackName).pop();
                    }
                    break;
                case "ADD":
                    char stackName2 = parts[2].charAt(0);
                    if (!stacks.get(stackName).isEmpty() && !stacks.get(stackName2).isEmpty()) {
                        int sum = stacks.get(stackName).peek() + stacks.get(stackName2).peek();
                        stacks.get(stackName).pop();
                        stacks.get(stackName).push(sum % 1024);
                    }
                    break;
                case "MUL":
                    char stackName3 = parts[2].charAt(0);
                    if (!stacks.get(stackName).isEmpty() && !stacks.get(stackName3).isEmpty()) {
                        int product = stacks.get(stackName).peek() * stacks.get(stackName3).peek();
                        stacks.get(stackName).pop();
                        stacks.get(stackName).push(product % 1024);
                    }
                    break;
                case "DIV":
                    char stackName4 = parts[2].charAt(0);
                    if (!stacks.get(stackName).isEmpty() && !stacks.get(stackName4).isEmpty()) {
                        int dividend = stacks.get(stackName).peek();
                        int divisor = stacks.get(stackName4).peek();
                        int quotient = dividend / divisor;
                        int remainder = dividend % divisor;
                        stacks.get(stackName).pop();
                        stacks.get(stackName).push(quotient % 1024);
                        stacks.get(stackName4).pop();
                        stacks.get(stackName4).push(remainder % 1024);
                    }
                    break;
                default:
                    break;
            }
        }

        int[] result = new int[20];
        for (char c = 'a'; c <= 't'; c++) {
            if (stacks.get(c).isEmpty()) {
                result[c - 'a'] = -1;
            } else {
                result[c - 'a'] = stacks.get(c).peek();
            }
        }
        return result;
    }

    /**
     * 样例 1
     * 输入 PSH a 8, PSH d 3, PSH c 3, ADD a c, DIV a c, MUL d c, POP c
     * 输出 [3, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
     * 样例 2
     * 输入 PSH a 9, PSH t 400, MUL t a, DIV t a, PSH a 30, MUL a t
     * 输出 [716, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58]
     **/
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            String headerInfo = cin.nextLine();
            List<String> instructions = Arrays.asList(headerInfo.split(", "));
            System.out.println(Arrays.toString(stackCalculator(instructions)));
        }
    }
}
