package com.wxy.day08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/21 23:18
 */
public class Lt02 {
}
class Solution01 {
    /*
    层序遍历 bfs
        一层
    */
    public List<List<Integer>> levelOrder(TreeNode1 root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return  res;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);//队列 尾进
        /*
        bfs:1.不为空 2.size走同一行 3.收集结果
         */
        while(!queue.isEmpty()){
             int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(size!=0){
                //先出后进
                TreeNode1 poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                size--;
            }
            //到这树一行就走完了
            res.add(list);
        }
        return  res;
    }
}

