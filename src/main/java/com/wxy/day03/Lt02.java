package com.wxy.day03;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/16 13:46
 */
public class Lt02 {
    public static void main(String[] args) {
        System.out.println(new Solution01().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}

class Solution01 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //暴力
        int[] resArray = new int[nums1.length+nums2.length];
        int l = 0,r = 0;//指向两个数组
        double res = 0;
        while(l<nums1.length || r<nums2.length){
            //满足其一未到右终点继续赋值
            if(l<nums1.length && r<nums2.length &&nums1[l]<=nums2[r]){// 1 2        3
                resArray[l+r] = nums1[l];
                l++;
            }else if(l<nums1.length && r<nums2.length && nums1[l]>nums2[r]){
                resArray[l+r] = nums2[r];
                r++;
            }//一者到达末端了 nums2还有
            else if(!(l<nums1.length) && r<nums2.length){
                while(r<nums2.length){
                    resArray[l+r] = nums2[r];
                    r++;
                }
            }else{
                while(l<nums1.length){
                    resArray[l+r] = nums1[l];
                    l++;
                }
            }
        }
        if(resArray.length%2==0){
            res = (double) (resArray[(resArray.length/2)-1]+resArray[resArray.length/2])/2;
        }else{
            res = (double) resArray[resArray.length/2];
        }
        return res;
       
    }
}