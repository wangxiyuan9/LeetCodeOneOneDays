package com.wxy.day02;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/15 14:57
 */
public class Lt01 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(23));
    }

}

class Solution {
    public boolean isPalindrome(int x) {
        boolean res = true;//不进入循环都是长度为1的 就是回文数
        char[] chars = String.valueOf(x).toCharArray();
        //二分
        int left=0 , right =chars.length-1;
        while(left<right){//保证索引能够不越界
            if(chars[left]!=chars[right]){
                res = false;
                break;
            }
            left++;
            right--;
        }
        return  res;
    }
}