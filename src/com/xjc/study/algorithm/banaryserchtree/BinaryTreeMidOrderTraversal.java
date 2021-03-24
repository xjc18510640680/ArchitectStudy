package com.xjc.study.algorithm.banaryserchtree;

import java.util.Stack;
/**
 * @author 19040838
 */
public class BinaryTreeMidOrderTraversal {
	//中序遍历递归实现
	public static void midOrderRe(TreeNode biTree) {
		if(biTree == null) {
			return;
		} else {
			midOrderRe(biTree.left);
			System.out.print(biTree.value);
			midOrderRe(biTree.right);
		}
	}

	//中序遍历费递归实现
	public static void midOrder(TreeNode biTree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(biTree != null || !stack.isEmpty()) {
			while(biTree != null) {
				stack.push(biTree);
				biTree = biTree.left;
			}
			if(!stack.isEmpty()) {
				biTree = stack.pop();
				System.out.print(biTree.value);
				biTree = biTree.right;
			}
		}
	}
}
 
 
 