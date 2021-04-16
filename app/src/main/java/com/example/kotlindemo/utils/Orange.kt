package com.example.kotlindemo.utils



object EatOrangeQuestion {
    var map: HashMap<Int, Int?> = HashMap()

    @JvmStatic
    fun main(args: Array<String>) {
//        println(minDays(6))
//        println(minDays(56))
//        println(minDays(10))
        println(minDays(11))
        throw Exception("这是 一个异常")

    }

    fun minDays(n: Int): Int {
        //剩下0个了返回0天，剩下1个返回1天
        if (n <= 1) return n
        //检查一下有没有保存的最优解，有的话直接返回
        if (map.containsKey(n)) {
            return map[n]!!
        }
        //初始化一个最大值 用来后面比较
        var min = Int.MAX_VALUE
        //吃到条件2成立的情况下需要的天数
        min = Math.min(min, minDays(n / 2) + n % 2)
        //吃到条件3成立情况下需要的天数
        min = Math.min(min, minDays(n / 3) + n % 3)

        // +1 是因为你需要一天时间来吃掉1/2或者2/3
        // 或者可以把上面两行代码写成
        //min = Math.min(min, minDays(n / 2)+1 + (n % 2));
        //min = Math.min(min, minDays(n / 3)+1 + (n % 3));
        //那么此处就不需要+1了
        min += 1
        //把n个橘子吃的天数最优解保存起来
        map[n] = min
        return min
    }
}
