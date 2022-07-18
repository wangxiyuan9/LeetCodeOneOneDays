package com.wxy.day04;

import java.util.Arrays;

/**
 * Description:
 * 05
 * Author: wxy
 * Date: 2022/7/17 19:29
 */
public class Lt02 {
    public static void main(String[] args) {
        System.out.println(new Solution01().longestPalindrome("aaaa"));
    }

}

class Solution01 {
    public String longestPalindrome(String s) {
        /*
        s:babad
        dp[0][4] if s[0]!=s[4]:false
        if s[0]==s[4] = dp[1][3]
        1.get every dp[i][j]
        2.for it to get max distance result
         */
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int[] res = new int[2];
        //dp init
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len-1; i>=0; i--) {
            for (int j = 0; j < len; j++) {
                if(i>=j)
                    continue;
//                if(chars[i]!=chars[j])
//                    dp[i][j] = false; //unuseful
                if (chars[i]==chars[j]){
                    if(j-i<=2)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j]){
                        if((j-i)>(res[1]-res[0])){
                            //update
                            res[1] = j;
                            res[0] = i;
                        }
                    }

                }
            }
        }
        System.out.println(Arrays.toString(dp));
//        System.out.println(res[0]+""+res[1]);
        return s.substring(res[0],res[1]+1);//[l,r)
    }
}
