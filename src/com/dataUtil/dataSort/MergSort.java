package com.dataUtil.dataSort;

import java.util.List;

//按得分对玩家的数据进行排序
public class MergSort {
private static Comparable[] aux;


private static boolean less(Comparable obj1,Comparable obj2){
    return obj1.compareTo(obj2)>0;
}

    public static void merge(List<Comparable> list, int low, int mid, int high) {
        int i=low,j=mid+1;
        int k;
        for( k=low;k<=high;k++)
            aux[k]=list.get(k);
        for(k=low;k<=high;k++) {
            if(i>mid) {
                list.set(k, aux[j++]);
            }
            else if(j>high) {
                list.set(k, aux[i++]);
            }
            else if(less(aux[j],aux[i])) {
                list.set(k, aux[i++]);
            }
            else {
                list.set(k,aux[j++]);
            }

        }
    }

    public static void sort(List<Comparable> list) {
        int N=list.size();
        aux=new Comparable[N];
        for(int sz=1;sz<N;sz*=2){
            for(int lo=0;lo+sz<N;lo+=2*sz){
                merge(list,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }


    }



}
