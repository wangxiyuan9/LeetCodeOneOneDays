package com.wxy.day06;

/**
 * Description:
 * Lt 21 合并两个有序链表
 * Author: wxy
 * Date: 2022/7/19 15:34
 */
public class Lt01 {
    public static void main(String[] args) {
//        new Solution().mergeTwoLists()
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/*
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
len maybe 0
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)
            return null;
        ListNode resListNode = new ListNode(0);
        ListNode res = resListNode;//point resListNode head to get res
        while (list1!=null || list2!=null){
            //three
            if(list1!=null && list2!=null){
                if(list1.val<=list2.val){
                    resListNode.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
                else if(list1.val>list2.val){
                    resListNode.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                //finally
                resListNode = resListNode.next;
            }
            else if(list1==null && list2!=null){
                //fill just all list2 into res
                while(list2!=null){
                    resListNode.next = new ListNode(list2.val);
                    list2 = list2.next;
                    resListNode = resListNode.next;
                }
            }
            else{
                //fill just all list2 into res
                while(list1!=null){
                    resListNode.next = new ListNode(list1.val);
                    list1 = list1.next;
                    resListNode = resListNode.next;
                }
            }
        }

        return res.next;
    }
}
