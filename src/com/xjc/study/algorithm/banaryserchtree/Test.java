package com.xjc.study.algorithm.banaryserchtree;

import java.util.Stack;

/**
 * Description: TODO
 *
 * @title: Test
 * Created by 19040838 on 2021.03.08 11:29
 */
public class Test {
    public static void main(String[] args) {
        //以数组形式生成一棵完全二叉树
        TreeNode[] node = new TreeNode[10];
        TreeNode[] node1 = new TreeNode[10];
        TreeNode[] node2 = new TreeNode[10];
        for(int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for(int i = 0; i < 10; i++) {
            if(i * 2 + 1 < 10) {
                node[i].left = node[i * 2 + 1];
            }
            if(i * 2 + 2 < 10) {
                node[i].right = node[i * 2 + 2];
            }
        }
//        BinaryTreeMidOrderTraversal.midOrderRe(node[0]);
        midOrder(node[0]);
    }
    public static void preOrderRe(TreeNode treeNode) {
        System.out.print(treeNode.value);
        TreeNode leftNode = treeNode.left;
        if (leftNode != null) {
            preOrderRe(leftNode);
        }
        TreeNode rightNode = treeNode.right;
        if (rightNode != null) {
            preOrderRe(rightNode);
        }
    }

    public static void midOrderRe(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        } else {
            midOrderRe(treeNode.left);
            System.out.print(treeNode.value);
            midOrderRe(treeNode.right);
        }
    }

    public static void preOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.value);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    public static void midOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.value);
                treeNode = treeNode.right;
            }
        }
    }
}
