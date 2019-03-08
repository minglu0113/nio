package com.zhang.nio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectSort {
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(6);
        arrayList.add(14);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(3);
        SelectSort selectSort = new SelectSort();
        selectSort.sort(arrayList);
        System.out.println(arrayList.toString());
    }
    void sort(List<Integer> list){
        for(int i=0;i<list.size();i++){
            for(int j=i;j<list.size();j++){
                if(list.get(j)<list.get(i)){
                    int temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }
    @Test
    public void test(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(12);
        arrayList.add(13);
        System.out.println(arrayList.size());
        arrayList.set(0,12);
        System.out.println(arrayList.size());
    }
    @Test
    public void test2(){
        HashMap hashMap = new HashMap();
        hashMap.put("2","2");
        hashMap.put("3","3");
    }
    @Test
    public void test3(){
        System.out.println(15&51);
    }

    int[] buildMaxHeap(int[] array){
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for(int i=(array.length-2)/2;i>=0;i--){
            adjustDownToUp(array, i,array.length);
        }
        return array;
    }
    void adjustDownToUp(int[] array,int k,int length){
        int temp = array[k];
        for(int i=2*k+1; i<length-1; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if(i<length && array[i]<array[i+1]){  //取节点较大的子节点的下标
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if(temp>=array[i]){  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            }else{   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
    }
}
