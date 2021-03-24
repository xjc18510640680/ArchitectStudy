package com.xjc.study.test.demo.nowcoder;


import java.util.HashSet;
import java.util.Set;

/**
 * Description: TODO
 *
 * @title: LinkedTest
 * Created by 19040838 on 2021.03.19 15:34
 */
public class LinkedTest {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}