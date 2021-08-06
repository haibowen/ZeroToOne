package com.example.java_test;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 双指针求取  定长     求取 区间长度
 */
public class DoublePointDemo {

    int lengthOfLongestSubstring(String s){
        final int  N=s==null?0:s.length();
        int [] pos=new int[256];
        Arrays.fill(pos,-1);
        int ans=0;
        int left=-1;
        for (int i = 0; i < N; i++) {
            final int  idx=s.charAt(i);
            //（left,i）已经是 一个有效的解
            // 现在要把 s[i]加进来
            // 1、坏了才移动
            //那么看一下 是否会坏？
            while (pos[idx]>left){
                //如果（left,i）里面 已经有了s[i]
                //那么需要 移动左边
                //移动的时候 怎么 移动?
                //可以直接将left 移动到 pos[s[i]]
                //因为 我们采用 的区间 是左开右 闭
                left=pos[idx];
            }
            pos[idx]=i;
            ans=Math.max(ans,i-left);
        }
        return ans;
    }


    /**
     *
     *
     * 练习题 1：给定一个字符串，你可以把字符串里面的某些字符替换成任意字符 k 次。请返回你可以得到的最长相同字符的长度。
     *
     * 输入：s = 'ABACD', k = 1
     *
     * 输出：3
     *
     * 解释：只需要把 'ABA' 里面的 B 替换成 'A' 即可。
     */

    int characterReplacement(String s,int k){
        final  int N=s.length();
        int left=-1;

        int []cnt=new int[256];
        int oneNumber=0;
        int  ans=0;

        for (int i = 0; i < N; i++) {
            final  int c=s.charAt(i);
            //统计字符个数
            cnt[c]++;

            //考点
            //只有统计值发生 变动的那个字符才有可能
            //成为最多的字符，如果我们把出现次数
            //最多的字符当成主力，这里就是选出 主力字符
            oneNumber=Math.max(oneNumber,cnt[c]);

            //考点  最长 区间
            //坏了才移动原则：当新字符 加进来
            //如果 除了 主力字符 剩下的还是太多
            //那么要移除一个就可以了
            if (i-left-oneNumber>k){
                final int old=s.charAt(++left);
                cnt[old]--;
            }
            //到这里 为止，(left,i] 就是 一个满足要求的区间
            ans=Math.max(ans,i-left);

        }
        return ans;
    }

    /**
     *
     * 练习题 3：给定一个数组 A[]，请你找到一个最长区间，这个区间里面最多包含两个不一样的数。
     *
     * 输入：A = [1, 2, 1, 2, 3]
     *
     * 输出：4
     */


    class  Counter extends HashMap<Integer ,Integer>{

        public int get(int k){
            return containsKey(k)?super.get(k):0;
        }

        public void add(int k,int v){
            put(k,get(k)+v);
        }


    }
    int totalFruit(int [] A){
        final  int N=A==null?0:A.length;
        Counter H=new Counter();

        int left=-1;
        //记录最长的子数组的长度
        int ans=0;

        for (int i = 0; i <N ; i++) {
            int x=A[i];
            //把新进来的数放在子数组中去
            H.add(x,1);
            //如果破坏了状态
            //那么移动左指针
            while (H.size()>2){
                //把左边的数扔掉
                int old=A[++left];
                H.add(old,-1);
                if (H.get(old)==0){
                    H.remove(old);
                }
            }
            //这个 时候必然是一个合法的 状态
            ans=Math.max(ans,i-left);

        }
        return ans;
    }
}
