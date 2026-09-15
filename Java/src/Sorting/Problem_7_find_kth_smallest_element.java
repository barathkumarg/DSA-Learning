package Sorting;

/*
Given an array arr[] of N positive integers and a number K. The task is to find the kth smallest element in the array.



Example 1:

Input:
N = 5, K = 3
arr[] = {3,5,4,2,9}

Output:
4

Explanation:
Third smallest element in the array is 4.

Time complexity: 0(n log) => implementation of quick sort
Space complexity: 0(1)

*
* */


public class Problem_7_find_kth_smallest_element {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int lamutopartition(int arr[],int low,int high){

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




    static int partition(int arr[],int start,int end,int pos){

        while(start<=end){

            int p = lamutopartition(arr,start,end);
            if(p == pos - 1){
                return arr[p];
            }
            else if(p > pos -1){
                end = p - 1;
            }
            else{
                start = p + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3,5,4,2,9};
        int n = 5;
        int k=3;
        System.out.println( partition(arr,0,n-1,k));

    }
}
