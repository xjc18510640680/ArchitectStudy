//package com.xjc.study.test.demo.demo20210119;
//
//import org.apache.commons.collections.MapUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Description: TODO
// *
// * @title: Demo002
// * Created by 19040838 on 2021.01.19 16:36
// */
//public class Demo002 {
//
//    private static final List<String> KEY_LIST = new ArrayList<>();
//
//    static {
//        KEY_LIST.add("depotType");
//        KEY_LIST.add("cmmdtyCode");
//        KEY_LIST.add("supplierCode");
//        KEY_LIST.add("depotCode");
//        KEY_LIST.add("storeCode");
//        KEY_LIST.add("storeTyptCode");
//    }
//
//    /**传参说明：
//     * 采购大仓单品-商品:      boxRuleType（区分采购、调拨）,depotType（区分大仓、非大仓）,cmmdtyCode（商品）
//     * 采购大仓单品-大仓:      boxRuleType,depotType,cmmdtyCode,depotCode（大仓）
//     * 采购大仓单品-供应商:    boxRuleType,depotType,cmmdtyCode,supplierCode（供应商）,depotCode
//     * 采购非大仓单品-供应商:  boxRuleType,depotType,cmmdtyCode,supplierCode
//     * 采购非大仓单品-业态:    boxRuleType,depotType,cmmdtyCode,supplierCode,storeTyptCode（业态）
//     * 采购非大仓单品-门店:    boxRuleType,depotType,cmmdtyCode,supplierCode,storeCode（门店）
//     * 采购非大仓单品-商品:    boxRuleType,depotType,cmmdtyCode
//     *
//     * 调拨-大仓:             boxRuleType,cmmdtyCode,depotCode
//     * 调拨-业态:             boxRuleType,cmmdtyCode,depotCode,storeTyptCode
//     * 调拨-门店:             boxRuleType,cmmdtyCode,depotCode,storeCode
//     **/
//    public static String getRedisKey(Map<String, Object> params) {
//        String boxRuleType = MapUtils.getString(params, "boxRuleType");
//        StringBuffer sb = new StringBuffer();
//        if (StringUtils.isEmpty(boxRuleType)) {
//            return sb.toString();
//        }
//        /**    采购redis key值拼接标准
//         *     采购大仓单品
//         *     优先级从高到低依次为： 商品+供应商+大仓 -> 商品+大仓 -> 商品
//         *     queryPoBoxRuleNew_depotType_cmmdtyCode_supplierCode_depotCode
//         *     queryPoBoxRuleNew_depotType_cmmdtyCode_depotCode
//         *     queryPoBoxRuleNew_depotType_cmmdtyCode
//         *     采购非大仓单品
//         *     优先级从高到低依次为： 商品+供应商+门店维度 -> 商品+供应商+业态维度 -> 商品+供应商 -> 商品维度
//         *     queryPoBoxRuleNew_depotType_cmmdtyCode_supplierCode_storeCode
//         *     queryPoBoxRuleNew_depotType_cmmdtyCode_supplierCode_storeTyptCode
//         *     queryPoBoxRuleNew_depotType_cmmdtyCode_supplierCode
//         *     queryPoBoxRuleNew_depotType_cmmdtyCode
//         **/
//        if ("po".equals(boxRuleType)) {
//            sb.append("queryPoBoxRuleNew");
//        }
//        /**  调拨redis key值拼接标准
//         *   商品+调出仓+门店 -> 商品+调出仓+调入业态 -> 商品+调出仓。
//         *   queryStoBoxRuleNew_cmmdtyCode_depotCode_storeCode
//         *   queryStoBoxRuleNew_cmmdtyCode_depotCode_storeTyptCode
//         *   queryStoBoxRuleNew_cmmdtyCode_depotCode
//         **/
//        if ("sto".equals(boxRuleType)){
//            sb.append("queryStoBoxRuleNew");
//        }
//        for(String key : KEY_LIST) {
//            String value = MapUtils.getString(params, key);
//            if(StringUtils.isNotEmpty(value)) {
//                sb.append("_").append(value);
//            }
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        // 采购大仓单品-商品
//        Map<String, Object> cmmdtyCodePoMap = new HashMap<>();
//        cmmdtyCodePoMap.put("boxRuleType", "po");
//        cmmdtyCodePoMap.put("depotType", "0");
//        cmmdtyCodePoMap.put("cmmdtyCode", "11597168785");
//        System.out.println("采购大仓单品-商品:"+getRedisKey(cmmdtyCodePoMap));
//        // 采购大仓单品-大仓
//        Map<String, Object> depotCodePoMap = new HashMap<>();
//        depotCodePoMap.put("boxRuleType", "po");
//        depotCodePoMap.put("depotType", "0");
//        depotCodePoMap.put("cmmdtyCode", "11597168785");
//        depotCodePoMap.put("depotCode", "D025");
//        System.out.println("采购大仓单品-大仓:"+getRedisKey(depotCodePoMap));
//        // 采购大仓单品-供应商
//        Map<String, Object> supplierCodePoMap = new HashMap<>();
//        supplierCodePoMap.put("boxRuleType", "po");
//        supplierCodePoMap.put("depotType", "0");
//        supplierCodePoMap.put("cmmdtyCode", "11597168785");
//        supplierCodePoMap.put("supplierCode", "10046179");
//        supplierCodePoMap.put("depotCode", "D025");
//        System.out.println("采购大仓单品-供应商:"+getRedisKey(supplierCodePoMap));
//        // 采购非大仓单品-供应商
//        Map<String, Object> supplierCodeUnPoMap = new HashMap<>();
//        supplierCodeUnPoMap.put("boxRuleType", "po");
//        supplierCodeUnPoMap.put("depotType", "1");
//        supplierCodeUnPoMap.put("cmmdtyCode", "11597168785");
//        supplierCodeUnPoMap.put("supplierCode", "10046179");
//        System.out.println("采购非大仓单品-供应商:"+getRedisKey(supplierCodeUnPoMap));
//        // 采购非大仓单品-业态
//        Map<String, Object> storeTypeCodeUnPoMap = new HashMap<>();
//        storeTypeCodeUnPoMap.put("boxRuleType", "po");
//        storeTypeCodeUnPoMap.put("depotType", "1");
//        storeTypeCodeUnPoMap.put("cmmdtyCode", "11597168785");
//        storeTypeCodeUnPoMap.put("supplierCode", "10046179");
//        storeTypeCodeUnPoMap.put("storeTyptCode", "20");
//        System.out.println("采购非大仓单品-业态:"+getRedisKey(storeTypeCodeUnPoMap));
//        // 采购非大仓单品-门店
//        Map<String, Object> storeCodeUnPoMap = new HashMap<>();
//        storeCodeUnPoMap.put("boxRuleType", "po");
//        storeCodeUnPoMap.put("depotType", "1");
//        storeCodeUnPoMap.put("cmmdtyCode", "11597168785");
//        storeCodeUnPoMap.put("supplierCode", "10046179");
//        storeCodeUnPoMap.put("storeCode", "7610");
//        System.out.println("采购非大仓单品-门店:"+getRedisKey(storeCodeUnPoMap));
//        // 采购非大仓单品-商品
//        Map<String, Object> cmmdtyCodeUnPoMap = new HashMap<>();
//        cmmdtyCodeUnPoMap.put("boxRuleType", "po");
//        cmmdtyCodeUnPoMap.put("depotType", "1");
//        cmmdtyCodeUnPoMap.put("cmmdtyCode", "11597168785");
//        System.out.println("采购非大仓单品-商品:"+getRedisKey(cmmdtyCodeUnPoMap));
//        // 调拨-大仓
//        Map<String, Object> depotCodeStoMap = new HashMap<>();
//        depotCodeStoMap.put("boxRuleType", "sto");
//        depotCodeStoMap.put("cmmdtyCode", "11597168785");
//        depotCodeStoMap.put("depotCode", "70NX");
//        System.out.println("调拨-大仓:"+getRedisKey(depotCodeStoMap));
//        // 调拨-业态
//        Map<String, Object> storeTypeCodeStoMap = new HashMap<>();
//        storeTypeCodeStoMap.put("boxRuleType", "sto");
//        storeTypeCodeStoMap.put("cmmdtyCode", "11597168785");
//        storeTypeCodeStoMap.put("depotCode", "70NX");
//        storeTypeCodeStoMap.put("storeTyptCode", "23");
//        System.out.println("调拨-业态:"+getRedisKey(storeTypeCodeStoMap));
//        // 调拨-门店
//        Map<String, Object> storeCodeStoMap = new HashMap<>();
//        storeCodeStoMap.put("boxRuleType", "sto");
//        storeCodeStoMap.put("cmmdtyCode", "11597168785");
//        storeCodeStoMap.put("depotCode", "70NX");
//        storeCodeStoMap.put("storeCode", "D025");
//        System.out.println("调拨-门店:"+getRedisKey(storeCodeStoMap));
//    }
//}
