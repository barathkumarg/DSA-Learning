package Sorting;


import java.util.Arrays;

/*
Lomuto partition: In this partition,
The last element chooses as a pivot in this partition. The pivot acquires its required position after partition but more comparison takes place in this partition.

Finds the exact position of the number to be sorted in the array.

Pivot always be on the last

Inplace and unstable
Time complexity : 0(n^2)
Space complexity : 0(1)
*
* */
public class Problem_5_lomuto_partition_quick_sort {

    public static void swap(int []arr,int m,int n){
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static int lamutoPartition(int[] arr,int low,int high){

        int pivotElement = arr[high];
        int index = low - 1;
        for(int j=low;j<high;j++){
            if(pivotElement > arr[j]){
                index ++;
                swap(arr,index,j); //swap the element if it as lesser than pivot
            }
        }
        index++; //incremet the index to swap
        swap(arr,index, high);
        return index;
    }

    public static void quickSort(int []arr,int first,int last){
        if(first < last){
            int pivot = lamutoPartition(arr,first,last);
            quickSort(arr,first,pivot -1);
            quickSort(arr,pivot + 1,last);
        }
    }


    public static void main(String[] args) {

        int[] arr = {4,3,1,2};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
