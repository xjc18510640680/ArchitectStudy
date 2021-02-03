package com.xjc.study.exam;

import java.util.Scanner;

/**
 * Description:
 * 系统提供人民币（CNY）美元（USD）英镑（GBP）价值转换
 * @author 19040838
 * @title: ExchangeRate
 * Created by 19040838 on 2021.02.01 22:17
 */
public class ExchangeRate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            System.out.println(SolutionWay.computer(input));
        }
    }
    public static class SolutionWay {
        // 英镑
        private static final String GBP = "GBP";
        // 美元
        private static final String USD = "USD";
        // 人民币
        private static final String CNY = "CNY";
        // 港元
        private static final String HKD = "HKD";
        // 最大兑换
        private static final String MAX = "MAX";
        // 最小兑换
        private static final String MIN = "MIN";
        private static final String ERROR = "ERROR";
        private static int gbpRate;
        private static int usdRate;
        private static int cnyRate;
        private static int inputNum;
        private static String inputType;
        private static String resultType;

        private static String computer(String input) {
            // 以空白字符分割字符串，得到一个字符串数组。
            String[] strArr = input.split("\\s");
            /*
            1、\s用于匹配空白字符。
            2、\\s用于匹配字符串中的\和s，两个字符。
            */
            if (strArr.length == 6 && (checkNum(strArr[0]) && checkNum(strArr[1]) && checkNum(strArr[2]) &&
                    checkNum(strArr[3]) && checkType(strArr[4]) && checkResultType(strArr[5]))) {
                setParam(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]),
                        Integer.parseInt(strArr[3]), strArr[4], strArr[5]);
                if (resultType.equals(MAX)) {
                    // 最大兑换
                    return getMaxResult();
                } else {
                    return getMinResult();
                }
            } else {
                return ERROR;
            }
        }

        // 设置汇率系数
        private static void setParam(int a, int b, int c, int num, String inputT, String resultT) {
            gbpRate = a * b * c;
            usdRate = a * b;
            cnyRate = a;
            inputNum = num;
            inputType = inputT;
            resultType = resultT;
        }

        // 检查输入是否为负数，或小数
        private static boolean checkNum(String num) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }

        // 检查货币类型是否为以下四种之一，主要是检查是否为大写
        private static boolean checkType(String type) {
            return type.equals(HKD) || type.equals(CNY) || type.equals(USD) || type.equals(GBP);
        }
        // 输入的所有参数都要进行检查 检查是否为MAX或MIN
        private static boolean checkResultType(String resultType) {
            return resultType.equals(MAX) || resultType.equals(MIN);
        }


        private static String getMaxResult() {
            // 货币转换成以港元为单位
            int tempV = getRate(inputType) * inputNum;
            StringBuilder result = new StringBuilder();
            if (tempV / gbpRate > 0) {
                result.append(tempV / gbpRate).append(' ').append("GBP ");
                tempV = tempV % getRate(GBP);
            }
            if (tempV / usdRate > 0) {
                result.append(tempV / usdRate).append(' ').append("USD ");
                tempV = tempV % getRate(USD);
            }
            if (tempV / cnyRate > 0) {
                result.append(tempV / cnyRate).append(' ').append("CNY ");
                tempV = tempV % getRate(CNY);
            }
            if (tempV > 0) {
                result.append(tempV).append(' ').append("HKD");
            }
            return result.toString();
        }

        private static String getMinResult() {
            return inputNum * getRate(inputType) + " HKD";
        }

        private static int getRate(String type) {
            switch (type) {
                case GBP:
                    return gbpRate;
                case USD:
                    return usdRate;
                case CNY:
                    return cnyRate;
                default:///港元
                    return 1;
            }
        }
    }
}
