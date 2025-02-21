/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.xjc.study.algorithm.workinglevel;

import java.util.ArrayList;
import java.util.List;

/**
 编程语言包管理系统
 某编程语言包管理系统遵循严格的语义化版本控制规则，版本号由多段组成
 格式为：x.y.z，其中x、y、z分别表示：主版本、次版本、补丁版本
 版本比较时三段优先级依次降低。
 注：主版本号和次版本号始终存在；而补丁版本号可以省略，默认为0 如：1.2等于1.2.0
 给定一系列的版本包的信息versions，格式versions[i]=[当前版本，新版本]
 请按以下版本升级规则处理最后返回能够从当前版本升级到新版本的包的个数
 版本审计规则：升级前后首个非零字段及之前的段保持不变，且新版本大于当前版本
 1.0.22的首个非零字段是1，可升级到大于 1.0.22 且小于 2.0.0的任何版本
 0.3的首个非零字段是3，可升级到大于 0.3.0 且小于 0.4.0 的任何版本

 样例
 输入 [["0.1.12","0.1.14"],["4.0","4.0.1"],["6.5","6.6"],["0.2","0.2.0"]]
 输出 3
 *
 * @author x30057190
 * @since 2024-06-19 19:04
 */
public class UpdateVersionPair {
    public static void main(String[] args) {
        List<VersionPair> versions = new ArrayList<>();
        VersionPair versionPair = new VersionPair();
        versionPair.curVersion = "0.1.12";
        versionPair.newVersion = "0.1.14";
        versions.add(versionPair);
        VersionPair versionPair1 = new VersionPair();
        versionPair1.curVersion = "4.0";
        versionPair1.newVersion = "4.0.1";
        versions.add(versionPair1);
        VersionPair versionPair2 = new VersionPair();
        versionPair2.curVersion = "6.5";
        versionPair2.newVersion = "6.6";
        versions.add(versionPair2);
        VersionPair versionPair3 = new VersionPair();
        versionPair3.curVersion = "0.2";
        versionPair3.newVersion = "0.2.0";
        versions.add(versionPair3);
//        VersionPair versionPair = new VersionPair();
//        versionPair.curVersion = "0.2";
//        versionPair.newVersion = "1.2.1";
//        versions.add(versionPair);
//        VersionPair versionPair1 = new VersionPair();
//        versionPair1.curVersion = "0.2";
//        versionPair1.newVersion = "0.3.0";
//        versions.add(versionPair1);
//        VersionPair versionPair2 = new VersionPair();
//        versionPair2.curVersion = "6.5";
//        versionPair2.newVersion = "7.5";
//        versions.add(versionPair2);
//        VersionPair versionPair3 = new VersionPair();
//        versionPair3.curVersion = "3.9.4";
//        versionPair3.newVersion = "3.9.4";
//        versions.add(versionPair3);

        System.out.println(upgradeCnt(versions));
    }
    public static int upgradeCnt(List<VersionPair> versions) {

        int count = 0;
        for (VersionPair versionPair : versions) {
            String currentVersion = versionPair.curVersion;
            String newVersion = versionPair.newVersion;
            String[] currentVersionParts = currentVersion.split("\\.");
            String[] newVersionParts = newVersion.split("\\.");
            if (currentVersionParts.length > newVersionParts.length) {
                newVersion = newVersion + ".0";
                newVersionParts = newVersion.split("\\.");
            }
            if (currentVersionParts.length < newVersionParts.length) {
                currentVersion = currentVersion + ".0";
                currentVersionParts = currentVersion.split("\\.");
            }
            int partIndex = 0;
            while (partIndex < currentVersionParts.length && partIndex < newVersionParts.length) {
                if (Integer.parseInt(currentVersionParts[partIndex]) == Integer.parseInt(newVersionParts[partIndex])) {
                    partIndex++;
                    continue;
                }
                if (Integer.parseInt(currentVersionParts[0]) != Integer.parseInt(newVersionParts[0])) {
                    break;
                }
                if (Integer.parseInt(currentVersionParts[0]) == 0 && Integer.parseInt(newVersionParts[0]) == 0
                        && Integer.parseInt(currentVersionParts[1]) != Integer.parseInt(newVersionParts[1])) {
                    break;
                }
                if (Integer.parseInt(currentVersionParts[partIndex]) < Integer.parseInt(newVersionParts[partIndex])) {
                    count++;
                    break;
                }
                break;
            }
        }
        return count;
    }
}
class VersionPair {
    String curVersion;
    String newVersion;
    public String toString() {
        return String.format(java.util.Locale.ROOT, "[\"%s\", \"%s\"]", curVersion, newVersion);
    }
}
