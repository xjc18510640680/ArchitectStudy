package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1189. 【软件认证】删除指定目录:https://oj.rnd.huawei.com/problems/1189/details
 *
 * @author x30057190
 * @since 2024/5/18
 */
public class DeleteSpecifiedDirectory {

    static class FileNone {
        String name;
        int grade;
        FileNone(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

    }

    // 待实现函数，在此函数中填入答题代码
    private static int delDirectorys(String delDirNameBunch, String[] dirTreeLines) {
        String[] deleteFileNames = delDirNameBunch.split(" ");
        HashSet<String> deleteFileName = new HashSet<>();
        LinkedList<FileNone> fileList = new LinkedList<>();
        Collections.addAll(deleteFileName, deleteFileNames);
        for (String temp : dirTreeLines) {
            String[] split = temp.split("\\|-");
            int grade = split.length - 1;
            String fileName = split[grade];
            fileList.addLast(new FileNone(fileName, grade));
        }
        int before = fileList.size();
        int len = 0;
        while (len != fileList.size()) {
            len = fileList.size();
            for (int i = 0; i < fileList.size(); i++) {
                if (deleteFileName.contains(fileList.get(i).name) && (i == fileList.size() - 1
                    || fileList.get(i).grade >= fileList.get(i + 1).grade)) {
                    fileList.remove(fileList.get(i));
                    i--;
                }
            }
        }
        return before - len;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String delDirNameBunch = cin.nextLine();
        int num = cin.nextInt();
        cin.nextLine();
        String[] dirTreeLines = new String[num];
        for (int i = 0; i < num; i++) {
            dirTreeLines[i] = cin.nextLine();
        }
        cin.close();
        int result = delDirectorys(delDirNameBunch, dirTreeLines);
        System.out.println(result);
    }
}
