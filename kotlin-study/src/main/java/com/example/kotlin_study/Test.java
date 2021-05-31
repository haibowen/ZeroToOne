package com.example.kotlin_study;


/**
 * 汉明距离 计算
 */
public class Test {


    public static void main(String[] args) {
        int [] number={4,14,2};
        System.out.println("开始输出");
        System.out.println(distance(number));
        System.out.println("输出结束");

    }

    public static  int distance(int[] numbers) {
        int distance = 0;
        int lengthNumber = numbers.length;
        //判断每个元素的最大 二进制 位数
        // 题干要求小于 10的9次方
        // 因此 二进制位数最多 30位   10^9<2^30
        for (int i = 0; i < 30; i++) {
            int result = 0;
            //取出及数组中的每个元素 值
            for (int val : numbers) {
                //每一位上的值  //体会 下这个取值
                result += (val >> i) & i;
            }
            //汉明距离 的计算     这个计算公式是重点
            //假设数组中有三个元素   其中一个元素的第i为是1，其余两位元素的 第i位 是0
            //那么现在 当前二进制 i位上的汉明距离是  2 （因为有两个是 不一样的）
            //换成公式 的话   假设第一个元素i 为是 1 记做 result，其余 元素i位
            //上的值是 lengthNumber-result; 那这个距离就可以表示成如下公式：
            ////[这里这个公式很巧妙，避免了传统思想上的对元素 的排列组合 加深了
            // 复杂度]
            distance += result * (lengthNumber - result);
        }
        return distance;
    }
}
