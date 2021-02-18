package com.xjc.study.toolutils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description: 日期工具类
 * @author 19040838
 * @title: DateUtils
 * Created by 19040838 on 2021.02.10 9:48
 */
public class DateUtils {

    private static final Calendar CALE = Calendar.getInstance();

    /**
     * dateFormat--返回的字符串日期的格式
     * 例如：yyyy-MM-dd hh:mm:ss或yyyy/MM/dd hh:mm:ss
     **/
    public static String getNowDate (String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(new Date());
    }

    /**
     * 获取当前月第一天
     **/
    public static String getFirstDayOfMonth() {
        caleSet(0, 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(CALE.getTime());
    }

    /**
     * 获取当前月最后一天
     **/
    public static String getLastDayOfMonth() {
        caleSet(1, 0);
        return new SimpleDateFormat("yyyy-MM-dd").format(CALE.getTime());
    }

    private static void caleSet(int calendarMonth, int calendarDayOfMonth) {
        CALE.add(Calendar.MONTH, calendarMonth);
        CALE.set(Calendar.DAY_OF_MONTH, calendarDayOfMonth);
    }
}
