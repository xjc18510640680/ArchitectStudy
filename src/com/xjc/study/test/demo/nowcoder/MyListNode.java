package com.xjc.study.test.demo.nowcoder;

public class MyListNode {
 
    public static ListNode head;
    public static ListNode current;
 
    public static void add(int data) {
        //如果头结点为空,为头结点
        if(head == null) {
            head = new ListNode(data);
            current = head;
        } else {
            current.next = new ListNode(data);
            current = current.next;
        }
    }
 
    //打印链表
    public static void print(ListNode node) {
        if(node == null) {
            return;
        }
        current = node;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
 
    // 初始化链表,并且返回表头
    public static ListNode init(int size) {
        for(int i = 1; i < size; i++) {
            add(i);
        }
        return head;
    }
 
    //求链表长度
    public static int size(ListNode head) {
        if (head == null) {
            return -1;
        }
        int length = 0;
        current = head;
        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}