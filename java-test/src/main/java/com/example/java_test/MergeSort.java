package com.example.java_test;


/**
 * 合并排序
 */
public class MergeSort {


    private void mSort(int [] a,int b,int e,int t[]){

        //空区间 或只有一个元素
        //为了防止 b+1 溢出，这里用b>=e先判断一下
        if (b>=e||b+1>=e){
            return;
        }

        //分成两半 二叉树可以自动取得 root.left root.right
        //这里我们需要通过0计算来得到 左右子数组
        final  int m=b+((e-b)>>1);

        //类比二叉树 分别遍历 左子树 右子树
        mSort(a,b,m,t);
        mSort(a,m,e,t);
        //i 指向左子数组 的开头, j 指向右子数组的开头
        //to 指向要 临时数组t与区间[b,e]对应的位置
        int i=b;
        int j=m;
        int to=b;

        //将两个子数组进行合并,注意下面一个 很重要的 模板
        //这里的判断条是，只要两个子数组中还有元素
        while (i<m||j<e){
            //如果右子数组没有元素，或者左子数组 开头的元素小于右子 数组开头的 元素
            //那么取走 左子数组开头的元素
            //考点 a[i]<=a[j]这样 可以 保证合并排序最稳定
            if (j>=e||i<m&&a[i]<=a[j]){
                t[to++]=a[i++];
            }else {
                //否则就是 取右子数组开头的 元素
                t[to++]=a[j++];
            }
        }
        //把合并的结果考回原来的数组 a[]
        for (int k = 0; k <e ; k++) {
            a[i]=t[i];

        }
    }

    public void mergeSort(int [] nUms){
        //如果传进来 的数组为空
        if (nUms==null||nUms.length==0){
            return;
        }
        //t是一个临时中转的数组
        int [] t=new int[nUms.length];
        mSort(nUms,0,nUms.length,t);
    }
}
