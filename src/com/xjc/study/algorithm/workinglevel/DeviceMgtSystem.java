package com.xjc.study.algorithm.workinglevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 统计进程管理的设备
 一款设备管理软件系统，管理的设备类型 deviceType 共有无线、数通、接入3 种类型（值分别为1、2、3），针对每种类型的设备都有一个进程组进行管理（编号对应也为1、2、3）。
 每个进程组均有procNum 个进程（进程 procId 从 0 开始依次编号）；每个进程可管理多个设备，进程的内存资源上限均为 maxMemSize，每新增管理一个设备都会消耗某进程的内存资源。请完成该系统如下功能：
 DeviceMgtSystem(int procNum, int maxMemSize)—初始化：每个进程组创建procNum个进程，每个进程的内存上限为maxMemSize。
 createDevice(int deviceId, int deviceType, int memSize)—在 deviceType 对应进程组内，按「负载均衡规则」选择一个进程，
    创建设备 deviceId 进行管理，内存消耗为 memSize，创建成功返回所在进程编号；当对应进程组内所有进程的剩余内存资源都不足时，则创建失败，返回 -1 。
 「负载均衡规则」：优先选择空闲内存较多的进程；若空闲内存相同，则选择编号较小者。
 注意：用例保证每次传入的 deviceId 均不同。
 deleteDevice(int deviceId)—删除设备 deviceId 。若存在该设备，则删除成功、释放内存，并返回 true；否则返回 false。
 queryDevice(int deviceType)—返回 deviceType 对应进程组内所有设备信息的列表（或为空列表 []）：
 设备信息格式：[deviceId, memSize, procId]。
 返回顺序：优先按设备所消耗的内存 memSize 降序；若有相同按设备所在的进程 procId 升序；若还有相同按 deviceId 升序。
 输入
 每行表示一个函数调用，初始化函数仅首行调用一次，累计函数调用不超过 1000 次。
 1 <= procNum <= 5, 100 <= maxMemSize <= 1000
 1 <= deviceType <= 3, 1 <= memSize <= 100, 1 <= deviceId <= 1000
 输出
 答题时按照函数/方法原型中的要求（含返回值）进行实现，输出由框架完成（其中首行固定输出 null）
 样例1
 复制输入：
 DeviceMgtSystem(2, 200)
 createDevice(8, 1, 50)
 createDevice(12, 1, 30)
 createDevice(3, 1, 30)
 queryDevice(1)
 createDevice(15, 1, 30)
 queryDevice(1)
 deleteDevice(10)
 复制输出：
 null
 0
 1
 1
 [[8, 50, 0], [3, 30, 1], [12, 30, 1]]
 0
 [[8, 50, 0], [15, 30, 0], [3, 30, 1], [12, 30, 1]]
 false
 解释：
 DeviceMgtSystem(2, 200) // 初始化，每个进程组的进程数有 2 个，每个进程的内存上限为 200
 createDevice(8, 1, 50) // 创建设备 8，设备类型为 1，消耗内存 50。在进程组 1 中，按负载均衡规则，选择在进程 0 创建，返回 0
 createDevice(12, 1, 30) // 在进程组 1 的进程 1 上创建，返回 1
 createDevice(3, 1, 30) // 在进程组 1 中选择空闲内存多的进程 1 上创建，返回 1
 queryDevice(1) // 按设备消耗的内存降序，设备 8 排在前面；之后是设备12、3，两个设备都在进程 1 上，再按设备id升序，所以设备 3 排在前面。
 // 最后输出 [[8, 50, 0], [3, 30, 1], [12, 30, 1]]
 createDevice(15, 1, 30) // 在进程组 1 的进程 0 上创建，返回 0
 queryDevice(1) // 设备 8 的消耗的内存最多，排在最前；设备 3、12、15 消耗的内存相同，由于设备 15 所在进程号为 0，排在设备3、12前面，最后输出 [[8, 50, 0], [15, 30, 0], [3, 30, 1], [12, 30, 1]]
 deleteDevice(10) // 删除设备 10，设备不存在，返回false。

 样例2
 复制输入：
 DeviceMgtSystem(2, 100)
 createDevice(18, 2, 50)
 createDevice(3, 2, 30)
 createDevice(12, 2, 20)
 queryDevice(1)
 queryDevice(2)
 createDevice(15, 1, 40)
 createDevice(6, 2, 30)
 createDevice(19, 2, 60)
 deleteDevice(18)
 createDevice(26, 2, 70)
 queryDevice(1)
 queryDevice(2)
 复制输出：
 null
 0
 1
 1
 []
 [[18, 50, 0], [3, 30, 1], [12, 20, 1]]
 0
 0
 -1
 true
 0
 [[15, 40, 0]]
 [[26, 70, 0], [6, 30, 0], [3, 30, 1], [12, 20, 1]]
 解释：
 DeviceMgtSystem(2, 100)
 createDevice(18, 2, 50) // 在进程组 2 的进程 0 上创建
 createDevice(3, 2, 30) // 在进程组 2 的进程 1 上创建
 createDevice(12, 2, 20) // 按负载均衡规则，在进程组 2 的进程 1 上创建
 queryDevice(1) // 未创建过设备类型 1 的设备，返回列表为空 []
 queryDevice(2)
 createDevice(15, 1, 40) // 在进程组 1 的进程 0 上创建
 createDevice(6, 2, 30) // 进程组 2 的进程0、1空闲内存相同，按负载均衡规则，在进程 0 上创建
 createDevice(19, 2, 60) // 进程组 2 的进程 0 空闲内存为 20，进程 1 空闲内存为 50，资源均不足，创建失败，返回 -1
 deleteDevice(18) // 删除后，进程组 2 的进程 0 空闲内存为 70，进程 1 空闲内存为 50
 createDevice(26, 2, 70) // 进程组 2 的进程 0 的空闲内存刚好够用，创建成功
 queryDevice(1)
 queryDevice(2)
 */


