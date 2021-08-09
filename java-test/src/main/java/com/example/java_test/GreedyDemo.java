package com.example.java_test;


/**
 * 贪心算法求解
 */
public class GreedyDemo {


    /**
     * 求一个数组中的最大值
     */

    int getMaxValue(int [] A){
        final int N=A==null?0:A.length;
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ans=Math.max(ans,A[i]);
        }
        return ans;
    }

    /**
     * 双指针求取 数组中的最大值
     */

    int getMaxValue2(int [] A){
        final   int N=A==null?0:A.length;
        int i=0,j=N-1;
        while (i<j){
            if (A[i]>A[j]){
                j--;
            }else {
                i++;
            }
        }
        return A[i];

    }

    /**
     * maxArea
     */

    int maxArea(int []A){
        final int N=A==null?0:A.length;
        int ans=0;
        int i=0,j=N-1;
        while (i<j){
            int height=Math.min(A[i],A[j]);
            int width=j-i;
            ans=Math.max(ans,height*width);
            if (A[i]>A[j]){
                j--;
            }else {
                i++;
            }
        }
        return ans;
    }
}
