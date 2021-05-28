package com.xjc.study.toolutils;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;

/**
 * @Description: Map和Bean互相转化
 * @Author: XuJiuCheng
 * @Date: 2021/5/28 14:45
 */
public class ConvertUtils {

    /**
     * @escription: 将 Map对象转化为JavaBean
     * @Author: XuJiuCheng
     * @Date: 2021/5/28 14:46
     * @Param:  * @param null
     * @Exception:
     * @Return: {@link null}
     */
    public static <T> T convertMapTOBean(Map<String, Object> map, Class<T> T){
        if (map == null || map.size() == 0) {
            return null;
        }
        T bean = null;
        try {
            // 获取map中所有的key值，全部更新成大写，添加到keys集合中
            Object mvalue = null;
            Map<String, Object> newMap = new HashMap<>();
            Iterator<Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                mvalue = map.get(key);
                newMap.put(key.toUpperCase(Locale.US), mvalue);
            }

            BeanInfo beanInfo = Introspector.getBeanInfo(T);
            bean = T.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0, n = propertyDescriptors.length; i < n; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                String upperPropertyName = propertyName.toUpperCase();

                if (newMap.keySet().contains(upperPropertyName)) {
                    Object value = newMap.get(upperPropertyName);
                    // 这个方法不会报参数类型不匹配的错误。
                    BeanUtils.copyProperty(bean, propertyName, value);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return bean;
    }

    /**
     * @escription: 实体类转换为Map对象
     * @Author: XuJiuCheng
     * @Date: 2021/5/28 14:46
     * @Param:  * @param null
     * @Exception:
     * @Return: {@link null}
     */
    @SuppressWarnings("rawtypes")
	public static Map<String, Object> convertObjToMap(Object obj){
        Map<String, Object> reMap = new HashMap<String, Object>();
        if (obj == null){
            return null;
        }
        List<Field> fields = new ArrayList<Field>();
        List<Field> childFields;
        List<String> fieldsName = new ArrayList<String>();
        Class tempClass = obj.getClass();
        // 当父类为null的时候说明到达了最上层的父类(Object类).
        while (tempClass != null) {
            fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }
        childFields = Arrays.asList(obj.getClass().getDeclaredFields());
        for (Field field : childFields) {
            fieldsName.add(field.getName());
        }
        try {
            // 循环转换
            for (Field field : fields) {
                if (fieldsName.contains(field.getName())) {
                    Field f = obj.getClass().getDeclaredField(field.getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(field.getName(), o);
                } else {
                    // 获取父类字段
                    Field f = obj.getClass().getSuperclass().getDeclaredField(field.getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(field.getName(), o);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return reMap;
    }
}
