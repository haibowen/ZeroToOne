package com.example.kotlindemo.utils;

/**
 * Created on 4/15/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class SoulutionTest {
    /**
     *
     * 排列组合 6种情况
     *
     * 除以三可能 余 0 1 2
     * 除以二 可能  余 0 1
     */
    static int sumDay = 0;
    public static void main(String[] args) {
        SoulutionTest soulutionTest=new SoulutionTest();
        System.out.println(soulutionTest.minDay(56));
    }

    /**
     * 最少天数
     */
    public int minDay(int n){

        if (n<=2)return n;
        return dfs(n);

    }
    /**
     * 整体计算判断
     * @param n
     * @return
     */
    public int dfs(int n) {
        int record1 = 0;
        int record2 = 0;
        /**
         * 这里的判断可以debug下看看为啥
         */
        if (n < 4) {
            return sumDay - 2;
        }
        if (n % 2 == 0 && n % 3 == 0) {
            //同时被2 3整除的优先3
            record1 = judge3(n);
            sumDay++;
            dfs(record1);
        } else if (n % 2 == 0 && n % 3 == 1) {
            record1 = judge2(n);
            record2 = judge2to3(n);
            if (judge3(record2) < record1) {
                sumDay++;
                dfs(record2);
            }
        } else if (n % 2 == 0 && n % 3 == 2) {
            record1 = judge2(n);
            sumDay++;
            dfs(record1);
        } else if (n % 2 == 1 && n % 3 == 0) {
            record1 = judge3(n);
            sumDay++;
            dfs(record1);
        } else if (n % 2 == 1 && n % 3 == 1) {
            record1 = judge2to3(n);
            sumDay++;
            dfs(record1);
        } else if (n % 2 == 1 && n % 3 == 2) {
            record1 = judge2to3(n);
            sumDay++;
            dfs(record1);
        }
        return sumDay;
    }

    /**
     * 不能被2或者3整除
     */

    public int judge2to3(int n) {
        return n - 1;
    }

    /**
     * 被2整除的
     */

    public int judge2(int n) {
        return n / 2;
    }

    /**
     * 被3整除的
     */

    public int judge3(int n) {
        return n - 2 * (n / 3);
    }

}
