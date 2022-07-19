package com.wxy.day06;

/**
 * Description:
 * Lt 07 整数反转
 * Author: wxy
 * Date: 2022/7/19 15:55
 */
public class Lt02 {
    public static void main(String[] args) {
        System.out.println(new Solution01().reverse(-12010)==-1021);
    }
}
/*
    int:4 byte 32 bit
    int->String  -123  321-  100 001
*/
class Solution01 {
    public int reverse(int x) {
        if(x>=0 && x<10)
            return x;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        StringBuilder stringBuffer = new StringBuilder();
        boolean firstLook = false;
        //init data process
        if(chars[0]=='-')
            stringBuffer.append('-');
        for (int i = chars.length - 1; i >= 0; i--) {
            //0 Location needs satisfy
            if (i==chars.length-1 && !firstLook && chars[i] == '0') {
                while(chars[i]=='0'){
                    i--;
                }
                firstLook = true;// to through first 0 loop
            }
            if(i==0 && chars[i]=='-')
                continue;
            stringBuffer.append(chars[i]);
        }
        //no in [−231,  231 − 1] res = 0
        double res = Double.parseDouble(stringBuffer.toString());
        if(res<-Math.pow(2,31) || res>Math.pow(2,31)-1)
            return  0;
        else
            return (int)res;//double to int ok    ! Double to Integer not ok
    }
}
