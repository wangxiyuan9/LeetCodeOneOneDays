package com.wxy.day02;

import java.util.*;

/**
 * Description:
 * 无重复字符的最长子串
 * 维护一个队列
 * "abcabcbb"
 * [] 因为为空先去a [a] 检测b不在其中 [a,b] c不在其中 [a,b,c] 发现a在其中将左侧出掉直到发现左侧第一个是a将之出掉
 * Author: wxy
 * Date: 2022/7/15 15:10
 */
public class Lt02 {
    public static void main(String[] args) {
        System.out.println(new Solution01().lengthOfLongestSubstring(""));
        System.out.println(new Solution02().lengthOfLongestSubstring(
                "abcabcbb"));
    }
}

class Solution01 {
    public int lengthOfLongestSubstring(String s) {
        //先不管效率 先实现
        int resMaxLen = 0;
        char[] chars = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char aChar : chars) {
            if(queue.isEmpty()||!queue.contains(aChar)){
                //为空或者不含直接放入队列
                queue.offer(aChar);//插入队尾

            }else{
                //队列里有该元素
                while(queue.size()>0){
                    //直到等于才停止出队列
                    Character poll = queue.peek();
                    if(poll.equals(aChar)) {
                        queue.offer(poll);
                        break;
                    }
                }
            }
            //到这里都是符合条件的
            resMaxLen = Math.max(queue.size(), resMaxLen);
        }
        return resMaxLen;

    }
}
/*
优化方案 02 普通setbux必须要记录位置的那种
 */
class Solution02 {
    public int lengthOfLongestSubstring(String s) {
        //用set or hashmap
        /*
        baca l:0 n:0  {} 0 1 {b} 0 2 {bac}  一个for循环去遍历l即i的每一种可能
         */
        int r = 0,max = 0;//r的设置是为了abcdefa  从0开始的abcdef 到1开始的bcdef绝对是非重复的右端由r决定在判断a即可
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if(i>0){
                //到这里就是新的一次l取值 从0到....末尾 把所有的可能探测出来
                //第一个值 i=0可能进入map了 肯定不为空
                set.remove(chars[i-1]);//set只能remove不能头出
            }else if(i==0){
                set.add(chars[0]);
            }
            //判断r指针的下一个是否在下一个 判断下一个最末是n-1即<n
            while((r+1)<chars.length && !set.contains(chars[r+1])){
                set.add(chars[r+1]);
                r++;
            }
            max = Math.max(max,r-i+1);
        }
        return max;
    }
}

