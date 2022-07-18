package com.wxy.day01;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/14 11:55
 */
public  class Lt02 {
    public static void main(String[] args) {
        new Solution().addTwoNumbers(new ListNode(),new ListNode());
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //342 465 807
//        int len1 = 0,len2 = 0;
//        l1
        ListNode listNode = new ListNode();//val:0 next；null
        ListNode res = listNode;
        int up = 0;
        int now = 0;
        while(l1!=null || l2!=null){
            //其一满足进入循环
            if(l1!=null&& l2!=null){
                now = (l1.val+l2.val)%10+up;
                up = (l1.val+l2.val)/10;
                listNode.next = new ListNode(now);
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1==null && l2!=null){
                now = (l2.val+up)%10;
                up = (l2.val+up)/10;
                listNode.next = new ListNode(now);
                l2 = l2.next;
            }else if(l1!=null && l2==null){
                now = (l1.val+up)%10;
                up = (l1.val+up)/10;
                listNode.next = new ListNode(now);
                l1 = l1.next;
            }
            listNode = listNode.next;//所有人必须
        }
        if(up!=0){
            listNode.next = new ListNode(up);
        }

        return res.next;
    }
}
