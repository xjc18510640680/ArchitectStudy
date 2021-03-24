package com.xjc.study.test.demo.nowcoder;

/**
 * Description: TODO
 *  leetcde第十九题java解法——删除链表的倒数第N个节点
 * @title: LinkRemove
 * Created by 19040838 on 2021.03.08 10:42
 */
public class LinkRemove {
    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(1);
        linkNode.next = new LinkNode(2);
        linkNode.next.next = new LinkNode(3);
        linkNode.next.next.next = new LinkNode(4);
        linkNode.next.next.next.next = new LinkNode(5);
        linkNode.next.next.next.next.next = new LinkNode(6);
        System.out.println(reMove(linkNode, 2));
    }

    private static LinkNode reMove(LinkNode linkNode, int n) {
        LinkNode first = linkNode, last = linkNode;
        while (n > 0) {
            n--;
            last = last.next;
        }
        if (last == null) {
            return linkNode.next;
        }
        while (last.next != null) {
            first = first.next;
            last = last.next;
        }
        first.next = first.next.next;
        return linkNode;
    }
}
class LinkNode {
    int value;
    LinkNode next;
    LinkNode (int value) {
        this.value = value;
    }
}
