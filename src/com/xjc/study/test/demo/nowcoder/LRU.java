package com.xjc.study.test.demo.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *  设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 * 示例1
 * 输入 [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 返回值 [1,-1]
 * 第一次操作后：最常使用的记录为("1", 1)
 * 第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
 * 第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
 * 第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
 * 第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
 * @title: LRU
 * Created by 19040838 on 2021.03.04 19:13
 */
public class LRU {
    static class Node{
        int key , value;
        Node prev,next;
        public Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer,Node> map = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int k;
    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.k = k;
        head.next = tail;
        tail.prev = head;
        int len =(int) Arrays.stream(operators).filter(x->x[0] == 2).count();
        int[] ans = new int[len];
        int cnt = 0;
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                set(operator[1], operator[2]);
            } else {
                ans[cnt++] = get(operator[1]);
            }
        }
        return ans;
    }
    public void set(int key,int value){
        if(get(key) > -1){
            map.get(key).value = value;
        }else{
            if(map.size() == k ){
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            removeToHead(node);
        }
    }
    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            removeToHead(node);
            return node.value;
        }
        return -1;
    }
    public void removeToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
