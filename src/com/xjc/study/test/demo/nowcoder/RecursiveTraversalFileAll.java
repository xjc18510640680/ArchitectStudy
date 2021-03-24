package com.xjc.study.test.demo.nowcoder;

import java.io.File;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: RecursiveTraversalFileAll
 * Created by 19040838 on 2021.03.09 15:08
 */
public class RecursiveTraversalFileAll {

    public static void main(String[] args) {
        scanFile("E:\\IDEA-workspace\\ArchitectStudy\\src\\com\\xjc\\study\\test");
    }
    /**
     * 递归遍历目录下的所有文件
     * @param path 扫描路径
     */

    public static void scanFile(String path){
        File files = new File(path);
        File[] fileList = null;
        // 1.扫描路径若为目录，则将该目录下的所有文件（目录+文件）放入数组
        // 2.扫描路径若为文件，将该文件放入数组，该数组中就该文件一个元素
        if(files.isDirectory()){
            fileList = files.listFiles();
        } else if (files.isFile()){
            fileList = new File[]{files};
        }
        // 遍历数组
        for (File file : fileList) {
            if (file.isDirectory()) {
                // 递归调用
                scanFile(file.getPath());
            } else if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

}
