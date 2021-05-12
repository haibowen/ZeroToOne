package com.example.java_test;


import java.util.Stack;

/**
 * 寻找配对的字符串 算法
 */
public class StackTest {
    public static void main(String[] args) {

        System.out.println("开始 输出 ");
        System.out.println(isValid("((()))()()"));
        System.out.println(isValid("((()))()("));
        System.out.println("输出结束");

        System.out.println(isReally("((()))((()))"));
        System.out.println(isReally("((()))((())"));
    }


    /**
     * 寻找配对的字符串
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //特殊情况判断 ,字符串为空的时候
        if (s.length() == 0 || s == null) {
            return true;
        }
        //当字符串 为奇数的时候
        if (s.length() % 2 == 1) {
            return false;
        }
        //消除法的主要 核心逻辑
        /**
         *
         *
         *
         * 采用栈这种 特殊的 数据结构来实现会更合理一些
         */
        Stack<Character> t = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            //取出字符
            char c = s.charAt(i);
            //如果是左括号就入栈
            if (c == '(') {
                t.push(c);
            } else if (c == ')') {
                //那就弹栈
                if (t.empty()) return false;
                t.pop();
            }
        }
        return t.empty();

    }

    /**
     * 第二种解法
     * <p>
     * 寻找配对的字符串
     */

    public static boolean isReally(String s) {
        int result = 0;//记录左半边括号的个数
        //两个特殊情况
        if (s.length() == 0 || s == null) return false;
        if (s.length() % 2 == 1) return false;
        //实际判断
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                result++;
            } else if (s.charAt(i) == ')') {
                result--;
            }
        }
        return result == 0;
    }

    /**
     * 大鱼吃小鱼的操作 计算剩余多少条鱼
     */
    public static int solution(int[] fishSize, int[] fishDirection) {

        //对特殊值进行判断
        final int fishNumber = fishSize.length;
        if (fishNumber <= 1) return fishNumber;

        //标记 游动的方向
        final int left = 0;//向左
        final int right = 1;//向右

        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < fishNumber; i++) {

            //当前鱼的状态  大小 方向
            final int curFishSize = fishSize[i];
            final int curFishDirection = fishDirection[i];
            //当前的鱼的存活状态
            boolean hasEat = false;
            //若果栈中有鱼，并且栈中鱼,当前的鱼向左游动,那就有相遇的可能性
            while (!t.empty() && fishDirection[t.peek()] == right && curFishDirection == left) {

                //判断是否吃掉
                if (fishSize[t.peek()] > curFishSize) {
                    hasEat = true;
                    break;
                }
                //如果栈中鱼小，栈中的鱼会被吃掉
                t.pop();
            }
            //若果新来的鱼没有被吃掉,入栈
            if (!hasEat) {
                t.push(i);
            }
        }
        return t.size();
    }

}
