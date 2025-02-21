package com.xjc.study.algorithm.workinglevel;

import java.util.*;

/**
 * AssetsSystem
简易资产管理系统
 请设计一个资产管理系统，支持资产增加、借用、归还、统计的功能。每个资产编号都是全局唯一的
 AssetsSystem()-系统初始化
 addAssets(int assetsId)-线系统中增加一个编号为 assetsId 的资产，如果资产已经存在则直接返回0；
 否则增加成功并返回1.
 borrowAssets(int employeeId, int assetsId)-员工 employeeId 解用资产 assetsId：
    如果资产不存在，则直接返回-1
    如果资产被借用、且为归还，则直接返回0；
    如果资产未被借用，则成功借用并返回1
 returnAssets(int assetsId)-归还资产 assetsId
    如果资产不存在，则直接返回-1
    如果资产未被任何人借用，则直接返回0
    否则成功归还，并返回1
 statAssets(int topNum)-统计当前系统内有借用、且未归还的借用人，并按如下规则返回 topNum 个借用人的 employeeId 和未归还资产的数量
    优先按未归还的数量从大到小排序；若数量相同，再按借用人的 employeeId 从小到大排序
    如果人数不足 topNum ，则按实际人数返回；如果实际人数为0，返回空数组[]
 样例1
 输入
 new AssetsSystem();
 addAssets(1812);
 borrowAssets(99527, 1812);
 addAssets(1812);
 statAssets(2);
 returnAssets(1812);
 输出
 null
 1
 1
 0
 [[99527,1]]
 1
 样例2
 输入
 AssetsSystem();
 addAssets(6789);
 borrowAssets(41336, 6789);
 addAssets(1234);
 addAssets(2345);
 borrowAssets(99527, 1234);
 borrowAssets(99527, 2345);
 statAssets(2);
 returnAssets(2345);
 statAssets(2);
 returnAssets(555);
 输出
 null
 1
 1
 1
 1
 1
 1
 [[99527, 2], [41336, 1]]
 1
 [[41336, 1], [99527, 1]]
 -1
 * @author x30057190
 * @since 2024/5/23
 */
public class AssetsSystem {

    private static List<Map<Integer, Integer>> assetsList = new ArrayList<>();

    private static final List<Map<Integer, Integer>> employeeList = new ArrayList<>();

    AssetsSystem() {
        System.out.println("null");
    }

    static int addAssets(int assetsId) {
        if (assetsList == null) {
            assetsList = new ArrayList<>();
        }
        for (Map<Integer, Integer> map : assetsList) {
            if (map.containsKey(assetsId)) {
                return 0;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(assetsId, 1);
        assetsList.add(map);
        return 1;
    }

    static int borrowAssets(int employeeId, int assetsId) {
        for (Map<Integer, Integer> map : assetsList) {
            if (!map.containsKey(assetsId)) {
                continue;
            }
            int status = map.get(assetsId);
            if (status == 1) {
                map.put(assetsId, 0);
                Map<Integer, Integer> employeeMap = new HashMap<>();
                employeeMap.put(employeeId, assetsId);
                employeeList.add(employeeMap);
                return 1;
            }
            if (status == 0) {
                return 0;
            }
        }
        return -1;
    }

    static int returnAssets(int assetsId) {
        for (Map<Integer, Integer> map : assetsList) {
            if (!map.containsKey(assetsId)) {
                continue;
            }
            int status = map.get(assetsId);
            if (status == 1) {
                return 0;
            }
            if (status == 0) {
                map.put(assetsId, 1);
                for (Map<Integer, Integer> employeeMap : new ArrayList<>(employeeList)) {
                    if (employeeMap.containsValue(assetsId)) {
                        employeeList.remove(employeeMap);
                        break;
                    }
                }
                return 1;
            }
        }
        return -1;
    }


    static int[][] statAssets(int topNum) {
        if (employeeList == null || employeeList.isEmpty()) {
            return new int[0][2];
        }

        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> tempMap = new HashMap<>();

        for (Map<Integer, Integer> map : employeeList) {
            int key = map.keySet().iterator().next();
            int sum = tempMap.containsKey(key) ? 1 + tempMap.get(key) : 1;
            tempMap.put(key, sum);

            boolean found = false;
            for (int[] temp : list) {
                if (temp[0] == key) {
                    temp[1] = sum;
                    found = true;
                    break;
                }
            }

            if (!found) {
                list.add(new int[] {key, sum});
            }
        }

        list.sort((o1, o2) -> {
            int cmp = o2[1] - o1[1];
            if (cmp == 0) {
                return o1[0] - o2[0];
            }
            return cmp;
        });

        if (list.size() > topNum) {
            list.subList(topNum, list.size()).clear();
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }

        if (list.size() < topNum) {
            res = Arrays.copyOf(res, list.size());
        }

        return res;
    }

    public static void main(String[] args) {
        new AssetsSystem();

        System.out.println(addAssets(1812));
        System.out.println(borrowAssets(99527, 1812));
        System.out.println(addAssets(1812));
        System.out.println(Arrays.deepToString(statAssets(2)));
        System.out.println(returnAssets(1812));

        // System.out.println(addAssets(6789));
        // System.out.println(borrowAssets(41336, 6789));
        // System.out.println(addAssets(1234));
        // System.out.println(addAssets(2345));
        // System.out.println(borrowAssets(99527, 1234));
        // System.out.println(borrowAssets(99527, 2345));
        // System.out.println(Arrays.deepToString(statAssets(2)));
        // System.out.println(returnAssets(2345));
        // System.out.println(Arrays.deepToString(statAssets(2)));
        // System.out.println(returnAssets(555));
    }
}
