package com.xjc.study.toolutils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

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

    /**
     * @escription: 随机生成浮点数
     * @Author: XuJiuCheng
     * @Date: 2021/5/25 17:42
     * @Param:  * @param null
     * @Exception:
     * @Return: {@link null}
     */
    public static double nextDouble(final double min, final double max) {
        //保留两位小数
        DecimalFormat df = new DecimalFormat("#.00");
        if (max < min) {
            return min - max;
        }
        if (min == max) {
            return min;
        }
        return  Double.parseDouble(df.format(min + ((max - min) * new Random().nextDouble())));
    }
}
