package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 假设从浏览器依次下载若干个文件，保存到本地硬盘的同一个目录（初始目录为空）
 需要对文件名进行处理，规则如下：
 如果已存在同名文件，则后面生成的文件名添加后缀(k)，其中k为从2开始递增的整数，
 表示该文件名已出现的次数（含本次）
 如果无同名文件，则文件名保持不变
 样例1
 输入 ["myfile","yourfile","myfile","myfile"]
 输出 ["myfile","yourfile","myfile(2)","myfile(3)"]
 * @since 2024/5/28
 */
public class GenerateFileName {
    public static List<String> generateFileName(List<String> fileNames) {
        Map<String, Integer> countMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String fileName : fileNames) {
            if (countMap.containsKey(fileName)) {
                int count = countMap.get(fileName);
                countMap.put(fileName, count + 1);
                result.add(fileName + "(" + (count + 1) + ")");
            } else {
                countMap.put(fileName, 1);
                result.add(fileName);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            String[] fileName = cin.nextLine().trim().split(",");
            List<String> fileNames = new ArrayList<>();
            Collections.addAll(fileNames, fileName);
            System.out.println(generateFileName(fileNames));
        }
    }
}
