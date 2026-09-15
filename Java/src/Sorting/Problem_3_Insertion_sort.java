package Sorting;


/*
Time Complexity: O(N^2)
Auxiliary Space: O(1)



*
* */


import java.util.Arrays;

public class Problem_3_Insertion_sort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void insertionSort(int arr[], int n)
    {

        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){

                if(arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }

    }


    public static void main(String[] args) {

        int[] arr = {12,20,13,4,2,1,0};
        insertionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));


    }
}
