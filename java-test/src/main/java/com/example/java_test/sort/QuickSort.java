package com.example.java_test.sort;

public class QuickSort {


    public static void main(String[] args) {
        int []  array={5,2,4,9,0,5,1};
        QuickSort  quickSort=new QuickSort(array);
        quickSort.sort();
        quickSort.print();

        System.out.println("————————————————————————————————");
        int []  arrayTest={5,2,4,9,0,5,1};
        QuickSort quickSort1=new QuickSort(arrayTest);
        quickSort1.sort();
        quickSort1.print();

    }

    private int [] array;
    public QuickSort(int [] array){
        this.array=array;

    }

    public void sort(){
        quickSort(array,0,array.length-1);
    }

    public void print(){
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
            
        }
    }


    /**
     * 递归排序  快速排序的实现
     */

    public void quickSort(int [] array,int begin,int end){
        if (begin<end){
            int key=array[begin];
            int i=begin;
            int j=end;
            while (i<j){

                //判断尾部的值是否小于选定的值
                while (i<j&&array[j]>key){
                    j--;
                }

                if (i<j){
                    array[i]=array[j];
                    i++;
                }

                //判断头部的值是否小于选定的值
                while (i<j&&array[i]<key){
                    i++;
                }
                if (i<j){
                    array[j]=array[i];
                    j--;
                }
            }
            array[i]=key;
            quickSort(array,begin,i-1);
            quickSort(array,i+1,end);
        }
    }


    /**
     * 快速排序的实现
     */

    public void quickSortTest(int [] array,int begin,int end){

        if (begin<end){
            int key=array[begin];
            int i =begin;
            int j=end;
            while (i<j){
                //判断尾部的是否小于 选定的值
                while (i<j&&array[j]<key){
                    j--;
                }
                if (i<j){
                    array[i]=array[j];
                    i++;
                }
                //判断头部的值是否大于选定的值

                while (i<j&&array[i]>key){
                    i++;
                }
                if (i<j){
                    array[j]=array[i];
                    j--;
                }
                quickSort(array,begin,i-1);
                quickSort(array,i+1,end);
            }
        }

    }
}
