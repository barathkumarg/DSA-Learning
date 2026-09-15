package Sorting;

import java.util.Arrays;

/*

Quick sort implementation using the hoare's partition, better than lamuto partition technique

Pivot will be always on the first

Inplace and unstable
Time complexity : 0(n^2)
Space complexity : 0(1)
*
* */

public class Problem_6_hoare_partition_quick_sort {

    public static void swap(int []arr,int m,int n){
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static int hoarePartition(int[] arr,int start,int end){

        int firtsIndex = start;
        int lastIndex = end;
        int pivotElement = arr[start];

        while (true){

            while(arr[firtsIndex] < pivotElement) firtsIndex ++;

            while(arr[lastIndex] > pivotElement) lastIndex --;

            if(firtsIndex < lastIndex){
                swap(arr,firtsIndex,lastIndex);
            }else{
                break;
            }

        }
        return firtsIndex;
    }

    public static void quickSort(int[]arr,int start,int end){
        if(start < end) {
            int pivot = hoarePartition(arr, start, end);
            quickSort(arr, start, pivot);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] arr = {4,5,1,2,3,7,13,14,0,8};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
