package com.xjc.study.algorithm.workinglevel;

import java.util.LinkedList;

/**
 题目描述
 打开一个浏览器，此浏览器窗口一般具备浏览历史的特性（如上图所示），请实现如下功能：
 BrowserHistorySys(string homepage, int maxCount) — 初始化。homepage作为当前页，并缓存到浏览历史中；浏览历史中最多缓存maxCount个网页。
 visit(string url) — 跳转访问页面url，返回访问后浏览历史中的缓存页面数量。
 如果入参 url 仍是当前页，则继续浏览此页面，即：当前页不变，且浏览历史也不变；
 如果入参 url 不是当前页，则跳转到此 url，并把此 url 页面作为当前页； 同时清除浏览历史中原当前页的前进记录，再将此 url 缓存到浏览历史中
 当前页为：google.com，此时跳转访问mails.huawei.com，则：
 - 清除前进记录
 - 跳转访问 mails.huawei.com
 - 当前页变为 mails.huawei.com
 - 最新当前页进入缓存浏览历史
 如果新增缓存后，浏览历史缓存页面数量超过 maxCount, 则清除浏览历史中最早的记录。
 back() — 在浏览历史中从当前页后退一步，返回停留页面的 url，并作为当前页。
 注：如果已退无可退，则不再后退，继续停留在当前页。
 forward() — 在浏览历史中从当前页前进一步，返回停留页面的 url，并作为当前页。
 注：如果已进无可进，则不再前进，继续停留在当前页。

 样例
 输入样例 1
 BrowserHistorySys("w3.huawei.com", 10)
 visit("google.com")
 back()
 forward()
 forward()
 visit("baidu.com")
 visit("youtube.com")
 back()
 visit("baidu.com")
 back()
 visit("mails.huawei.com")
 输出样例 1
 null
 2
 "w3.huawei.com"
 "google.com"
 "google.com"
 3
 4
 "baidu.com"
 4
 "google.com"
 3
 *
 * @author x30057190
 * @since 2024/6/19
 */
public class BrowserHistorySys {
    LinkedList<String> hisStack;    //当前栈
    LinkedList<String> forwardStack;    //前进栈
    int max;    //缓存页面最大数量

    public BrowserHistorySys(String homepage, int maxCount) {
        hisStack = new LinkedList<>();
        forwardStack = new LinkedList<>();
        hisStack.add(homepage);
        max = maxCount;
    }

    public int visit(String url) {
        // 判断访问的页面是不是当前页
        if (!hisStack.peekFirst().equals(url)) {
            // 不是当前页，则删除前进栈的记录，缓存新页面
            forwardStack.clear();
            hisStack.addFirst(url);
        }
        // 判断当前栈页面的数量是否超过最大值
        if (hisStack.size() > max) {
            hisStack.pollLast();
        }
        // 返回缓存中的页面数量（两个栈数量相加）
        return hisStack.size() + forwardStack.size();
    }

    public String back() {
        // 回退操作(判断能否回退)
        if (hisStack.size() > 1) {
            // 能回退，则弹出第一个，加入前进栈中
            forwardStack.addFirst(hisStack.pollFirst());
        }
        // 返回当前栈的第一个url
        return hisStack.peekFirst();
    }

    public String forward() {
        // 判断能否前进
        if (!forwardStack.isEmpty()) {
            // 能前进
            hisStack.addFirst(forwardStack.pollFirst());
        }
        // 返回当前页面
        return hisStack.peekFirst();
    }
}
