package com.xjc.study.algorithm.banaryserchtree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * @author 19040838
 */
public class BinaryTreePostOrderTraversal {
	//后序遍历递归实现
	public static void postOrderRe(TreeNode biTree) {
		if(biTree == null) {
			return;
		} else {
			postOrderRe(biTree.left);
			postOrderRe(biTree.right);
			System.out.print(biTree.value);
		}
	}

	//后序遍历非递归实现
	public static void postOrder(TreeNode biTree) {
		//在辅助栈里表示左节点
		int left = 1;
		//在辅助栈里表示右节点
		int right = 2;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。
		Stack<Integer> stack2 = new Stack<Integer>();
		while(biTree != null || !stack.empty()) {
			//将节点压入栈1，并在栈2将节点标记为左节点
			while(biTree != null) {
				stack.push(biTree);
				stack2.push(left);
				biTree = biTree.left;
			}
			//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
			while(!stack.empty() && stack2.peek() == right) {
				stack2.pop();
				System.out.print(stack.pop().value);
			}
			//如果是从左子节点返回父节点，则将标记改为右子节点
			if(!stack.empty() && stack2.peek() == left) {
				stack2.pop();
				stack2.push(right);
				biTree = stack.peek().right;
			}
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();
		if(root == null) {
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			//头插此时根节点
			list.add(0, node.value);
			if(node.left != null) {
				stack.push(node.left);
			}
			if(node.right != null) {
				stack.push(node.right);
			}
		}
		return list;
	}
}
 
 