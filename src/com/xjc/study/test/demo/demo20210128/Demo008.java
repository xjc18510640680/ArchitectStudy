package com.xjc.study.test.demo.demo20210128;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: TODO 题目描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * 输入描述: 输入一个算术表达式 输出描述: 得到计算结果
 * 示例1 输入 3+2*{1+2*[-4/(8-6)+7]} 输出 25
 * @title: Demo008
 * Created by 19040838 on 2021.01.28 10:11
 */
public class Demo008 {
    public static void main(String[] args) {
        String reg = "^[0-9*\\-\\[\\]+/)(}{x22]*$";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine().replace("[","(").replace("]",")")
                    .replace("{","(").replace("}",")");
            if (!input.matches(reg)) {
                return;
            }
            System.out.println(arithmetic(input));
        }
    }

    public static double arithmetic(String exp){
        String result = parseExp(exp).replaceAll("[\\[\\]]", "");
        return Double.parseDouble(exp);
    }
    /**
     * 解析计算四则运算表达式，例：2+((3+4)*2-22)/2*3
     * @param expression
     * @return
     */
    public static String parseExp(String expression){
        //String numberReg="^((?!0)\\d+(\\.\\d+(?<!0))?)|(0\\.\\d+(?<!0))$";
        expression = expression.replaceAll("\\s+", "").replaceAll("^\\((.+)\\)$", "$1");
        String checkExp="\\d";
        String minExp="^((\\d+(\\.\\d+)?)|(\\[\\-\\d+(\\.\\d+)?\\]))[\\+\\-\\*\\/]((\\d+(\\.\\d+)?)|(\\[\\-\\d+(\\.\\d+)?\\]))$";
        //最小表达式计算
        if(expression.matches(minExp)){
            String result=calculate(expression);

            return Double.parseDouble(result)>=0?result:"["+result+"]";
        }
        //计算不带括号的四则运算
        String noParentheses="^[^\\(\\)]+$";
        String priorOperatorExp="(((\\d+(\\.\\d+)?)|(\\[\\-\\d+(\\.\\d+)?\\]))[\\*\\/]((\\d+(\\.\\d+)?)|(\\[\\-\\d+(\\.\\d+)?\\])))";
        String operatorExp="(((\\d+(\\.\\d+)?)|(\\[\\-\\d+(\\.\\d+)?\\]))[\\+\\-]((\\d+(\\.\\d+)?)|(\\[\\-\\d+(\\.\\d+)?\\])))";
        if(expression.matches(noParentheses)){
            Pattern patt=Pattern.compile(priorOperatorExp);
            Matcher mat=patt.matcher(expression);
            if(mat.find()){
                String tempMinExp=mat.group();
                expression=expression.replaceFirst(priorOperatorExp, parseExp(tempMinExp));
            }else{
                patt=Pattern.compile(operatorExp);
                mat=patt.matcher(expression);

                if(mat.find()){
                    String tempMinExp=mat.group();
                    expression=expression.replaceFirst(operatorExp, parseExp(tempMinExp));
                }
            }
            return parseExp(expression);
        }
        //计算带括号的四则运算
        String minParentheses="\\([^\\(\\)]+\\)";
        Pattern patt= Pattern.compile(minParentheses);
        Matcher mat=patt.matcher(expression);
        if(mat.find()){
            String tempMinExp=mat.group();
            expression=expression.replaceFirst(minParentheses, parseExp(tempMinExp));
        }
        return parseExp(expression);
    }
    /**
     * 计算最小单位四则运算表达式（两个数字）
     * @param exp
     * @return
     */
    public static String calculate(String exp){
        exp=exp.replaceAll("[\\[\\]]", "");
        String number[]=exp.replaceFirst("(\\d)[\\+\\-\\*\\/]", "$1,").split(",");
        BigDecimal number1=new BigDecimal(number[0]);
        BigDecimal number2=new BigDecimal(number[1]);
        BigDecimal result=null;

        String operator=exp.replaceFirst("^.*\\d([\\+\\-\\*\\/]).+$", "$1");
        if("+".equals(operator)){
            result=number1.add(number2);
        }else if("-".equals(operator)){
            result=number1.subtract(number2);
        }else if("*".equals(operator)){
            result=number1.multiply(number2);
        }else if("/".equals(operator)){
            result=number1.divide(number2);
        }

        return result!=null?result.toString():null;
    }
}
