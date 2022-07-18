package com.wxy.day04;

/**
 * Description:
 * lt
 * Author: wxy
 * Date: 2022/7/17 18:28
 */
public class Lt01 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"f"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen,str.length());
        }
        StringBuilder stringBuilder = new StringBuilder();
        //0~minLen to get max
        loop1:
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].charAt(i)!=strs[0].charAt(i)){
                    break loop1;
                }
            }
            stringBuilder.append(strs[0].charAt(i));
        }
        return stringBuilder.toString();
    }
}
