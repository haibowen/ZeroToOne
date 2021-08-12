package com.example.java_test;

/**
 * 动态规划
 */
public class Dynamic {

    public int coinChange(int [] coins,int amount){

        //没有解的时候 ，设置一个较大的值
        final int INF=Integer.MAX_VALUE/4;
        int []dp=new int[amount+1];
        //一开始给所有的 数设置 为不可解
        for (int i = 0; i <=amount ; i++) {
            dp[i]=INF;
        }
        //DP的初始条件
        dp[0]=0;
        for (int i = 0; i < amount; i++) {
            for (int y:coins){
                //注意边界的处理，不要越界
                if (y<=amount&&i+y<amount+1&&i+y>=0){
                    //正向推导时 递推公式
                    dp[i+y]=Math.min(dp[i+y],dp[i]+1);
                }
            }
        }
        return dp[amount]>=INF?-1:dp[amount];


    }


    /**
     * 你是一个专业的小偷，计划去沿街的住户家里偷盗。每间房内都藏有一定的现金，
     * 影响你偷盗的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，要求你计算不触动警报装置的情况下 ，
     * 一夜之内能够偷窃到的最高金额。
     *
     * 输入：nums = [1,2,3,1]
     *
     * 输出：4
     */

    public int rob(int [] nums){

        final int N=nums==null?0:nums.length;
        if (N<=0){
            return 0;
        }
        int []dp=new int [N];
        dp[0]=Math.max(0,nums[0]);
        if (N==1){
            return dp[0];
        }
        dp[1]=Math.max(0,Math.max(nums[0],nums[1]));
        for (int i = 2; i <N ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[N-1];
    }





}
