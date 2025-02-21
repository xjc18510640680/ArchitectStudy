package com.xjc.study.algorithm.workinglevel;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 部门排序
 公司hr想要分析各个研究所所在城市的主力业务分布。给定一批部门信息记录于数组departments，
 departments[i]格式为city departmentName personNum，分别带别该部门所在城市、部门名称、人数
 1、先从每个城市选取人数多最多的5个部门作为分析对象，当人数相等时优先取departmentName字典序小的
 注：不足5个部门的城市，按实际个数选取
 2、然后对于选取的结果，按格式city departmentName逐行输出。首先按city字典升序输出；同一个城市内，
 按departmentName字典升序输出
 样例1
 输入
 [["shenzhen", "ebg", 5],
 ["shenzhen", "dbg", 7],
 ["shenzhen", "cbg", 5],
 ["shenzhen", "abg", 6],
 ["shenzhen", "zbg", 5],
 ["shenzhen", "bbg", 4],
 ["beijing", "cbg", 1]]
 输出
 [["beijing", "cbg"], ["shenzhen", "abg"], ["shenzhen", "cbg"], ["shenzhen", "dbg"], ["shenzhen", "ebg"], ["shenzhen", "zbg"]]
 样例2
 输入
 [["wuhan", "appdept", 100],
 ["wuhan", "app", 100],
 ["wuhan", "cpdept", 100],
 ["wuhan", "dock", 100],
 ["wuhan", "energy", 100],
 ["wuhan", "finance", 100]]
 输出
 [["wuhan", "app"], ["wuhan", "appdept"], ["wuhan", "cpdept"], ["wuhan", "dock"], ["wuhan", "energy"]]
 *
 * @author x30057190
 * @since 2024/7/31
 */
public class DepartmentSort {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        while (cin.hasNext()) {
            List<Department> departments = new ArrayList<>();
            int groupNum = cin.nextInt();
            cin.nextLine();
            for (int i = 0; i < groupNum; i++) {
                Department department = new Department();
                String[] inputStr = cin.nextLine().split(" ");
                department.city = inputStr[0];
                department.departmentName = inputStr[1];
                department.personNum = Integer.parseInt(inputStr[2]);
                departments.add(department);
            }
            System.out.println(getTop5Department(departments));
        }
    }

    public static List<Department> getTop5Department(List<Department> departments) {
        Map<String, List<Department>> map = new TreeMap<>();
        for (Department department : departments) {
            String city = department.city;
            if (!map.containsKey(city)) {
                map.put(city, new ArrayList<>());
            }
            map.get(city).add(department);
        }

        for (String city : map.keySet()) {
            List<Department> list = map.get(city);
            list.sort((o1, o2) -> {
                int cmp = o2.personNum - o1.personNum;
                if (cmp == 0) {
                    return o1.departmentName.compareTo(o2.departmentName);
                }
                return cmp;
            });
            while (list.size() > 5) {
                list.remove(5);
            }
        }

        List<Department> result = new ArrayList<>();
        for (String city : map.keySet()) {
            result.addAll(map.get(city));
        }
        // 对result分别按照city departmentName personNum 升序排序
        result.sort((o1, o2) -> {
            int cmp = o1.city.compareTo(o2.city);
            if (cmp == 0) {
                cmp = o1.departmentName.compareTo(o2.departmentName);
            }
            return cmp;
        });
        return result;
    }
}
class Department {
    String city = null;
    String departmentName = null;
    int personNum = -1; // 返回时不需要赋值，也不会显示

    public String toString() {
        return String.format(java.util.Locale.ROOT, "[\"%s\", \"%s\"]",
            this.city, this.departmentName);
    }
}