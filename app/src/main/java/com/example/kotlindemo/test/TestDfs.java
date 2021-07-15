package com.example.kotlindemo.test;

public class TestDfs {


    private char VIS='A';
    private int [] [] dir={{0,1},{0,-1},{1,0},{-1,0}};
    private int R,C;
    private void dfs(char[] [] A,int r,int c){

        for (int d=0;d<4;d++){
            final int nr=r+dir[d][0];
            final  int nc=c+dir[d][1];
            if (nr<0||nr>=R||nc<0||nc>=C){
                continue;
            }
            if (A[nr][nc]=='O'){
                A[nr][nc]=VIS;
                dfs(A,nr,nc);
            }
        }

    }

    public void solve(char[][] A){
        if (A==null||A.length==0){
            return;
        }

        R=A.length;
        C=A[0].length;

        //step1 从边缘出发，遍历所有与之 相领的点
        for (int r=0;r<R;r++){

        }
    }

}
