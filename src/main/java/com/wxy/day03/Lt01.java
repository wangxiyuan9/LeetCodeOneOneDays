package com.wxy.day03;

import java.util.HashMap;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/16 13:15
 */
public class Lt01 {
    public static void main(String[] args) {
        //Character和String是两种截然不同的类型
        char a = 'a';
        char b ='b';
        System.out.println(a+b);//195
        System.out.println(new Solution().romanToInt("MCMXCIV") == 1994);
    }
}

class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);//Character和String是两种截然不同的类型

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='I'&&i+1<chars.length){
                if(chars[i+1]=='V'){
                    res+=4;
                    i++;
                }else  if(chars[i+1]=='X'){
                    res+=9;
                    i++;
                }else{
                    res+=1;
                }
            }else if(chars[i]=='X'&&i+1<chars.length){
                if(chars[i+1]=='L'){
                    res+=40;
                    i++;
                }else  if(chars[i+1]=='C'){
                    res+=90;
                    i++;
                }else{
                    res+=10;
                }

            }else if(chars[i]=='C'&&i+1<chars.length){
                if(chars[i+1]=='D'){
                    res+=400;
                    i++;
                }else  if(chars[i+1]=='M'){
                    res+=900;
                    i++;
                }else{
                    res+=map.get(chars[i]);
                }
            }else{
                res+=map.get(chars[i]);
            }
        }
        return res;
    }
}