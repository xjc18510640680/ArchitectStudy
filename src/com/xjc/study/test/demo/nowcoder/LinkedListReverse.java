package com.xjc.study.test.demo.nowcoder;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: LinkedListReverse
 * Created by 19040838 on 2021.03.03 15:35
 */
public class LinkedListReverse {

    public static void main(String[] args) {
        ListNode listNode = null;
        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode result = reverseList(listNode);
        System.out.println(result.val + " " + result.next.val + " " + result.next.next.val);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode node = null;
        while (head != null) {
            node = head.next;
            head.next = preNode;
            preNode = head;
            head = node;
        }
        return preNode;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}