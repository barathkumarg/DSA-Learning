package Sorting;

import java.util.Arrays;

/*

TIme complexity = 0(n^2)
Space complexity = 0(1)

-> Inplace and stable sorting algorithm

*
* */



public class Problem_1_Bubble_sort {

    //swap function
    public static void swap(int []arr,int m,int n){
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    //Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[], int n)
    {

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){ //always sorts the last element forst
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int []arr = {2,3,56,7,9,0};
        bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
