package com.wxy.day05;

/**
 * Description:
 * 6. Z 字形变换
 * s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * Author: wxy
 * Date: 2022/7/18 14:57
 
 
 github修改
 本地修改测试提交main分支
 */
public class Lt01 {
    public static void main(String[] args) {
        System.out.println(new Solution().convert( "ABCD",2));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        /*
        paypali
        3
        p   a   h   n
        a p l s i i g
        y   i   r
        4
        P     I    N
        A   L S  I G
        Y A   H R
        P     I
        res:pahnaplsiigyir resArray[i][j]
        if flag and 0<=i<numRows-1: res[i][j] = s[k],i++;
        if   i==numRows-1: res[i][j] = s[k],i--,j++;
        if !flag and 0<=i<numRows-1
            while !flag:
                res[i][j] = s[k]
                i-=1,j++;
                if(i==0)
                    flag = true;
        */
        if(numRows==1)
            return s;
        boolean downFlag = true;
        char[][] resArray = new char[numRows][s.length()];//Charac:null char:'\t0000'==0
        char[] chars = s.toCharArray();
        int  i = 0,j = 0;
        for (int k = 0; k < chars.length; k++) {
            resArray[i][j] = chars[k];
            if(downFlag && i>=0 && i<numRows-1)
                i++;
            else if(i==numRows-1){
                i--;
                j++;
                if(i!=0)
                    downFlag = false;
            }
            else if(i!=0){
                while( !downFlag  && k < chars.length-1){
                    i--;
                    j++;
                    k++;
                    resArray[i][j] = chars[k];
                    if(i==0){
                        downFlag = true;
                        i++;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (char[] chars1 : resArray) {
            for (char c : chars1) {
                if(c==0)
                    continue;
                res.append(c);
            }
        }
        return res.toString();
    }
}
