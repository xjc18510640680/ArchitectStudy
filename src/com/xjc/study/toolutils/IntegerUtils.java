package com.xjc.study.toolutils;

/**
 * Description: TODO
 *
 * @title: IntegerUtils
 * Created by 19040838 on 2020.12.02 17:42
 */
public class IntegerUtils {

    /**
     * @Description  随机生成minValue~maxValue之间的数
     * @Author 19040838
     * @Date 2020.12.02 17:44
     **/
    public static int generatorInt(int minValue, int maxValue) {
        return (int)(Math.random() + minValue) + (int)((maxValue - minValue) * Math.random());
    }
}