public class DeviceMgtSystem {
    //进程组集合
    List<Process[]> processes;
    //map的key:deviceId，value记录设备的地址信息:{设备类型，进程号}，
    HashMap<Integer, int[]> map = new HashMap<>(); 

    /**
     * 初始化：每个进程组创建procNum个进程，每个进程的内存上限为maxMemSize
     **/
    public DeviceMgtSystem(int procNum, int maxMemSize) {
        //添加3个进程组
        processes = new ArrayList<>();
        processes.add(new Process[procNum]);
        processes.add(new Process[procNum]);
        processes.add(new Process[procNum]);
        processes.forEach(process -> {
            //为每个进程组增添相应数量的进程
            for (int i = 0; i < procNum; i++) {
                process[i] = new Process(i, maxMemSize);
            }
        });
    }

    /**
     * 在 deviceType 对应进程组内，按「负载均衡规则」选择一个进程，创建设备 deviceId 进行管理，内存消耗为 memSize，
     * 创建成功返回所在进程编号；当对应进程组内所有进程的剩余内存资源都不足时，则创建失败，返回 -1 。
     * 「负载均衡规则」：优先选择空闲内存较多的进程；若空闲内存相同，则选择编号较小者。
     * 注意：用例保证每次传入的 deviceId 均不同。
     **/
    public int createDevice(int deviceId, int deviceType, int memSize) {
        Process[] curProc = processes.get(deviceType - 1);
        int id = 0;
        int maxSize = 0;
        //遍历一遍根据负载均衡规则选出进程
        for (int i = 0; i < curProc.length; i++) {
            if (curProc[i].size > maxSize) {
                id = i;
                maxSize = curProc[i].size;
            } else if (curProc[i].size == maxSize) {
                id = Math.min(id, i);
            }
        }
        if (curProc[id].size < memSize) {
            return -1;
        }
        //将设备加入到所选进程的设备集合中
        curProc[id].devs.add(new DeviceInfo(deviceId, memSize, curProc[id].id));
        //更新进程剩余空间
        curProc[id].size -= memSize;
        //记录设备地址信息
        map.put(deviceId, new int[]{deviceType, curProc[id].id});
        return curProc[id].id;
    }

    /**
     * 删除设备 deviceId 。若存在该设备，则删除成功、释放内存，并返回 true；否则返回 false。
     **/
    public boolean deleteDevice(int deviceId) {
        if (!map.containsKey(deviceId)) {
            return false;
        }
        //获取设备的地址信息
        int[] index = map.get(deviceId);
        //得到响应的进程组
        Process[] curProc = processes.get(index[0] - 1);
        for (Process process : curProc) {
            //遍历进程组找到map记录的进程
            if (process.id == index[1]) {
                for (int j = 0; j < process.devs.size(); j++) {
                    //遍历进程根据地址信息找到含有设备的进程
                    if (process.devs.get(j).deviceId == deviceId) {
                        DeviceInfo de = process.devs.remove(j); //从对应的集合中删除
                        process.size += de.memSize; //归还空间
                        map.remove(deviceId); //删除地址信息记录
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 返回 deviceType 对应进程组内所有设备信息的列表（或为空列表 []）：
     * 设备信息格式：[deviceId, memSize, procId]。
     * 返回顺序：优先按设备所消耗的内存 memSize 降序；若有相同按设备所在的进程 procId 升序；若还有相同按 deviceId 升序。
     **/
    public List<DeviceInfo> queryDevice(int deviceType) {
        Process[] curProc = processes.get(deviceType - 1);
        List<DeviceInfo> res = new ArrayList<>();
        //遍历对应的进程组，将所有设备增加到集合中
        for (Process process : curProc) {
            res.addAll(process.devs);
        }
        if (res.isEmpty()) {
            return res;
        }
        res.sort((a, b) -> {
            if (a.memSize != b.memSize) {
                return b.memSize - a.memSize;
            } else if (a.procId != b.procId) {
                return a.procId - b.procId;
            } else {
                return a.deviceId - b.deviceId;
            }
        });
        return res;
    }

    public static void main(String[] args) {
        DeviceMgtSystem dms = new DeviceMgtSystem(2, 200);
        System.out.println(dms.createDevice(8, 1, 50)); // 0
        System.out.println(dms.createDevice(12, 1, 30)); // 1
        System.out.println(dms.createDevice(3, 1, 30)); // 1
        System.out.println(dms.queryDevice(1)); // [[8, 50, 0], [3, 30, 1], [12, 30, 1]]
        System.out.println(dms.createDevice(15, 1, 30)); // 0
        System.out.println(dms.queryDevice(1)); // [[8, 50, 0], [15, 30, 0], [3, 30, 1], [12, 30, 1]]
        System.out.println(dms.deleteDevice(10)); // false
    }
}

class DeviceInfo {
    int deviceId;
    int memSize;
    int procId;
    DeviceInfo(int deviceId, int memSize, int procId) {
        this.deviceId = deviceId;
        this.memSize = memSize;
        this.procId = procId;
    }
    public String toString() {
        return String.format(Locale.ROOT, "[%d, %d, %d]", deviceId, memSize, procId);
    }
}

class Process {
    //进程id
    int id;
    //设备集合
    List<DeviceInfo> devs;
    //剩余空间
    int size;
    public Process(int id, int size) {
        this.id = id;
        this.devs = new ArrayList<>();
        this.size = size;
    }
}