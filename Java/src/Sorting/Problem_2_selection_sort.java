package Sorting;

import java.util.Arrays;

/*

TIme complexity = 0(n^2)
Space complexity = 0(1)

-> Inplace and non stable sorting algorithm

*
* */

public class Problem_2_selection_sort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int pos = i;
            for(int j=i;j<arr.length;j++) {
                if (arr[j]<arr[pos]){
                    pos = j;
                }
            }
            swap(arr,i,pos);

        }


    }

    public static void main(String[] args) {
        int[] arr = {12,10,19,8,7,6};

        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
