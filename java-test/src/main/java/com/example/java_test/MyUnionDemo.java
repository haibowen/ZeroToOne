package com.example.java_test;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 并查集
 * 的相关操作
 *
 */
public class MyUnionDemo {

    //并查集 中集合 的 个数
    int [] F=null;
    //记录并查集中集合的个数
    int count=0;
    //记录集合中点的个数 ,比如要知道 i 所在集合的点有多少个 :
    //注意 这里不能 直接使用 C[i]
    //因为只有 跟节点的统计 是 正确的
    int []Cnt =null;
    //并查集的初始化
    void Init(int n){
        F=new int[n];
        Cnt=new int[n];
        for (int i = 0; i <n ; i++) {
            F[i]=i;
            Cnt[i]=1;
        }
        count=n;
    }
    int Find(int x){
        if (x==F[x]){
            return x;
        }
        F[x]=Find(F[x]);
        return F[x];

    }

    void  Union(int x,int y){
        int xPar=Find(x);
        int yPar=Find(y);
        //将x所有集合，合并到y所在集合
        if (xPar!=yPar){
            F[xPar]=yPar;
            //y集合里面的个数要增加
            Cnt[yPar]+=Cnt[xPar];
            count--;
        }
    }

    int Size(int i){
        return Cnt[Find(i)];
    }


    /**
     * 克鲁斯卡尔算法
     */

    private  long cost=0;
    //这里 申请了足够多的 内存
    private   int []  Q=null;
    //并查集初始化
    //注意点的编号是从 1-n
    private void  InitDemo(int n){
        Q=new int[n+1];
        for (int i = 0; i <=n ; i++) {
            F[i]=i;

        }
        cost=0;
    }
    private int FindDemo(int x){
        if (x==F[x]){
            return x;
        }
        F[x]=FindDemo(F[x]);
        return F[x];
    }
    //合并的时候 需要 加上代价
    private void  UnionDemo(int x,int y,int pay){
        if (FindDemo(x)!=FindDemo(y)){
            cost+=pay;
            F[Find(x)]=Find(y);
        }
    }
    //一共 有n个点,编号从1-n
    //conn 表示输入的 边的集合
    //每一项是 一个三元组[]
    public long Kruskal(int n,int m,int[][] conn){
        InitDemo(n);
        //边集的排序
        Arrays.sort(conn, 0, m, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }
        });
        //顺次将边集添加到集合中
        for (int i=0;i<m;i++){
            UnionDemo(conn[i][0],conn[i][1],conn[i][2]);
        }
        return cost;
    }

}