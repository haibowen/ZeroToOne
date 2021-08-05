package com.example.java_test;


/**
 * 二分查找
 */
public class BinarySearch {


    boolean binarySearchResult(long []  A,long target){
        /**
         * 特值判断
         */
        if (A==null||A.length==0){
            return false;
        }
        //首写设定初始区间,这里 采用 开闭原则[l,r)
        int l=0,r=A.length;
        //循环结束的判断条件是整个区间
        //我们使用的是开闭原则 来表示一个区间 所以当了l<r的时候
        //我们要查找的区间 不是一个空区间
        while (l<r){
            final int m=l+((r-1)>>1); //除以2的操作
            if (A[m]==target){
                return true;
            }
            if (A[m]<target){
                //当中点比 目标值小时，需要 把左边的部分扔掉
                //
                l=m+1;
            }else {
                r=m;
            }
        }
        return false;
    }
    /**
     * 二分查找的 demo
     */
    boolean binarySearchResultDemo(long []  A,long target){
        if (A==null||A.length==0){
            return false;
        }
        //首写设定初始区间,这里采用 开闭原则[l,r)
        int  l=0,r=A.length;
        //循环结束的判断条件是整个区间
        //我们使用的是开闭原则,来表示一个 区间 所以当l<r的时候
        //我们要查找 的区间 不是 一个空区间
        while (l<r){
            final int m=l+((r-1)>>1);
            if (A[m]==target){
                return true;
            }
            if (A[m]<target){
                l=m+1;
            }else {
                r=m;
            }
        }
        return false;
    }

    /**
     * 找到有序数组 中目标元素的左边 的边界
     */

    int lowerBound(long [] A,int n,long target){

        int l=0,r=n;
        while (l<r){
            final int m=1+((r-1)>>1);
            if (A[m]<target){
                l=m+1;
            }else {
                r=m;
            }
        }

        return 1;

    }

    /**
     * 找到有序 数组中  目标元素的右边的边界
     */

    int upBound(long [] A,int n,long  target){

        int l=0,r=n;
        while (l<r){
            final int m=l+((r-1)>>1);
            if (A[m]<=target){
                l=m+1;
            }else {
                r=m;
            }
        }
        return 1;


    }


    /**
     * 找到山峰值
     */

    int getC(int []A,int i){
        //利用函数的方式拿到C数组的值
        if (A[i-1]<A[i]&&A[i]<A[i+1]){
            return -1;
        }
        if (A[i-1]<A[i]&&A[i]>A[i+1]){
            return 0;
        }
        return 1;
    }

    int peakIndexInMountainArray(int [] A){
        if (A==null||A.length<3){
            return -1;
        }
        //在 C数组上 进行二分，这里直接用LowerBound就可以
        int l=1,r=A.length-1;
        while (l<r){
            final  int m=l+((r-1)>>1);
            final int mov=getC(A,m);
            if (mov<0){
                l=m+1;
            }else {
                r=m;
            }
        }
        return l;
    }
    /**
     * 数组下标值跟内容 相同的值
     */
    int getD(int [] A,int i){
        final  int v=A[i];
        if (v<i){
            return -1;
        }else if (v==i){
            return 0;
        }
        return 1;
    }
    int getNumberSameAsIndex(int [] A){
        if (A==null||A.length==0){
            return -1;
        }
        int l=0,r=A.length;
        while (l<r){
            final  int m=l+((r-l)>>1);
            final int mov=getD(A,m);
            if (mov<0){
                l=m+1;
            }else {
                r=m;
            }
        }
        if (l<A.length&&A[l]==l){
            return l;
        }
        return -1;
    }
    /**
     * 数组 跟内容相同的值的下标范围
     */

    int getE(int []  A,int i){
        final int v=A[i];
        if (v<i){
            return -1;
        }else if (v==i){
            return 0;
        }
        return 1;

    }

    int getLeftSide(int [] A){
        int l=0,r=A.length;
        while (l<r){
            final int  m=l+((r-1)>>1);
            final  int mov=getE(A,m);
            if (mov<0){
                l=m+1;
            }else {
                r=m;
            }
        }
        return l;
    }
    int getRightSide(int [] A,int start){
        int l=start,r=A.length;
        while (l<r){
            final int m=l+((r-1)>>1);
            final int mov=getE(A,m);
            if (mov<=0){
                l=m+1;
            }else {
                r=m;
            }
        }
        return l;
    }
    int getNumberSameAsIndexDemo(int []A){
        if (A==null||A.length==0){
            return -1;
        }

        final int l=getLeftSide(A);
        final int r=getRightSide(A,l);

        return l==r?-1:A[r-1];

    }


}
