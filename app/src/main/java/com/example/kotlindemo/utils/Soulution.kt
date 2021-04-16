package com.example.kotlindemo.utils
/**
 * Created on 4/15/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */

fun main() {
    var solution = Solution();
    solution.minDays(10);
    println(solution.minDays(10))
}

internal class Solution {
    var sumDay = 0 //记录最快吃完的天数
    fun minDays(n: Int): Int {
        return if (n <= 2) n else dfs(n)
        //橘子一共可能存在如下几种情况
        //  n%2的情况 有2种  1或者0  （类似奇数偶数的判断）
        //   n%3的情况 有三种  2或者 1或者 0
        // 对上面的情况进行组合有六种情况
        //  n%2==0 && n%3==0
        // n%2==0 && n%3==1
        // n%2==0 && n%3==2
        //n%2==1&& n%3==0
        //n%2==1&& n%3==1
        //n%2==1&&n%3==2
    }

    fun dfs(n: Int): Int {
        var record1 = 0
        var record2 = 0

        if (n<4){
            return sumDay-2
        }
        if (n % 2 == 0 && n % 3 == 0) {
            record1 = judge3(n)
            sumDay++
            dfs(record1)
        } else if (n % 2 == 0 && n % 3 == 1) {
            record1 = judge2(n)
            record2 = judge2to3(n)
            if (judge3(record2) < record1) {
                sumDay++
                dfs(record2)
            }
        } else if (n % 2 == 0 && n % 3 == 2) {
            record1 = judge2(n)
            sumDay++
            dfs(record1)
        } else if (n % 2 == 1 && n % 3 == 0) {
            record1 = judge3(n)
            sumDay++

            dfs(record1)
        } else if (n % 2 == 1 && n % 3 == 1) {
            record1 = judge2to3(n)
            sumDay++
            dfs(record1)
        } else if (n % 2 == 1 && n % 3 == 2) {
            record1 = judge2to3(n)
            sumDay++

            dfs(record1)

        }
        return sumDay
    }

    //第一个方法 不能被2或者3整除
    fun judge2to3(n: Int): Int {
        var n = n
        return n-1
    }

    //第二个方法 只能被2整除
    fun judge2(n: Int): Int {
        return n / 2
    }

    //只能被3整除
    fun judge3(n: Int): Int {
        var n = n
        return n - 2 * (n / 3).also { n = it }
    }
}