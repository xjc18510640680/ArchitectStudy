package com.xjc.study.algorithm.medium;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1143. 【软件认证】数据库缓存：https://oj.rnd.huawei.com/problems/1143/details
 *
 * @author x30057190
 * @since 2024/5/14
 */
public class QueryDatabaseCache {
    // 参照数据
    List<Integer> idsList = new ArrayList<>();
    // 待实现函数，在此函数中填入答题代码
    private int queryDatabase(int cacheSize, int[] ids) {
        idsList = Arrays.stream(ids).boxed().collect(Collectors.toList());
        int idsLength = ids.length;
        if (idsLength <= 1) {
            return idsLength;
        }
        // 缓存存储
        List<Integer> cacheList = new LinkedList<>();
        // 数据库查询次数
        int queryDatabaseNum = 0;
        for (int i = 0; i < idsLength; i++) {
            int id = ids[i];
            if (cacheList.contains(id)) {
                continue;
            }
            // 缓存没有满
            if (cacheList.size() < cacheSize) {
                cacheList.add(id);
            } else { // 缓存满了
                int removeIndex = deleteItem(cacheList, i);
                cacheList.remove(removeIndex);
                cacheList.add(id);
            }
            queryDatabaseNum++;
        }
        return queryDatabaseNum;
    }

    private int deleteItem(List<Integer> cacheList, int index) {
        int maxIndexToDelete = 0;
        int deleteIndex = 0;
        for (int i = 0; i < cacheList.size(); i++) {
            int nextIndex = nextIndexOf(idsList, cacheList.get(i), index);
            if (nextIndex == -1) {
                return i;
            }
            if (nextIndex > maxIndexToDelete) {
                maxIndexToDelete = nextIndex;
                deleteIndex = i;
            }
        }
        return deleteIndex;
    }

    private int queryDatabase2(int cacheSize, int[] ids) {
        Map<Integer, List<Integer>> sequenceMap = new HashMap<>(ids.length);
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            if (!sequenceMap.containsKey(id)) {
                sequenceMap.put(id, new ArrayList<>());
            }
            sequenceMap.get(id).add(i);
        }
        Map<Integer, Boolean> cache = new HashMap<>(2);
        int queryDbTimes = 0;
        for (int id : ids) {
            sequenceMap.get(id).remove(0);
            if (cache.get(id) != null) {
                continue;
            }
            queryDbTimes++;
            if (cache.size() < cacheSize) {
                cache.put(id, true);
                continue;
            }
            Integer maxId = -1;
            Integer val = -1;
            for (Integer idKey : cache.keySet()) {
                if (sequenceMap.get(idKey).isEmpty()) {
                    maxId = idKey;
                    break;
                }
                if (sequenceMap.get(idKey).get(0) > val) {
                    maxId = idKey;
                    val = sequenceMap.get(idKey).get(0);
                }
            }
            cache.remove(maxId);
            cache.put(id, true);
        }
        return queryDbTimes;
    }

    public static int nextIndexOf(List<Integer> list, int num, int index) {
        if (list.lastIndexOf(num) <= index) {
            return -1;
        }
        List<Integer> subList = list.subList(index + 1,list.size());
        return index + 1 + subList.indexOf(num);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int size = cin.nextInt();
        int length = cin.nextInt();
        int[] ids = new int[length];
        for (int i = 0; i < length; i++) {
            ids[i] = cin.nextInt();
        }
        cin.close();
        int maxSum = new QueryDatabaseCache().queryDatabase(size, ids);
        System.out.println(maxSum);
        System.out.println(new QueryDatabaseCache().queryDatabase2(size, ids));
    }
}
