package com.xjc.study.algorithm.banaryserchtree;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @Description 广度优先遍历
 * @Author 19040838
 * @Date 2021.03.17 15:35
 **/
public class LevelOrder {
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //如果根节点不为空,将第一层根节点入队列
        if(root != null) {
            queue.offer(root);
        }
        //只要队列不为空，执行循环
        while(!queue.isEmpty()) {
            //记录此时队列的长度，此时的num代表了某一层一共有多少个节点，防止被后边入队的节点个数影响输出这一层的节点
            int num = queue.size();
            //对某一层的所有节点进行操作(从左到右)
            for(int i = 0; i < num; i++) {
                //取出这一层第一个节点
                TreeNode topNode = queue.poll();
                //打印节点
                assert topNode != null;
                System.out.println(topNode.value);
                //将此节点的左子树根节点入队列
                if(topNode.left != null) {
                    queue.offer(topNode.left);
                }
                //将此节点的右子树根节点入队列
                if(topNode.right != null) {
                    queue.offer(topNode.right);
                }
            }
        }
    }
}
