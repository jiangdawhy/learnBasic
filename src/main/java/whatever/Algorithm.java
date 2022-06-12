package whatever;

import java.util.*;

public class Algorithm {

    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }



    public static void main(String[] args){

        /*
        1.先看数据结构. 图看拓扑排序(course schedule I, II), breadth fs, depth fs..    图的存储: 邻接矩阵, 邻接表
        2.做树的题目, 可以非常熟悉 dfs, bfs, 回溯算法
        3.树 哈希表的题可以多练练





         */


        /*//栈和队列
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();

        //堆 logN返回一堆数据中最小或者最大的值  comparator
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap.add(1);
        minHeap.add(-9);
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(7);
        Integer top = minHeap.poll();
        System.out.println(top);*/

        //并查集  字典树(不用看)

        //dfs, bfs, (dp, 回溯), 贪心, 排序, 双指针



        //背归并 快排

    }
}
