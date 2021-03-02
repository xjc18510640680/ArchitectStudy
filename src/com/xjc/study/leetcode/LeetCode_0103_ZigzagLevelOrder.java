package com.xjc.study.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: TODO
 *  103. 二叉树的锯齿形层序遍历
 *  给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author 19040838
 * @title: LeetCode_0103_ZigzagLevelOrder
 * Created by 19040838 on 2021.03.02 15:00
 */
public class LeetCode_0103_ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);

    }

    /**
     * 对节点之间的顺序进行维护
     **/
    public List<List<Integer>> zigzagLevelOrder(TreeNode1 root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode1> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode1 node = null;
                //因为是走z字形，所有相邻两层的节点处理是相反的
                if(depth % 2 == 0){
                    //获取链表最后一个节点
                    node = queue.pollLast();
                    assert node != null;
                    if(node.left != null){
                        queue.offerFirst(node.left);
                    }
                    if(node.right != null){
                        queue.offerFirst(node.right);
                    }

                }else{
                    //获取链表第一个节点
                    node = queue.poll();
                    assert node != null;
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                }
                tmp.add(node.val);
            }
            depth++;
            result.add(tmp);
        }
        return result;
    }

    /**
     * 对节点值之间进行维护，关注点在于值的顺序
     **/
    public List<List<Integer>> zigzagLevelOrder1(TreeNode1 root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode1> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            //这里不能申明为将LinkedList泛化为list，否则不能调用addFirst方法
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode1 node = queue.poll();
                assert node != null;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(depth % 2 == 0){
                    tmp.add(node.val);
                }else{
                    tmp.addFirst(node.val);
                }
            }
            depth++;
            result.add(tmp);
        }
        return result;
    }

    /**
     * 递归
     **/
    public List<List<Integer>> zigzagLevelOrder2(TreeNode1 root) {
        List<LinkedList<Integer>> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(list, root, 0);
        result.addAll(list);
        return result;
    }
    public void helper(List<LinkedList<Integer>> result, TreeNode1 node, int depth){
        if(node == null){
            return;
        }
        if(depth == result.size()){
            result.add(new LinkedList());
        }
        if(depth % 2 == 0){
            result.get(depth).add(node.val);
        }else{
            result.get(depth).addFirst(node.val);
        }
        helper(result, node.left, depth + 1);
        helper(result, node.right, depth + 1);
    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x)
    {
        val = x;
    }

    @Override
    public String toString()
    {
        return "" + val;
    }
}