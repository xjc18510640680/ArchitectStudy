package com.xjc.study.test;

import com.xjc.study.toolutils.ArrayUtils;
import com.xjc.study.toolutils.ConvertUtils;
import com.xjc.study.toolutils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: TODO
 *
 * @title: Demo
 * Created by 19040838 on 2021.02.20 9:41
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        List<String> list = new ArrayList<>();
        list.add("a");
        Collection<String> collection = Collections.unmodifiableList(list);
        collection.add("b");
        System.out.println(list.size());
        ReentrantLock lock = new ReentrantLock();
    }
}