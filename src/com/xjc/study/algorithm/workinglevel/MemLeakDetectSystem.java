package com.xjc.study.algorithm.workinglevel;

import java.util.List;

/**
 简易内存泄漏检测程序
 请设计一个工具，产品代码中的内存申请、释放向该工具登记信息，
 收集的信息可用于辅助分析产品潜在的内存泄漏风险。需实现的接口如下：
    MemleakDetectSystem() -- 初始化
    onMemoryAlloced(int memAddr, int size, String filename, int line) -- 产品运行中，代码每次
        申请内存后，同步在工具中登记，登记信息：在代码文件filename第line行分配了一小段为size字节的内存，内存首地址为memAddr
    onMemoryFreed(int memAddr) -- 产品运行中，每次释放内存后，同步在工具中去除登记，即释放首地址为memAddr的内存
        如果次首地址已登记过，去除登记信息，并返回0；否则返回-1
    statLeakInfo(int topNum) -- 工具统计并返回当前的topNum个内存泄漏风险点（格式为[文件名，行号，字节总数和]）；
        若数量不足topNum，按实际数量返回：
        只要某内存被分配但尚未被释放，则把申请该内存的代码位置（文件名和行号）识别为一个[泄漏风险点]
        字节数总和：同一个[泄漏风险点]的多次分配但尚未释放的内存size之和
        优先按字节数总和从大到小排序；若字节数总和相同，再按文件名字典序升序排序；若文件名也相同，按行号升序排序。
 注意：memAddr在释放之前全局唯一，释放后可以被重用，同一个文件相同行可能会多次申请内存
 样例1
 输入
 MemLeakDetectSystem()
 onMemoryAlloced(12345678, 100, "nbbmmgr.c", 1948)
 onMemoryFreed(12345678)
 onMemoryAlloced(12345678, 200, "nbbmmgr.c", 1948)
 onMemoryAlloced(12346999, 300, "nbbmmgr.c", 1948)
 onMemoryAlloced(11223344, 400, "util.c", 1999)
 statLeakInfo(2)
 输出
 null
 null
 0
 null
 null
 null
 [["nbbmmgr.c", 1948, 500], ["util.c", 1999, 400]]
 样例2
 输入
 MemLeakDetectSystem()
 onMemoryAlloced(11223344, 200, "nbbmmgr.c", 1948)
 onMemoryFreed(11223344)
 statLeakInfo(2)
 onMemoryAlloced(12345678, 300, "crc64.c", 1995)
 onMemoryAlloced(11225000, 50, "crc64.c", 1995)
 onMemoryFreed(11223344)
 onMemoryAlloced(11223344, 400, "util.c", 1999)
 onMemoryAlloced(11230000, 400, "monitor.c", 1999)
 onMemoryAlloced(11240000, 400, "monitor.c", 1995)
 statLeakInfo(1)
 statLeakInfo(6)
 onMemoryFreed(12345699)
 输出
 null
 null
 0
 []
 null
 null
 -1
 null
 null
 null
 [["monitor.c", 1995, 400]]
 [["monitor.c", 1995, 400], ["monitor.c", 1999, 400], ["util.c", 1999, 400], ["crc64.c", 1995, 350]]
 -1
 * @author x30057190
 * @since 2024/9/14
 */
public class MemLeakDetectSystem {

    MemLeakDetectSystem() {

    }
    void onMemoryAlloced(int memAddr, int size, String filename, int line) {

    }
    int onMemoryFreed(int memAddr) {
        return 0;
    }
    List<RiskPoint> statLeakInfo(int topNum) {
        return List.of();
    }
}

class RiskPoint {
    String filename;
    int line;
    int total;
    public String toString() {
        return String.format(java.util.Locale.ROOT, "[\"%s\", %d, %d]", filename, line, total);
    }
}