package com.xjc.study.test.demo.nowcoder;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: LinkedListReverse
 * Created by 19040838 on 2021.03.03 15:35
 */
public class LinkedListReverse {

    // 测试
    public static void main(String[] args) {
        ListNode listNode = MyListNode.init(6);
        MyListNode.print(listNode);
        System.out.println();
        ListNode result = reverse(listNode);
        MyListNode.print(result);
        System.out.println();
        System.out.println(MyListNode.size(result));
    }

    public static ListNode reverseList(ListNode head) {
        // 表头
        ListNode preNode = null;
        // 链表尾
        ListNode node = null;
        while (head != null) {
            // 链表头尾值互换
            node = head.next;
            head.next = preNode;
            // 链表头尾指针互换
            preNode = head;
            head = node;
        }
        return preNode;
    }

    /**
     * 递归反转：利用递归走到链表的末端，然后再更新每一个node的next 值
     **/
    public static ListNode reverse(ListNode current) {
        if (current == null || current.next == null) {
            return current;
        }
        ListNode nextNode = current.next;
        current.next = null;
        ListNode reverseRest = reverse(nextNode);
        nextNode.next = current;
        return reverseRest;
    }

}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}