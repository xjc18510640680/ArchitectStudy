package com.xjc.study.algorithm.banaryserchtree;

import java.util.Stack;

/**
 * @Description 前序遍历的递归实现与非递归实现
 * @Author 19040838
 * @Date 2021.03.08 16:53
 **/
public class BinaryTreePreOrderTraversal {

	/**
	 * 递归方式：方法一preOrderRe
	 *          方法二preOrderRe1
	 **/
	public static void preOrderRe(TreeNode biTree) {
		if(biTree == null) {
			return;
		} else {
			System.out.print(biTree.value);
			preOrderRe(biTree.left);
			preOrderRe(biTree.right);
		}
	}

	public static void preOrderRe1(TreeNode biTree) {
		System.out.print(biTree.value);
		TreeNode leftTree = biTree.left;
		if(leftTree != null) {
			preOrderRe(leftTree);
		}
		TreeNode rightTree = biTree.right;
		if(rightTree != null) {
			preOrderRe(rightTree);
		}
	}

	/**
	 * 非递归实现:方法一preOrder
	 *           方法二preOrder1
	 **/
	public static void preOrder(TreeNode biTree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(biTree != null || !stack.isEmpty()) {
			while(biTree != null) {
				System.out.print(biTree.value);
				stack.push(biTree);
				biTree = biTree.left;
			}
			if(!stack.isEmpty()) {
				biTree = stack.pop();
				biTree = biTree.right;
			}
		}
	}

	public static void preOrder1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		// 树为空
		if(root == null) {
			return;
		}
		// 将根节点压入栈中
		stack.add(root);
		// 只要栈不为空，执行循环
		while(!stack.isEmpty()){
			// 取出栈顶元素打印，此时的栈顶元素是以node为根的子树的根
			TreeNode node = stack.pop();
			System.out.print(node.value);
			// 将右子树压入栈中
			if(node.right != null) {
				stack.push(node.right);
			}
			// 将左子树压入栈中
			if(node.left != null) {
				stack.push(node.left);
			}
		}
	}
}
 
 
 