package com.xjc.study.collection;

import java.util.Objects;

/**
 * @author: XuJiuCheng
 * @date: Created in 10:13 2021/7/19
 * @description:
 */
public enum AfterSaleDetailTagEnum {

    /**
     * 2的10次方-当前明细商品品牌是否已买断
     */
    BRAND_IS_BUYOUT(1024L,"当前品牌已买断"),
    ZYCS(2048L,"自营厂送商品标")

    ;

    /**
     * 处理类型
     */
    private Long code;

    /**
     * 处理类型描述
     */
    private String message;

    AfterSaleDetailTagEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据枚举code获取枚举名称
     *
     * @param code
     * @return
     */
    public static String getValueByCode(Long code) {
        if (code == null) {
            return "";
        }
        for (AfterSaleDetailTagEnum e : values()) {
            if (e.equalEnum(code)) {
                return e.getMessage();
            }
        }
        return "";
    }

    /**
     * 判断某个标识位是否存在
     * @param tagNum
     * @param afterSaleDetailTagEnum
     * @return
     */
    public static boolean judgeContainTheTag(Long tagNum, AfterSaleDetailTagEnum afterSaleDetailTagEnum) {

        if(null == tagNum || null == afterSaleDetailTagEnum) {
            return false ;
        }

        if((tagNum & afterSaleDetailTagEnum.getCode()) > 0) {
            return true ;
        }

        return false ;
    }

    /**
     * 判断是否相等
     *
     * @param code
     * @return
     */
    public boolean equalEnum(Long code) {
        if (code == null) {
            return false;
        }
        return Objects.equals(this.code, code);
    }

    /**
     * 判断是否相等
     *
     * @param code
     * @return
     */
    public boolean equalEnum(String code) {
        if (code == null) {
            return false;
        }
        return this.code.toString().equals(code);
    }

    /**
     * 判断订单标记
     *
     * @param confirmTag 目标订单类型
     * @param orderTag   订单类型
     * @return
     */
    public static boolean isTagOrder(Long confirmTag, Long orderTag) {
        if (confirmTag == null || orderTag == null) {
            return false;
        }
        if ((confirmTag & orderTag) > 0) {
            return true;
        }
        return false;
    }


    public Long getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}

